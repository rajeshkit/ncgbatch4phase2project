package com.ats.repository;
import com.ats.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IFlightRepository extends JpaRepository<Flight,Integer>{
    public List<Flight> findByFlightType(String flightType);

    public Flight findByRouteFromAndRouteTo(String routeFrom, String routeTo);
}
