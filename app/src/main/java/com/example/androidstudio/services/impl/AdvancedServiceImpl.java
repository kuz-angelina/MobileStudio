package com.example.androidstudio.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.example.androidstudio.model.clothes.ClotheType;
import com.example.androidstudio.model.footwear.FootwearType;
import com.example.androidstudio.model.service.RepairType;
import com.example.androidstudio.model.service.ServiceType;
import com.example.androidstudio.services.AdvancedService;


/**
 * @author Angelina Kuzmina
 */
public class AdvancedServiceImpl implements AdvancedService
{
	String url = "http://10.0.2.2:8080/advanced";
	HessianProxyFactory factory = new HessianProxyFactory();

	AdvancedService advancedService;

	@Override
	public List<ServiceType> getAllServiceType()
	{
		try
		{
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getAllServiceType();
	}

	@Override
	public List<RepairType> getAllRepairType()
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getAllRepairType();
	}

	@Override
	public List<ClotheType> getAllClothesType()
	{

		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getAllClothesType();
	}

	@Override
	public List<FootwearType> getAllFootwearType()
	{

		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getAllFootwearType();
	}

	@Override
	public ClotheType getClotheTypeByID(Integer clotheId)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getClotheTypeByID(clotheId);
	}

	@Override
	public FootwearType getFootwearTypeByID(Integer clotheId)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getFootwearTypeByID(clotheId);
	}

	@Override
	public ServiceType getServiceTypeById(Integer serviceTypeId)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getServiceTypeById(serviceTypeId);
	}

	@Override
	public RepairType getRepairTypeById(Integer repairTypeId)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			advancedService = (AdvancedService) factory.create(AdvancedService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return advancedService.getRepairTypeById(repairTypeId);
	}

	@Override
	public void savefootwearType(FootwearType footwearType)
	{
		advancedService.savefootwearType(footwearType);
	}

	@Override
	public void updatefootwearType(FootwearType footwearType) {

	}
}
