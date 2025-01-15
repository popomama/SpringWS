package com.wx.webservices.first_rest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wx.webservices.first_rest.user.Post;


public interface IPostRepository extends JpaRepository<Post, Integer> {

}
