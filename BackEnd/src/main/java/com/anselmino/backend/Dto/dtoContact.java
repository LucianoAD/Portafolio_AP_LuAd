package com.anselmino.backend.Dto;

public class dtoContact {
    private Long id;
    private String gmail;
    private String git;
    private String linkedin;
    private String hotmail;

    public dtoContact(Long id, String gmail, String git, String linkedin, String hotmail) {
        this.id = id;
        this.gmail = gmail;
        this.git = git;
        this.linkedin = linkedin;
        this.hotmail = hotmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getHotmail() {
        return hotmail;
    }

    public void setHotmail(String hotmail) {
        this.hotmail = hotmail;
    }
  
    
}
