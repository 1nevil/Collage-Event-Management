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

/**
 *
 * @author hp
 */
@Entity
@Table(name = "participation_master")
@NamedQueries({
    @NamedQuery(name = "ParticipationMaster.findAll", query = "SELECT p FROM ParticipationMaster p"),
    @NamedQuery(name = "ParticipationMaster.findByParticipationId", query = "SELECT p FROM ParticipationMaster p WHERE p.participationId = :participationId")})
public class ParticipationMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "participation_id")
    private Integer participationId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private GroupMaster groupId;
    @JoinColumn(name = "register_id", referencedColumnName = "register_id")
    @ManyToOne
    private RegisterMaster registerId;

    public ParticipationMaster() {
    }

    public ParticipationMaster(Integer participationId) {
        this.participationId = participationId;
    }

    public Integer getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Integer participationId) {
        this.participationId = participationId;
    }

    public GroupMaster getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupMaster groupId) {
        this.groupId = groupId;
    }

    public RegisterMaster getRegisterId() {
        return registerId;
    }

    public void setRegisterId(RegisterMaster registerId) {
        this.registerId = registerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participationId != null ? participationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipationMaster)) {
            return false;
        }
        ParticipationMaster other = (ParticipationMaster) object;
        if ((this.participationId == null && other.participationId != null) || (this.participationId != null && !this.participationId.equals(other.participationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ParticipationMaster[ participationId=" + participationId + " ]";
    }
    
}
