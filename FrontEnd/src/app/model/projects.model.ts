export class projects {
    id? : number;
    title : string;
    tech : string;
    description : string;
    url : string;

    constructor( title: string, tech: string, description: string, url: string ){
        this.title = title;
        this.tech = tech;
        this.description = description;
        this.url = url;
    }
}
