package com.example.androidstudio.model.role;


import com.example.androidstudio.model.UserDto;

public class Manager extends User
{
  public Manager(UserDto userDto)
  {
    super(userDto.getId(), userDto.getLogin(), userDto.getPassword(), userDto.getName(), userDto.getUserType());
  }

  public Manager()
  {
  }

}
