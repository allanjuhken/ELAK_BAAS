package dao;

import model.Jumper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class JumperDAO {

    public ArrayList<String> getPersonalCodes() {
        Session session = HibernateUtils.getCurrentSessionFromConfig();
        session.beginTransaction();

        Query<String> query = session.createQuery("SELECT j.personal_code FROM Jumper j", String.class);
        List<String> personalCodes = query.list();

        session.getTransaction().commit();

        return new ArrayList<>(personalCodes);
    }

    public void updateJumperTotalJumps(String jumperId) {
        Session session = HibernateUtils.getCurrentSessionFromConfig();
        session.beginTransaction();
        // Retrieve the maximum jump number for the given jumper_id
        Query<Integer> maxJumpNrQuery = session.createQuery("SELECT MAX(jump.id.jumpNr) FROM JumperJumps jump WHERE jump.id.jumperId = :jumperId", Integer.class);
        maxJumpNrQuery.setParameter("jumperId", jumperId);
        Integer maxJumpNr = maxJumpNrQuery.uniqueResult();

        // Update the total_jumps field in the Jumper entity
        Jumper jumper = session.get(Jumper.class, jumperId);
        if (jumper != null && maxJumpNr != null) {
            jumper.setTotalJumpNr(maxJumpNr);
            session.update(jumper);
        }
    }

}
