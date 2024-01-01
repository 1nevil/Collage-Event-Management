/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import EJBs.AdminBeanLocal;
import Entity.AwardMaster;
import Entity.CategoryMaster;
import Entity.EventMaster;
import Entity.HackathonMaster;
import Entity.RegisterMaster;
import Entity.SponserMaster;
import Entity.WinnerMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ws.rs.core.Context;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author hp
 */
@Path("admin")
@RequestScoped
public class AdminRest {

    @EJB
    AdminBeanLocal admin;
    @Context
    private UriInfo context;

    public AdminRest() {
    }

    @POST
    @Path("/createEvent/{title}/{description}/{registerId}/{startTime}/{endTime}/{address}/{pincode}/{isGallary}/{isGroup}/{startDate}/{endDate}/{categoryId}/{numberOfPeopleInGroup}/{img}")
    public Response createEvent(
            @PathParam("title") String title,
            @PathParam("description") String description,
            @PathParam("registerId") int registerId,
            @PathParam("startTime") String startTime,
            @PathParam("endTime") String endTime,
            @PathParam("address") String address,
            @PathParam("pincode") String pincode,
            @PathParam("isGallary") boolean isGallary,
            @PathParam("isGroup") boolean isGroup,
            @PathParam("startDate") String startDate,
            @PathParam("endDate") String endDate,
            @PathParam("categoryId") int categoryId,
            @PathParam("numberOfPeopleInGroup") int numberOfPeopleInGroup,
            @PathParam("img") String img) {

        admin.createEvent(title, description, registerId, startTime, endTime, address, pincode, isGallary, isGroup, startDate, endDate, categoryId, numberOfPeopleInGroup, img);

        return Response.ok("Event created successfully").build();
    }

    @PUT
    @Path("/updateEvent/{eventId}/{registerId}/{catgoryId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEventById(EventMaster e, @PathParam("eventId") int eventId, @PathParam("registerId") int registerId, @PathParam("catgoryId") int categoryId) {
        admin.updateEventById(eventId, e.getTitle(), e.getDescription(), registerId, e.getStartTime(), e.getEndTime(), e.getAddress(), e.getPincode(), e.getStartDate(), e.getEndDate(), categoryId, e.getMaxPeopleGroup(), e.getEventImg());

        return Response.ok("Event updated successfully").build();
    }

    @DELETE
    @Path("/deleteEvent/{eventId}")
    public Response deleteEventById(@PathParam("eventId") int eventId) {
        admin.deleteEventById(eventId);
        return Response.ok("Event deleted successfully").build();
    }

    @GET
    @Path("/getAllEvents")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EventMaster> getAllEvents() {
        System.out.println(admin.getAllEvents());
        return admin.getAllEvents();
    }

    @GET
    @Path("/getEventById/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventMaster getEventById(@PathParam("eventId") int eventId) {
        return admin.getEventById(eventId);
    }

    @GET
    @Path("/byStartDate/{startDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EventMaster> getEventByStartDate(@PathParam("startDate") String startDate) {
        return admin.getEventByStartDate(startDate);
    }

    @GET
    @Path("/byEndDate/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EventMaster> getEventByEndDate(@PathParam("endDate") String endDate) {
        return admin.getEventByEndDate(endDate);
    }

    @GET
    @Path("/byCategoryId/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EventMaster> getEventByCategoryId(@PathParam("categoryId") int categoryId) {
        return admin.getEventByCategoryId(categoryId);
    }

    @POST
    @Path("/createCategory/{categoryName}/{type}")
    public Response createCategory(@PathParam("categoryName") String name, @PathParam("type") String type) {
        admin.createCategory(name, type);
        return Response.ok("Category created successfully").build();
    }

    @GET
    @Path("/getCategoryById/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryMaster getCategoryById(@PathParam("categoryId") int categoryId) {
        return admin.getCategoryById(categoryId);
    }

    @DELETE
    @Path("/deleteCategory/{categoryId}")
    public Response deleteCategory(@PathParam("categoryId") int categoryId) {
        admin.deleteCategory(categoryId);
        return Response.ok("Category deleted successfully").build();
    }

    @PUT
    @Path("/updateCategory/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(CategoryMaster c, @PathParam("categoryId") int categoryId) {

        System.out.println("REST  : " + categoryId);
        System.out.println(c.getCategoryName());
        System.out.println(c.getCategoryType());

        admin.updateCategory(categoryId, c.getCategoryName(), c.getCategoryType());
        return Response.ok("Category updated successfully").build();
    }

    @GET
    @Path("/getAllCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CategoryMaster> getAllCategory() {
        return admin.getAllCategory();
    }

    @POST
    @Path("/createAward/{eventId}/{awardTitle}/{awardDescription}")
    public Response createAwardOfEvent(@PathParam("eventId") int eventId, @PathParam("awardTitle") String awardTitle, @PathParam("awardDescription") String awardDescription) {
        admin.createAwardOfEvent(eventId, awardTitle, awardDescription);
        return Response.ok("Award created successfully").build();
    }

    @PUT
    @Path("/updateAward/{awardId}/{eventId}/{awardTitle}/{awardDescription}")
    public Response updateAwardById(@PathParam("awardId") int awardId, @PathParam("eventId") int eventId, @PathParam("awardTitle") String awardTitle, @PathParam("awardDescription") String awardDescription) {
        admin.updateAwardById(awardId, eventId, awardTitle, awardDescription);
        return Response.ok("Award updated successfully").build();
    }

    @DELETE
    @Path("/deleteAward/{awardId}")
    public Response deleteAwardDetailById(@PathParam("awardId") int awardId) {
        admin.deleteAwardDetailById(awardId);
        return Response.ok("Award deleted successfully").build();
    }

    @GET
    @Path("/getallAward")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AwardMaster> getAllAwards() {
        return admin.getAllAwards();
    }

    @GET
    @Path("/getAwardByAwardId/{awardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AwardMaster getAwardByAwardId(@PathParam("awardId") int awardId) {
        return admin.getAwardByAwardId(awardId);
    }

    @GET
    @Path("/getAwardByEventId/{eventId}")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<AwardMaster> getAwardByEventId(@PathParam("eventId") int eventId) {
        return admin.getAwardByEventId(eventId);
    }

    @POST
    @Path("/createSponser/{eventId}/{sponserName}/{sponserDescription}/{Img}/{contact}")
    public Response createSponserOfEvent(
            @PathParam("eventId") int eventId,
            @PathParam("sponserName") String sponserName,
            @PathParam("sponserDescription") String sponserDescription,
            @PathParam("Img") String Img,
            @PathParam("contact") String contact) {

        admin.createSponserOfEvent(eventId, sponserName, sponserDescription, Img, contact);
        return Response.ok("Sponser created successfully").build();
    }

    @DELETE
    @Path("/deleteSponser/{sponserId}")
    public Response deleteSponserById(
            @PathParam("sponserId") int sponserId) {

        try {
            admin.deleteSponserById(sponserId);
            return Response.ok("Sponser deleted successfully").build();
        } catch (Exception e) {
            return Response.notModified().build();

        }
    }

    @PUT
    @Path("/updateSponser/{eventId}/{sponserId}/{sponserName}/{sponserDescription}/{Img}/{contact}")
    public Response updateSponserById(
            @PathParam("eventId") int eventId,
            @PathParam("sponserId") int sponserId,
            @PathParam("sponserName") String sponserName,
            @PathParam("sponserDescription") String sponserDescription,
            @PathParam("Img") String Img,
            @PathParam("contact") String contact) {

        admin.updateSponserById(eventId, sponserId, sponserName, sponserDescription, Img, contact);
        return Response.ok("Sponser updated successfully").build();
    }

    @GET
    @Path("/getAllSponser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SponserMaster> getAllSponsers() {
        return admin.getAllSponsers();
    }

    @GET
    @Path("/getSponserbyEventId/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SponserMaster> getSponserByEventId(@PathParam("eventId") int eventId) {
        return admin.getSponserByEventId(eventId);
    }

    @GET
    @Path("/getSponserbySponserId/{sponserId}")
    @Produces(MediaType.APPLICATION_JSON)
    public SponserMaster getSponserBySponserId(@PathParam("sponserId") int sponserId) {
        return admin.getSponserBySponserId(sponserId);
    }

    @POST
    @Path("/createWinner/{eventId}/{groupId}/{winnerTitle}")
    public Response createWinner(
            @PathParam("eventId") int eventId,
            @PathParam("groupId") int groupId,
            @PathParam("winnerTitle") String winnerTitle) {

        try {
            admin.createWinner(eventId, groupId, winnerTitle);
            return Response.ok("Winner created successfully").build();
        } catch (EJBException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/deleteWinner/{winnerId}")
    public Response deleteWinner(
            @PathParam("winnerId") int winnerId) {

        admin.deleteWinner(winnerId);
        return Response.ok("Winner deleted successfully").build();
    }

    @PUT
    @Path("/updateWinner/{winnerId}/{eventId}/{groupId}/{winnerTitle}")
    public Response updateWinner(
            @PathParam("winnerId") int winnerId,
            @PathParam("eventId") int eventId,
            @PathParam("groupId") int groupId,
            @PathParam("winnerTitle") String winnerTitle) {

        admin.updateWinner(winnerId, eventId, groupId, winnerTitle);
        return Response.ok("Winner updated successfully").build();
    }

    @GET
    @Path("/getWinnerbyWinnerId/{winnerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public WinnerMaster getWinnerByWinnerId(@PathParam("winnerId") int winnerId) {
        return admin.getWinnerByWinnerId(winnerId);
    }

    @GET
    @Path("/getAllWinner")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<WinnerMaster> getAllWinner() {
        return admin.getAllWinner();
    }

    @GET
    @Path("/getAllWinnerByEventId/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<WinnerMaster> getAllWinnerByEventId(@PathParam("eventId") int eventId) {
        return admin.getWinnerByEventId(eventId);
    }

    @GET
    @Path("/hackathonDetails/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<HackathonMaster> gethackathonDetailsByEventId(@PathParam("eventId") int eventId) {
        return admin.gethackathonDetailsByEventId(eventId);
    }

    @GET
    @Path("/allRegisterUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RegisterMaster> getAllRegisterUserDetails() {
        return admin.getAllRegisterUserDetails();
    }

    @GET
    @Path("/allStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RegisterMaster> getAllStudents() {
        return admin.getAllStudents();
    }

    @GET
    @Path("/allAdmins")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RegisterMaster> getAllAdmins() {
        return admin.getAllAdmins();
    }

    @DELETE
    @Path("/removeUser/{registerId}")
    public Response removeUser(@PathParam("registerId") int registerId) {
        admin.removeUser(registerId);
        return Response.ok("User removed successfully").build();
    }

    @PUT
    @Path("/updateRole/{registerId}")
    public Response updateRole(
            @PathParam("registerId") int registerId) {
        System.out.print("In rest ap" + registerId);
        admin.updateRole(registerId);
        return Response.ok("User role updated successfully").build();
    }

    @GET
    @Path("/eventsCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int countTotalEvents() {
        return admin.countTotalEvents();
    }

    @GET
    @Path("/categoriesCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int countTotalCategories() {
        return admin.countTotalCategories();
    }

    @GET
    @Path("/usersCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int countTotalUsers() {
        return admin.countTotalUsers();
    }

    @GET
    @Path("/sponsorsCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int countTotalSponsors() {
        return admin.countTotalSponsors();
    }
}
