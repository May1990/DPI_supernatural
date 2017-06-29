package twitter_webservice.doa;

import twitter_webservice.domain.Userr;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Anna-May on 09/03/2017.
 */
@Stateless
@Default
public class UserrDAO_impl implements UsserDAO {

    @PersistenceContext(unitName = "DefaultPU")
    EntityManager em;

    public UserrDAO_impl() {
    }

    public Userr create(Userr user) {
        em.persist(user);
        return user;
    }

    public void edit(Userr user) {
        try {
            em.merge(user);
        }catch (Exception e){

        }

    }

    public List<Userr> findAll() {
        Query query = em.createNamedQuery("User.all", Userr.class);
        return (List<Userr>) query.getResultList();

//        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(Userr.class));
//        return em.createQuery(cq).getResultList();
    }

    public Userr findByUserName(String userName) {
        Userr user = null;
        List<Userr> users = em.createNamedQuery("User.userByUserName").setParameter("userName", userName).getResultList();
        if(users.size() > 0){
            user = users.get(0);
        }
        return user;
    }

    public void remove(Userr user) {
        em.remove(em.merge(user));
    }

    public boolean doesUsernameExist(String tempUserName) {
        Object count = em.createNamedQuery("User.existUserName").setParameter("userName", tempUserName).getSingleResult();
        boolean exist = false;
        if(Integer.parseInt(count.toString()) > 0){
            exist = true;
        }

        return exist;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
