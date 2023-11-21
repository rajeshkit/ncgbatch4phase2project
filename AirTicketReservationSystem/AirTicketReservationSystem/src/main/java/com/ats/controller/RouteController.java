package com.ats.controller;

import com.ats.entity.Route;
import com.ats.exception.AdminException;
import com.ats.exception.RouteException;
import com.ats.service.IRouteService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats")
public class RouteController {
    private final IRouteService routeService;
    private final Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    public RouteController(IRouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/admin/route/add")
    public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route, @RequestParam(required = false) String key) throws RouteException, AdminException {
        logger.info("Received request to add route with details: {}", route);
        Route newRoute = routeService.addRoute(route, key);
        logger.info("Route added successfully. Route details: {}", newRoute);
        return new ResponseEntity<>(newRoute, HttpStatus.ACCEPTED);
    }

    @GetMapping("/route/all")
    public ResponseEntity<List<Route>> getAllRouteHandler() throws RouteException {
        logger.info("Received request to get all routes.");
        List<Route> route = routeService.viewAllRoute();
        logger.info("Total routes: {}", route.size());
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @GetMapping("/route/{routeID}")
    public ResponseEntity<Route> getRouteByRouteIdHandler(@PathVariable Integer routeID) throws RouteException {
        logger.info("Received request to get route by routeId: {}", routeID);
        Route route = routeService.viewRoute(routeID);
        logger.info("Route details: {}", route);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @PutMapping("/admin/route/update")
    public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route, @RequestParam(required = false) String key) throws RouteException, AdminException {
        logger.info("Received request to update route with details: {}", route);
        Route updatedRoute = routeService.updateRoute(route, key);
        logger.info("Route updated successfully. Updated route details: {}", updatedRoute);
        return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
    }

    @DeleteMapping("/admin/route/delete/{routeID}")
    public ResponseEntity<Route> deleteRoute(@PathVariable Integer routeID, @RequestParam(required = false) String key) throws RouteException, AdminException {
        logger.info("Received request to delete route with routeId: {}", routeID);
        Route deletedRoute = routeService.deleteRoute(routeID, key);
        logger.info("Route deleted successfully. Deleted route details: {}", deletedRoute);
        return new ResponseEntity<>(deletedRoute, HttpStatus.OK);
    }
}
