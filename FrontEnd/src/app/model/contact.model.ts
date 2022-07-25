export class contact {
    id?: number;
    gmail: string;
    git: string;
    linkedin: string;
    hotmail: string

    constructor( gmail: string, git: string, linkedin: string, hotmail: string ){
        this.gmail = gmail;
        this.git = git;
        this.linkedin = linkedin;
        this.hotmail = hotmail;
    }
}
