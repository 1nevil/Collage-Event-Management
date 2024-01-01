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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "hackathon_master")
@NamedQueries({
    @NamedQuery(name = "HackathonMaster.findAll", query = "SELECT h FROM HackathonMaster h"),
    @NamedQuery(name = "HackathonMaster.findByHackathonId", query = "SELECT h FROM HackathonMaster h WHERE h.hackathonId = :hackathonId"),
    @NamedQuery(name = "HackathonMaster.findByGithubLink", query = "SELECT h FROM HackathonMaster h WHERE h.githubLink = :githubLink"),
    @NamedQuery(name = "HackathonMaster.findByLiveLink", query = "SELECT h FROM HackathonMaster h WHERE h.liveLink = :liveLink")})
public class HackathonMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hackathon_id")
    private Integer hackathonId;
    @Size(max = 255)
    @Column(name = "github_link")
    private String githubLink;
    @Size(max = 255)
    @Column(name = "live_link")
    private String liveLink;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventMaster eventId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @OneToOne
    private GroupMaster groupId;

    public HackathonMaster() {
    }

    public HackathonMaster(Integer hackathonId) {
        this.hackathonId = hackathonId;
    }

    public Integer getHackathonId() {
        return hackathonId;
    }

    public void setHackathonId(Integer hackathonId) {
        this.hackathonId = hackathonId;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
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
        hash += (hackathonId != null ? hackathonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HackathonMaster)) {
            return false;
        }
        HackathonMaster other = (HackathonMaster) object;
        if ((this.hackathonId == null && other.hackathonId != null) || (this.hackathonId != null && !this.hackathonId.equals(other.hackathonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.HackathonMaster[ hackathonId=" + hackathonId + " ]";
    }
    
}
