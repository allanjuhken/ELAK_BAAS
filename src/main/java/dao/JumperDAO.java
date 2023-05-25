package dao;

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
        session.close();

        return new ArrayList<>(personalCodes);
    }
}
