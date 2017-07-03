package entities;
// Generated 25-jun-2017 14:24:32 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Payment generated by hbm2java
 */
public class Payment  implements java.io.Serializable {


     private BigDecimal id;
     private BigDecimal noTickets;
     private BigDecimal amount;
     private BigDecimal transactionsId;
     private Set ticketses = new HashSet(0);

    public Payment() {
    }

	
    public Payment(BigDecimal id, BigDecimal noTickets, BigDecimal transactionsId) {
        this.id = id;
        this.noTickets = noTickets;
        this.transactionsId = transactionsId;
    }
    public Payment(BigDecimal id, BigDecimal noTickets, BigDecimal amount, BigDecimal transactionsId, Set ticketses) {
       this.id = id;
       this.noTickets = noTickets;
       this.amount = amount;
       this.transactionsId = transactionsId;
       this.ticketses = ticketses;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
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
    public BigDecimal getTransactionsId() {
        return this.transactionsId;
    }
    
    public void setTransactionsId(BigDecimal transactionsId) {
        this.transactionsId = transactionsId;
    }
    public Set getTicketses() {
        return this.ticketses;
    }
    
    public void setTicketses(Set ticketses) {
        this.ticketses = ticketses;
    }




}

