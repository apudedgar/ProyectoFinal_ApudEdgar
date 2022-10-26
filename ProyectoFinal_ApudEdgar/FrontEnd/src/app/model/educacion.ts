export class Educacion {
    id ?:number;
    nombreE:string;
    descripcionE:string;
    anioE:string;

    constructor (nombreE: string, descripcionE: string,anioE:string){
        this.nombreE=nombreE;
        this.descripcionE=descripcionE;
        this.anioE=anioE;
    }
}
