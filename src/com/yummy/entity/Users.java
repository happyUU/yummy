package com.yummy.entity;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/7 9:08
 */
public class Users {
    private String phone;
    private String password;
    private String name;
    private String email;
    private String admin;
    private String paypswd;

    public Users() {
    }

    public Users(String phone, String password, String name, String email, String paypswd) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.email = email;
        this.paypswd = paypswd;
    }

    public Users(String phone, String password, String name, String email, String admin, String paypswd) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.email = email;
        this.admin = admin;
        this.paypswd = paypswd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPaypswd() {
        return paypswd;
    }

    public void setPaypswd(String paypswd) {
        this.paypswd = paypswd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", admin='" + admin + '\'' +
                ", paypswd='" + paypswd + '\'' +
                '}';
    }
}
