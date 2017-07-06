package entities;
// Generated 05-07-2017 11:24:52 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Tickets generated by hbm2java
 */
public class Tickets  implements java.io.Serializable {


     private BigDecimal id;
     private Drafts drafts;
     private Payment payment;
     private Users users;
     private BigDecimal number1;
     private BigDecimal number2;
     private BigDecimal number3;
     private BigDecimal number4;
     private BigDecimal number5;
     private BigDecimal number6;

    public Tickets() {
    }

    public Tickets(BigDecimal id, Drafts drafts, Payment payment, Users users, BigDecimal number1, BigDecimal number2, BigDecimal number3, BigDecimal number4, BigDecimal number5, BigDecimal number6) {
       this.id = id;
       this.drafts = drafts;
       this.payment = payment;
       this.users = users;
       this.number1 = number1;
       this.number2 = number2;
       this.number3 = number3;
       this.number4 = number4;
       this.number5 = number5;
       this.number6 = number6;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public Drafts getDrafts() {
        return this.drafts;
    }
    
    public void setDrafts(Drafts drafts) {
        this.drafts = drafts;
    }
    public Payment getPayment() {
        return this.payment;
    }
    
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public BigDecimal getNumber1() {
        return this.number1;
    }
    
    public void setNumber1(BigDecimal number1) {
        this.number1 = number1;
    }
    public BigDecimal getNumber2() {
        return this.number2;
    }
    
    public void setNumber2(BigDecimal number2) {
        this.number2 = number2;
    }
    public BigDecimal getNumber3() {
        return this.number3;
    }
    
    public void setNumber3(BigDecimal number3) {
        this.number3 = number3;
    }
    public BigDecimal getNumber4() {
        return this.number4;
    }
    
    public void setNumber4(BigDecimal number4) {
        this.number4 = number4;
    }
    public BigDecimal getNumber5() {
        return this.number5;
    }
    
    public void setNumber5(BigDecimal number5) {
        this.number5 = number5;
    }
    public BigDecimal getNumber6() {
        return this.number6;
    }
    
    public void setNumber6(BigDecimal number6) {
        this.number6 = number6;
    }

    @Override
    public String toString() {
        return "{\"data\": {" + 
                "\"id\": \"" + id.intValueExact() + '"' +
                ",\"payment\": \"" + payment.getId() + '"' +
                ",\"user\": \"" + users.getId() + '"' +
                ",\"draft\": \"" + drafts.getId() + '"' +
                ",\"number1\": \"" + number1 + '"' +
                ",\"number2\": \"" + number2 + '"' +
                ",\"number3\": \"" + number3 + '"' +
                ",\"number4\": \"" + number4 + '"' +
                ",\"number5\": \"" + number5 + '"' +
                ",\"number6\": \"" + number6 + '"' +
                "}}";
    }


}


