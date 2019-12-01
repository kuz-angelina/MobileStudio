package com.example.androidstudio.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.example.androidstudio.model.table.TableDataOrder;
import com.example.androidstudio.services.OrderService;

/**
 * @author Angelina Kuzmina
 */
public class OrderServiceImpl implements OrderService
{
	String url = "http://10.0.2.2:8080/order";

	HessianProxyFactory factory = new HessianProxyFactory();
	OrderService orderService;

	@Override
	public void removeOrder(Integer orderId)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			orderService = (OrderService) factory.create(OrderService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		orderService.removeOrder(orderId);
	}

	@Override
	public void removeServiceDate(int serviceDateId)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			orderService = (OrderService) factory.create(OrderService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		orderService.removeServiceDate(serviceDateId);
	}


	@Override
	public TableDataOrder getOrderById(Integer id)
	{
		return null;
	}

	@Override
	public void saveOrder(TableDataOrder tableDataOrder)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			orderService = (OrderService) factory.create(OrderService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		orderService.saveOrder(tableDataOrder);
	}

	@Override
	public List<TableDataOrder> getOrdersByUserId(Integer userId)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			orderService = (OrderService) factory.create(OrderService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return orderService.getOrdersByUserId(userId);
	}

	@Override
	public List<TableDataOrder> getAllOrder()
	{
		return null;
	}

	@Override
	public void updateOrder(TableDataOrder tableDataOrder)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			orderService = (OrderService) factory.create(OrderService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		orderService.updateOrder(tableDataOrder);
	}
}
