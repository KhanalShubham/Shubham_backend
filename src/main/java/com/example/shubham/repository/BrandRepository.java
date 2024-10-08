package com.example.shubham.repository;
import com.example.shubham.entity.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    Optional<Brand> findByBrandName(String name);


}
