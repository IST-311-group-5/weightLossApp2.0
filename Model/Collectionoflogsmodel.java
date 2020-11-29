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
@Table(name = "COLLECTIONOFLOGSMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionoflogsmodel.findAll", query = "SELECT c FROM Collectionoflogsmodel c")
    , @NamedQuery(name = "Collectionoflogsmodel.findById", query = "SELECT c FROM Collectionoflogsmodel c WHERE c.id = :id")
    , @NamedQuery(name = "Collectionoflogsmodel.findByUsermodel", query = "SELECT c FROM Collectionoflogsmodel c WHERE c.usermodel = :usermodel")
    , @NamedQuery(name = "Collectionoflogsmodel.findByListoflogs", query = "SELECT c FROM Collectionoflogsmodel c WHERE c.listoflogs = :listoflogs")})
public class Collectionoflogsmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERMODEL")
    private String usermodel;
    @Column(name = "LISTOFLOGS")
    private String listoflogs;

    public Collectionoflogsmodel() {
    }

    public Collectionoflogsmodel(Integer id) {
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

    public String getListoflogs() {
        return listoflogs;
    }

    public void setListoflogs(String listoflogs) {
        this.listoflogs = listoflogs;
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
        if (!(object instanceof Collectionoflogsmodel)) {
            return false;
        }
        Collectionoflogsmodel other = (Collectionoflogsmodel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Collectionoflogsmodel[ id=" + id + " ]";
    }
    
}
