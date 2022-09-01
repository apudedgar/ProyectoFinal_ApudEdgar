import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-acerca-d',
  templateUrl: './acerca-d.component.html',
  styleUrls: ['./acerca-d.component.css']
})
export class AcercaDComponent implements OnInit {
  persona:persona=new persona("","","");
  constructor(public personaService: PersonaService) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data=>(this.persona=data))
  }

}
