package com.wx.webservices.first_rest.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	static List<User> users= new ArrayList<>();
	static Integer usersCount=0;
	
	static {
		users.add( new User(++usersCount,"Adam" ,LocalDate.now().minusYears(30)));
		users.add( new User(++usersCount,"John", LocalDate.now().minusYears(25)));

		users.add( new User(++usersCount,"Bay", LocalDate.now().minusYears(14)));

	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		 Predicate<? super User> predicate =user -> user.getId()==id;
		return users.stream().filter(predicate ).findFirst().orElse(null);
	}
	
	public User saveUser(User user)
	{
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

}
