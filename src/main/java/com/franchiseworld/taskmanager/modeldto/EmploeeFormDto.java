package com.franchiseworld.taskmanager.modeldto;

public class EmploeeFormDto {


    private String usernameEmail;

    private String password;

    private String position;

    public EmploeeFormDto() {
    }

    public EmploeeFormDto(String usernameEmail, String password, String position) {
        this.usernameEmail = usernameEmail;
        this.password = password;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsernameEmail() {
        return usernameEmail;
    }

    public void setUsernameEmail(String usernameEmail) {
        this.usernameEmail = usernameEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
