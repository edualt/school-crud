package com.example.school.repositories;

import com.example.school.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITutorRepository extends JpaRepository<Tutor, Long> {
}
