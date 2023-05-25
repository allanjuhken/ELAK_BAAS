package dao;

import model.Jumper;
import model.Manifest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ManifestDAO {

    public List<Jumper> getJumpersOnLoadNr(int loadNr){

        Session session = HibernateUtils.getCurrentSessionFromConfig();
        Transaction trn = session.beginTransaction();
        Manifest manifest = session.load(Manifest.class,loadNr);
        List<Jumper> jumpersOnLoad = manifest.getJumper();
        System.out.println(jumpersOnLoad);
        trn.commit();
        return jumpersOnLoad;
    }

//    public List<String> getPersonalCodes() {
//        List<String> personalCodes = new ArrayList<>();
//
//        if (jumper != null) {
//            EntityManager entityManager = Persistence.createEntityManagerFactory("your-persistence-unit-name").createEntityManager();
//            entityManager.getTransaction().begin();
//
//            Query query = entityManager.createQuery("SELECT j.personalCode FROM Jumper j ORDER BY RAND()");
//            query.setMaxResults(10);
//            List<String> randomPersonalCodes = query.getResultList();
//
//            personalCodes.addAll(randomPersonalCodes);
//
//            entityManager.getTransaction().commit();
//            entityManager.close();
//        }
//
//        return personalCodes;
//    }
}
