package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DemoEntity;

public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

}
