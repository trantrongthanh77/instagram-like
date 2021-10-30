package com.cozwork.application.message;

import java.io.Serializable;

public abstract class Request implements Serializable {


    public Request() {
    }

    /**
     * Validate the request parameters
     *
     * @return TRUE / FALSE
     * @throws Exception
     */
    public Boolean validate() throws Exception {
        this.rules();
        return Boolean.TRUE;
    }

    /**
     * Defined rules base on the class inheritance
     *
     * @throws Exception
     */
    public abstract void rules() throws Exception;

}
