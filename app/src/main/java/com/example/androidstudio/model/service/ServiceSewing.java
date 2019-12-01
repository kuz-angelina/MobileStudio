package com.example.androidstudio.model.service;

/**
 * @author Angelina Kuzmina
 */

public class ServiceSewing extends Service
{
	private ServiceDate serviceDate;

	public ServiceDate getServiceDate()
	{
		return serviceDate;
	}

	public void setServiceDate(ServiceDate serviceDate)
	{
		this.serviceDate = serviceDate;
	}
}
