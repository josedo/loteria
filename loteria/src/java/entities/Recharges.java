package entities;
// Generated 07-07-2017 11:51:38 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Recharges generated by hbm2java
 */
public class Recharges  implements java.io.Serializable {


     private BigDecimal id;
     private Transactions transactions;
     private Users users;
     private BigDecimal amount;

    public Recharges() {
    }

    public Recharges(BigDecimal id, Transactions transactions, Users users, BigDecimal amount) {
       this.id = id;
       this.transactions = transactions;
       this.users = users;
       this.amount = amount;
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
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{\"data\": {" + 
                "\"id\": \"" + id.intValueExact() + '"' +
                ",\"transaction\": \"" + transactions.getId() + '"' +
                ",\"user\": \"" + users.getId() + '"' +
                ",\"amount\": \"" + amount + '"' +
                "}}";
    }



}


