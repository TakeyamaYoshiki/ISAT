/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entity.SecretQuestion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TakeyamaYoshiki
 */
@Stateless
public class SecretQuestionFacade extends AbstractFacade<SecretQuestion> {

    @PersistenceContext(unitName = "ISATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecretQuestionFacade() {
        super(SecretQuestion.class);
    }
    
}
