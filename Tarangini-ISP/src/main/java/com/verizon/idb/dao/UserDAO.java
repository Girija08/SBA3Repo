package com.verizon.idb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.idb.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
