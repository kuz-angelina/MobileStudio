package com.example.androidstudio.tasks;

import java.util.List;

import com.example.androidstudio.R;
import com.example.androidstudio.model.table.TableDataOrder;
import com.example.androidstudio.services.OrderService;
import com.example.androidstudio.services.impl.OrderServiceImpl;

import android.content.Context;
import android.os.AsyncTask;

public class GetOrdersTask extends AsyncTask<Integer, Void, List<TableDataOrder>>
{
  private OrderService orderService;
  private Context context;

  public GetOrdersTask(Context context)
  {
    this.context = context;
  }

  @Override
  protected List<TableDataOrder> doInBackground(Integer... userId)
  {
    String url = context.getResources().getString(R.string.url_order);
    orderService = new OrderServiceImpl(url);
    return orderService.getOrdersByUserId(userId[0]);
  }

  @Override
  protected void onPostExecute(List<TableDataOrder> result) {
    super.onPostExecute(result);
  }
}
