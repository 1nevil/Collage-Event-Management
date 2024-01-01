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
 * Jersey REST client generated for REST resource:StudentRest [student]<br>
 * USAGE:
 * <pre>
 *        StudentClient client = new StudentClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hp
 */
public class StudentClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/event_management/resources";

    public StudentClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("student");
    }

    public Response hackathonSubmissionUpdate(String groupId, String eventId, String hackathonId, String githubLink, String demoLink) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateHackthonDetails/{0}/{1}/{2}/{3}/{4}", new Object[]{groupId, eventId, hackathonId, githubLink, demoLink})).request().put(null, Response.class);
    }

    public String updatePassword(Object requestEntity) throws ClientErrorException {
        return webTarget.path("updatePassword").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
    }

    public <T> T getParticipationByUserId(Class<T> responseType, String registerId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getEnrollDataByRegisterId/{0}", new Object[]{registerId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response hackathonSubmission(String groupId, String eventId, String githubLink, String demoLink) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("submitInHackathon/{0}/{1}/{2}/{3}", new Object[]{groupId, eventId, githubLink, demoLink})).request().post(null, Response.class);
    }

    public <T> T getHackathonSubmissionByGroup(Class<T> responseType, String eventId, String groupId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHackathonSubmissionByGroup/{0}/{1}", new Object[]{eventId, groupId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteHackathonSubmission(String eventId, String hackathonId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteHackathonSubmission/{0}/{1}", new Object[]{eventId, hackathonId})).request().delete(Response.class);
    }

    public <T> T getAllParticipationsByGroupId(Class<T> responseType, String groupId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllParticipationsByGroupId/{0}", new Object[]{groupId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserDetailsByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserDetailsByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateUserDetailsByEmail(String email, String userName, String password, String phoneNumber, String dataOfBirth, String address, String image) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateUserByEmail/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{email, userName, password, phoneNumber, dataOfBirth, address, image})).request().put(null, Response.class);
    }

    public String deleteGroupById(String groupId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteGroupById/{0}", new Object[]{groupId})).request().delete(String.class);
    }

    public String registerUser(String userName, String email, String password, String phoneNumber, String dataOfBirth, String address, String image) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("registerUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{userName, email, password, phoneNumber, dataOfBirth, address, image})).request().post(null, String.class);
    }

    public String deleteParticipationById(String participationId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteParticipationById/{0}", new Object[]{participationId})).request().delete(String.class);
    }

    public String participateInEvent(String eventId, String groupName, String registerId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("participateInEvent/{0}/{1}/{2}", new Object[]{eventId, groupName, registerId})).request().post(null, String.class);
    }

    public <T> T getAllGroupsByEventId(Class<T> responseType, String eventId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllGroupsByEventId/{0}", new Object[]{eventId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
