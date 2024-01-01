/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBeans;

import Entity.AwardMaster;
import Entity.CategoryMaster;
import Entity.EventMaster;
import Entity.GroupMaster;
import Entity.HackathonMaster;
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
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hp
 */
@Named(value = "adminBean")
@RequestScoped
public class adminBean {

    AdminClient ac;
    StudentClient sc;
    Response rs;

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(false);

    Collection<EventMaster> events;
    Collection<CategoryMaster> category;
    Collection<WinnerMaster> winners;
    Collection<SponserMaster> sponsers;
    Collection<AwardMaster> award;
    Collection<HackathonMaster> hackathon;
    Collection<RegisterMaster> admins;
    Collection<RegisterMaster> students;
    Collection<GroupMaster> groups;
    Collection<ParticipationMaster> participations;
    Collection<AwardMaster> filterAwards;

    private Part file;

    GenericType<Collection<EventMaster>> genricEvents;
    GenericType<Collection<CategoryMaster>> genricCategory;
    GenericType<Collection<WinnerMaster>> genricWinners;
    GenericType<Collection<SponserMaster>> genricSponsers;
    GenericType<Collection<AwardMaster>> gernricAward;
    GenericType<Collection<RegisterMaster>> genricStudents;
    GenericType<Collection<RegisterMaster>> genricAdmins;
    GenericType<Collection<HackathonMaster>> genricHackathon;
    GenericType<Collection<GroupMaster>> genricGroup;
    GenericType<Collection<ParticipationMaster>> genricParticipations;
    GenericType<Collection<AwardMaster>> genricFilterAwards;

    CategoryMaster cat;
    EventMaster event;

    String totalEvents;
    String totalUsers;
    String totalSponsers;
    String totalCategory;

    public String getTotalCategory() {
        return totalCategory;
    }

    public void setTotalCategory(String totalCategory) {
        this.totalCategory = totalCategory;
    }

    public String getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(String totalEvents) {
        this.totalEvents = totalEvents;
    }

    public String getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(String totalUsers) {
        this.totalUsers = totalUsers;
    }

    public String getTotalSponsers() {
        return totalSponsers;
    }

    public void setTotalSponsers(String totalSponsers) {
        this.totalSponsers = totalSponsers;
    }

    CategoryMaster catagory = new CategoryMaster();
    EventMaster eventUpdate = new EventMaster();
    //Event variables
    String eventId, title, description, registerId, startTime, endTime, address, pincode, isGallary, isGroup, startDate, endDate, categoryId, img, numberOfPeopleInGroup;
    //award
    String awardTitle, awardDiscription;

//    //winner
    String winnerEventId, winnerGroupId, winnerTitle;

    private String we, wg, wt;

    public String getWe() {
        return we;
    }

    public void setWe(String we) {
        this.we = we;
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

    //Sponser
    String sponserEventId, sponserName, sponserDiscription, sponserImage, contactNumber;

    //category 
    String categoryName, categoryTitle;

    //register
    public adminBean() {
        ac = new AdminClient();
        sc = new StudentClient();

        events = new ArrayList<>();
        category = new ArrayList();
        winners = new ArrayList();
        sponsers = new ArrayList();
        award = new ArrayList();
        hackathon = new ArrayList();
        admins = new ArrayList();
        students = new ArrayList();
        category = new ArrayList();
        groups = new ArrayList();
        participations = new ArrayList();
        filterAwards = new ArrayList();

        genricCategory = new GenericType<Collection<CategoryMaster>>() {
        };
        genricEvents = new GenericType<Collection<EventMaster>>() {
        };

        genricCategory = new GenericType<Collection<CategoryMaster>>() {
        };
        genricWinners = new GenericType<Collection<WinnerMaster>>() {
        };
        genricSponsers = new GenericType<Collection<SponserMaster>>() {
        };
        gernricAward = new GenericType<Collection<AwardMaster>>() {
        };
        genricStudents = new GenericType<Collection<RegisterMaster>>() {
        };
        genricAdmins = new GenericType<Collection<RegisterMaster>>() {
        };
        genricHackathon = new GenericType<Collection<HackathonMaster>>() {
        };
        genricGroup = new GenericType<Collection<GroupMaster>>() {
        };
        genricParticipations = new GenericType<Collection<ParticipationMaster>>() {
        };
        genricFilterAwards = new GenericType<Collection<AwardMaster>>() {
        };

        cat = new CategoryMaster();
        event = new EventMaster();
    }

    public Collection<ParticipationMaster> getParticipations() {
        return participations;
    }

    public void setParticipations(Collection<ParticipationMaster> participations) {
        this.participations = participations;
    }

    public GenericType<Collection<ParticipationMaster>> getGenricParticipations() {
        return genricParticipations;
    }

    public void setGenricParticipations(GenericType<Collection<ParticipationMaster>> genricParticipations) {
        this.genricParticipations = genricParticipations;
    }

    public String getSponserEventId() {
        return sponserEventId;
    }

    public void setSponserEventId(String sponserEventId) {
        this.sponserEventId = sponserEventId;
    }

    public String getSponserName() {
        return sponserName;
    }

    public void setSponserName(String sponserName) {
        this.sponserName = sponserName;
    }

    public String getSponserDiscription() {
        return sponserDiscription;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void setSponserDiscription(String sponserDiscription) {
        this.sponserDiscription = sponserDiscription;
    }

    public String getSponserImage() {
        return sponserImage;
    }

    public void setSponserImage(String sponserImage) {
        this.sponserImage = sponserImage;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWinnerEventId() {
        return winnerEventId;
    }

    public void setWinnerEventId(String winnerEventId) {
        this.winnerEventId = winnerEventId;
    }

    public String getWinnerGroupId() {
        return winnerGroupId;
    }

    public void setWinnerGroupId(String winnerGroupId) {
        this.winnerGroupId = winnerGroupId;
    }

    public String getWinnerTitle() {
        return winnerTitle;
    }

    public void setWinnerTitle(String winnerTitle) {
        this.winnerTitle = winnerTitle;
    }

    public String getAwardTitle() {
        return awardTitle;
    }

    public void setAwardTitle(String awardTitle) {
        this.awardTitle = awardTitle;
    }

    public String getAwardDiscription() {
        return awardDiscription;
    }

    public void setAwardDiscription(String awardDiscription) {
        this.awardDiscription = awardDiscription;
    }

    public Collection<AwardMaster> getFilterAwards() {
        return filterAwards;
    }

    public void setFilterAwards(Collection<AwardMaster> filterAwards) {
        this.filterAwards = filterAwards;
    }

    public GenericType<Collection<AwardMaster>> getGenricFilterAwards() {
        return genricFilterAwards;
    }

    public void setGenricFilterAwards(GenericType<Collection<AwardMaster>> genricFilterAwards) {
        this.genricFilterAwards = genricFilterAwards;
    }

    public GenericType<Collection<RegisterMaster>> getGenricStudents() {
        return genricStudents;
    }

    public void setGenricStudents(GenericType<Collection<RegisterMaster>> genricStudents) {
        this.genricStudents = genricStudents;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public GenericType<Collection<RegisterMaster>> getGenricAdmins() {
        return genricAdmins;
    }

    public void setGenricAdmins(GenericType<Collection<RegisterMaster>> genricAdmins) {
        this.genricAdmins = genricAdmins;
    }

    public GenericType<Collection<HackathonMaster>> getGenricHackathon() {
        return genricHackathon;
    }

    public void setGenricHackathon(GenericType<Collection<HackathonMaster>> genricHackathon) {
        this.genricHackathon = genricHackathon;
    }

    public void setAdmins(Collection<RegisterMaster> admins) {
        this.admins = admins;
    }

    public void setWinners(Collection<WinnerMaster> winners) {
        this.winners = winners;
    }

    public void setSponsers(Collection<SponserMaster> sponsers) {
        this.sponsers = sponsers;
    }

    public Collection<AwardMaster> getAward() {
        rs = ac.getAllAwards(Response.class);
        award = rs.readEntity(gernricAward);
        return award;
    }

    public void setAward(Collection<AwardMaster> award) {
        this.award = award;
    }

    public Collection<HackathonMaster> getHackathon() {
        return hackathon;
    }

    public void setHackathon(Collection<HackathonMaster> hackathon) {
        this.hackathon = hackathon;
    }

    public void setStudents(Collection<RegisterMaster> students) {
        this.students = students;
    }

    public GenericType<Collection<WinnerMaster>> getGenricWinners() {
        return genricWinners;
    }

    public void setGenricWinners(GenericType<Collection<WinnerMaster>> genricWinners) {
        this.genricWinners = genricWinners;
    }

    public GenericType<Collection<SponserMaster>> getGenricSponsers() {
        return genricSponsers;
    }

    public void setGenricSponsers(GenericType<Collection<SponserMaster>> genricSponsers) {
        this.genricSponsers = genricSponsers;
    }

    public GenericType<Collection<AwardMaster>> getGernricAward() {
        return gernricAward;
    }

    public void setGernricAward(GenericType<Collection<AwardMaster>> gernricAward) {
        this.gernricAward = gernricAward;
    }

    public void setEvents(Collection<EventMaster> events) {
        this.events = events;
    }

    public void setCategory(Collection<CategoryMaster> category) {
        this.category = category;
    }

    public GenericType<Collection<EventMaster>> getGenricEvents() {
        return genricEvents;
    }

    public void setGenricEvents(GenericType<Collection<EventMaster>> genricEvents) {
        this.genricEvents = genricEvents;
    }

    public GenericType<Collection<CategoryMaster>> getGenricCategory() {
        return genricCategory;
    }

    public void setGenricCategory(GenericType<Collection<CategoryMaster>> genricCategory) {
        this.genricCategory = genricCategory;
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

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
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

    public String getIsGallary() {
        return isGallary;
    }

    public void setIsGallary(String isGallary) {
        this.isGallary = isGallary;
    }

    public String getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(String isGroup) {
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

    public String getCategoryId() {
        return categoryId;
    }

    public Collection<GroupMaster> getGroups() {
        return groups;
    }

    public void setGroups(Collection<GroupMaster> groups) {
        this.groups = groups;
    }

    public GenericType<Collection<GroupMaster>> getGenricGroup() {
        return genricGroup;
    }

    public void setGenricGroup(GenericType<Collection<GroupMaster>> genricGroup) {
        this.genricGroup = genricGroup;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Collection<CategoryMaster> getAllCategory() {
        rs = ac.getAllCategory(Response.class);
        category = rs.readEntity(genricCategory);
        return category;
    }

    public Collection<EventMaster> getEvents() {
        rs = ac.getAllEvents(Response.class);
        events = rs.readEntity(genricEvents);
        System.out.println(totalEvents);
        return events;
    }

    public Collection<WinnerMaster> getWinners() {
        rs = ac.getAllWinner(Response.class);
        winners = rs.readEntity(genricWinners);
        return winners;
    }

    public Collection<AwardMaster> getAllAwards() {
        rs = ac.getAllAwards(Response.class);
        award = rs.readEntity(gernricAward);
        return award;
    }

    public Collection<CategoryMaster> getCategory() {
        rs = ac.getAllCategory(Response.class);
        category = rs.readEntity(genricCategory);
        return category;
    }

    public Collection<SponserMaster> getSponsers() {
        rs = ac.getAllSponsers(Response.class);
        sponsers = rs.readEntity(genricSponsers);
        return sponsers;
    }

    public Collection<RegisterMaster> getAdmins() {
        rs = ac.getAllAdmins(Response.class);
        admins = rs.readEntity(genricAdmins);
        return admins;
    }

    public Collection<RegisterMaster> getStudents() {
        rs = ac.getAllStudents(Response.class);
        students = rs.readEntity(genricStudents);
        return students;
    }

    public void loadAwardsAndGroups() {
        this.winnerEventId = winnerEventId;
      

        this.filterAwards = getAwardByEventId(winnerEventId);
        this.groups = getGroupsByEventId(winnerEventId);

    }

    public String checkEmail() {

        RegisterMaster user = (RegisterMaster) session.getAttribute("User");
        if (user == null || user.getRoleId().getRole().equals("student")) {
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/Login.jsf");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception as needed
            }
            return "/Login.jsf?faces-redirect=true";
        }
        return "successOutcome";
    }

    //Insert Functions
    public String insertEvent() {


        this.registerId = String.valueOf(session.getAttribute("registerId"));

     

        String imageName;
        if (file != null) {
            try {
                imageName = file.getSubmittedFileName();
                Response createEvent = ac.createEvent(title, description, registerId, startTime, endTime, address, pincode, "0", "0", startDate, endDate, categoryId, numberOfPeopleInGroup, imageName);

                System.out.println(createEvent.getStatus());

                String uploadDirectory = "E:\\College_Event_proj\\event_management\\src\\main\\webapp\\resources\\images";

                File uploadDir = new File(uploadDirectory);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File uploadedFile = new File(uploadDirectory, imageName);

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

        return "EventDisplay.jsf?faces-redirect=true";
    }

    public String insertAward() {

        ac.createAwardOfEvent(eventId, awardTitle, awardDiscription);
        return "DisplayAwards.jsf?faces-redirect=true";
    }

    public String insertCategory() {
        if (FacesContext.getCurrentInstance().isValidationFailed()) {
            System.out.println("Validation called");
            return null; // or some other outcome
        }
        ac.createCategory(categoryName, categoryTitle);
        return "DisplayCategory.jsf?faces-redirect=true";
    }

//    public String insertWinner() {
//      
//
////        ac.createWinner(winnerEventId, winnerGroupId, winnerTitle);
//        return "DisplayWinner.jsf?faces-redirect=true";
//    }

    public String insertSponsers() {
     

        String fileName;
        if (file != null) {
            try {
                fileName = file.getSubmittedFileName();
                System.out.println(fileName);
                ac.createSponserOfEvent(sponserEventId, sponserName, sponserDiscription, fileName, contactNumber);

                String uploadDirectory = "E:\\College_Event_proj\\event_management\\src\\main\\webapp\\resources\\images";
                File uploadDir = new File(uploadDirectory);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File uploadedFile = new File(uploadDirectory, fileName);

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
        return "DisplaySponsers.jsf?faces-redirect=true";
    }

    //Delete 
    public void deleteCategory(String id) {
        ac.deleteCategory(id);
    }

    public void deleteEvent(String id) {
        ac.deleteEventById(id);
    }

    public void deleteWinner(String id) {
        ac.deleteWinner(id);
    }

    public void deleteSponser(String id) {
        ac.deleteSponserById(id);
    }

    public void deleteAward(String id) {
        ac.deleteAwardDetailById(id);
    }

    //get by Id
    public Collection<GroupMaster> getGroupsByEventId(String winnerEventId) {
        rs = sc.getAllGroupsByEventId(Response.class, winnerEventId);
        groups = rs.readEntity(genricGroup);
        setGroups(groups);
        return groups;
    }

    public Collection<AwardMaster> getAwardByEventId(String winnerEventId) {
        rs = ac.getAwardByEventId(Response.class, winnerEventId);
        filterAwards = rs.readEntity(genricFilterAwards);
        setAward(filterAwards);
        return filterAwards;
    }

//    public Collection<ParticipationMaster> getParticipationByGroupId(String groupId) {
//        System.out.println(groupId);
//        rs = sc.getAllParticipationsByGroupId(Response.class, groupId);
//        participations = rs.readEntity(genricParticipations);
//        return participations;
//    }
//        public Collection<GroupMaster> getParticipation(String eventId){
//        rs = sc.getAllGroupsByEventId(Response.class, eventId);
//        groups = rs.readEntity(genricGroup);
//        return groups;
//    }
    //update role
//    public String changeRole(String rid) {
//        try {
//            System.out.println("Hiiiiiiiiiiiiiiiii : " + rid);
//           Response rs = ac.updateRole(rid);
//           System.out.println(rs.getStatus());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return "Admin.jsf?faces-redirect=true";
//    }
    //set values
    public String setValueCategory(String categoryId) {
        rs = ac.getCategoryById(Response.class, categoryId);
        GenericType<CategoryMaster> tempCat = new GenericType<CategoryMaster>() {
        };
        cat = rs.readEntity(tempCat);

        this.categoryId = cat.getCategoryId().toString();
        this.categoryName = cat.getCategoryName();
        this.categoryTitle = cat.getCategoryType();

        System.out.println(categoryId);
        System.out.println(categoryName);
        System.out.println(categoryTitle);

        return "updateCategory.jsf";
    }

    public String setEventValues(int eventId) {

        String tempEventId = String.valueOf(eventId);
        rs = ac.getEventById(Response.class, tempEventId);
        GenericType<EventMaster> tempEvent = new GenericType<EventMaster>() {
        };
        event = rs.readEntity(tempEvent);
        this.eventId = event.getEventId().toString();
        this.title = event.getTitle().toString();
        this.description = event.getDescription();
        this.registerId = event.getRegisterId().toString();
        this.startTime = event.getStartTime();
        this.endTime = event.getEndTime();
        this.address = event.getAddress();
        this.pincode = event.getPincode();
        this.isGroup = String.valueOf(event.getIsGroup());
        this.isGallary = String.valueOf(event.getIsGallary());
        this.categoryId = event.getCategoryId().toString();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.img = event.getEventImg();
        this.numberOfPeopleInGroup = event.getMaxPeopleGroup().toString();
        return "updateEvent.jsf";
    }

    //update category
    public String updateCategory() {
        System.out.println("CDI BEANS " + categoryId);
        System.out.print(categoryName);
        System.out.println(categoryTitle);

        catagory.setCategoryName(categoryName);
        catagory.setCategoryType(categoryTitle);

        rs = ac.updateCategory(catagory, categoryId);

        return "DisplayCategory.jsf";
    }

    public String updateEvent() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        RegisterMaster user = (RegisterMaster) session.getAttribute("User");

        String fileName = null;
        if (file != null) {
            try {
                fileName = file.getSubmittedFileName();
                System.out.println(fileName);
                String uploadDirectory = "E:\\College_Event_proj\\event_management\\src\\main\\webapp\\resources\\images";
                File uploadDir = new File(uploadDirectory);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File uploadedFile = new File(uploadDirectory, fileName);

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

        eventUpdate.setTitle(title);
        eventUpdate.setDescription(description);
        eventUpdate.setAddress(address);
        eventUpdate.setStartTime(startTime);
        eventUpdate.setEndTime(endTime);
        eventUpdate.setPincode(pincode);
        eventUpdate.setStartDate(startDate);
        eventUpdate.setEndDate(endDate);
        eventUpdate.setEventImg(fileName);
        eventUpdate.setMaxPeopleGroup(Integer.valueOf(numberOfPeopleInGroup));
        ac.updateEventById(eventUpdate, eventId, user.getRegisterId().toString(), categoryId);
        return "EventDisplay.jsf";
    }

    public void loadDashbord() {
        totalEvents = String.valueOf(ac.countTotalEvents(Integer.class));
        totalCategory = String.valueOf(ac.countTotalCategories(Integer.class));
        totalSponsers = String.valueOf(ac.countTotalSponsors(Integer.class));
        totalUsers = String.valueOf(ac.countTotalUsers(Integer.class));

    }

}
