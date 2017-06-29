package twitter_webservice.service;

import twitter_webservice.domain.Role;
import twitter_webservice.domain.Userr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna-May on 05/04/2017.
 */
public class TestData_2 {
    private Role roleHunter;
    private Role roleDemon;
    private Role roleAngel;

    private Userr userOne;
    private Userr userTwo;
    private Userr userThree;
    private Userr userFour;

    public TestData_2() {
    }

    public Userr getUserOne() {
        return userOne;
    }

    public Userr getUserTwo() {
        return userTwo;
    }

    public Userr getUserThree() {
        return userThree;
    }

    public Userr getUserFour() {
        return userFour;
    }

    public Role getRoleHunter() {
        return roleHunter;
    }

    public Role getRoleDemon() {
        return roleDemon;
    }

    public Role getRoleAngel() {
        return roleAngel;
    }


    public String generateSHApassword(String password){
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
    }

    public void fillTestDataTweet(){
        userOne = new Userr(
                generateSHApassword("test"),
                "josbergman@gmail.com",
                "Jos Bergman",
                "jos1940"
        );

        userTwo = new Userr(
                generateSHApassword("test"),
                "florisvanrosemondt@gmail.com",
                "Floris van Rosemondt",
                "floris1944"
        );

        userThree = new Userr(
                generateSHApassword("test"),
                "rutgerhauer@gmail.com",
                "Rutger Hauer",
                "Rutger1944"
        );

        userFour = new Userr(
                generateSHApassword("test"),
                "fakiresindala@gmail.com",
                "Fakire Sindala",
                "sindala1940"
        );
        roleHunter = new Role("hunter");
        roleHunter.addUser(userOne);
        roleHunter.addUser(userFour);

        roleAngel = new Role("angel");
        roleAngel.addUser(userTwo);

        roleDemon = new Role("demon");
        roleAngel.addUser(userThree);

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleHunter);
        userOne.setRoles(roles);
        userFour.setRoles(roles);

        roles = new ArrayList<Role>();
        roles.add(roleAngel);
        userTwo.setRoles(roles);

        roles = new ArrayList<Role>();
        roles.add(roleDemon);
        userThree.setRoles(roles);
    }
}
