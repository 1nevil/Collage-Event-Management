/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBeans;

import Entity.AwardMaster;
import Entity.EventMaster;
import Entity.GroupMaster;
import JerseyClient.AdminClient;
import JerseyClient.StudentClient;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hp
 */
@Named(value = "insertWinner")
@SessionScoped
public class InsertWinner implements Serializable {

    AdminClient ac;
    StudentClient sc;
    GenericType<Collection<AwardMaster>> genricFilterAwards;
    Collection<AwardMaster> filterAwards;
    Response rs;
    Collection<EventMaster> events;

    GenericType<Collection<GroupMaster>> genricGroup;
    GenericType<Collection<EventMaster>> genricEvents;

    public InsertWinner(GenericType<Collection<AwardMaster>> genricFilterAwards, Collection<AwardMaster> filterAwards, GenericType<Collection<GroupMaster>> genricGroup, Collection<GroupMaster> groups, String winnerEventId, String wg, String wt) {
        this.genricFilterAwards = genricFilterAwards;
        this.filterAwards = filterAwards;
        this.genricGroup = genricGroup;
        this.groups = groups;
        this.winnerEventId = winnerEventId;
        this.wg = wg;
        this.wt = wt;
    }
    Collection<GroupMaster> groups;

    public InsertWinner() {

        ac = new AdminClient();
        sc = new StudentClient();
        genricFilterAwards = new GenericType<Collection<AwardMaster>>() {
        };
        genricGroup = new GenericType<Collection<GroupMaster>>() {
        };
        genricEvents = new GenericType<Collection<EventMaster>>() {
        };
        filterAwards = new ArrayList();
        groups = new ArrayList();
        events = new ArrayList();

    }

    private String winnerEventId;
    private String wg;
    private String wt;

    public Collection<EventMaster> getEvents() {
        rs = ac.getAllEvents(Response.class);
        events = rs.readEntity(genricEvents);
        return events;
    }

    public void loadAwardsAndGroups() {
        this.winnerEventId = winnerEventId;

        this.filterAwards = getAwardByEventId(winnerEventId);
        this.groups = getGroupsByEventId(winnerEventId);

    }

    public Collection<GroupMaster> getGroupsByEventId(String winnerEventId) {
        rs = sc.getAllGroupsByEventId(Response.class, winnerEventId);
        groups = rs.readEntity(genricGroup);
        return groups;
    }

    public GenericType<Collection<AwardMaster>> getGenricFilterAwards() {
        return genricFilterAwards;
    }

    public void setGenricFilterAwards(GenericType<Collection<AwardMaster>> genricFilterAwards) {
        this.genricFilterAwards = genricFilterAwards;
    }

    public Collection<AwardMaster> getFilterAwards() {
        return filterAwards;
    }

    public void setFilterAwards(Collection<AwardMaster> filterAwards) {
        this.filterAwards = filterAwards;
    }

    public GenericType<Collection<GroupMaster>> getGenricGroup() {
        return genricGroup;
    }

    public void setGenricGroup(GenericType<Collection<GroupMaster>> genricGroup) {
        this.genricGroup = genricGroup;
    }

    public GenericType<Collection<EventMaster>> getGenricEvents() {
        return genricEvents;
    }

    public void setGenricEvents(GenericType<Collection<EventMaster>> genricEvents) {
        this.genricEvents = genricEvents;
    }

    public Collection<GroupMaster> getGroups() {
        return groups;
    }

    public void setGroups(Collection<GroupMaster> groups) {
        this.groups = groups;
    }

    public Collection<AwardMaster> getAwardByEventId(String winnerEventId) {
        rs = ac.getAwardByEventId(Response.class, winnerEventId);
        filterAwards = rs.readEntity(genricFilterAwards);
//        setAward(filterAwards);
        return filterAwards;
    }

    public String insertWinner() {
       
        ac.createWinner(winnerEventId, wg, wt);
        return "DisplayWinner.jsf?faces-redirect=true";
    }

    public String getWinnerEventId() {
        return winnerEventId;
    }

    public void setWinnerEventId(String winnerEventId) {
        this.winnerEventId = winnerEventId;
    }

    public String getWg() {
        return wg;
    }

    public void setWg(String wg) {
        this.wg = wg;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

}
