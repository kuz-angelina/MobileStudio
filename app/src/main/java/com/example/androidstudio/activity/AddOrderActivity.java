package com.example.androidstudio.activity;

import com.example.androidstudio.R;
import com.example.androidstudio.model.table.TableDataOrder;
import com.example.androidstudio.tasks.RemoveOrderTask;
import com.example.androidstudio.tasks.SendOrderTask;
import com.example.androidstudio.tasks.UpdateOrderTask;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddOrderActivity extends AppCompatActivity implements View.OnClickListener
{
  Button btAddOrder;
  Button btBack;
  Button btSaveOrder;
  Button btRemoveOrder;
  Button btCancel;
  TextView textViewServiceListInit;
  TextView textViewRepairListInit;
  TextView textViewClotherListInit;
  TableDataOrder tableDataOrder;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_order);

    btAddOrder = findViewById(R.id.btAddOrder_order);
    btBack = findViewById(R.id.btBack);
    btSaveOrder = findViewById(R.id.btSaveOrder);
    btRemoveOrder = findViewById(R.id.btRemoveOrder);
    btCancel = findViewById(R.id.btCancel);
    btAddOrder.setOnClickListener(this);
    btBack.setOnClickListener(this);
    btSaveOrder.setOnClickListener(this);
    btRemoveOrder.setOnClickListener(this);
    btCancel.setOnClickListener(this);

    textViewServiceListInit = findViewById(R.id.textViewServiceListInit);
    textViewRepairListInit = findViewById(R.id.textViewRepairListInit);
    textViewClotherListInit = findViewById(R.id.textViewClotherListInit);
    textViewServiceListInit.setOnClickListener(this);
    textViewRepairListInit.setOnClickListener(this);
    textViewClotherListInit.setOnClickListener(this);

    Bundle params = getIntent().getExtras();
    tableDataOrder = (TableDataOrder) params.getSerializable("tableDataOrder");
    if (tableDataOrder == null)
    {
      tableDataOrder = new TableDataOrder();
      btRemoveOrder.setVisibility(View.INVISIBLE);
      btSaveOrder.setVisibility(View.INVISIBLE);
      btCancel.setVisibility(View.INVISIBLE);
      String user_login = (String) params.getSerializable("user_login");
      tableDataOrder.setClientLogin(user_login);
    }
    else
    {
      btAddOrder.setVisibility(View.INVISIBLE);
      btBack.setVisibility(View.INVISIBLE);
      textViewServiceListInit.setText(tableDataOrder.getServiceType());
      textViewRepairListInit.setText(tableDataOrder.getRepairType());
      textViewClotherListInit.setText(tableDataOrder.getClotherType());
    }

  }

  @Override
  public void onClick(View v)
  {
    Intent intent = null;
    switch (v.getId())
    {
      case R.id.btAddOrder_order:
        SendOrderTask sendOrderTask = new SendOrderTask();
        sendOrderTask.execute(tableDataOrder);
        Toast.makeText(this, R.string.order_add_complete, Toast.LENGTH_LONG).show();
        finish();
        break;
      case R.id.btSaveOrder:
        UpdateOrderTask updateOrderTask = new UpdateOrderTask();
        updateOrderTask.execute(tableDataOrder);
        Toast.makeText(this, R.string.order_edit_complete, Toast.LENGTH_LONG).show();
        finish();
        break;
      case R.id.btRemoveOrder:
        RemoveOrderTask removeOrderTask = new RemoveOrderTask();
        removeOrderTask.execute(tableDataOrder.getId());
        Toast.makeText(this, R.string.order_remove_complete, Toast.LENGTH_LONG).show();
        finish();
        break;
      case R.id.btBack:
      case R.id.btCancel:
        finish();
        break;
      case R.id.textViewServiceListInit:
        intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("listContentId", R.array.serviceTypeListContent);
        startActivityForResult(intent, 1);
        break;
      case R.id.textViewRepairListInit:
        intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("listContentId", R.array.repairTypeListContent);
        startActivityForResult(intent, 2);
        break;
      case R.id.textViewClotherListInit:
        intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("listContentId", R.array.clotherTypeListContent);
        startActivityForResult(intent, 3);
        break;
      default:
        break;
    }

  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    if (data == null)
    {
      return;
    }
    switch (requestCode)
    {
      case 1:
        textViewServiceListInit.setText(data.getStringExtra("name"));
        int serivceId = data.getIntExtra("id", 1);
        tableDataOrder.setServiceTypeId(serivceId);
        if (serivceId == 1)
        {
          textViewRepairListInit.setOnClickListener(null);
          textViewRepairListInit.setText("---");
        }
        else
        {
          textViewRepairListInit.setOnClickListener(this);
          textViewRepairListInit.setText(R.string.textView_as_list);
        }
        break;
      case 2:
        textViewRepairListInit.setText(data.getStringExtra("name"));
        tableDataOrder.setRepairTypeId(data.getIntExtra("id", 1));
        break;
      case 3:
        textViewClotherListInit.setText(data.getStringExtra("name"));
        tableDataOrder.setClotherTypeId(data.getIntExtra("id", 1));
        break;
      default:
        break;
    }
  }
}
