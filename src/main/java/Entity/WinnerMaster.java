/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
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
@Table(name = "winner_master")
@NamedQueries({
    @NamedQuery(name = "WinnerMaster.findAll", query = "SELECT w FROM WinnerMaster w"),
    @NamedQuery(name = "WinnerMaster.findByWinnerId", query = "SELECT w FROM WinnerMaster w WHERE w.winnerId = :winnerId"),
    @NamedQuery(name = "WinnerMaster.findByWinnerTitle", query = "SELECT w FROM WinnerMaster w WHERE w.winnerTitle = :winnerTitle")})
public class WinnerMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "winner_id")
    private Integer winnerId;
    @Size(max = 45)
    @Column(name = "winner_title")
    private String winnerTitle;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventMaster eventId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private GroupMaster groupId;

    public WinnerMaster() {
    }

    public WinnerMaster(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public String getWinnerTitle() {
        return winnerTitle;
    }

    public void setWinnerTitle(String winnerTitle) {
        this.winnerTitle = winnerTitle;
    }

    public EventMaster getEventId() {
        return eventId;
    }

    public void setEventId(EventMaster eventId) {
        this.eventId = eventId;
    }

    public GroupMaster getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupMaster groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (winnerId != null ? winnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WinnerMaster)) {
            return false;
        }
        WinnerMaster other = (WinnerMaster) object;
        if ((this.winnerId == null && other.winnerId != null) || (this.winnerId != null && !this.winnerId.equals(other.winnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WinnerMaster[ winnerId=" + winnerId + " ]";
    }
    
}
