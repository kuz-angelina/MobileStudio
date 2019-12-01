package com.example.androidstudio.model.role;

import java.util.Date;

import com.example.androidstudio.model.UserDto;

/**
 * @author Angelina Kuzmina
 */

public class Tailor extends User
{
	private String phoneNumber;
	private String address;
	private Integer experience;
	private Date dateOfAdoption;

	public Tailor(UserDto userDto)
	{
		super(userDto.getId(), userDto.getLogin(), userDto.getPassword(), userDto.getName(), userDto.getUserType());
		this.phoneNumber = userDto.getPhoneNumber();
		this.address = userDto.getAddress();
		this.experience = userDto.getExperience();
		this.dateOfAdoption = userDto.getDateOfAdoption();
	}

	public Tailor()
	{
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Integer getExperience()
	{
		return experience;
	}

	public void setExperience(Integer experience)
	{
		this.experience = experience;
	}

	public Date getDateOfAdoption()
	{
		return dateOfAdoption;
	}

	public void setDateOfAdoption(Date dateOfAdoption)
	{
		this.dateOfAdoption = dateOfAdoption;
	}
}

