package com.example.androidstudio.activity;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.androidstudio.R;
import com.example.androidstudio.model.table.TableDataOrder;
import com.example.androidstudio.tasks.GetOrdersTask;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OrdersActivity extends AppCompatActivity implements View.OnClickListener
{
  List<TableDataOrder> tableDataOrderList;
  TableLayout tableLayout;
  Integer clientId;
  Button btBack_orders;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ordersactivity);
    tableLayout = findViewById(R.id.tableLayoutOrders);
    btBack_orders = findViewById(R.id.btBack_orders);
    btBack_orders.setOnClickListener(this);
    Bundle params = getIntent().getExtras();
    clientId= (Integer) params.getSerializable("user_id");
    GetOrdersTask getOrdersTask = new GetOrdersTask(getApplicationContext());
    getOrdersTask.execute(clientId);
    try
    {
      tableDataOrderList = getOrdersTask.get();
    }
    catch (ExecutionException | InterruptedException e)
    {
      e.printStackTrace();
    }
    initGridHead();
    initGridData(tableDataOrderList);
  }

  private void addRowInTable(boolean isHead, String... text)
  {
    TableRow tableRow = new TableRow(this);

    TextView orderNumber = new TextView(this);
    TextView orderService = new TextView(this);
    TextView orderRepairType = new TextView(this);
    TextView orderClotheType = new TextView(this);
    TextView orderCost = new TextView(this);

    if (!isHead)
    {
      setStyleTextView(orderNumber);
      setStyleTextView(orderService);
      setStyleTextView(orderRepairType);
      setStyleTextView(orderClotheType);
      setStyleTextView(orderCost);
      tableRow.setOnClickListener(this);
    }
    else
    {
      setStyleTextViewHead(orderNumber);
      setStyleTextViewHead(orderService);
      setStyleTextViewHead(orderRepairType);
      setStyleTextViewHead(orderClotheType);
      setStyleTextViewHead(orderCost);
    }

    orderNumber.setText(text[0]);
    orderService.setText(text[1]);
    orderRepairType.setText(text[2]);
    orderClotheType.setText(text[3]);
    orderCost.setText(text[4]);

    tableRow.addView(orderNumber);
    tableRow.addView(orderService);
    tableRow.addView(orderRepairType);
    tableRow.addView(orderClotheType);
    tableRow.addView(orderCost);

    tableLayout.addView(tableRow);
  }

  private void initGridData(List<TableDataOrder> tableDataOrderList)
  {
    for (TableDataOrder tableDataOrder : tableDataOrderList)
    {
      String[] strings = {String.valueOf(tableDataOrder.getId()), tableDataOrder.getServiceType(), tableDataOrder.getRepairType(),
              tableDataOrder.getClotherType(), String.valueOf(tableDataOrder.getCost())};

      addRowInTable(false, strings);
    }
  }

  private void initGridHead()
  {
    setStyleTableLayout();
    String[] strings = {getString(R.string.order_number), getString(R.string.order_number), getString(R.string.order_service),
            getString(R.string.order_repairtype), getString(R.string.order_clothetype), getString(R.string.order_cost)};

    addRowInTable(true, strings);
  }

  private void setStyleTableLayout()
  {
    tableLayout.removeAllViews();
    tableLayout.setStretchAllColumns(true);
    //    tableLayout.setBackground(getDrawable(R.color.order_table_background));
  }

  private void setStyleTextView(TextView textView)
  {
    ShapeDrawable border = new ShapeDrawable(new RectShape());
    border.getPaint().setStyle(Paint.Style.STROKE);
    border.getPaint().setColor(Color.RED);

    textView.setBackground(border);
    textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    textView.setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
  }
  private void setStyleTextViewHead(TextView textView)
  {
    ShapeDrawable border = new ShapeDrawable(new RectShape());
    border.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    border.getPaint().setColor(Color.GREEN);

    textView.setBackground(border);
    textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    textView.setTextColor(getColor(R.color.order_table_textColor_head));
    textView.setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
  }

  @Override
  public void onClick(View v)
  {
    if (v.getId() == R.id.btBack_orders)
    {
      finish();
    }
    else
    {
      int rowIndex = tableLayout.indexOfChild(v);
      TableDataOrder tableDataOrder = tableDataOrderList.get(rowIndex - 1);
      Intent intent = new Intent(this, AddOrderActivity.class);
      intent.putExtra("tableDataOrder", tableDataOrder);
      startActivityForResult(intent, 1);
    }

  }
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    GetOrdersTask getOrdersTask = new GetOrdersTask(getApplicationContext());
    getOrdersTask.execute(clientId);
    try
    {
      tableDataOrderList = getOrdersTask.get();
    }
    catch (ExecutionException | InterruptedException e)
    {
      e.printStackTrace();
    }
    tableLayout.removeAllViews();
    initGridHead();
    initGridData(tableDataOrderList);
  }
}
