/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entity.UserData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author TakeyamaYoshiki
 */
@Stateless
public class UserDataFacade extends AbstractFacade<UserData> {

    @PersistenceContext(unitName = "ISATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDataFacade() {
        super(UserData.class);
    }
    
    public UserData getUser(String userId){
        TypedQuery<UserData> query = em.createNamedQuery("UserData.findByUserId",UserData.class).setParameter("userId", userId);
        return query.getSingleResult();
    }
    
}
