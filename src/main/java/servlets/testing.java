/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import EJBs.AdminBeanLocal;
import Entity.EventMaster;
import JerseyClient.AdminClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "testing", urlPatterns = {"/testing"})
public class testing extends HttpServlet {

    @EJB
    AdminBeanLocal abl;
//    @EJB
//    StudentLocal stl;
    
    @Inject AdminClient ac;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testing</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet testing at Hello </h1>");
            
            
             out.println(abl.countTotalEvents());
            
            // Event Operations
//             abl.createEvent("test4", "test4", 1, "12:30", "6:30", "test", "1234545", true, true, "1/2/2022", "2/2/2002", 1, 20, 5, "img");
//             abl.deleteEventById(2);
//             abl.updateEventById(3, "test3", "test3", 1, "test3", "test3", "test3", "1234545", true, true, "test", "test", 1, 10, 100, "img");
//            Collection<EventMaster> events = (Collection<EventMaster>) abl.getAllEvents();
//            for (EventMaster event : events) {
//                System.out.println(event.getEventId());
//                System.out.println(event.getCategoryId());
//                System.out.println(event.getRegisterId());
//
//            }
            // System.out.println(events);
//             EventMaster event = abl.getEventById(3);
//             System.out.println(event.getTitle());
//  Collection<EventMaster> events = abl.getEventByRegisterId(1);
//             for (EventMaster event : events) {
//                System.out.println(event.getEventId());
//             }
//             System.out.println(abl.getEventByStartDate("1/2/2022"));
//             System.out.println(abl.getEventByEndDate("2/2/2002"));
//=======================================================================================================
//             User Registration
//             stl.register("user4", "user4@gmail.com", "123123", "1234567890", "5/3/2002", "test", "test", 1 );

//            Collection<RegisterMaster> students = abl.getAllStudents();
//            for (RegisterMaster student : students) {
//                System.out.println(student.getUsername());
//            }
//            Collection<RegisterMaster> admins = abl.getAllAdmins();
//            for (RegisterMaster admin : admins) {
//                System.out.println(admin.getUsername());
//            }
//       abl.removeUser(4);
//abl.updateRole(1,1 );
//=======================================================================================================
            // Category Operations
            // abl.createCategory("test", "test");
            // abl.createCategory("test2", "test2");
            // abl.updateCategory(5, "test5", "test5");
            // Collection<CategoryMaster> categories = abl.getAllCategory();
            // for (CategoryMaster cat : categories) {
            //    System.out.println(cat.getCategoryName());
            //    System.out.println(cat.getCategoryType());
            // }
//=======================================================================================================
            // Award Table Operations
            // abl.createAwardOfEvent(2, "First Winner", "Get 1000 rs");
            // abl.createAwardOfEvent(2, "Second Winner", "Get 500 rs");
            // abl.createAwardOfEvent(2, "Third Winner", "Get 350 rs");
            // abl.deleteAwardDetailById(2, 1);
            // abl.deleteAwardDetailById(2, 2);
            // abl.deleteAwardDetailById(2, 3);
            // abl.updateAwardById(4, 2, "no data", "nothing");
            // Collection<AwardMaster> AwardByEvents = abl.getAwardByEventId(2);
            // for (AwardMaster awd : AwardByEvents) {
            //    System.out.println(awd.getAwardTitle());
            //    System.out.println(awd.getAwardDescription());
            // }
//=======================================================================================================
//SponserMaster operation
//abl.createSponserOfEvent(3,"Meet Mistry","Logic wind ceo","yo-yo","@logicwind");
//abl.updateSponserById(3, 3, "meet yo", "Logic wind ceo", "yo-yo-2", "@meetYo");
//abl.deleteSponserById(3, 3);
//            Collection<SponserMaster> EventSponsers = abl.getSponserByEventId(3);
//            for (SponserMaster sponser : EventSponsers) {
//                System.out.println(sponser.getSponserContact());
//                System.out.println(sponser.getSponserDescription());
//                System.out.println(sponser.getSponserImg());
//                System.out.println(sponser.getSponserName());}
//            Collection<SponserMaster> allSponsers = abl.getAllSponsers();
//            for (SponserMaster sponser : allSponsers) {
//                System.out.println(sponser.getSponserContact());
//                System.out.println(sponser.getSponserDescription());
//                System.out.println(sponser.getSponserImg());
//                System.out.println(sponser.getSponserName());
//            }
//            SponserMaster sponser = abl.getSponserBySponserId(4);
//            System.out.println(sponser.getSponserContact());
//            System.out.println(sponser.getSponserDescription());
//            System.out.println(sponser.getSponserImg());
//            System.out.println(sponser.getSponserName());
//=================================================================
//Winner table
            abl.createWinner(4, 3, "winnerTitle");
//=================================================================
//participant in event
//System.out.println("servlets :"+stl.participateInEvent(5, "testing 2", 2));
//=================================================================
// Group master
//            System.out.println(stl.deleteGroupById(1));
//            Collection<GroupMaster> groupsByEvents = stl.getAllGroupByEventId(4);
////            System.out.println(stl.deleteParticipationById(5));
//            if (groupsByEvents.isEmpty()) {
//                System.out.println("Their is no group in this events");
//            } else {
//                for (GroupMaster group : groupsByEvents) {
//                    System.out.println(group.getGroupId());
//                    System.out.println(group.getGroupName());
//                    System.out.println(group.getEventId().getTitle());
//
//                    Collection<ParticipationMaster> participations = stl.getAllParticipationByGroupId(group.getGroupId());
//
//                    for (ParticipationMaster participant : participations) {
//                        System.out.println(participant.getRegisterId().getUsername());
//                    }
//                }
//            }
//=====================================================================
//Hackthon master
//            stl.hackathonSubmition(11, 5, "www.github.com    ","www.demolink.com");
            //stl.hackathonSubmitionUpdate(3, 4,1 , "www.github.com", "helloo.com");
            //stl.deleteHackthonSubmition(4, 1);
//stl.getHackthonSubmissionByGroupId(5,10);
//
//            for (HackathonMaster h : hacks) {
//                System.out.println(h.getLiveLink());
//                System.out.println(h.getGithubLink());
//            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
//        ac.updateEventById("14", "title", "description", "1", "12-2-23", "13-2-23", "address", "123456", "true", "true","12-2-23","12-2-23", "1", "2", "img");
      }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
