package com.example.androidstudio.model.service;


import java.io.Serializable;
import java.sql.Date;

/**
 * @author Angelina Kuzmina
 */

public class ServiceDate implements Serializable
{
	private Integer id;
	private Date measurements;
	private Date modeling;
	private Date pattern;
	private Date stitching;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Date getMeasurements()
	{
		return measurements;
	}

	public void setMeasurements(Date measurements)
	{
		this.measurements = measurements;
	}

	public Date getModeling()
	{
		return modeling;
	}

	public void setModeling(Date modeling)
	{
		this.modeling = modeling;
	}

	public Date getPattern()
	{
		return pattern;
	}

	public void setPattern(Date pattern)
	{
		this.pattern = pattern;
	}

	public Date getStitching()
	{
		return stitching;
	}

	public void setStitching(Date stitching)
	{
		this.stitching = stitching;
	}
}
