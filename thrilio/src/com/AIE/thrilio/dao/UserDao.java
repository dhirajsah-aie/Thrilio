package com.AIE.thrilio.dao;

import com.AIE.thrilio.DataStore;
import com.AIE.thrilio.entities.User;


//fetching user Data from DataStore , in real world use Database to fetch using mysql

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}

}
