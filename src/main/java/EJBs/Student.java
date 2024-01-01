/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJBs;

import Entity.EventMaster;
import Entity.GroupMaster;
import Entity.HackathonMaster;
import Entity.ParticipationMaster;
import Entity.RegisterMaster;
import Entity.RoleMaster;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

@Stateless
public class Student implements StudentLocal {

    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare phc;

    @PersistenceContext(name = "event_unit")
    EntityManager em;

    @EJB
    validate validation;

    @Override
    public String register(String userName, String email, String password, String phoneNumber, String dataOfBirth, String address, String image) {

        if (validation.isUsernameExists(userName)) {
            return "User name is Already exist";
        }

        if (validation.isEmailExists(email)) {
            return "Email is already Exists";
        }

        if (validation.isPhoneNoExists(phoneNumber)) {
            return "phone number is already exists";
        }

        try {
            RoleMaster role = em.find(RoleMaster.class, 2);

            RegisterMaster register = new RegisterMaster();
            register.setUsername(userName);
            register.setEmail(email);
            register.setPassword(password);
            register.setPhoneNo(phoneNumber);
            register.setDateOfBirth(dataOfBirth);
            register.setAddress(address);
            register.setMyImg(image);
            register.setCreatedAt(LocalDate.now().toString());
            register.setRoleId(role);
            em.persist(register);
            return "Register Success fully";
        } catch (Exception e) {
            System.out.println("Message :  " + e.getMessage());
            e.printStackTrace();
            return "";
        }

    }

    @Override
    public void updatePassword(String email, String newPassword) {
        try {
            RegisterMaster userEmail = (RegisterMaster) em.createNamedQuery("RegisterMaster.findByEmail").setParameter("email", email).getSingleResult();
            userEmail.setPassword(newPassword);
            em.merge(userEmail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public Collection<ParticipationMaster> getParticipationByUserId(int registerId) {
        String queryString = "SELECT p FROM ParticipationMaster p WHERE p.registerId.registerId = :registerId";
        Query query = em.createQuery(queryString, ParticipationMaster.class);
        query.setParameter("registerId", registerId);
        return query.getResultList();
    }

    @Override
    public RegisterMaster getUserByPhoneNumber(String phoneno) {
        try {

            RegisterMaster userPhoneno = (RegisterMaster) em.createNamedQuery("RegisterMaster.findByPhoneNo").setParameter("phoneNo", phoneno).getSingleResult();
            System.out.println(userPhoneno);
            if (userPhoneno == null) {
                return null;
            }
            return userPhoneno;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public RegisterMaster getUserByUserName(String userName) {
        try {

            RegisterMaster user = (RegisterMaster) em.createNamedQuery("RegisterMaster.findByUsername").setParameter("username", userName).getSingleResult();
            if (user == null) {
                return null;
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public RegisterMaster getUserDetailsByEmail(String email) {
        try {

            RegisterMaster userEmail
                    = (RegisterMaster) em.createNamedQuery("RegisterMaster.findByEmail").setParameter("email", email).getSingleResult();
            if (userEmail == null) {
                return null;
            }
            return userEmail;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateUserDetailsByEmail(String email, String userName, String password, String phoneNumber, String dataOfBirth, String address, String image) {
        try {
            RoleMaster role = em.find(RoleMaster.class, 2);
            System.out.println(email);
            System.out.println(userName);
            System.out.println(password);
            System.out.println(phoneNumber);
            System.out.println(dataOfBirth);
            System.out.println(address);
            System.out.println(image);

            RegisterMaster user = (RegisterMaster) em.createNamedQuery("RegisterMaster.findByEmail").setParameter("email", email).getSingleResult();

            user.setRegisterId(user.getRegisterId());
            user.setUsername(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNo(phoneNumber);
            user.setDateOfBirth(dataOfBirth);
            user.setAddress(address);
            user.setMyImg(image);
            user.setRoleId(role);
            user.setCreatedAt(LocalDate.now().toString());
            em.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void hackathonSubmition(int groupId, int eventId, String githubLink, String demoLink) {
        try {
            EventMaster event = em.find(EventMaster.class,
                    eventId);
            Collection<HackathonMaster> hackathonsSubmissionData = event.getHackathonMasterCollection();
            GroupMaster group = em.find(GroupMaster.class,
                    groupId);

            HackathonMaster hackathon = new HackathonMaster();
            hackathon.setGroupId(group);
            hackathon.setEventId(event);
            hackathon.setGithubLink(githubLink);
            hackathon.setLiveLink(demoLink);
            hackathonsSubmissionData.add(hackathon);

            event.setHackathonMasterCollection(hackathonsSubmissionData);

            em.persist(hackathon);
            em.merge(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void hackathonSubmitionUpdate(int groupId, int eventId, int hackathonId, String githubLink, String demoLink) {
        try {
            EventMaster event = em.find(EventMaster.class,
                    eventId);
            Collection<HackathonMaster> hackathonsSubmissionData = event.getHackathonMasterCollection();

            HackathonMaster hackathon = em.find(HackathonMaster.class,
                    hackathonId);

            if (hackathon != null && hackathonsSubmissionData.contains(hackathon)) {
                hackathon.setGithubLink(githubLink);
                hackathon.setLiveLink(demoLink);
                em.merge(hackathon);
            } else {
                System.out.println("Null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteHackthonSubmition(int eventId, int hackathonId) {

        try {
            EventMaster event = em.find(EventMaster.class,
                    eventId);
            Collection<HackathonMaster> hackathonsSubmissionData = event.getHackathonMasterCollection();

            HackathonMaster hackathon = em.find(HackathonMaster.class,
                    hackathonId);

            if (hackathon != null && hackathonsSubmissionData.contains(hackathon)) {
                em.remove(hackathon);
            } else {
                System.out.println("Null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public HackathonMaster
            getHackthonSubmissionByGroupId(int eventId, int groupId) {

        try {

            EventMaster event = em.find(EventMaster.class, eventId);
            GroupMaster myGroup = em.find(GroupMaster.class, groupId);
            Collection<GroupMaster> group = event.getGroupMasterCollection();

            if (group.contains(myGroup)) {

                HackathonMaster hackthonSubmissions = myGroup.getHackathonMaster();
                return hackthonSubmissions;
            } else {
                throw new EJBException("You are not submitted any project");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Group and paticipation table
    private GroupMaster findOrCreateGroup(EventMaster event, String groupName) {

        try {
            System.err.println(event.getEventId());
            List<GroupMaster> existingGroups = em.createQuery("SELECT g FROM GroupMaster g WHERE g.eventId = :event AND g.groupName = :groupName", GroupMaster.class
            )
                    .setParameter("event", event)
                    .setParameter("groupName", groupName)
                    .getResultList();

            if (!existingGroups.isEmpty()) {
                // Return First events the existing group
                System.out.println(existingGroups.get(0));

                return existingGroups.get(0);
            } else {
                // Create a new group
                System.out.println("New group is created");

                GroupMaster group = new GroupMaster();
                group.setEventId(event);
                group.setGroupName(groupName);

                System.out.println("Linie number 372 : " + group.getEventId() + "" + group.getGroupName() + "" + group.getGroupId());

                em.persist(group);
                return group;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    // group Master table 
    @Override
    public String participateInEvent(int eventId, String groupName, int registerId) {

//        if (vl.isGroupNameExists(groupName)) {
//            return "Group name is already exist";
//        }
        try {
            EventMaster event = em.find(EventMaster.class,
                    eventId);

            RegisterMaster registerUser = em.find(RegisterMaster.class,
                    registerId);

//            GroupMaster groupExist = (GroupMaster) em.createNamedQuery("GroupMaster.findByGroupName").setParameter("groupName", groupName).getSingleResult();
//
//            if (groupExist != null) {
//                return "Group Name is Already exist";
//            }
            if (event == null) {
                return "Event not Exists";
            }

            // Create or find the group
            GroupMaster group = findOrCreateGroup(event, groupName);
            System.out.println("Line :393" + group);
            int sizeOfGroup = 0;
            if (group.getParticipationMasterCollection() != null) {
                sizeOfGroup = group.getParticipationMasterCollection().size();
            }

            int eventGroupSize = event.getMaxPeopleGroup();

            if (sizeOfGroup <= eventGroupSize) {
                Collection<ParticipationMaster> CheckExist = em.createQuery("SELECT p FROM ParticipationMaster p WHERE p.groupId = :group AND p.registerId = :registerId  ", ParticipationMaster.class
                ).setParameter("registerId", registerUser).setParameter("group", group).getResultList();

                if (CheckExist.isEmpty()) {
                    ParticipationMaster participant = new ParticipationMaster();
                    participant.setRegisterId(registerUser);
                    participant.setGroupId(group);
                    Collection<ParticipationMaster> participants = group.getParticipationMasterCollection();

                    participants = new ArrayList<>();
                    System.out.println("Line number 324 :" + participants);

                    System.out.println("Not Alrady ");
                    participants.add(participant);

                    group.setParticipationMasterCollection(participants);

                    em.persist(group);
                    em.persist(participant);
                    int registerPeople = event.getNoOfRegistration() + 1;
                    event.setNoOfRegistration(registerPeople);
                    em.merge(event);

                    return "You are Enrolled in the Event";

                } else {
                    return "Group is limit to " + eventGroupSize + "people ";
                }
            } else {
                return "You are already Enrolled";
            }

        } catch (Exception e) {
            e.printStackTrace();

            return e.getMessage();

        }
    }

    @Override
    public Collection<GroupMaster> getAllGroupByEventId(int eventId
    ) {
        EventMaster event = em.find(EventMaster.class,
                eventId);
        return event.getGroupMasterCollection();
    }

//    @Override
    @Override
    public Collection<ParticipationMaster> getAllParticipationByGroupId(int groupId
    ) {
        GroupMaster group = em.find(GroupMaster.class,
                groupId);
        return group.getParticipationMasterCollection();
    }

    @Override
    public String deleteGroupById(int groupId
    ) {
        try {
            GroupMaster group = em.find(GroupMaster.class,
                    groupId);
            em.remove(group);
            return "Deleted successFully";

        } catch (Exception e) {
            return "Error in Delete GroupId" + e;
        }
    }

    @Override
    public String deleteParticipationById(int participationId
    ) {
        try {
            ParticipationMaster participate = em.find(ParticipationMaster.class,
                    participationId);
            em.remove(participate);
            return "Deleted successFully";

        } catch (Exception e) {
            return "Error in Delete GroupId" + e;
        }
    }

}
