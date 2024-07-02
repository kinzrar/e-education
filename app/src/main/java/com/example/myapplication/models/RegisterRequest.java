package com.example.myapplication.models;

public class RegisterRequest {
    private String login;
    private String password;
    private String repeatPassword;
    private String email;
    private String realName;

    public RegisterRequest(String login, String password, String repeatPassword, String email, String realName) {
        this.login = login;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
        this.realName = realName;
    }

    // гет сет
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
