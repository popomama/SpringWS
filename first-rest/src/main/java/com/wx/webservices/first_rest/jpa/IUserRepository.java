package com.wx.webservices.first_rest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wx.webservices.first_rest.user.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
