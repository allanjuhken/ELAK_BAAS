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


    // TODO:   make to method first, code adds load to manifest, increases jump.nr ++1 in jumper_jumps updates all existing values
//    Transaction trn = session.beginTransaction(); // throws double value entry for table jumper_jumps, col- jumper_id
//
//        String[] jumperIds = {"pro","sal", "elo", "kka","msa", "awi", "ska", "jam", "asn"};
//
//        for (int i = 0; i < jumperIds.length; i++) {
//            Manifest manifest = new Manifest();
//            manifest.setLoadNr(3);
//            manifest.setLoadDate(LocalDate.now());
//            manifest.setJumperId(jumperIds[i]);
//            manifest.setPlaneID("ES-ECG");
//            manifest.setLoadMaster("jam");
//
//            session.save(manifest);
//
//            Jumper jumper = session.get(Jumper.class, jumperIds[i]);
//
//            // Retrieve the maximum jump number for the current jumper_id
//            Query<Integer> maxJumpNrQuery = session.createQuery("SELECT MAX(jump.id.jumpNr) FROM JumperJumps jump WHERE jump.id.jumperId = :jumperId", Integer.class);
//            maxJumpNrQuery.setParameter("jumperId", jumperIds[i]);
//            Integer maxJumpNr = maxJumpNrQuery.uniqueResult();
//            int jumpNr = (maxJumpNr != null) ? maxJumpNr + 1 : 1; // Increment the maximum jump number by 1 or start from 1 if no previous jumps
//
//            JumperJumpsId jumperJumpsId = new JumperJumpsId(jumperIds[i], jumpNr);
//            JumperJumps jumperJumps = new JumperJumps(jumperJumpsId, jumper, "ES-ECG", LocalDate.now());
//
//            //session.merge(jumperJumps);
//            try {
//                session.saveOrUpdate(jumperJumps);
//            } catch (ConstraintViolationException e) {
//                session.update(jumperJumps);
//            }
//        }
//
//        trn.commit();
    

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
