package com.ats.repository;
import com.ats.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRouteRepository extends JpaRepository<Route, Integer>{
    public Route findByRouteFromAndRouteTo(String from,String to);
}
