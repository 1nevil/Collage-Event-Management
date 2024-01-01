/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "group_master")
@NamedQueries({
    @NamedQuery(name = "GroupMaster.findAll", query = "SELECT g FROM GroupMaster g"),
    @NamedQuery(name = "GroupMaster.findByGroupId", query = "SELECT g FROM GroupMaster g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupMaster.findByGroupName", query = "SELECT g FROM GroupMaster g WHERE g.groupName = :groupName")})
public class GroupMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "group_name")
    private String groupName;
    @OneToOne(mappedBy = "groupId")
    @JsonbTransient
    private HackathonMaster hackathonMaster;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventMaster eventId;
    @OneToMany(mappedBy = "groupId")
    @JsonbTransient
    private Collection<WinnerMaster> winnerMasterCollection;
    @OneToMany(mappedBy = "groupId")
    @JsonbTransient
    private Collection<ParticipationMaster> participationMasterCollection;

    public GroupMaster() {
    }

    public GroupMaster(Integer groupId) {
        this.groupId = groupId;
    }

    public GroupMaster(Integer groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public HackathonMaster getHackathonMaster() {
        return hackathonMaster;
    }

    public void setHackathonMaster(HackathonMaster hackathonMaster) {
        this.hackathonMaster = hackathonMaster;
    }

    public EventMaster getEventId() {
        return eventId;
    }

    public void setEventId(EventMaster eventId) {
        this.eventId = eventId;
    }

    public Collection<WinnerMaster> getWinnerMasterCollection() {
        return winnerMasterCollection;
    }

    public void setWinnerMasterCollection(Collection<WinnerMaster> winnerMasterCollection) {
        this.winnerMasterCollection = winnerMasterCollection;
    }

    public Collection<ParticipationMaster> getParticipationMasterCollection() {
        return participationMasterCollection;
    }

    public void setParticipationMasterCollection(Collection<ParticipationMaster> participationMasterCollection) {
        this.participationMasterCollection = participationMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMaster)) {
            return false;
        }
        GroupMaster other = (GroupMaster) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.GroupMaster[ groupId=" + groupId + " ]";
    }

}
