package entities;
// Generated 07-07-2017 11:51:38 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Winners generated by hbm2java
 */
public class Winners  implements java.io.Serializable {


     private BigDecimal id;
     private Drafts drafts;
     private Users users;
     private BigDecimal prize;

    public Winners() {
    }

    public Winners(BigDecimal id, Drafts drafts, Users users, BigDecimal prize) {
       this.id = id;
       this.drafts = drafts;
       this.users = users;
       this.prize = prize;
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
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public BigDecimal getPrize() {
        return this.prize;
    }
    
    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "{\"data\": {" + 
                "\"id\": \"" + id.intValueExact() + '"' +
                ",\"draft\": \"" + drafts.getId() + '"' +
                ",\"user\": \"" + users.getId() + '"' +
                ",\"prize\": \"" + prize + '"' +
                "}}";
    }



}


