/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJBs;

import Entity.GroupMaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author hp
 */
@Stateless
public class validate {

    @PersistenceContext(name = "event_unit")
    EntityManager em;

    public boolean isGroupNameExists(String groupName) {
        System.out.println(groupName);

        TypedQuery<Long> query = em.createQuery("SELECT COUNT(g) FROM GroupMaster g WHERE g.groupName = :groupName", Long.class);
        query.setParameter("groupName", groupName);

        return query.getSingleResult() > 0;
    }

    public boolean isUsernameExists(String username) {
        System.out.println(username);

        TypedQuery<Long> query = em.createQuery("SELECT COUNT(r) FROM RegisterMaster r WHERE r.username = :username", Long.class);
        query.setParameter("username", username);
        
        
        return query.getSingleResult() > 0;
    }

    public boolean isEmailExists(String email) {
        System.out.println(email);

        TypedQuery<Long> query = em.createQuery("SELECT COUNT(r) FROM RegisterMaster r WHERE r.email = :email", Long.class);
        query.setParameter("email", email);

        return query.getSingleResult() > 0;
    }

    public boolean isPhoneNoExists(String phoneNo) {
        System.out.println(phoneNo);

        TypedQuery<Long> query = em.createQuery("SELECT COUNT(r) FROM RegisterMaster r WHERE r.phoneNo = :phoneNo", Long.class);
        query.setParameter("phoneNo", phoneNo);

        return query.getSingleResult() > 0;
    }
}
