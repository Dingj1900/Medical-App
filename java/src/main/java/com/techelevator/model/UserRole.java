package com.techelevator.model;

public class UserRole {

    int userId;

    int roleId;

    public UserRole(){

    }
    public UserRole(int userId, int roleId){
        this.roleId = roleId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
