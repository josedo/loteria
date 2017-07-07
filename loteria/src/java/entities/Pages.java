package entities;
// Generated 07-07-2017 11:51:38 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Pages generated by hbm2java
 */
public class Pages  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private String url;
     private String icon;
     private BigDecimal parent;
     private Set profilesPageses = new HashSet(0);

    public Pages() {
    }

	
    public Pages(BigDecimal id, String name, String url, String icon, BigDecimal parent) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.parent = parent;
    }
    public Pages(BigDecimal id, String name, String url, String icon, BigDecimal parent, Set profilesPageses) {
       this.id = id;
       this.name = name;
       this.url = url;
       this.icon = icon;
       this.parent = parent;
       this.profilesPageses = profilesPageses;
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
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public BigDecimal getParent() {
        return this.parent;
    }
    
    public void setParent(BigDecimal parent) {
        this.parent = parent;
    }
    public Set getProfilesPageses() {
        return this.profilesPageses;
    }
    
    public void setProfilesPageses(Set profilesPageses) {
        this.profilesPageses = profilesPageses;
    }

    @Override
    public String toString() {
        return "{\"data\": {" + 
                "\"id\": \"" + id.intValueExact() + '"' +
                ",\"name\": \"" + name + '"' +
                ",\"url\": \"" + url + '"' +
                ",\"icon\": \"" + icon + '"' +
                ",\"parent\": \"" + parent.intValueExact() + '"' +
                "}}";
    }



}


