/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@Table(name = "FITNESSLEVELMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fitnesslevelmodel.findAll", query = "SELECT f FROM Fitnesslevelmodel f")
    , @NamedQuery(name = "Fitnesslevelmodel.findById", query = "SELECT f FROM Fitnesslevelmodel f WHERE f.id = :id")
    , @NamedQuery(name = "Fitnesslevelmodel.findByWeeklyfrequency", query = "SELECT f FROM Fitnesslevelmodel f WHERE f.weeklyfrequency = :weeklyfrequency")
    , @NamedQuery(name = "Fitnesslevelmodel.findByActivitylevel", query = "SELECT f FROM Fitnesslevelmodel f WHERE f.activitylevel = :activitylevel")
    , @NamedQuery(name = "Fitnesslevelmodel.findByPreferredactivities", query = "SELECT f FROM Fitnesslevelmodel f WHERE f.preferredactivities = :preferredactivities")})
public class Fitnesslevelmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "WEEKLYFREQUENCY")
    private Integer weeklyfrequency;
    @Column(name = "ACTIVITYLEVEL")
    private Integer activitylevel;
    @Column(name = "PREFERREDACTIVITIES")
    private String preferredactivities;

    public Fitnesslevelmodel() {
    }

    public Fitnesslevelmodel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeeklyfrequency() {
        return weeklyfrequency;
    }

    public void setWeeklyfrequency(Integer weeklyfrequency) {
        this.weeklyfrequency = weeklyfrequency;
    }

    public Integer getActivitylevel() {
        return activitylevel;
    }

    public void setActivitylevel(Integer activitylevel) {
        this.activitylevel = activitylevel;
    }

    public String getPreferredactivities() {
        return preferredactivities;
    }

    public void setPreferredactivities(String preferredactivities) {
        this.preferredactivities = preferredactivities;
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
        if (!(object instanceof Fitnesslevelmodel)) {
            return false;
        }
        Fitnesslevelmodel other = (Fitnesslevelmodel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Fitnesslevelmodel[ id=" + id + " ]";
    }
    
}
