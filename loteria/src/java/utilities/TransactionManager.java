/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Tickets;
import entities.Users;
import java.math.BigDecimal;
import javax.xml.ws.WebServiceRef;
import model.TicketsModel;
import model.UsersModel;
import services.Payment;
import services.Payment_Service;

/**
 *
 * @author Joe-Xidu
 */
public class TransactionManager {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Payment/Payment.wsdl")
    static Payment_Service paymentService = new Payment_Service();
    static final Payment PAYMENT = TransactionManager.paymentService.getPaymentPort();
    public static final BigDecimal TICKET_PRICE = BigDecimal.valueOf(1200.0);
    
    public static int makeTransaction(String account, String mount) {
        return TransactionManager.PAYMENT.transaction(account, mount);
    }
    
    public static boolean hasBalance(Users user) {
        return user.getWallet().compareTo(TransactionManager.TICKET_PRICE) > 0;
    }
    
    public static Users discountWallet(Users user) {
        BigDecimal wallet = user.getWallet();
        user.setWallet(wallet.subtract(TransactionManager.TICKET_PRICE));
        return user;
    }
    
    public static boolean buyTicket(Users user, Tickets ticket) throws Exception {
        boolean buying = false;
        if (TransactionManager.hasBalance(user)) {
            if (TransactionManager.isValidTicket(ticket)) {
                TicketsModel tm = new TicketsModel();
                if (tm.createTickets(ticket)) {
                    user = TransactionManager.discountWallet(user);
                    UsersModel um = new UsersModel();
                    buying = um.updateUsers(user);
                }
            } else {
                throw new Exception("Ticket inválido, secuencia de números ocupada");
            }
            
        } else {
            throw new Exception("Saldo Insuficiente");
        }
        return buying;
    }
    
    public static boolean isValidTicket(Tickets ticket) {
        boolean isValid = false;
        TicketsModel ticketsModel = new TicketsModel();
        isValid = ticket.getNumber1().compareTo(BigDecimal.valueOf(0.0)) == 1
            && ticket.getNumber2().compareTo(BigDecimal.valueOf(0.0)) == 1
            && ticket.getNumber3().compareTo(BigDecimal.valueOf(0.0)) == 1
            && ticket.getNumber4().compareTo(BigDecimal.valueOf(0.0)) == 1
            && ticket.getNumber5().compareTo(BigDecimal.valueOf(0.0)) == 1
            && ticket.getNumber6().compareTo(BigDecimal.valueOf(0.0)) == 1
            && ticketsModel.checkTicket(ticket);
        return isValid;
    }
    
    
    
}
