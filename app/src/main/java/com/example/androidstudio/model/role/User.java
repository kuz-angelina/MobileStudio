package com.example.androidstudio.model.role;

import java.io.Serializable;

public abstract class User implements Serializable {

    private Integer id;
    private String login;
    private String password;
    private String name;
    private UserType userType;

    public User(Integer id, String login, String password, String name, UserType userType)
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.userType = userType;
    }

    public User() {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public UserType getUserType()
    {
        return userType;
    }

    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }
}
