import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {
  nombre: string = '';
  porcentaje: number = 0;

  constructor(private sskill: SkillService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const sk = new Skill(this.nombre, this.porcentaje);
    this.sskill.save(sk).subscribe({
      next: (data) => {
        alert("Experiencia añadida");
        this.router.navigate(['']);
      }, error: (err) => {
        alert("Falló");
        this.router.navigate(['']);
      }
    });
  }

}
