import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  proyecto:Proyecto[]=[];
  constructor(private ProyectoS:ProyectoService,private tokenService:TokenService) { }
  isLogged=false;
  ngOnInit(): void {
    this.cargarProyecto();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProyecto(): void{
    this.ProyectoS.lista().subscribe(data => {this.proyecto=data;});
  }
  delete(id?:number){
    if(confirm("¿Desea borrar esta información?")){
      if(id!=undefined){
      this.ProyectoS.delete(id).subscribe(data=>{
        this.cargarProyecto();}
        ,err=>{
          alert("No se pudo borrar la experiencia.");
        
      })
    }
  }
  }

}
