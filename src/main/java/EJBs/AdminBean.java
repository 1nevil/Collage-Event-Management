package EJBs;

import Entity.AwardMaster;
import Entity.CategoryMaster;
import Entity.EventMaster;
import Entity.GroupMaster;
import Entity.HackathonMaster;
import Entity.ParticipationMaster;
import Entity.RegisterMaster;
import Entity.RoleMaster;
import Entity.SponserMaster;
import Entity.WinnerMaster;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdminBean implements AdminBeanLocal {

    @PersistenceContext(name = "event_unit")
    EntityManager em;

    //EventMaster CRUD
    @Override
    public void createEvent(String title, String description, int registerId, String startTime, String endTime, String address, String pincode, boolean isGallary, boolean isGroup, String startDate, String endDate, int categoryId, int numberOfPeopleInGroup, String img) {
        try {
            System.out.println("Hello");
            RegisterMaster register = em.find(RegisterMaster.class, registerId);

            EventMaster event = new EventMaster();
            event.setTitle(title);
            event.setDescription(description);
            event.setRegisterId(register);
            event.setStartTime(startTime);
            event.setEndTime(endTime);
            event.setAddress(address);
            event.setPincode(pincode);
            event.setIsGallary((short) 1);
            event.setIsGroup((short) 1);
            event.setStartDate(startDate);
            event.setEndDate(endDate);
            event.setNoOfRegistration(0);
            event.setMaxPeopleGroup(numberOfPeopleInGroup);
            event.setEventImg(img);

            CategoryMaster category = em.find(CategoryMaster.class, categoryId);
            event.setCategoryId(category);

            em.persist(event);
        } catch (Exception e) {
            System.out.println("Message :  " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void updateEventById(int eventId, String title, String description, int registerId, String startTime, String endTime, String address, String pincode, String startDate, String endDate, int categoryId, int numberOfPeopleInGroup, String img) {
        try {
            EventMaster event = (EventMaster) em.find(EventMaster.class, eventId);
            RegisterMaster register = (RegisterMaster) em.find(RegisterMaster.class, registerId);

            event.setTitle(title);
            event.setDescription(description);
            event.setRegisterId(register);
            event.setStartTime(startTime);
            event.setEndTime(endTime);
            event.setAddress(address);
            event.setPincode(pincode);
            event.setIsGallary((short) 1);
            event.setIsGroup((short) 1);
            event.setStartDate(startDate);
            event.setEndDate(endDate);
            event.setNoOfRegistration(0);
            event.setMaxPeopleGroup(numberOfPeopleInGroup);
            event.setEventImg(img);

            CategoryMaster category = em.find(CategoryMaster.class, categoryId);
            event.setCategoryId(category);

            em.merge(event);
        } catch (Exception e) {
            System.out.println("Message :  " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEventById(int eventId) {
        try {
            EventMaster event = em.find(EventMaster.class, eventId);
            em.remove(event);
        } catch (Exception e) {
            System.out.println("Error in InsertEvent By Id method : \n");
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
    }

    @Override
    public Collection<EventMaster> getAllEvents() {
        return em.createNamedQuery("EventMaster.findAll").getResultList();
    }

    @Override
    public EventMaster getEventById(int eventId) {
        try {
            return em.find(EventMaster.class, eventId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<EventMaster> getEventByRegisterId(int registerId) {
        try {
            RegisterMaster register = em.find(RegisterMaster.class, registerId);
            return register.getEventMasterCollection();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<EventMaster> getEventByStartDate(String startDate) {
        try {
            return em.createNamedQuery("EventMaster.findByStartDate").setParameter("startDate", startDate).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<EventMaster> getEventByEndDate(String endDate) {
        try {
            return em.createNamedQuery("EventMaster.findByEndDate").setParameter("endDate", endDate).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<EventMaster> getEventByCategoryId(int categoryId) {
        CategoryMaster category = em.find(CategoryMaster.class, categoryId);
        return category.getEventMasterCollection();
    }

    //Category Master CRUD
    @Override
    public void createCategory(String name, String type) {

        try {
            CategoryMaster category = new CategoryMaster();
            category.setCategoryName(name);
            category.setCategoryType(type);
            em.persist(category);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public void deleteCategory(int categoryId) {
        try {
            CategoryMaster category = em.find(CategoryMaster.class, categoryId);
            em.remove(category);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public void updateCategory(int categoryId, String name, String type) {
        try {
            CategoryMaster category = em.find(CategoryMaster.class, categoryId);
            category.setCategoryName(name);
            category.setCategoryType(type);
            em.merge(category);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public Collection<CategoryMaster> getAllCategory() {
        return em.createNamedQuery("CategoryMaster.findAll").getResultList();
    }

    @Override
    public CategoryMaster getCategoryById(int categoryId) {
        return em.find(CategoryMaster.class, categoryId);
    }

    //Award Master
    @Override
    public void createAwardOfEvent(int eventId, String awardTitle, String awardDescription) {
        try {
            EventMaster event = em.find(EventMaster.class, eventId);
            Collection<AwardMaster> awards = event.getAwardMasterCollection();

            AwardMaster award = new AwardMaster();
            award.setEventId(event);
            award.setAwardTitle(awardTitle);
            award.setAwardDescription(awardDescription);
            awards.add(award);
            event.setAwardMasterCollection(awards);

            em.persist(award);
            em.merge(event);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public void updateAwardById(int awardId, int eventId, String awardTitle, String awardDescription) {
        try {
            EventMaster event = em.find(EventMaster.class, eventId);
            Collection<AwardMaster> awards = event.getAwardMasterCollection();

            AwardMaster award = em.find(AwardMaster.class, awardId);

            if (awards.contains(award)) {
                award.setAwardTitle(awardTitle);
                award.setAwardDescription(awardDescription);
                em.merge(award);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public void deleteAwardDetailById(int awardId) {
        try {
            AwardMaster award = em.find(AwardMaster.class, awardId);

            em.remove(award);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public Collection<AwardMaster> getAllAwards() {
        return em.createNamedQuery("AwardMaster.findAll").getResultList();
    }

    @Override
    public AwardMaster getAwardByAwardId(int awardId) {
        return em.find(AwardMaster.class, awardId);
    }

    @Override
    public Collection<AwardMaster> getAwardByEventId(int eventId) {
        EventMaster event = em.find(EventMaster.class, eventId);
        return event.getAwardMasterCollection();
    }

    //Sponser Master
    @Override
    public void createSponserOfEvent(int eventId, String sponserName, String sponserDescription, String Img, String contact) {
        try {

            EventMaster event = em.find(EventMaster.class, eventId);

            Collection<SponserMaster> sponsers = event.getSponserMasterCollection();

            SponserMaster sponser = new SponserMaster();
            sponser.setSponserName(sponserName);
            sponser.setSponserDescription(sponserDescription);
            sponser.setSponserImg(Img);
            sponser.setEventId(event);
            sponser.setSponserContact(contact);
            sponsers.add(sponser);

            event.setSponserMasterCollection(sponsers);

            em.persist(sponser);
            em.merge(event);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
    }

    @Override
    public void deleteSponserById(int sponserId) {
        try {

            SponserMaster sponser = em.find(SponserMaster.class, sponserId);

            em.remove(sponser);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public void updateSponserById(int eventId, int sponserId, String sponserName, String sponserDescription, String Img, String contact) {
        try {
            EventMaster event = em.find(EventMaster.class, eventId);
            Collection<SponserMaster> sponsers = event.getSponserMasterCollection();

            SponserMaster sponser = em.find(SponserMaster.class, sponserId);

            if (sponsers.contains(sponser)) {
                sponser.setSponserName(sponserName);
                sponser.setSponserDescription(sponserDescription);
                sponser.setSponserImg(Img);
                sponser.setSponserContact(contact);
                em.merge(sponser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public Collection<SponserMaster> getAllSponsers() {
        return em.createNamedQuery("SponserMaster.findAll").getResultList();
    }

    @Override
    public Collection<SponserMaster> getSponserByEventId(int eventId) {
        EventMaster event = em.find(EventMaster.class, eventId);
        return event.getSponserMasterCollection();
    }

    @Override
    public SponserMaster getSponserBySponserId(int sponserId) {
        return em.find(SponserMaster.class, sponserId);
    }

    //Winner Master
    @Override
    public void createWinner(int eventId, int groupId, String winnerTitle) {
        try {

            EventMaster event = em.find(EventMaster.class, eventId);
            GroupMaster group = em.find(GroupMaster.class, groupId);

            if (event == null) {
                throw new EJBException("Event is not found");
            }

            if (group == null) {
                throw new EJBException("Group is not found");
            }

            Collection<WinnerMaster> winners = event.getWinnerMasterCollection();

            WinnerMaster winner = new WinnerMaster();
            winner.setEventId(event);
            winner.setGroupId(group);
            winner.setWinnerTitle(winnerTitle);
            winners.add(winner);
            event.setWinnerMasterCollection(winners);

            em.persist(winner);
            em.merge(event);
        } catch (EJBException e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public void deleteWinner(int winnerId) {
        try {

            WinnerMaster winner = em.find(WinnerMaster.class, winnerId);
            em.remove(winner);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }

    @Override
    public void updateWinner(int winnerId, int eventId, int groupId, String winnerTitle) {

        try {
            EventMaster event = em.find(EventMaster.class, eventId);
            GroupMaster group = em.find(GroupMaster.class, groupId);

            Collection<WinnerMaster> winners = event.getWinnerMasterCollection();

            WinnerMaster winner = em.find(WinnerMaster.class, winnerId);
            if (winners.contains(winner)) {
                winner.setGroupId(group);
                winner.setWinnerTitle(winnerTitle);
                em.merge(winner);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
    }

    @Override
    public WinnerMaster getWinnerByWinnerId(int winnerId) {
        return em.find(WinnerMaster.class, winnerId);
    }

    @Override
    public Collection<WinnerMaster> getWinnerByEventId(int eventId) {
        EventMaster event = em.find(EventMaster.class, eventId);
        return event.getWinnerMasterCollection();
    }

    @Override
    public Collection<WinnerMaster> getAllWinner() {
        return em.createNamedQuery("WinnerMaster.findAll").getResultList();
    }

    //hackathon Master
    @Override
    public Collection<HackathonMaster> gethackathonDetailsByEventId(int eventId) {
        EventMaster event = em.find(EventMaster.class, eventId);
        return event.getHackathonMasterCollection();
    }

    @Override
    public Collection<RegisterMaster> getAllRegisterUserDetails() {
        return em.createNamedQuery("RegisterMaster.findAll").getResultList();
    }

    @Override
    public Collection<RegisterMaster> getAllStudents() {
        RoleMaster role = em.find(RoleMaster.class, 2);
        return role.getRegisterMasterCollection();
    }

    @Override
    public Collection<RegisterMaster> getAllAdmins() {
        RoleMaster role = em.find(RoleMaster.class, 1);
        return role.getRegisterMasterCollection();
    }

    @Override
    public void removeUser(int registerId) {
        try {
            RegisterMaster register = em.find(RegisterMaster.class, registerId);
            em.remove(register);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }
    }

    @Override
    public void updateRole(int registerId) {
        try {
            RegisterMaster register = em.find(RegisterMaster.class, registerId);

            RoleMaster role = null;
            if (register.getRoleId().getRoleId() == 1) {
                role = em.find(RoleMaster.class, 2);

            } else {
                System.out.println("Chage to 1");
                role = em.find(RoleMaster.class, 1);
            }
            register.setRoleId(role);
            em.persist(register);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Message :  " + e.getMessage());
        }

    }
    
    @Override
    public int countTotalEvents() {
        try {
            Long count = (Long) em.createQuery("SELECT COUNT(e) FROM EventMaster e")
                    .getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            // Handle exceptions, log or rethrow as needed
            return -1; // Return a negative value to indicate an error
        }
    }
    
     @Override
     public int countTotalCategories() {
        try {
            Long count = (Long) em.createQuery("SELECT COUNT(c) FROM CategoryMaster c")
                    .getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            // Handle exceptions, log or rethrow as needed
            return -1; // Return a negative value to indicate an error
        }
    }
     
 @Override
     public int countTotalUsers() {
        try {
            Long count = (Long) em.createQuery("SELECT COUNT(u) FROM RegisterMaster u")
                    .getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            // Handle exceptions, log or rethrow as needed
            return -1; // Return a negative value to indicate an error
        }
    }
     
      @Override
     public int countTotalSponsors() {
        try {
            Long count = (Long) em.createQuery("SELECT COUNT(s) FROM SponserMaster s")
                    .getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            // Handle exceptions, log or rethrow as needed
            return -1; // Return a negative value to indicate an error
        }
    }
}
