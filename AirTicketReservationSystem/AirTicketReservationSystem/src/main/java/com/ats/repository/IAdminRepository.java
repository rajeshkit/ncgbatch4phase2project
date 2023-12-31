package com.ats.repository;

import com.ats.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{
        List<Admin> findByEmail(String email);

}
