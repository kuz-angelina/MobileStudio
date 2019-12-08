package com.example.androidstudio.tasks;

import com.example.androidstudio.R;
import com.example.androidstudio.services.OrderService;
import com.example.androidstudio.services.impl.OrderServiceImpl;

import android.content.Context;
import android.os.AsyncTask;

public class RemoveOrderTask extends AsyncTask<Integer, Void, Void>
{
  private OrderService orderService;
  private Context context;

  public RemoveOrderTask(Context context)
  {
    this.context = context;
  }

  @Override
  protected Void doInBackground(Integer... id)
  {
    String url = context.getResources().getString(R.string.url_order);
    orderService = new OrderServiceImpl(url);
    orderService.removeOrder(id[0]);
    return null;
  }

  @Override
  protected void onPostExecute(Void result)
  {
    super.onPostExecute(result);
  }
}
