import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {
  sk:Skill=null;
  constructor(private sskill:SkillService,private activatedRouter:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const id=this.activatedRouter.snapshot.params['id'];  
    this.sskill.detail(id).subscribe({next:(data)=>{

      this.sk=data;
    },error:(err)=>{
      alert("Error al modificar experiencia");
      this.router.navigate(['']);
     }
    });
  }
  onUpdate():void{
    const id=this.activatedRouter.snapshot.params['id'];
    this.sskill.update(id,this.sk).subscribe({next:(data)=>{
      this.router.navigate(['']);
    }, error:(err)=>{
      alert("Error al modificar experiencia");
      this.router.navigate(['']);
    }
  });
  }
}
