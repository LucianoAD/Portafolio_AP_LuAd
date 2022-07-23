export class Tecnologias {
    id? : number;
    title : string;
    imgtech : string;
    perctech : string;

    constructor( title: string, imgtech: string, perctech: string ){
        this.title = title;
        this.imgtech = imgtech;
        this.perctech = perctech;
    }
}
