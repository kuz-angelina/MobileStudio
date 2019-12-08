package com.example.androidstudio.tasks;

import com.example.androidstudio.R;
import com.example.androidstudio.model.UserDto;
import com.example.androidstudio.services.UserService;
import com.example.androidstudio.services.impl.UserServiceImpl;

import android.content.Context;
import android.os.AsyncTask;

public class GetUserTask extends AsyncTask<String, Void, UserDto>
{
  private Context context;
  private UserService userService;

  public GetUserTask(Context context)
  {
    this.context = context;
  }

  @Override
  protected UserDto doInBackground(String... login)
  {
    String url = context.getResources().getString(R.string.url_user);
    userService = new UserServiceImpl(url);
    return userService.getUserByLogin(login[0]);
  }

  @Override
  protected void onPostExecute(UserDto result) {
    super.onPostExecute(result);
  }
}
