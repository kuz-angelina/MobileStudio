package com.example.androidstudio.model.clothes;

import java.io.Serializable;

/**
 * @author Angelina Kuzmina
 */
public class ClotheType implements Serializable
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
