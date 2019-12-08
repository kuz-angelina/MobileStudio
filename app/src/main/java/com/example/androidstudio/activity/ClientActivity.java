package com.example.androidstudio.activity;

import com.example.androidstudio.R;
import com.example.androidstudio.model.role.Client;
import com.example.androidstudio.model.role.User;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ClientActivity extends AppCompatActivity implements View.OnClickListener
{
  Button btShowOrders;
  Button btAddOrder;
  Button btLogout;
  TextView textViewLogin;
  TextView textViewName;
  TextView textViewPhone;
  TextView textViewEmail;
  Client client;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_clientactivity);
    btShowOrders = findViewById(R.id.btShowOrders);
    btAddOrder = findViewById(R.id.btAddOrder);
    btLogout = findViewById(R.id.btLogout);
    btShowOrders.setOnClickListener(this);
    btAddOrder.setOnClickListener(this);
    btLogout.setOnClickListener(this);
    Bundle params = getIntent().getExtras();
    client = (Client) params.getSerializable(User.class.getSimpleName());
    fillUserInfo(client);
  }

  private void fillUserInfo(Client client)
  {
    textViewLogin = findViewById(R.id.textViewLogin);
    textViewName = findViewById(R.id.textViewName);
    textViewPhone = findViewById(R.id.textViewPhone);
    textViewEmail = findViewById(R.id.textViewEmail);

    textViewLogin.setText(client.getLogin());
    textViewName.setText(client.getName());
    textViewPhone.setText(client.getPhoneNumber());
    textViewEmail.setText(client.getEmail());
  }

  @Override
  public void onClick(View v)
  {
    Intent intent = null;
    switch (v.getId())
    {
      case R.id.btShowOrders:
        intent = new Intent(this, OrdersActivity.class);
        intent.putExtra("user_id", client.getId());
        break;
      case R.id.btAddOrder:
        intent = new Intent(this, AddOrderActivity.class);
        intent.putExtra("user_login", client.getLogin());
        break;
      case R.id.btLogout:
        finish();
        moveTaskToBack(true);
      default:
        break;
    }
    if (intent != null)
    {
      startActivity(intent);
    }
  }
}
