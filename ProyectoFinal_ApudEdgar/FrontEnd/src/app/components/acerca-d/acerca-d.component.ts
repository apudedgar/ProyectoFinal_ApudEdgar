import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-d',
  templateUrl: './acerca-d.component.html',
  styleUrls: ['./acerca-d.component.css']
})
export class AcercaDComponent implements OnInit {
  persona:Persona=null;
  constructor(private personaS: PersonaService,private tokenService:TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.cargarPersona();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarPersona():void{
    this.personaS.detail(1).subscribe(data=>{
        this.persona=data}
      )
  }

}
