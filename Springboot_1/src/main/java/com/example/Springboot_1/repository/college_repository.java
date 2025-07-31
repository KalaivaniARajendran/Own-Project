package com.example.Springboot_1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springboot_1.Model.College;

public interface college_repository extends JpaRepository<College, Long>
{
	//Select * from college where status = 'true'
List<College> findByStatus(boolean s);



}
