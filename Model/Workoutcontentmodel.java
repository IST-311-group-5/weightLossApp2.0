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
@Table(name = "WORKOUTCONTENTMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workoutcontentmodel.findAll", query = "SELECT w FROM Workoutcontentmodel w")
    , @NamedQuery(name = "Workoutcontentmodel.findById", query = "SELECT w FROM Workoutcontentmodel w WHERE w.id = :id")
    , @NamedQuery(name = "Workoutcontentmodel.findByNumberofreps", query = "SELECT w FROM Workoutcontentmodel w WHERE w.numberofreps = :numberofreps")
    , @NamedQuery(name = "Workoutcontentmodel.findByNumberofsets", query = "SELECT w FROM Workoutcontentmodel w WHERE w.numberofsets = :numberofsets")
    , @NamedQuery(name = "Workoutcontentmodel.findByExercise", query = "SELECT w FROM Workoutcontentmodel w WHERE w.exercise = :exercise")})
public class Workoutcontentmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMBEROFREPS")
    private Integer numberofreps;
    @Column(name = "NUMBEROFSETS")
    private Integer numberofsets;
    @Column(name = "EXERCISE")
    private String exercise;

    public Workoutcontentmodel() {
    }

    public Workoutcontentmodel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberofreps() {
        return numberofreps;
    }

    public void setNumberofreps(Integer numberofreps) {
        this.numberofreps = numberofreps;
    }

    public Integer getNumberofsets() {
        return numberofsets;
    }

    public void setNumberofsets(Integer numberofsets) {
        this.numberofsets = numberofsets;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
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
        if (!(object instanceof Workoutcontentmodel)) {
            return false;
        }
        Workoutcontentmodel other = (Workoutcontentmodel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Workoutcontentmodel[ id=" + id + " ]";
    }
    
}
