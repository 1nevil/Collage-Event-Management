/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import EJBs.StudentLocal;
import Entity.GroupMaster;
import Entity.HackathonMaster;
import Entity.ParticipationMaster;
import Entity.RegisterMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 * REST Web Service
 *
 * @author hp
 */
@Path("student")
@RequestScoped
public class StudentRest {

    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare phc;

    @EJB
    StudentLocal student;
    @Context
    private UriInfo context;

    public StudentRest() {
    }

    @POST
    @Path("/registerUser/{userName}/{email}/{password}/{phoneNumber}/{dataOfBirth}/{address}/{image}")
    public String registerUser(
            @PathParam("userName") String userName,
            @PathParam("email") String email,
            @PathParam("password") String password,
            @PathParam("phoneNumber") String phoneNumber,
            @PathParam("dataOfBirth") String dataOfBirth,
            @PathParam("address") String address,
            @PathParam("image") String image) {

        System.out.println("Hellllllllllllllllllllloooooooooooooo");
        System.out.println(email);
        System.out.println(userName);
        System.out.println(password);
        System.out.println(phoneNumber);
        System.out.println(dataOfBirth);
        System.out.println(address);
        System.out.println(image);

        pb = new Pbkdf2PasswordHashImpl();
        phc = new PasswordHashCompare();
        String encPass = pb.generate(password.toCharArray());

        return student.register(userName, email, encPass, phoneNumber, dataOfBirth, address, image);

//        } 
        //else if (userPhoneNo != null) {
//            return Response.status(Response.Status.CONFLICT).entity("User with the given phoneNumber already exists.").build();
//        } 
    }

    @PUT
    @Path("/updatePassword")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePassword(RegisterMaster user) {
        pb = new Pbkdf2PasswordHashImpl();
        phc = new PasswordHashCompare();
        String encPass = pb.generate(user.getPassword().toCharArray());

        try {
            student.updatePassword(user.getEmail(), encPass);
            return "Password updated successfully";
        } catch (Exception e) {
            return "SomeThing went wrong";
        }
    }

    @GET
    @Path("/getEnrollDataByRegisterId/{registerId}")
    @Produces("application/json")
    public Collection<ParticipationMaster> getParticipationByUserId(@PathParam("registerId") int registerId) {
        return student.getParticipationByUserId(registerId);
    }

    @GET
    @Path("getUserDetailsByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public RegisterMaster getUserDetailsByEmail(@PathParam("email") String email) {
        return student.getUserDetailsByEmail(email);
    }

    @PUT
    @Path("/updateUserByEmail/{email}/{userName}/{password}/{phoneNumber}/{dataOfBirth}/{address}/{image}")
    public Response updateUserDetailsByEmail(
            @PathParam("email") String email,
            @PathParam("userName") String userName,
            @PathParam("password") String password,
            @PathParam("phoneNumber") String phoneNumber,
            @PathParam("dataOfBirth") String dataOfBirth,
            @PathParam("address") String address,
            @PathParam("image") String image) {

        pb = new Pbkdf2PasswordHashImpl();
        phc = new PasswordHashCompare();
        String encPass = pb.generate(password.toCharArray());

        System.out.println(email);
        System.out.println(userName);
        System.out.println(password);
        System.out.println(phoneNumber);
        System.out.println(dataOfBirth);
        System.out.println(address);
        System.out.println(image);

        student.updateUserDetailsByEmail(email, userName, encPass, phoneNumber, dataOfBirth, address, image);
        return Response.ok("User details updated successfully").build();
    }

    @POST
    @Path("/submitInHackathon/{groupId}/{eventId}/{githubLink}/{demoLink}")
    public Response hackathonSubmission(
            @PathParam("groupId") int groupId,
            @PathParam("eventId") int eventId,
            @PathParam("githubLink") String githubLink,
            @PathParam("demoLink") String demoLink) {

        student.hackathonSubmition(groupId, eventId, githubLink, demoLink);
        return Response.ok("Hackathon submission successful").build();
    }

    @PUT
    @Path("/updateHackthonDetails/{groupId}/{eventId}/{hackathonId}/{githubLink}/{demoLink}")
    public Response hackathonSubmissionUpdate(
            @PathParam("groupId") int groupId,
            @PathParam("eventId") int eventId,
            @PathParam("hackathonId") int hackathonId,
            @PathParam("githubLink") String githubLink,
            @PathParam("demoLink") String demoLink) {

        student.hackathonSubmitionUpdate(groupId, eventId, hackathonId, githubLink, demoLink);
        return Response.ok("Hackathon submission update successful").build();
    }

    @GET
    @Path("getHackathonSubmissionByGroup/{eventId}/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHackathonSubmissionByGroup(
            @PathParam("eventId") int eventId,
            @PathParam("groupId") int groupId) {

        HackathonMaster submission = student.getHackthonSubmissionByGroupId(eventId, groupId);
        return Response.ok(submission).build();
    }

    @DELETE
    @Path("/deleteHackathonSubmission/{eventId}/{hackathonId}")
    public Response deleteHackathonSubmission(
            @PathParam("eventId") int eventId,
            @PathParam("hackathonId") int hackathonId) {

        student.deleteHackthonSubmition(eventId, hackathonId);
        return Response.ok("Hackathon submission deleted successfully").build();
    }

    @Path("/participateInEvent/{eventId}/{groupName}/{registerId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String participateInEvent(
            @PathParam("eventId") int eventId,
            @PathParam("groupName") String groupName,
            @PathParam("registerId") int registerId) {

        return student.participateInEvent(eventId, groupName, registerId);

    }

    @Path("getAllGroupsByEventId/{eventId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<GroupMaster> getAllGroupsByEventId(@PathParam("eventId") int eventId) {
        return student.getAllGroupByEventId(eventId);
    }

    @Path("/getAllParticipationsByGroupId/{groupId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ParticipationMaster> getAllParticipationsByGroupId(@PathParam("groupId") int groupId) {
        return student.getAllParticipationByGroupId(groupId);
    }

    @Path("/deleteGroupById/{groupId}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteGroupById(@PathParam("groupId") int groupId) {
        return student.deleteGroupById(groupId);
    }

    @Path("/deleteParticipationById/{participationId}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteParticipationById(@PathParam("participationId") int participationId) {
        return student.deleteParticipationById(participationId);
    }
}
