package com.project.context.services.rest;

public abstract class BaseRest {

    protected static String BASE_URL;

    //constructor
    public BaseRest() {
        this.BASE_URL = "http://dummy.restapiexample.com/api/v1";
    }

}
