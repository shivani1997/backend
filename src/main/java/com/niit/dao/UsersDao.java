package com.niit.dao;
import com.niit.model.Users;
import java.util.List;

public interface UsersDao 
{
	public boolean addUser(Users user);
	public void deleteUser(Users user);
	public void updateUser(Users user);
	public List<Users> displayUsers();
	public Users displayUserById(Users user);
	public Users displayUserByUserName(Users user);

}
