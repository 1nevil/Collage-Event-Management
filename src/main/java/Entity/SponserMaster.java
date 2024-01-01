/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "sponser_master")
@NamedQueries({
    @NamedQuery(name = "SponserMaster.findAll", query = "SELECT s FROM SponserMaster s"),
    @NamedQuery(name = "SponserMaster.findBySponserId", query = "SELECT s FROM SponserMaster s WHERE s.sponserId = :sponserId"),
    @NamedQuery(name = "SponserMaster.findBySponserName", query = "SELECT s FROM SponserMaster s WHERE s.sponserName = :sponserName"),
    @NamedQuery(name = "SponserMaster.findBySponserDescription", query = "SELECT s FROM SponserMaster s WHERE s.sponserDescription = :sponserDescription"),
    @NamedQuery(name = "SponserMaster.findBySponserImg", query = "SELECT s FROM SponserMaster s WHERE s.sponserImg = :sponserImg"),
    @NamedQuery(name = "SponserMaster.findBySponserContact", query = "SELECT s FROM SponserMaster s WHERE s.sponserContact = :sponserContact")})
public class SponserMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sponser_id")
    private Integer sponserId;
    @Size(max = 45)
    @Column(name = "sponser_name")
    private String sponserName;
    @Size(max = 400)
    @Column(name = "sponser_description")
    private String sponserDescription;
    @Size(max = 255)
    @Column(name = "sponser_img")
    private String sponserImg;
    @Size(max = 45)
    @Column(name = "sponser_contact")
    private String sponserContact;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne
    private EventMaster eventId;

    public SponserMaster() {
    }

    public SponserMaster(Integer sponserId) {
        this.sponserId = sponserId;
    }

    public Integer getSponserId() {
        return sponserId;
    }

    public void setSponserId(Integer sponserId) {
        this.sponserId = sponserId;
    }

    public String getSponserName() {
        return sponserName;
    }

    public void setSponserName(String sponserName) {
        this.sponserName = sponserName;
    }

    public String getSponserDescription() {
        return sponserDescription;
    }

    public void setSponserDescription(String sponserDescription) {
        this.sponserDescription = sponserDescription;
    }

    public String getSponserImg() {
        return sponserImg;
    }

    public void setSponserImg(String sponserImg) {
        this.sponserImg = sponserImg;
    }

    public String getSponserContact() {
        return sponserContact;
    }

    public void setSponserContact(String sponserContact) {
        this.sponserContact = sponserContact;
    }

    public EventMaster getEventId() {
        return eventId;
    }

    public void setEventId(EventMaster eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sponserId != null ? sponserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SponserMaster)) {
            return false;
        }
        SponserMaster other = (SponserMaster) object;
        if ((this.sponserId == null && other.sponserId != null) || (this.sponserId != null && !this.sponserId.equals(other.sponserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SponserMaster[ sponserId=" + sponserId + " ]";
    }
    
}
