/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBeans;

import Entity.AwardMaster;
import Entity.EventMaster;
import Entity.GroupMaster;
import Entity.ParticipationMaster;
import Entity.RegisterMaster;
import Entity.SponserMaster;
import Entity.WinnerMaster;
import JerseyClient.AdminClient;
import JerseyClient.StudentClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hp
 */
@Named(value = "studentBean")
@RequestScoped
public class studentBean {

    StudentClient sc;
    AdminClient ac;
    Response rs;

    String eventId, title, description, startTime, endTime, address, pincode, startDate, endDate, categoryId, img, numberOfPeopleInGroup;

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(false);

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String newPassword;

    String groupNameInput;

    EventMaster event;
    ArrayList<EventMaster> events;
    GenericType<Collection<EventMaster>> genricEvent;

    Collection<SponserMaster> sponsers;
    GenericType<Collection<SponserMaster>> genricSponsers;

    Collection<AwardMaster> awards;
    GenericType<Collection<AwardMaster>> genricAwards;

    Collection<GroupMaster> groups;
    GenericType<Collection<GroupMaster>> genricGroups;

    Collection<WinnerMaster> winners;
    GenericType<Collection<WinnerMaster>> genricWinners;

    Collection<ParticipationMaster> participation;
    GenericType<Collection<ParticipationMaster>> genricParticipation;

    String groupName;

    public studentBean() {

        ac = new AdminClient();
        sc = new StudentClient();
        sponsers = new ArrayList<>();
        genricSponsers = new GenericType<Collection<SponserMaster>>() {
        };

        event = new EventMaster();
        events = new ArrayList<EventMaster>();
        genricEvent = new GenericType<Collection<EventMaster>>() {
        };

        awards = new ArrayList();
        genricAwards = new GenericType<Collection<AwardMaster>>() {
        };

        groups = new ArrayList();
        genricGroups = new GenericType<Collection<GroupMaster>>() {
        };

        winners = new ArrayList();
        genricWinners = new GenericType<Collection<WinnerMaster>>() {
        };

        participation = new ArrayList();
        genricParticipation = new GenericType<Collection<ParticipationMaster>>() {
        };
    }

    public String getGroupNameInput() {
        return groupNameInput;
    }

    public void setGroupNameInput(String groupNameInput) {
        this.groupNameInput = groupNameInput;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNumberOfPeopleInGroup() {
        return numberOfPeopleInGroup;
    }

    public void setNumberOfPeopleInGroup(String numberOfPeopleInGroup) {
        this.numberOfPeopleInGroup = numberOfPeopleInGroup;
    }

    public Collection<ParticipationMaster> getParticipation() {
        return participation;
    }

    public void setParticipation(Collection<ParticipationMaster> participation) {
        this.participation = participation;
    }

    public GenericType<Collection<ParticipationMaster>> getGenricParticipation() {
        return genricParticipation;
    }

    public void setGenricParticipation(GenericType<Collection<ParticipationMaster>> genricParticipation) {
        this.genricParticipation = genricParticipation;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Collection<EventMaster> getEvent() {
        return events;
    }

    public GenericType<Collection<EventMaster>> getGenricEvent() {
        return genricEvent;
    }

    public void setGenricEvent(GenericType<Collection<EventMaster>> genricEvent) {
        this.genricEvent = genricEvent;
    }

    public Collection<SponserMaster> getSponsers() {
        return sponsers;
    }

    public void setSponsers(Collection<SponserMaster> sponsers) {
        this.sponsers = sponsers;
    }

    public GenericType<Collection<SponserMaster>> getGenricSponsers() {
        return genricSponsers;
    }

    public void setGenricSponsers(GenericType<Collection<SponserMaster>> genricSponsers) {
        this.genricSponsers = genricSponsers;
    }

    public Collection<AwardMaster> getAwards() {
        return awards;
    }

    public void setAwards(Collection<AwardMaster> awards) {
        this.awards = awards;
    }

    public GenericType<Collection<AwardMaster>> getGenricAwards() {
        return genricAwards;
    }

    public void setGenricAwards(GenericType<Collection<AwardMaster>> genricAwards) {
        this.genricAwards = genricAwards;
    }

    public Collection<GroupMaster> getGroups() {
        return groups;
    }

    public void setGroups(Collection<GroupMaster> groups) {
        this.groups = groups;
    }

    public GenericType<Collection<GroupMaster>> getGenricGroups() {
        return genricGroups;
    }

    public void setGenricGroups(GenericType<Collection<GroupMaster>> genricGroups) {
        this.genricGroups = genricGroups;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    private Part file;

    String username, password, email, phoneNumber, dob, userAddress;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String createAndEnroll(String eventId) {

        RegisterMaster user = (RegisterMaster) session.getAttribute("User");

        if (groupNameInput != null && eventId != null && user.getRegisterId() != null) {
            System.out.println("event Id" + eventId);
            System.out.println("Group Name Input : " + groupNameInput);
            System.out.println("regisrer Id" + user.getRegisterId());

            this.message = sc.participateInEvent(eventId, groupNameInput, user.getRegisterId().toString());

            return "enrolled.jsf?faces-redirect=true";
        } else {
            System.out.println("Anything is null");
            return "Student/details.jsf?eventId=" + eventId + "";
        }
    }

    public String enrollEvent(String eventId, String groupName) {
        System.out.println("event Id" + eventId);
        System.out.println("Group Name" + groupName);

        if (eventId != null && groupName != null) {
            System.out.println("HEOLOLSDFSFDSDFSDFSFFDFSFDS");
            System.out.println("event Id" + eventId);
            System.out.println("Group Name" + groupName);

            sc.participateInEvent(eventId, groupName, "14");

        }
        return "enrolled.jsf?faces-redirect=true";
    }

    public Collection<ParticipationMaster> getParticpationByGroupId(String groupId) {
        System.out.println("Group Id " + groupId);
        rs = sc.getAllParticipationsByGroupId(Response.class, groupId);
        participation = rs.readEntity(genricParticipation);
        System.out.println(participation);
        return participation;
    }

    public void loadItemDetails() {
//        rs = ac.getEventById(Response.class, eventId);
//        GenericType<EventMaster> genricEvent = new GenericType<EventMaster>() {
//        };
//        event = rs.readEntity(genricEvent);
//
//        System.out.println(event.getEventId());
//        System.out.println(event.getTitle());
        rs = ac.getEventById(Response.class, eventId);

        GenericType<EventMaster> genricEvent = new GenericType<EventMaster>() {
        };

        event = rs.readEntity(genricEvent);

        this.title = event.getTitle();
        this.description = event.getDescription();
        this.address = event.getAddress();
        this.img = event.getEventImg();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.numberOfPeopleInGroup = event.getMaxPeopleGroup().toString();
        this.pincode = event.getPincode();
        this.startTime = event.getStartTime();
        this.endTime = event.getEndTime();

        rs = ac.getSponserByEventId(Response.class, eventId);
        sponsers = rs.readEntity(genricSponsers);

        rs = ac.getAwardByEventId(Response.class, eventId);
        awards = rs.readEntity(genricAwards);

        rs = ac.getAllWinnerByEventId(Response.class, eventId);
        winners = rs.readEntity(genricWinners);

        rs = sc.getAllGroupsByEventId(Response.class, eventId);
        groups = rs.readEntity(genricGroups);

    }

    public Collection<WinnerMaster> getWinners() {
        return winners;
    }

    public void setWinners(Collection<WinnerMaster> winners) {
        this.winners = winners;
    }

    public GenericType<Collection<WinnerMaster>> getGenricWinners() {
        return genricWinners;
    }

    public void setGenricWinners(GenericType<Collection<WinnerMaster>> genricWinners) {
        this.genricWinners = genricWinners;
    }

    public studentBean(EventMaster event, ArrayList<EventMaster> events) {
        this.event = event;
        this.events = events;
    }

    public String registerUser() {

        String image;
        if (file != null) {
            try {
                image = file.getSubmittedFileName();


                this.message = sc.registerUser(username, email, password, phoneNumber, dob, userAddress, image);
                System.out.println(message);
                String uploadDirectory = "E:\\College_Event_proj\\event_management\\src\\main\\webapp\\resources\\images";

                File uploadDir = new File(uploadDirectory);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File uploadedFile = new File(uploadDirectory, image);

                try (InputStream in = file.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }

        return "Login.jsf?faces-redirect=true";
    }

//    public Collection<SponserMaster> getSponsersByEventId(String eventId) {
//        rs = ac.getSponserByEventId(Response.class, eventId);
//        sponsers = rs.readEntity(genricSponsers);
//        return sponsers;
//    }
//
//    public Collection<GroupMaster> getGroupsByEventId(String eventId) {
//        rs = sc.getAllGroupsByEventId(Response.class, eventId);
//        groups = rs.readEntity(genricGroups);
//        return groups;
//    }
//
//    public Collection<AwardMaster> getAwardsByEventId(String eventId) {
//        rs = ac.getAwardByEventId(Response.class, eventId);
//        awards = rs.readEntity(genricAwards);
//        return awards;
//    }
    public Collection<ParticipationMaster> getParticipationDetailsByRegisterId() {



        RegisterMaster user = (RegisterMaster) session.getAttribute("User");
        rs = sc.getParticipationByUserId(Response.class, user.getRegisterId().toString());
        participation = rs.readEntity(genricParticipation);
        System.out.println(participation);
        return participation;

    }

    public void updatePassword() {
        RegisterMaster userUpdatePass = new RegisterMaster();


        RegisterMaster user = (RegisterMaster) session.getAttribute("User");

        userUpdatePass.setEmail(user.getEmail());
        userUpdatePass.setPassword(newPassword);
        this.message = sc.updatePassword(userUpdatePass);

    }
}
