package twitter_webservice.backingbeans;

import twitter_webservice.domain.Userr;
import twitter_webservice.service.UserMgr;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Anna-May on 09/04/2017.
 */
@Named("registerLogIn")
@SessionScoped
public class RegisterLogInBean implements Serializable {
    // log in
    private String username;
    private String password;

    private Userr logInUser;

    @Inject
    private UserMgr userMgr;

    //region getterSetter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Userr getLogInUser() {
        return logInUser;
    }

    public void setLogInUser(Userr logInUser) {
        this.logInUser = logInUser;
    }

    public UserMgr getUserMgr() {
        return userMgr;
    }

    public void setUserMgr(UserMgr userMgr) {
        this.userMgr = userMgr;
    }


    //endregion

    public void logInUserByUserName(){
        try {
            if(username!= ""){
                logInUser = userMgr.getUserByUserName(username);
                if(logInUser == null){
                    this.redirectError();
                }else{
                    this.redirectStart();
                }
            }else{
                this.redirectError();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirect() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("login.xhtml");
    }

    public void redirectStart() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("index.xhtml");
    }

    public void redirectError() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("login_error.xhtml");
    }
}
