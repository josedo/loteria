package entities;
// Generated 05-07-2017 11:24:52 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Payment generated by hbm2java
 */
public class Payment  implements java.io.Serializable {


     private BigDecimal id;
     private Transactions transactions;
     private BigDecimal noTickets;
     private BigDecimal amount;
     private Set ticketses = new HashSet(0);

    public Payment() {
    }

	
    public Payment(BigDecimal id, Transactions transactions, BigDecimal noTickets) {
        this.id = id;
        this.transactions = transactions;
        this.noTickets = noTickets;
    }
    public Payment(BigDecimal id, Transactions transactions, BigDecimal noTickets, BigDecimal amount, Set ticketses) {
       this.id = id;
       this.transactions = transactions;
       this.noTickets = noTickets;
       this.amount = amount;
       this.ticketses = ticketses;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public Transactions getTransactions() {
        return this.transactions;
    }
    
    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
    public BigDecimal getNoTickets() {
        return this.noTickets;
    }
    
    public void setNoTickets(BigDecimal noTickets) {
        this.noTickets = noTickets;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Set getTicketses() {
        return this.ticketses;
    }
    
    public void setTicketses(Set ticketses) {
        this.ticketses = ticketses;
    }

    @Override
    public String toString() {
        return "{\"data\": {" + 
                "\"id\": \"" + id.intValueExact() + '"' +
                ",\"transaction\": \"" + transactions.getId() + '"' +
                ",\"noTickets\": \"" + noTickets + '"' +
                ",\"amount\": \"" + amount + '"' +
                "}}";
    }


}


