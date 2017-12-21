package Beans;

import Ejb.UserDataFacade;
import Ejb.UserinfoFacade;
import Entity.UserData;
import Entity.Userinfo;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author TakeyamaYoshiki
 */
@Named(value = "lb")
@RequestScoped
public class LoginBean {
    private String id;
    private String password;
    private boolean flag;
    private List<Userinfo> list;
    @EJB
    UserDataFacade udf;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }  

    public List<Userinfo> getList() {
        return list;
    }

    public void setList(List<Userinfo> list) {
        this.list = list;
    }
    
    public String find(){
        
        Userinfo user;
        user = uf.login(id);
        System.out.println("name = " + user.getName());

        return null;
    }
    
    public String auth(){
        UserData user;
        user = udf.getUser(id);
        if(user.getPassword().equals(password)){
            return "schedule.xhtml";
        }else{
            return "error.xhtml";
        }
    }
}