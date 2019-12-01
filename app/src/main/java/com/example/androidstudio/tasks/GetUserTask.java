package com.example.androidstudio.tasks;

import com.example.androidstudio.model.UserDto;
import com.example.androidstudio.services.UserService;
import com.example.androidstudio.services.impl.UserServiceImpl;

import android.os.AsyncTask;

public class GetUserTask extends AsyncTask<String, Void, UserDto>
{
  private UserService userService = new UserServiceImpl();

  @Override
  protected UserDto doInBackground(String... login)
  {
    return userService.getUserByLogin(login[0]);
  }

  @Override
  protected void onPostExecute(UserDto result) {
    super.onPostExecute(result);
  }
}
