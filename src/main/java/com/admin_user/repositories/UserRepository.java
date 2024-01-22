package com.admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin_user.model.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String email);
}
