
export class persona {
    id?: number;
    nombre: String;
    apellido: String;
    imgbackground: String;
    img: String;

    constructor(nombre: String, apellido: String, imgbackground: String, img: String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.imgbackground = imgbackground;
        this.img = img;
    }

}