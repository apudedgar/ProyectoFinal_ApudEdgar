import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImgService } from 'src/app/service/img.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {
  proyecto: Proyecto = null;
  constructor(private sProyecto: ProyectoService, private activatedRouter: ActivatedRoute, private router: Router, public imageService:ImgService) { }


  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyecto.detail(id).subscribe({
      next: (data) => {
        this.proyecto = data;
      }, error: (err) => {
        alert("Error al modificar PROYECTO");
        this.router.navigate(['']);
      }
    });
  }



onUpdate(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.proyecto.imgP=this.imageService.url;
  this.sProyecto.update(id, this.proyecto).subscribe({
    next: (data) => {
      this.router.navigate(['']);
    }, error: (err) => {
      alert("Error al modificar PROYECTO");
      this.router.navigate(['']);
    }
  });
}
uploadImageV($event: any) {
  const fecha= new Date();
  const nombrearch="proyecto_"+ fecha;
  this.imageService.uploadImageV($event,nombrearch);
}
}
