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
@Table(name = "event_master")
@NamedQueries({
    @NamedQuery(name = "EventMaster.findAll", query = "SELECT e FROM EventMaster e"),
    @NamedQuery(name = "EventMaster.findByEventId", query = "SELECT e FROM EventMaster e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "EventMaster.findByTitle", query = "SELECT e FROM EventMaster e WHERE e.title = :title"),
    @NamedQuery(name = "EventMaster.findByDescription", query = "SELECT e FROM EventMaster e WHERE e.description = :description"),
    @NamedQuery(name = "EventMaster.findByStartTime", query = "SELECT e FROM EventMaster e WHERE e.startTime = :startTime"),
    @NamedQuery(name = "EventMaster.findByEndTime", query = "SELECT e FROM EventMaster e WHERE e.endTime = :endTime"),
    @NamedQuery(name = "EventMaster.findByAddress", query = "SELECT e FROM EventMaster e WHERE e.address = :address"),
    @NamedQuery(name = "EventMaster.findByPincode", query = "SELECT e FROM EventMaster e WHERE e.pincode = :pincode"),
    @NamedQuery(name = "EventMaster.findByIsGallary", query = "SELECT e FROM EventMaster e WHERE e.isGallary = :isGallary"),
    @NamedQuery(name = "EventMaster.findByIsGroup", query = "SELECT e FROM EventMaster e WHERE e.isGroup = :isGroup"),
    @NamedQuery(name = "EventMaster.findByStartDate", query = "SELECT e FROM EventMaster e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "EventMaster.findByEndDate", query = "SELECT e FROM EventMaster e WHERE e.endDate = :endDate"),
    @NamedQuery(name = "EventMaster.findByNoOfRegistration", query = "SELECT e FROM EventMaster e WHERE e.noOfRegistration = :noOfRegistration"),
    @NamedQuery(name = "EventMaster.findByEventImg", query = "SELECT e FROM EventMaster e WHERE e.eventImg = :eventImg"),
    @NamedQuery(name = "EventMaster.findByMaxPeopleGroup", query = "SELECT e FROM EventMaster e WHERE e.maxPeopleGroup = :maxPeopleGroup")})
public class EventMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Basic(optional = false)
    @Column(name = "title")
    @NotNull
    @Size(min = 1, max = 255)
    private String title;
    @Basic(optional = false)
    @Column(name = "description")
    @NotNull
    @Size(min = 1, max = 255)
    private String description;
    @Basic(optional = false)
    @Column(name = "start_time")
    @NotNull
    @Size(min = 1, max = 20)
    private String startTime;
    @Basic(optional = false)
    @Column(name = "end_time")
    @NotNull
    @Size(min = 1, max = 20)
    private String endTime;
    @Basic(optional = false)
    @Column(name = "address")
    @NotNull
    @Size(min = 1, max = 255)
    private String address;
    @Basic(optional = false)
    @Column(name = "pincode")
    @NotNull
    @Size(min = 1, max = 20)
    private String pincode;
    @NotNull
    @Basic(optional = false)
    @Column(name = "is_gallary")
    private short isGallary;
    @Basic(optional = false)
    @Column(name = "is_group")
    @NotNull
    private short isGroup;
    @Basic(optional = false)
    @Column(name = "start_date")
    @NotNull
    @Size(min = 1, max = 20)
    private String startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @NotNull
    @Size(min = 1, max = 20)
    private String endDate;
    @Basic(optional = false)
    @Column(name = "no_of_registration")
    @NotNull
    private int noOfRegistration;
    @Column(name = "event_img")
    @Size(max = 255)
    private String eventImg;
    @Column(name = "max_people_group")
    private Integer maxPeopleGroup;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private CategoryMaster categoryId;
    @JoinColumn(name = "register_id", referencedColumnName = "register_id")
    @ManyToOne(optional = false)
    private RegisterMaster registerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    @JsonbTransient
    private Collection<HackathonMaster> hackathonMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    @JsonbTransient
    private Collection<GroupMaster> groupMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    @JsonbTransient
    private Collection<WinnerMaster> winnerMasterCollection;
    @OneToMany(mappedBy = "eventId")
    @JsonbTransient
    private Collection<AwardMaster> awardMasterCollection;
    @OneToMany(mappedBy = "eventId")
    @JsonbTransient
    private Collection<SponserMaster> sponserMasterCollection;

    public EventMaster() {
    }

    public EventMaster(Integer eventId) {
        this.eventId = eventId;
    }

    public EventMaster(Integer eventId, String title, String description, String startTime, String endTime, String address, String pincode, short isGallary, short isGroup, String startDate, String endDate, int noOfRegistration) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.pincode = pincode;
        this.isGallary = isGallary;
        this.isGroup = isGroup;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfRegistration = noOfRegistration;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public short getIsGallary() {
        return isGallary;
    }

    public void setIsGallary(short isGallary) {
        this.isGallary = isGallary;
    }

    public short getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(short isGroup) {
        this.isGroup = isGroup;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getNoOfRegistration() {
        return noOfRegistration;
    }

    public void setNoOfRegistration(int noOfRegistration) {
        this.noOfRegistration = noOfRegistration;
    }

    public String getEventImg() {
        return eventImg;
    }

    public void setEventImg(String eventImg) {
        this.eventImg = eventImg;
    }

    public Integer getMaxPeopleGroup() {
        return maxPeopleGroup;
    }

    public void setMaxPeopleGroup(Integer maxPeopleGroup) {
        this.maxPeopleGroup = maxPeopleGroup;
    }

    public CategoryMaster getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryMaster categoryId) {
        this.categoryId = categoryId;
    }

    public RegisterMaster getRegisterId() {
        return registerId;
    }

    public void setRegisterId(RegisterMaster registerId) {
        this.registerId = registerId;
    }

    public Collection<HackathonMaster> getHackathonMasterCollection() {
        return hackathonMasterCollection;
    }

    public void setHackathonMasterCollection(Collection<HackathonMaster> hackathonMasterCollection) {
        this.hackathonMasterCollection = hackathonMasterCollection;
    }

    public Collection<GroupMaster> getGroupMasterCollection() {
        return groupMasterCollection;
    }

    public void setGroupMasterCollection(Collection<GroupMaster> groupMasterCollection) {
        this.groupMasterCollection = groupMasterCollection;
    }

    public Collection<WinnerMaster> getWinnerMasterCollection() {
        return winnerMasterCollection;
    }

    public void setWinnerMasterCollection(Collection<WinnerMaster> winnerMasterCollection) {
        this.winnerMasterCollection = winnerMasterCollection;
    }

    public Collection<AwardMaster> getAwardMasterCollection() {
        return awardMasterCollection;
    }

    public void setAwardMasterCollection(Collection<AwardMaster> awardMasterCollection) {
        this.awardMasterCollection = awardMasterCollection;
    }

    public Collection<SponserMaster> getSponserMasterCollection() {
        return sponserMasterCollection;
    }

    public void setSponserMasterCollection(Collection<SponserMaster> sponserMasterCollection) {
        this.sponserMasterCollection = sponserMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventMaster)) {
            return false;
        }
        EventMaster other = (EventMaster) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EventMaster[ eventId=" + eventId + " ]";
    }

}
