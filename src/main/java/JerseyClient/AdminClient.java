/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package JerseyClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:AdminRest [admin]<br>
 * USAGE:
 * <pre>
 *        AdminClient client = new AdminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hp
 */
public class AdminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/event_management/resources";

    public AdminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("admin");
    }

    public Response updateWinner(String winnerId, String eventId, String groupId, String winnerTitle) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateWinner/{0}/{1}/{2}/{3}", new Object[]{winnerId, eventId, groupId, winnerTitle})).request().put(null, Response.class);
    }

    public <T> T getEventByCategoryId(Class<T> responseType, String categoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("byCategoryId/{0}", new Object[]{categoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateRole(String registerId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateRole/{0}", new Object[]{registerId})).request().put(null, Response.class);
    }

    public Response updateSponserById(String eventId, String sponserId, String sponserName, String sponserDescription, String Img, String contact) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateSponser/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{eventId, sponserId, sponserName, sponserDescription, Img, contact})).request().put(null, Response.class);
    }

    public <T> T countTotalUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("usersCount");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateCategory(Object requestEntity, String categoryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateCategory/{0}", new Object[]{categoryId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getAllEvents(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllEvents");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getEventById(Class<T> responseType, String eventId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getEventById/{0}", new Object[]{eventId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getEventByStartDate(Class<T> responseType, String startDate) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("byStartDate/{0}", new Object[]{startDate}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response removeUser(String registerId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("removeUser/{0}", new Object[]{registerId})).request().delete(Response.class);
    }

    public <T> T getAllAdmins(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allAdmins");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countTotalCategories(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("categoriesCount");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteEventById(String eventId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteEvent/{0}", new Object[]{eventId})).request().delete(Response.class);
    }

    public <T> T countTotalEvents(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("eventsCount");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response createEvent(String title, String description, String registerId, String startTime, String endTime, String address, String pincode, String isGallary, String isGroup, String startDate, String endDate, String categoryId, String numberOfPeopleInGroup, String img) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createEvent/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{title, description, registerId, startTime, endTime, address, pincode, isGallary, isGroup, startDate, endDate, categoryId, numberOfPeopleInGroup, img})).request().post(null, Response.class);
    }

    public <T> T getEventByEndDate(Class<T> responseType, String endDate) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("byEndDate/{0}", new Object[]{endDate}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response createCategory(String categoryName, String type) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createCategory/{0}/{1}", new Object[]{categoryName, type})).request().post(null, Response.class);
    }

    public <T> T getAllSponsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllSponser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response createWinner(String eventId, String groupId, String winnerTitle) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createWinner/{0}/{1}/{2}", new Object[]{eventId, groupId, winnerTitle})).request().post(null, Response.class);
    }

    public Response updateAwardById(String awardId, String eventId, String awardTitle, String awardDescription) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateAward/{0}/{1}/{2}/{3}", new Object[]{awardId, eventId, awardTitle, awardDescription})).request().put(null, Response.class);
    }

    public <T> T getWinnerByWinnerId(Class<T> responseType, String winnerId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getWinnerbyWinnerId/{0}", new Object[]{winnerId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRegisterUserDetails(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allRegisterUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAwardByAwardId(Class<T> responseType, String awardId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAwardByAwardId/{0}", new Object[]{awardId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllAwards(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallAward");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getSponserByEventId(Class<T> responseType, String eventId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getSponserbyEventId/{0}", new Object[]{eventId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getSponserBySponserId(Class<T> responseType, String sponserId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getSponserbySponserId/{0}", new Object[]{sponserId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteWinner(String winnerId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteWinner/{0}", new Object[]{winnerId})).request().delete(Response.class);
    }

    public Response deleteSponserById(String sponserId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteSponser/{0}", new Object[]{sponserId})).request().delete(Response.class);
    }

    public <T> T getAllWinner(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllWinner");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllStudents(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allStudents");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response createSponserOfEvent(String eventId, String sponserName, String sponserDescription, String Img, String contact) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createSponser/{0}/{1}/{2}/{3}/{4}", new Object[]{eventId, sponserName, sponserDescription, Img, contact})).request().post(null, Response.class);
    }

    public <T> T countTotalSponsors(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("sponsorsCount");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteCategory(String categoryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteCategory/{0}", new Object[]{categoryId})).request().delete(Response.class);
    }

    public Response deleteAwardDetailById(String awardId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteAward/{0}", new Object[]{awardId})).request().delete(Response.class);
    }

    public Response updateEventById(Object requestEntity, String eventId, String registerId, String catgoryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateEvent/{0}/{1}/{2}", new Object[]{eventId, registerId, catgoryId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getCategoryById(Class<T> responseType, String categoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryById/{0}", new Object[]{categoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAwardByEventId(Class<T> responseType, String eventId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAwardByEventId/{0}", new Object[]{eventId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response createAwardOfEvent(String eventId, String awardTitle, String awardDescription) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createAward/{0}/{1}/{2}", new Object[]{eventId, awardTitle, awardDescription})).request().post(null, Response.class);
    }

    public <T> T gethackathonDetailsByEventId(Class<T> responseType, String eventId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("hackathonDetails/{0}", new Object[]{eventId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllWinnerByEventId(Class<T> responseType, String eventId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllWinnerByEventId/{0}", new Object[]{eventId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
