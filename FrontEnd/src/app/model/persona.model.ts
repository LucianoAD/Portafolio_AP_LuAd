
export class Persona {
    id?: number;
    nombre: string;
    apellido: string;
    cv: string;
    imgbackground: string;
    img: string;

    constructor(nombre: string, apellido: string, cv: string, imgbackground: string, img: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cv = cv;
        this.imgbackground = imgbackground;
        this.img = img;
    }
}