package twitter_webservice.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Anna-May on 29/06/2017.
 */
@Singleton
@Startup
public class FirstData_2 {
    private EntityManager em;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DefaultPU");

    private TestData_2 testData;

    @PostConstruct
    public void init(){
        testData = new TestData_2();
        em = emf.createEntityManager();

        testData.fillTestDataTweet();
        em.persist(testData.getRoleAngel());
        em.persist(testData.getRoleDemon());
        em.persist(testData.getRoleHunter());
        em.persist(testData.getUserOne());
        em.persist(testData.getUserTwo());
        em.persist(testData.getUserThree());
        em.persist(testData.getUserFour());
    }
}
