import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  sk:Skill[]=[];
  
  constructor(private sskill:SkillService,private tokenService:TokenService) { }

  isLogged=false;
  ngOnInit(): void {
    this.cargarSkill();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
    }
    cargarSkill(): void{
    this.sskill.lista().subscribe(data => {this.sk=data;})
  }
  delete(id?:number){
    if(confirm("¿Desea borrar esta información?")){
      if(id!=undefined){
      this.sskill.delete(id).subscribe(data=>{
        this.cargarSkill();}
        ,err=>{
          alert("No se pudo borrar la experiencia.");
        
      })
    }
  }
  }

}
