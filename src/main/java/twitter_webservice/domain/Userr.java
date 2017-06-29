package twitter_webservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Anna-May on 09/03/2017.
 */
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NamedQueries({
        @NamedQuery(name = "User.all", query = "SELECT c FROM Userr c"),
        @NamedQuery(name = "User.userByUserName", query = "SELECT c FROM Userr c WHERE c.userName = :userName"),
        @NamedQuery(name = "User.existUserName", query = "SELECT count(c.userName) FROM Userr c WHERE c.userName = :userName")
})
public class Userr implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @JsonIgnore
    private String password;
    @JsonIgnore
    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private List<Role> roles;

    private String email;
    private String name;

    @Column(unique = true)
    private String userName;

//    @JsonIgnore
//    private List<String> ownSayings;

    @JsonCreator
    public Userr(@JsonProperty("id") Long id, @JsonProperty("name") String name,  @JsonProperty("userName") String userName) {
        this.id = id;
        this.name = name;
        this.userName = userName;
    }

    public Userr() {
    }

    public Userr(String password, String email, String name, String userName) { //, List<String> ownSayings
        this.password = password;
        this.email = email;
        this.name = name;
        this.userName = userName;
        //this.ownSayings = ownSayings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public List<String> getOwnSayings() {
//        return ownSayings;
//    }
//
//    public void setOwnSayings(List<String> ownSayings) {
//        this.ownSayings = ownSayings;
//    }

    public void addRole(Role role){
        roles.add(role);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ")
                .append(this.id).append("\n")
                .append("name: ")
                .append(this.name).append("\n")
                .append("userName: ")
                .append(this.userName).append("\n");
        return stringBuilder.toString();
    }
}
