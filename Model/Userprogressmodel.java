/*
 * Weightloss App
 * Group 5 
 * IST 311
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author liamb
 */
@Entity
@Table(name = "USERPROGRESSMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userprogressmodel.findAll", query = "SELECT u FROM Userprogressmodel u")
    , @NamedQuery(name = "Userprogressmodel.findById", query = "SELECT u FROM Userprogressmodel u WHERE u.id = :id")
    , @NamedQuery(name = "Userprogressmodel.findByUsermeals", query = "SELECT u FROM Userprogressmodel u WHERE u.usermeals = :usermeals")
    , @NamedQuery(name = "Userprogressmodel.findByUserworkouts", query = "SELECT u FROM Userprogressmodel u WHERE u.userworkouts = :userworkouts")
    , @NamedQuery(name = "Userprogressmodel.findByCaloricintake", query = "SELECT u FROM Userprogressmodel u WHERE u.caloricintake = :caloricintake")})
public class Userprogressmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERMEALS")
    private String usermeals;
    @Column(name = "USERWORKOUTS")
    private String userworkouts;
    @Column(name = "CALORICINTAKE")
    private Integer caloricintake;

    public Userprogressmodel() {
    }

    public Userprogressmodel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsermeals() {
        return usermeals;
    }

    public void setUsermeals(String usermeals) {
        this.usermeals = usermeals;
    }

    public String getUserworkouts() {
        return userworkouts;
    }

    public void setUserworkouts(String userworkouts) {
        this.userworkouts = userworkouts;
    }

    public Integer getCaloricintake() {
        return caloricintake;
    }

    public void setCaloricintake(Integer caloricintake) {
        this.caloricintake = caloricintake;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userprogressmodel)) {
            return false;
        }
        Userprogressmodel other = (Userprogressmodel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Userprogressmodel[ id=" + id + " ]";
    }
    
}
