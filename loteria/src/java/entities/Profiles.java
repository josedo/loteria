package entities;
// Generated 05-jul-2017 1:22:33 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Profiles generated by hbm2java
 */
public class Profiles  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private Set profilesPageses = new HashSet(0);
     private Set userses = new HashSet(0);

    public Profiles() {
    }

	
    public Profiles(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }
    public Profiles(BigDecimal id, String name, Set profilesPageses, Set userses) {
       this.id = id;
       this.name = name;
       this.profilesPageses = profilesPageses;
       this.userses = userses;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getProfilesPageses() {
        return this.profilesPageses;
    }
    
    public void setProfilesPageses(Set profilesPageses) {
        this.profilesPageses = profilesPageses;
    }
    public Set getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set userses) {
        this.userses = userses;
    }




}


