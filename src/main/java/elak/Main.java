package elak;

import dao.ManifestDAO;
import model.Jumper;
import model.Manifest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getCurrentSessionFromConfig();

//        Jumper jumper = new Jumper();
//        jumper.setName("Allan Juhken");
//        jumper.setPersonal_code("AJU");
//        jumper.setEmail("alnj@mail.ee");
//        jumper.setPhone("53467899");
//        jumper.setLicence("D");
//        jumper.setBalance(500);
//        jumper.setReservePractice(LocalDate.now());
//        jumper.setHealthDeclaration(LocalDate.now());
//        Transaction trn = session.beginTransaction();
//        session.save(jumper);
//        trn.commit();

//        Transaction trn = session.beginTransaction();
//        Jumper jumper = session.load(Jumper.class,"aju"); // gives jumper by personal_code / not case-sensitive
//        System.out.println(jumper);
//        trn.commit();

//        Transaction trn = session.beginTransaction();
//        List<Jumper> jumpers = session.createCriteria(Jumper.class).list();
//        trn.commit();
//        System.out.println(jumpers);

//        Manifest manifest = new Manifest();
//        manifest.setLoadNr(1);
//        manifest.setLoadDate(LocalDate.now());
//        manifest.setPlaneID("ES-ECG");
//        manifest.setLoadMaster("jam");
//        manifest.setJumpers();
//        Transaction trn = session.beginTransaction();
//        session.save(manifest);
//        trn.commit();

        ManifestDAO manifestDAO = new ManifestDAO();


    }
}
