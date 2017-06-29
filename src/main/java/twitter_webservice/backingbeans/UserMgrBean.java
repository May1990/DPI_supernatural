package twitter_webservice.backingbeans;

import twitter_webservice.domain.Userr;
import twitter_webservice.service.UserMgr;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Anna-May on 08/04/2017.
 */
@Named("userMgr")
@SessionScoped
public class UserMgrBean implements Serializable {
    @Inject
    private UserMgr userMgr;

    private Userr selectedUser;

    private List<Userr> following;
    private List<Userr> followers;
    private List<Userr> users;

    private int countFollowing;
    private int countFollower;

    private String usernameExist;
    private String tempUserName;
    private String name;
    private String web;
    private String bio;
    private String pictureUrl;

    //region getterSetter
    public UserMgr getUserMgr() {
        return userMgr;
    }

    public void setUserMgr(UserMgr userMgr) {
        this.userMgr = userMgr;
    }

    public Userr getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Userr selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Userr> getFollowing() {
        return following;
    }

    public void setFollowing(List<Userr> following) {
        this.following = following;
    }

    public List<Userr> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Userr> followers) {
        this.followers = followers;
    }

    public List<Userr> getUsers() {
        return users;
    }

    public void setUsers(List<Userr> users) {
        this.users = users;
    }

    public int getCountFollowing() {
        return countFollowing;
    }

    public void setCountFollowing(int countFollowing) {
        this.countFollowing = countFollowing;
    }

    public int getCountFollower() {
        return countFollower;
    }

    public void setCountFollower(int countFollower) {
        this.countFollower = countFollower;
    }

    public String getUsernameExist() {
        return usernameExist;
    }

    public void setUsernameExist(String usernameExist) {
        this.usernameExist = usernameExist;
    }

    public String getTempUserName() {
        return tempUserName;
    }

    public void setTempUserName(String tempUserName) {
        this.tempUserName = tempUserName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    //endregion

    public void doesUsernameExist(){
        if(userMgr.doesUsernameExist(tempUserName)){
            usernameExist = "Username bestaat al!";
        }else{
            usernameExist = "";
        }
    }

    public void adjustUser(){
        selectedUser.setName(name);
        selectedUser.setUserName(tempUserName);

        userMgr.adjustUser(selectedUser);
    }
}
