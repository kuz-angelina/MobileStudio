package com.example.androidstudio.activity;

import java.util.concurrent.ExecutionException;

import com.example.androidstudio.R;
import com.example.androidstudio.model.UserDto;
import com.example.androidstudio.model.role.Client;
import com.example.androidstudio.model.role.Manager;
import com.example.androidstudio.model.role.Tailor;
import com.example.androidstudio.model.role.User;
import com.example.androidstudio.model.role.UserType;
import com.example.androidstudio.tasks.GetUserTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity
{
  Button btLogin;
  EditText fieldLogin;
  EditText fieldPass;
  UserDto userDto;
  Client client;
  Manager manager;
  Tailor tailor;
  String login;
  String pass;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btLogin = findViewById(R.id.btLogin);
    fieldLogin = findViewById(R.id.fieldLogin);
    fieldPass = findViewById(R.id.fieldPass);
    btLogin.setOnClickListener(new LoginListener());
  }


  class LoginListener implements View.OnClickListener
  {
    @Override
    public void onClick(View v)
    {
      login = String.valueOf(fieldLogin.getText());
      pass = String.valueOf(fieldPass.getText());
      GetUserTask getUserTask = new GetUserTask();
      getUserTask.execute(login);
      try
      {
        userDto = getUserTask.get();
      }
      catch (ExecutionException | InterruptedException e)
      {
        e.printStackTrace();
      }
      checkLogin(userDto);
      assumeRoleAndContinue(userDto);
    }
  }

  private void assumeRoleAndContinue(UserDto userDto)
  {
    Intent intent = null;
    switch (userDto.getUserType().getName())
    {
      case UserType.CLIENT:
        client = new Client(userDto);
        intent = new Intent(this, ClientActivity.class);
        intent.putExtra(User.class.getSimpleName(), client);
        break;
      case UserType.MANAGER:
        //          manager = new Manager(userDto);
        //          new Intent(this, ManagerActivity.class);
        //          intent.putExtra(User.class.getSimpleName(), manager);
      case UserType.TAILOR:
        //          tailor = new Tailor(userDto);
        //          new Intent(this, TailorActivity.class);
        //          intent.putExtra(User.class.getSimpleName(), manager);
    }
    startActivity(intent);
  }


  private void checkLogin(UserDto userDto)
  {
    if (userDto.getPassword() != null && userDto.getPassword().equals(pass))
    {
      Toast.makeText(this, "Succes", Toast.LENGTH_LONG).show();
    }
    else
    {
      Toast.makeText(this, "Incorect Login/Password", Toast.LENGTH_LONG).show();
    }
  }
}
