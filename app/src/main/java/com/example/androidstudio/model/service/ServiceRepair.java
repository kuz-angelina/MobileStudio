package com.example.androidstudio.model.service;

import java.io.Serializable;

/**
 * @author Angelina Kuzmina
 */

public class ServiceRepair extends Service  implements Serializable
{
	private RepairType repairType;

	public RepairType getRepairType()
	{
		return repairType;
	}

	public void setRepairType(RepairType repairType)
	{
		this.repairType = repairType;
	}
}
