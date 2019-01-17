/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class UserModel {
    private int user_id;
    private String user_name;
    private String user_pass;
    private String fullname;
    private String role;
    private String address;
    private int age;
    private boolean gender;
    private String date_start;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public UserModel() {
    }

    public UserModel(int user_id, String user_name, String user_pass, String fullname, String role, String address, int age, boolean gender, String date_start) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.fullname = fullname;
        this.role = role;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.date_start = date_start;
    }
    
    
}
