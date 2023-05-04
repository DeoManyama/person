package com.example.person.repository;

import com.example.person.entity.personDet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepository extends JpaRepository<personDet, Long> {
}
