/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Joe-Xidu
 */
@WebService(serviceName = "Payment")
@Stateless()
public class Payment {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "transaction")
    public int transaction(@WebParam(name = "account") String account, @WebParam(name = "mount") String mount) {
        return this.transactionCode();
    }
    
    private int transactionCode(){
        return (int)(Math.random()*(99999999-10000000+1)+10000000);
    }
}
