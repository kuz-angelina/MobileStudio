/**
 * @author Angelina Kuzmina
 * Created on 12/29/18
 */

package com.example.androidstudio.model.footwear;

import java.io.Serializable;

public class FootwearType implements Serializable
{
	private Integer id;
	private String name;
	private Integer size;
	private String color;

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

	public Integer getSize()
	{
		return size;
	}

	public void setSize(Integer size)
	{
		this.size = size;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}
}
