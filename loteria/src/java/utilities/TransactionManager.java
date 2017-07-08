/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Recharges;
import entities.Tickets;
import entities.Transactions;
import entities.Users;
import java.math.BigDecimal;
import javax.xml.ws.WebServiceRef;
import model.RechargesModel;
import model.TicketsModel;
import model.TransactionsModel;
import model.UsersModel;
import services.Payment;
import services.Payment_Service;

/**
 *
 * @author Joe-Xidu
 */
public class TransactionManager {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_42724/Payment/Payment.wsdl")
    static Payment_Service paymentService = new Payment_Service();
    static final Payment PAYMENT = TransactionManager.paymentService.getPaymentPort();
    public static final BigDecimal TICKET_PRICE = BigDecimal.valueOf(1200.0);
    
    public static int makeTransaction(String account, String amount) {
        return TransactionManager.PAYMENT.transaction(account, amount);
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
    
    public static boolean makeRecharge(Users user, BigDecimal amount, BigDecimal transaction, String payMethod) throws Exception {
        boolean isValid = false;
        TransactionsModel transactionsModel = new TransactionsModel();
        RechargesModel rechargesModel = new RechargesModel();
        Transactions transactions = new Transactions(transaction, payMethod, amount);
        if (transactionsModel.createTransactions(transactions)) {
            Recharges recharges = new Recharges(BigDecimal.ONE, transactions, user, amount);
            if (rechargesModel.createRecharges(recharges)) {
                UsersModel um = new UsersModel();
                user.setWallet(user.getWallet().add(amount));
                isValid = um.updateUsers(user);
            } else {
                throw new Exception("Error en la recarga. Comuníquese con el administrador.");
            }
        } else {
            throw new Exception("Error en la transacción. Comuníquese con el administrador.");
        }
        return isValid;
    }
    
    
    
}
