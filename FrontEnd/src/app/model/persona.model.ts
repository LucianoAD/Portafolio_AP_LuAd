
export class persona {
    id?: number;
    nombre: string;
    apellido: string;
    cv: string;
    imgbackground: string;
    img: string;
    imgaboutme: string;
    mydescription: string;
    myinterest1: string;
    myinterest2: string;
    myinterest3: string;
    myinterest4: string;

    constructor(nombre: string, apellido: string, cv: string, imgbackground: string, img: string, 
        imgaboutme: string, mydescription: string, myinterest1: string, myinterest2: string, myinterest3: string, myinterest4: string ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cv = cv;
        this.imgbackground = imgbackground;
        this.img = img;
        this.imgaboutme = imgaboutme;
        this.mydescription = mydescription;
        this.myinterest1 = myinterest1;
        this.myinterest2 = myinterest2;
        this.myinterest3 = myinterest3;
        this.myinterest4 = myinterest4;
    }
}