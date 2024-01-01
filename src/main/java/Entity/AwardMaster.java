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
@Table(name = "award_master")
@NamedQueries({
    @NamedQuery(name = "AwardMaster.findAll", query = "SELECT a FROM AwardMaster a"),
    @NamedQuery(name = "AwardMaster.findByAwardId", query = "SELECT a FROM AwardMaster a WHERE a.awardId = :awardId"),
    @NamedQuery(name = "AwardMaster.findByAwardTitle", query = "SELECT a FROM AwardMaster a WHERE a.awardTitle = :awardTitle"),
    @NamedQuery(name = "AwardMaster.findByAwardDescription", query = "SELECT a FROM AwardMaster a WHERE a.awardDescription = :awardDescription")})
public class AwardMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "award_id")
    private Integer awardId;
    @Column(name = "award_title")
    @Size(max = 45)
    private String awardTitle;
    @Column(name = "award_description")
    @Size(max = 45)
    private String awardDescription;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne
    private EventMaster eventId;

    public AwardMaster() {
    }

    public AwardMaster(Integer awardId) {
        this.awardId = awardId;
    }

    public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public String getAwardTitle() {
        return awardTitle;
    }

    public void setAwardTitle(String awardTitle) {
        this.awardTitle = awardTitle;
    }

    public String getAwardDescription() {
        return awardDescription;
    }

    public void setAwardDescription(String awardDescription) {
        this.awardDescription = awardDescription;
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
        hash += (awardId != null ? awardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AwardMaster)) {
            return false;
        }
        AwardMaster other = (AwardMaster) object;
        if ((this.awardId == null && other.awardId != null) || (this.awardId != null && !this.awardId.equals(other.awardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AwardMaster[ awardId=" + awardId + " ]";
    }

}
