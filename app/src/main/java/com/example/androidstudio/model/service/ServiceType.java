package com.example.androidstudio.model.service;

import java.io.Serializable;

/**
 * @author Angelina Kuzmina
 */

public class ServiceType implements Serializable
{
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
