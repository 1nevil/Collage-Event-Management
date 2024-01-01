/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJBs;

import Entity.AwardMaster;
import Entity.CategoryMaster;
import Entity.EventMaster;
import Entity.GroupMaster;
import Entity.HackathonMaster;
import Entity.ParticipationMaster;
import Entity.RegisterMaster;
import Entity.SponserMaster;
import Entity.WinnerMaster;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface AdminBeanLocal {
    //event table

    public void createEvent(String title, String description, int registerId, String startTime, String endTime, String address, String pincode, boolean isGallary, boolean isGroup, String startDate, String endDate, int categoryId, int numberOfPeopleInGroup, String img);

    public void updateEventById(int eventId, String title, String description, int registerId, String startTime, String endTime, String address, String pincode, String startDate, String endDate, int categoryId, int numberOfPeopleInGroup, String img);

    public void deleteEventById(int eventId);

    public Collection<EventMaster> getAllEvents();

    public EventMaster getEventById(int eventId);

    public Collection<EventMaster> getEventByRegisterId(int registerId);

    public Collection<EventMaster> getEventByStartDate(String startDate);

    public Collection<EventMaster> getEventByEndDate(String endDate);

    public Collection<EventMaster> getEventByCategoryId(int categoryId);

    //category table
    public void createCategory(String name, String type);

    public void deleteCategory(int categoryId);

    public void updateCategory(int categoryId, String name, String type);

    public Collection<CategoryMaster> getAllCategory();
    
    public CategoryMaster getCategoryById(int categoryId);

    //Award table
    public void createAwardOfEvent(int eventId, String awardTitle, String awardDescription);

    public void updateAwardById(int awardId, int eventId, String awardTitle, String awardDescription);

    public void deleteAwardDetailById( int awardId);

    public Collection<AwardMaster> getAllAwards();

    public AwardMaster getAwardByAwardId(int awardId);

    public Collection<AwardMaster> getAwardByEventId(int eventId);

    //sponser table
    public void createSponserOfEvent(int eventId, String sponserName, String sponserDescription, String Img, String contact);

    public void deleteSponserById( int sponserId);

    public void updateSponserById(int eventId, int sponserId, String sponserName, String sponserDescription, String Img, String contact);

    public Collection<SponserMaster> getAllSponsers();

    public Collection<SponserMaster> getSponserByEventId(int eventId);

    public SponserMaster getSponserBySponserId(int sponserId);

//Winner table
    public void createWinner(int eventId, int groupId, String winnerTitle);

    public void deleteWinner(int winnerId);

    public void updateWinner(int winnerId, int eventId, int groupId, String winnerTitle);

    public WinnerMaster getWinnerByWinnerId(int winnerId);

    public Collection<WinnerMaster> getAllWinner();
    
     public Collection<WinnerMaster> getWinnerByEventId(int eventId);

  
    
    //Hackthon master table
    
    public Collection<HackathonMaster> gethackathonDetailsByEventId(int eventId);

    // register master
    public Collection<RegisterMaster> getAllRegisterUserDetails();

    public Collection<RegisterMaster> getAllStudents();

    public Collection<RegisterMaster> getAllAdmins();

    public void removeUser(int registerId);

    public void updateRole(int registerId);
    
    //count
    
    public int countTotalEvents();
    
    public int countTotalCategories();
    
     public int countTotalUsers();
     public int countTotalSponsors();
}
