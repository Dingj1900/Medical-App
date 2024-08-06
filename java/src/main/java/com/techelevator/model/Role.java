package com.techelevator.model;

public class Role {
    int id;

    String role;

    Role(int id){
        this.id = id;
        this.role = "";
    }

    Role(String role){
        this.role = role;
        this.id = 0;
    }

    Role(int id, String role){
        this.id = id;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
