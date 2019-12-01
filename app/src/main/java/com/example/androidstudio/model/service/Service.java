package com.example.androidstudio.model.service;

import java.io.Serializable;

/**
 * @author Angelina Kuzmina
 */

public abstract class Service implements Serializable
{
	private Integer id;
	private Integer quantity;
	private ServiceType serviceType;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public ServiceType getServiceType()
	{
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType)
	{
		this.serviceType = serviceType;
	}
}


