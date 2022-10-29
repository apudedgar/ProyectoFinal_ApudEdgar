import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona.model';
import { ImageService } from 'src/app/service/image.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-acerca-d',
  templateUrl: './edit-acerca-d.component.html',
  styleUrls: ['./edit-acerca-d.component.css']
})
export class EditAcercaDComponent implements OnInit {
  persona: Persona = null;

  constructor(private personaS: PersonaService, private activatedRouter: ActivatedRoute, private router: Router, public imageService: ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaS.detail(id).subscribe({next: (data) => {
        this.persona = data;
      }, error: (err) => {
        alert("Error al modificar educacion");
        this.router.navigate(['']);
      }
    });
  }
  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.persona.img=this.imageService.url;
    this.personaS.update(id, this.persona).subscribe({next: (data) => {
        this.router.navigate(['']);
      }, error: (err) => {
        alert("Error al modificar educacion");
        this.router.navigate(['']);
      }
    });
  }
  uploadImage($event: any) {
    const id= this.activatedRouter.snapshot.params['id'];
    const name="fotoperfil_"+id;
    this.imageService.uploadImage($event, name);
    
  }
}
