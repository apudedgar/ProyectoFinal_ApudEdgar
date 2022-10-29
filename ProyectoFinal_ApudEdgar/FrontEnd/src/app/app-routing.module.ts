import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAcercaDComponent } from './components/acerca-d/edit-acerca-d.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectoComponent } from './components/proyectos/edit-proyecto.component';
import { NewProyectoComponent } from './components/proyectos/new-proyecto.component';
import { EditSkillComponent } from './components/skills/edit-skill.component';
import { NewSkillComponent } from './components/skills/new-skill.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'nuevaexp', component:NewExperienciaComponent},
  {path:'editexp/:id', component:EditExperienciaComponent},
  {path:'nuevaeducacion',component:NewEducacionComponent},
  {path:'editeducacion/:id',component:EditEducacionComponent},
  {path:'nuevaskill',component:NewSkillComponent},
  {path:'editskill/:id',component:EditSkillComponent},
  {path:'editaacercade/:id',component:EditAcercaDComponent},
  {path:'nuevoproyecto',component:NewProyectoComponent},
  {path:'editproyecto/:id',component:EditProyectoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
