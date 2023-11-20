package com.ats.service;

import com.ats.entity.Route;
import com.ats.exception.AdminException;
import com.ats.exception.RouteException;

import java.util.List;

public interface IRouteService {
    public Route addRoute(Route route, String key) throws RouteException, AdminException;
    public List<Route> viewAllRoute() throws RouteException;
    public Route viewRoute(int routeId) throws RouteException;
    public Route updateRoute(Route route,String key) throws RouteException, AdminException;
    public Route deleteRoute(int routeID,String key) throws RouteException, AdminException;

}
