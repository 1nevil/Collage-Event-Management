/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "register_master")
@NamedQueries({
    @NamedQuery(name = "RegisterMaster.findAll", query = "SELECT r FROM RegisterMaster r"),
    @NamedQuery(name = "RegisterMaster.findByRegisterId", query = "SELECT r FROM RegisterMaster r WHERE r.registerId = :registerId"),
    @NamedQuery(name = "RegisterMaster.findByUsername", query = "SELECT r FROM RegisterMaster r WHERE r.username = :username"),
    @NamedQuery(name = "RegisterMaster.findByEmail", query = "SELECT r FROM RegisterMaster r WHERE r.email = :email"),
    @NamedQuery(name = "RegisterMaster.findByPassword", query = "SELECT r FROM RegisterMaster r WHERE r.password = :password"),
    @NamedQuery(name = "RegisterMaster.findByPhoneNo", query = "SELECT r FROM RegisterMaster r WHERE r.phoneNo = :phoneNo"),
    @NamedQuery(name = "RegisterMaster.findByDateOfBirth", query = "SELECT r FROM RegisterMaster r WHERE r.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "RegisterMaster.findByAddress", query = "SELECT r FROM RegisterMaster r WHERE r.address = :address"),
    @NamedQuery(name = "RegisterMaster.findByMyImg", query = "SELECT r FROM RegisterMaster r WHERE r.myImg = :myImg"),
    @NamedQuery(name = "RegisterMaster.findByCreatedAt", query = "SELECT r FROM RegisterMaster r WHERE r.createdAt = :createdAt")})
public class RegisterMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "register_id")
    private Integer registerId;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Size(min = 1, max = 300)
    @Column(name = "password")
    @NotNull
    private String password;
    @Basic(optional = false)
    @Size(min = 1, max = 13)
    @NotNull
    @Column(name = "phone_no")
    private String phoneNo;
    @Size(max = 10)
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "my_img")
    private String myImg;
    @Size(max = 20)
    @Column(name = "created_at")
    private String createdAt;
    @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registerId")
    private Collection<EventMaster> eventMasterCollection;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private RoleMaster roleId;
    @JsonbTransient
    @OneToMany(mappedBy = "registerId")
    private Collection<ParticipationMaster> participationMasterCollection;

    public RegisterMaster() {
    }

    public RegisterMaster(Integer registerId) {
        this.registerId = registerId;
    }

    public RegisterMaster(Integer registerId, String password, String phoneNo) {
        this.registerId = registerId;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMyImg() {
        return myImg;
    }

    public void setMyImg(String myImg) {
        this.myImg = myImg;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Collection<EventMaster> getEventMasterCollection() {
        return eventMasterCollection;
    }

    public void setEventMasterCollection(Collection<EventMaster> eventMasterCollection) {
        this.eventMasterCollection = eventMasterCollection;
    }

    public RoleMaster getRoleId() {
        return roleId;
    }

    public void setRoleId(RoleMaster roleId) {
        this.roleId = roleId;
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
        hash += (registerId != null ? registerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisterMaster)) {
            return false;
        }
        RegisterMaster other = (RegisterMaster) object;
        if ((this.registerId == null && other.registerId != null) || (this.registerId != null && !this.registerId.equals(other.registerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RegisterMaster[ registerId=" + registerId + " ]";
    }

}
