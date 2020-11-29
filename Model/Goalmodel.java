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
@Table(name = "GOALMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goalmodel.findAll", query = "SELECT g FROM Goalmodel g")
    , @NamedQuery(name = "Goalmodel.findById", query = "SELECT g FROM Goalmodel g WHERE g.id = :id")
    , @NamedQuery(name = "Goalmodel.findByMealrecommendations", query = "SELECT g FROM Goalmodel g WHERE g.mealrecommendations = :mealrecommendations")
    , @NamedQuery(name = "Goalmodel.findByWorkoutrecommendations", query = "SELECT g FROM Goalmodel g WHERE g.workoutrecommendations = :workoutrecommendations")})
public class Goalmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MEALRECOMMENDATIONS")
    private String mealrecommendations;
    @Column(name = "WORKOUTRECOMMENDATIONS")
    private String workoutrecommendations;

    public Goalmodel() {
    }

    public Goalmodel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMealrecommendations() {
        return mealrecommendations;
    }

    public void setMealrecommendations(String mealrecommendations) {
        this.mealrecommendations = mealrecommendations;
    }

    public String getWorkoutrecommendations() {
        return workoutrecommendations;
    }

    public void setWorkoutrecommendations(String workoutrecommendations) {
        this.workoutrecommendations = workoutrecommendations;
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
        if (!(object instanceof Goalmodel)) {
            return false;
        }
        Goalmodel other = (Goalmodel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Goalmodel[ id=" + id + " ]";
    }
    
}
