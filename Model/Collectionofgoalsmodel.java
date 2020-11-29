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
@Table(name = "COLLECTIONOFGOALSMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionofgoalsmodel.findAll", query = "SELECT c FROM Collectionofgoalsmodel c")
    , @NamedQuery(name = "Collectionofgoalsmodel.findById", query = "SELECT c FROM Collectionofgoalsmodel c WHERE c.id = :id")
    , @NamedQuery(name = "Collectionofgoalsmodel.findByUsermodel", query = "SELECT c FROM Collectionofgoalsmodel c WHERE c.usermodel = :usermodel")
    , @NamedQuery(name = "Collectionofgoalsmodel.findByListofgoals", query = "SELECT c FROM Collectionofgoalsmodel c WHERE c.listofgoals = :listofgoals")})
public class Collectionofgoalsmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERMODEL")
    private String usermodel;
    @Column(name = "LISTOFGOALS")
    private String listofgoals;

    public Collectionofgoalsmodel() {
    }

    public Collectionofgoalsmodel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsermodel() {
        return usermodel;
    }

    public void setUsermodel(String usermodel) {
        this.usermodel = usermodel;
    }

    public String getListofgoals() {
        return listofgoals;
    }

    public void setListofgoals(String listofgoals) {
        this.listofgoals = listofgoals;
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
        if (!(object instanceof Collectionofgoalsmodel)) {
            return false;
        }
        Collectionofgoalsmodel other = (Collectionofgoalsmodel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Collectionofgoalsmodel[ id=" + id + " ]";
    }
    
}
