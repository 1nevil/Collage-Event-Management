/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJBs;

import Entity.GroupMaster;
import Entity.HackathonMaster;
import Entity.ParticipationMaster;
import Entity.RegisterMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author hp
 */
@Local
public interface StudentLocal {

    public String register(String userName, String email, String password, String phoneNumber, String dataOfBirth, String address, String image);

    public RegisterMaster getUserByUserName(String userName);

    public RegisterMaster getUserByPhoneNumber(String phoneno);

    RegisterMaster getUserDetailsByEmail(String email);

    public void updateUserDetailsByEmail(String email, String userName, String password, String phoneNumber, String dataOfBirth, String address, String image);

    public void updatePassword(String email ,String newPassword);
    
    //GroupMaster table & participation table
    public String participateInEvent(int eventId, String groupName, int registerId);

    public Collection<GroupMaster> getAllGroupByEventId(int eventId);

    public Collection<ParticipationMaster> getAllParticipationByGroupId(int groupId);

    public String deleteGroupById(int groupId);

    public String deleteParticipationById(int participationId);
    
    public Collection<ParticipationMaster> getParticipationByUserId(int registerId);

    //hackathon table
    void hackathonSubmition(int groupId, int eventId, String githubLink, String demoLink);

    void hackathonSubmitionUpdate(int groupId, int eventId, int hackathonId, String githubLink, String demoLink);

    void deleteHackthonSubmition(int eventId, int hackathonId);

    HackathonMaster getHackthonSubmissionByGroupId(int eventId, int groupId);
}
