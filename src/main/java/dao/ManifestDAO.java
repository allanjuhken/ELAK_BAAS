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

    public List<Jumper> getJumpersOnLoadNr(int loadNr) {
        Session session = HibernateUtils.getCurrentSessionFromConfig();
        Transaction transaction = null;
        List<Jumper> jumpersOnLoad = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            Manifest manifest = session.get(Manifest.class, loadNr);

            if (manifest != null) {
                String jumperId = manifest.getJumperId();
                Jumper jumper = session.get(Jumper.class, jumperId);

                if (jumper != null) {
                    jumpersOnLoad.add(jumper);
                    System.out.println(jumpersOnLoad);
                } else {
                    System.out.println("Jumper not found for jumperId: " + jumperId);
                }
            } else {
                System.out.println("Manifest not found for load number: " + loadNr);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Failed to retrieve jumpers on load.");
            e.printStackTrace();
        }

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
