package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Tasks, Long> {
}
