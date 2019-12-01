package com.example.androidstudio.model.role;


import java.io.Serializable;

public class UserType implements Serializable
{
  public static final String CLIENT = "client";
  public static final String MANAGER = "manager";
  public static final String TAILOR = "tailor";

  private Integer id;
  private String name;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
