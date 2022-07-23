export class About {
    id?: number;
    imgaboutme: string;
    mydescription: string;
    myinterest1: string;
    myinterest2: string;
    myinterest3: string;
    myinterest4: string;

    constructor( imgaboutme: string, mydescription: string, myinterest1: string, myinterest2: string, myinterest3: string, myinterest4: string ){
        this.imgaboutme = imgaboutme;
        this.mydescription = mydescription;
        this.myinterest1 = myinterest1;
        this.myinterest2 = myinterest2;
        this.myinterest3 = myinterest3;
        this.myinterest4 = myinterest4;
    }
}
