package com.example.androidstudio.services;


import java.util.List;

import com.example.androidstudio.model.table.TableDataOrder;

/**
 * @author Angelina Kuzmina
 */
public interface OrderService
{

	com.example.androidstudio.model.table.TableDataOrder getOrderById(Integer id);

	void saveOrder(TableDataOrder tableDataOrder);

	List<com.example.androidstudio.model.table.TableDataOrder> getOrdersByUserId(Integer clientId);

	List<TableDataOrder> getAllOrder();

	void updateOrder(TableDataOrder tableDataOrder);

	void removeOrder(Integer orderId);

	void removeServiceDate(int serviceDateId);
}
