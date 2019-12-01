package com.example.androidstudio.tasks;

import com.example.androidstudio.services.OrderService;
import com.example.androidstudio.services.impl.OrderServiceImpl;

import android.os.AsyncTask;

public class RemoveOrderTask extends AsyncTask<Integer, Void, Void>
{
  private OrderService orderService = new OrderServiceImpl();

  @Override
  protected Void doInBackground(Integer... id)
  {
    orderService.removeOrder(id[0]);
    return null;
  }

  @Override
  protected void onPostExecute(Void result)
  {
    super.onPostExecute(result);
  }
}
