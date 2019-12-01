

package com.example.androidstudio.model.table;

import java.io.Serializable;

import com.example.androidstudio.model.role.Client;


public class TableDataOrder implements Serializable
{
	private Integer id;
	private Boolean tailorAssignment;
	private String clotherType;
	private int clotherTypeId;
	private Integer serviceId;
	private String serviceType;
	private int serviceTypeId;
	private String repairType;
	private int repairTypeId;
	private Integer serviceDateId;
	private String measurements;
	private String modeling;
	private String pattern;
	private String stitching;
	private Boolean complete;
	private Double cost;
	private Boolean givenOut;
	private String clientLogin;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Boolean getTailorAssignment()
	{
		return tailorAssignment;
	}

	public void setTailorAssignment(Boolean tailorAssignment)
	{
		this.tailorAssignment = tailorAssignment;
	}

	public String getClotherType()
	{
		return clotherType;
	}

	public void setClotherType(String clotherType)
	{
		this.clotherType = clotherType;
	}

	public int getClotherTypeId()
	{
		return clotherTypeId;
	}

	public void setClotherTypeId(int clotherTypeId)
	{
		this.clotherTypeId = clotherTypeId;
	}

	public Integer getServiceId()
	{
		return serviceId;
	}

	public void setServiceId(Integer serviceId)
	{
		this.serviceId = serviceId;
	}

	public String getServiceType()
	{
		return serviceType;
	}

	public void setServiceType(String serviceType)
	{
		this.serviceType = serviceType;
	}

	public int getServiceTypeId()
	{
		return serviceTypeId;
	}

	public void setServiceTypeId(int serviceTypeId)
	{
		this.serviceTypeId = serviceTypeId;
	}

	public String getRepairType()
	{
		return repairType;
	}

	public void setRepairType(String repairType)
	{
		this.repairType = repairType;
	}

	public int getRepairTypeId()
	{
		return repairTypeId;
	}

	public void setRepairTypeId(int repairTypeId)
	{
		this.repairTypeId = repairTypeId;
	}

	public Integer getServiceDateId()
	{
		return serviceDateId;
	}

	public void setServiceDateId(Integer serviceDateId)
	{
		this.serviceDateId = serviceDateId;
	}

	public String getMeasurements()
	{
		return measurements;
	}

	public void setMeasurements(String measurements)
	{
		this.measurements = measurements;
	}

	public String getModeling()
	{
		return modeling;
	}

	public void setModeling(String modeling)
	{
		this.modeling = modeling;
	}

	public String getPattern()
	{
		return pattern;
	}

	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}

	public String getStitching()
	{
		return stitching;
	}

	public void setStitching(String stitching)
	{
		this.stitching = stitching;
	}

	public Boolean getComplete()
	{
		return complete;
	}

	public void setComplete(Boolean complete)
	{
		this.complete = complete;
	}

	public Double getCost()
	{
		return cost;
	}

	public void setCost(Double cost)
	{
		this.cost = cost;
	}

	public Boolean getGivenOut()
	{
		return givenOut;
	}

	public void setGivenOut(Boolean givenOut)
	{
		this.givenOut = givenOut;
	}

	public String getClientLogin()
	{
		return clientLogin;
	}

	public void setClientLogin(String clientLogin)
	{
		this.clientLogin = clientLogin;
	}
}
