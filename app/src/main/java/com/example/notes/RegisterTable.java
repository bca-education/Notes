package com.example.notes;

public class RegisterTable
{
    String user_name;
    String user_password;
    String user_enroll;
    public RegisterTable(String user_name, String user_enroll, String user_password)
    {
        this.user_name = user_name;
        this.user_enroll = user_enroll;
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_enroll() {
        return user_enroll;
    }

    public void setUser_enroll(String user_enroll) {
        this.user_enroll = user_enroll;
    }

    @Override
    public String toString() {
        return "RegisterTable{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_enroll='" + user_enroll + '\'' +
                '}';
    }
}