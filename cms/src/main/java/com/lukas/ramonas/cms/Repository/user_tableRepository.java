package com.lukas.ramonas.cms.Repository;

import org.springframework.data.repository.CrudRepository;

import com.lukas.ramonas.cms.Model.user_table;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface user_tableRepository extends CrudRepository<user_table, Integer> {

}