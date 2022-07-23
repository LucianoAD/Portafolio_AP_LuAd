package com.anselmino.backend.Dto;

import javax.validation.constraints.Size;

public class dtoAbout {
    private String imgaboutme;
    @Size(max = 500, message = "Max. 500 caracteres")
    private String mydescription;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest1;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest2;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest3;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest4;

    public dtoAbout(String imgaboutme, String mydescription, String myinterest1, String myinterest2, String myinterest3, String myinterest4) {
        this.imgaboutme = imgaboutme;
        this.mydescription = mydescription;
        this.myinterest1 = myinterest1;
        this.myinterest2 = myinterest2;
        this.myinterest3 = myinterest3;
        this.myinterest4 = myinterest4;
    }

    public String getImgaboutme() {
        return imgaboutme;
    }

    public void setImgaboutme(String imgaboutme) {
        this.imgaboutme = imgaboutme;
    }

    public String getMydescription() {
        return mydescription;
    }

    public void setMydescription(String mydescription) {
        this.mydescription = mydescription;
    }

    public String getMyinterest1() {
        return myinterest1;
    }

    public void setMyinterest1(String myinterest1) {
        this.myinterest1 = myinterest1;
    }

    public String getMyinterest2() {
        return myinterest2;
    }

    public void setMyinterest2(String myinterest2) {
        this.myinterest2 = myinterest2;
    }

    public String getMyinterest3() {
        return myinterest3;
    }

    public void setMyinterest3(String myinterest3) {
        this.myinterest3 = myinterest3;
    }

    public String getMyinterest4() {
        return myinterest4;
    }

    public void setMyinterest4(String myinterest4) {
        this.myinterest4 = myinterest4;
    }
    
    
    
    
}
