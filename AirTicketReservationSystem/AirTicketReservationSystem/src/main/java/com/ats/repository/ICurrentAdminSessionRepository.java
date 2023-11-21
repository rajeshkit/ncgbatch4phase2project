package com.ats.repository;

import com.ats.entity.CurrentAdminSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrentAdminSessionRepository extends JpaRepository<CurrentAdminSession, Integer> {
    @Query("select c from CurrentAdminSession c where c.aid=?1")
    public CurrentAdminSession findByaid(String aid);
}
