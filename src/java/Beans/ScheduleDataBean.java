/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Ejb.ScheduleFacade;
import Entity.Schedule;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author TakeyamaYoshiki
 */
@Named(value = "scheduleDataBean")
@SessionScoped
public class ScheduleDataBean implements Serializable {

    private ScheduleModel eventModel;
    
    @EJB
    ScheduleFacade sf;
    
    @PostConstruct
    public void init() {
        Schedule sch;
        sch = sf.search("テスト");
        eventModel = new DefaultScheduleModel();
        eventModel.addEvent(new DefaultScheduleEvent(sch.getTitle(), sch.getSDate(), sch.getEDate()));
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }
    
    
}
