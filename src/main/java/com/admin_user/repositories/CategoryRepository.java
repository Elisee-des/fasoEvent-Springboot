package com.admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin_user.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
