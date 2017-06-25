package entities;
// Generated 25-jun-2017 14:24:32 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Transactions generated by hbm2java
 */
public class Transactions  implements java.io.Serializable {


     private BigDecimal id;
     private String paymentMethod;
     private BigDecimal amount;

    public Transactions() {
    }

    public Transactions(BigDecimal id, String paymentMethod, BigDecimal amount) {
       this.id = id;
       this.paymentMethod = paymentMethod;
       this.amount = amount;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }




}


