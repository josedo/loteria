/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.xml.ws.WebServiceRef;
import service.Payment;
import service.Payment_Service;

/**
 *
 * @author Joe-Xidu
 */
public class TransactionManager {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Payment/Payment.wsdl")
    static Payment_Service paymentService = new Payment_Service();
    static final Payment PAYMENT = TransactionManager.paymentService.getPaymentPort();
    
    public static int makeTransaction(String account, String mount) {
        return TransactionManager.PAYMENT.transaction(account, mount);
    }
    
}
