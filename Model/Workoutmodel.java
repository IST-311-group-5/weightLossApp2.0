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
@Table(name = "WORKOUTMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workoutmodel.findAll", query = "SELECT w FROM Workoutmodel w")
    , @NamedQuery(name = "Workoutmodel.findById", query = "SELECT w FROM Workoutmodel w WHERE w.id = :id")
    , @NamedQuery(name = "Workoutmodel.findByWorkouttype", query = "SELECT w FROM Workoutmodel w WHERE w.workouttype = :workouttype")
    , @NamedQuery(name = "Workoutmodel.findByDuration", query = "SELECT w FROM Workoutmodel w WHERE w.duration = :duration")})
public class Workoutmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "WORKOUTTYPE")
    private String workouttype;
    @Column(name = "DURATION")
    private String duration;

    public Workoutmodel() {
    }

    public Workoutmodel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkouttype() {
        return workouttype;
    }

    public void setWorkouttype(String workouttype) {
        this.workouttype = workouttype;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
        if (!(object instanceof Workoutmodel)) {
            return false;
        }
        Workoutmodel other = (Workoutmodel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Workoutmodel[ id=" + id + " ]";
    }
    
}
