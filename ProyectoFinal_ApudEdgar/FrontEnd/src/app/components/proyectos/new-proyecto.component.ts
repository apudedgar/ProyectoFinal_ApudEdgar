import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Proyecto } from 'src/app/model/proyecto';

import { ImgService } from 'src/app/service/img.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {
  nombreP:string='';
  descripcionP:string='';
  imgP:string='';
  

  constructor(private ProyectoS:ProyectoService, private router:Router,public imageService:ImgService) { }
 
  ngOnInit(): void {
       
  }

  onCreate():void{
    const proyecto=new Proyecto(this.nombreP,this.descripcionP, this.imageService.url);
      this.ProyectoS.save(proyecto).subscribe({next:(data)=>{
      alert("Proyecto añadido");
      this.router.navigate(['']);
    },error:(err)=>{
      alert("Falló");
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
