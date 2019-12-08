package com.example.androidstudio.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.example.androidstudio.model.UserDto;
import com.example.androidstudio.model.role.User;
import com.example.androidstudio.model.role.UserType;
import com.example.androidstudio.services.UserService;

import android.app.Application;

/**
 * @author Angelina Kuzmina
 */
public class UserServiceImpl implements UserService
{
	String url;
	HessianProxyFactory factory = new HessianProxyFactory();
	UserService userService;

	@Override
	public boolean createUser()
	{
		return false;
	}

	@Override
	public User getUserById(Integer id)
	{
		return null;
	}

	@Override
	public UserDto getUserByLogin(String login)
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			userService = (UserService) factory.create(UserService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return userService.getUserByLogin(login);
	}

	@Override
	public List<UserType> getAllUserType()
	{
		try
		{
			//  for work without HessianProtocolException: expected hessian reply at 0x48 (H)
			factory.setHessian2Reply(false);
			userService = (UserService) factory.create(UserService.class, url);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		List<UserType> userTypes = userService.getAllUserType();
		return userTypes;
	}

	@Override
	public boolean saveUser(User user)
	{
		return false;
	}

	public UserServiceImpl(String url)
	{
		this.url = url;
	}
}
