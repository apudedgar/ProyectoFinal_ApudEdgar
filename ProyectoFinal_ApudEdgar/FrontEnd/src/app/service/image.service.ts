import { Injectable} from '@angular/core';
import {Storage,ref,uploadBytes,list,getDownloadURL} from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})

export class ImageService {
  url:string="";


  constructor(public storage:Storage) { }

  public uploadImage($event:any,name:string){
    
    const file =$event.target.files[0];
    const imagenDato=ref(this.storage,`imagen/`+ name)
    uploadBytes(imagenDato,file)
    .then(response=>{this.getImage()})
    .catch(error=>console.log(error));
  

  }
  getImage(){
    const imagenDato=ref(this.storage,'imagen')
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