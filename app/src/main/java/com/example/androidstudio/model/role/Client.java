package com.example.androidstudio.model.role;

import com.example.androidstudio.model.UserDto;

public class Client extends User {
    private String email;
    private String phoneNumber;

    public Client(UserDto userDto) {
        super(userDto.getId(), userDto.getLogin(), userDto.getPassword(), userDto.getName(), userDto.getUserType());
        this.email = userDto.getEmail();
        this.phoneNumber = userDto.getPhoneNumber();
    }

    public Client() {
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
