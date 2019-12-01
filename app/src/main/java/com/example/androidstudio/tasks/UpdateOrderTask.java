package com.example.androidstudio.tasks;

import com.example.androidstudio.model.table.TableDataOrder;
import com.example.androidstudio.services.OrderService;
import com.example.androidstudio.services.impl.OrderServiceImpl;

import android.os.AsyncTask;

public class UpdateOrderTask extends AsyncTask<TableDataOrder, Void, Void>
{
  private OrderService orderService = new OrderServiceImpl();

  @Override
  protected Void doInBackground(TableDataOrder... tableDataOrders)
  {
    orderService.updateOrder(tableDataOrders[0]);
    return null;
  }

  @Override
  protected void onPostExecute(Void result)
  {
    super.onPostExecute(result);
  }
}
