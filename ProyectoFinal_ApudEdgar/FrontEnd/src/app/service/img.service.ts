import { Injectable } from '@angular/core';
import {Storage,ref,uploadBytes,list,getDownloadURL} from '@angular/fire/storage';


@Injectable({
  providedIn: 'root'
})
export class ImgService {

  url:string="";


  constructor(public storage:Storage) { }

  public uploadImageV($event:any,name:string){
    
    const file =$event.target.files[0];
    const imagenDato=ref(this.storage,`imagenes/`+ name)
    uploadBytes(imagenDato,file)
    .then(response=>{this.getImageV()})
    .catch(error=>console.log(error));
  

  }
  getImageV(){
    const imagenDato=ref(this.storage,'imagenes')
    list(imagenDato)
    .then(async response=>{
      for(let item of response.items){
        this.url=await getDownloadURL(item);
        console.log(this.url);
      }
    })
    .catch(error=>console.log(error));
    


  }

}
