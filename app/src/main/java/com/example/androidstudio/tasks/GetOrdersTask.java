package com.example.androidstudio.tasks;

import java.util.List;

import com.example.androidstudio.model.table.TableDataOrder;
import com.example.androidstudio.services.OrderService;
import com.example.androidstudio.services.impl.OrderServiceImpl;

import android.os.AsyncTask;

public class GetOrdersTask extends AsyncTask<Integer, Void, List<TableDataOrder>>
{
  private OrderService orderService = new OrderServiceImpl();

  @Override
  protected List<TableDataOrder> doInBackground(Integer... userId)
  {
    return orderService.getOrdersByUserId(userId[0]);
  }

  @Override
  protected void onPostExecute(List<TableDataOrder> result) {
    super.onPostExecute(result);
  }
}
