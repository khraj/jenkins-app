package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.bean.Details;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Details,Long> {

}
