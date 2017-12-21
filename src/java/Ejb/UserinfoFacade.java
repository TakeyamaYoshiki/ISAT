/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entity.Userinfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author TakeyamaYoshiki
 */
@Stateless
public class UserinfoFacade extends AbstractFacade<Userinfo> {

    @PersistenceContext(unitName = "ISATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserinfoFacade() {
        super(Userinfo.class);
    }
    
    public Userinfo login(String userid){
        TypedQuery<Userinfo> query = em.createNamedQuery("Userinfo.findByUserid", Userinfo.class).setParameter("userid", userid);
        return query.getSingleResult();
    }
    
}
