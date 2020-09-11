package com.example.demo3.pojo;

public class User {
    private String username ;
    private  String userid ;
    private  String password ;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
