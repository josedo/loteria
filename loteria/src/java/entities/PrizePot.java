package entities;
// Generated 06-jul-2017 0:44:31 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * PrizePot generated by hbm2java
 */
public class PrizePot  implements java.io.Serializable {


     private BigDecimal id;
     private BigDecimal pot;

    public PrizePot() {
    }

    public PrizePot(BigDecimal id, BigDecimal pot) {
       this.id = id;
       this.pot = pot;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public BigDecimal getPot() {
        return this.pot;
    }
    
    public void setPot(BigDecimal pot) {
        this.pot = pot;
    }

    @Override
    public String toString() {
        return "{\"data\": {" + 
                "\"id\": \"" + id.intValueExact() + '"' +
                ",\"pot\": \"" + pot + '"' +
                "}}";
    }


}


