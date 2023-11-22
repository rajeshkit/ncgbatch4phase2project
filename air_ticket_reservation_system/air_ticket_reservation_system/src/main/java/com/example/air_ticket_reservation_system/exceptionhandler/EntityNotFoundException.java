package com.example.air_ticket_reservation_system.exceptionhandler;

public class EntityNotFoundException extends  Exception{

    String msg;
    String sol;
    public EntityNotFoundException(String msg,String sol){
        super(msg);
        this.sol = sol;
        this.msg=msg;
    }

}
