package elak;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtils.getCurrentSessionFromConfig();
            Scanner scanner = new Scanner(System.in);
            char again = 'y';
            while (again == 'y') {
                System.out.println("Choose one option (a,b,r,d)");
                System.out.println("a - adding a new jumper");
                System.out.println("b - adding jumpers on load");
                System.out.println("c - reading jumpers data");
//                System.out.println("d - deleting jumper");

                char action = scanner.nextLine().charAt(0);

                if (action == 'a') {

                    insertJumperData(session);

                } else if (action == 'b') {

                    addNewLoad(session);

                } else if (action == 'c') {

                    readJumperData(session);

//                } else if (action == 'd') {
//
//                    deleteJumperData(session);

                } else {
                    System.out.println("Invalid input!");
                }

                System.out.println("Do you want to continue? y/n");
                again = scanner.nextLine().charAt(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    private static void insertJumperData(Session session) {
        try {
            session.beginTransaction();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter personal code: ");
            String personalCode = scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter licence: ");
            String licence = scanner.nextLine();

            System.out.print("Enter account balance: ");
            int balance = scanner.nextInt();

            System.out.print("Enter reserve practice date (yyyy-MM-dd): ");
            LocalDate reservePractice = LocalDate.parse(scanner.next());

            System.out.print("Enter health declaration date (yyyy-MM-dd): ");
            LocalDate healthDeclaration = LocalDate.parse(scanner.next());

            System.out.print("Enter total jump number: ");
            int totalJumpNr = scanner.nextInt();

            Jumper jumper = new Jumper();
            jumper.setPersonal_code(personalCode);
            jumper.setName(name);
            jumper.setEmail(email);
            jumper.setPhone(phone);
            jumper.setLicence(licence);
            jumper.setBalance(balance);
            jumper.setReservePractice(reservePractice);
            jumper.setHealthDeclaration(healthDeclaration);
            jumper.setTotalJumpNr(totalJumpNr);

            session.save(jumper);
            session.getTransaction().commit();
            System.out.println("New Jumper record saved successfully!");
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Failed to save Jumper record.");
            e.printStackTrace();
        }
    }

    private static void addNewLoad(Session session) {
        try {
            session.beginTransaction();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter comma-separated user IDs: ");
            String jumperIdsInput = scanner.nextLine();
            String[] jumperIds = jumperIdsInput.split(",");

            System.out.print("Enter load number: ");
            int loadNr = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter load date (yyyy-MM-dd): ");
            LocalDate loadDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter aircraft ID: ");
            String aircraftId = scanner.nextLine();

            System.out.print("Enter load master: ");
            String loadMaster = scanner.nextLine();

            for (String jumperId : jumperIds) {
                Manifest newManifest = new Manifest();
                newManifest.setLoadNr(loadNr);
                newManifest.setLoadDate(loadDate);
                newManifest.setJumperId(jumperId.trim());
                newManifest.setPlaneID(aircraftId);
                newManifest.setLoadMaster(loadMaster);

                session.save(newManifest);

                Jumper jumper = session.get(Jumper.class, jumperId.trim());
                JumperJumpsId jumperJumpsId = new JumperJumpsId(jumperId.trim(), 1);
                JumperJumps jumperJumps = new JumperJumps(jumperJumpsId, jumper, aircraftId, loadDate);

                session.save(jumperJumps);
            }

            session.getTransaction().commit();
            System.out.println("New load added successfully!");
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Failed to add new load.");
            e.printStackTrace();
        }
    }

    private static void readJumperData(Session session) {

        try {
            session.beginTransaction();
            Query<Jumper> query = session.createQuery("FROM Jumper", Jumper.class);
            List<Jumper> jumpers = query.list();

            for (Jumper jumper : jumpers) {
                System.out.println(jumper);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Failed to read jumper data.");
            e.printStackTrace();
        }
    }

//    // TODO: 29.05.2023 java.lang.IllegalStateException: Session/EntityManager is closed
//    private static void deleteJumperData(Session session) {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the personal code of the jumper you want to delete: ");
//        String personalCode = scanner.nextLine();
//
//        try {
//            session.beginTransaction();
//            Query query = session.createQuery("DELETE FROM Jumper WHERE personal_code = :personalCode");
//            query.setParameter("personalCode", personalCode);
//            //int rowCount = query.executeUpdate();
//            session.getTransaction().commit();
//
//            //System.out.println("Deleted " + rowCount + " row(s) from the jumper table.");
//        } catch (Exception e) {
//            session.getTransaction().rollback();
//            System.out.println("Failed to delete data from the jumper table.");
//            e.printStackTrace();
//        }
//    }


}


//        Jumper jumper = new Jumper();
//        jumper.setName("Mellu Saarmets");
//        jumper.setPersonal_code("MSA");
//        jumper.setEmail("skygod@mail.eu");
//        jumper.setPhone("55216394");
//        jumper.setLicence("D");
//        jumper.setBalance(2000);
//        jumper.setReservePractice(LocalDate.now());
//        jumper.setHealthDeclaration(LocalDate.now());
//        jumper.setTotalJumpNr(1500);
//        Transaction trn = session.beginTransaction();
//        session.save(jumper);
//        trn.commit();

//        Transaction trn = session.beginTransaction();
//        Jumper jumper = session.load(Jumper.class,"msa"); // gives jumper by personal_code / not case-sensitive
//        System.out.println(jumper);
//        trn.commit();


//        Transaction trn = session.beginTransaction(); // works
//        List<Jumper> jumpers = session.createCriteria(Jumper.class).list();
//        trn.commit();
//        for (Jumper jumper : jumpers) {
//            System.out.println(jumper);
//        }


//        Manifest manifest = new Manifest(); // works
//        manifest.setLoadNr(1);
//        manifest.setLoadDate(LocalDate.now());
//        manifest.setJumperId("pro");
//        manifest.setPlaneID("ES-ECG");
//        manifest.setLoadMaster("jam");
//
//        Transaction trn = session.beginTransaction();
//        session.save(manifest);
//        trn.commit();


//        Transaction trn = session.beginTransaction(); / works
//
//        Aircraft aircraft = new Aircraft();
//        aircraft.setPlaneId("OH_SIS");
//        aircraft.setCapacity(16);
//
//        session.save(aircraft);
//        trn.commit();


//        Transaction trn = session.beginTransaction();// works
//
//        String[] jumperIds = {"sal", "elo", "kka","msa", "awi", "ska", "jam", "asn"}; // Array of different JumperId values


//        for (int i = 0; i < jumperIds.length; i++) {
//            Manifest manifest = new Manifest();
//            manifest.setLoadNr(1);
//            manifest.setLoadDate(LocalDate.now());
//            manifest.setJumperId(jumperIds[i]); // Set different JumperId value from the array
//            manifest.setPlaneID("ES-ECG");
//            manifest.setLoadMaster("jam");
//
//            session.save(manifest);
//        }
//        trn.commit();


//        Transaction trn = session.beginTransaction();// works
//
//        String[] jumperIds = {"pro","aju","sal", "elo", "kka","msa", "awi", "ska", "jam", "asn"}; // Array of different JumperId values
//
//
//        for (int i = 0; i < jumperIds.length; i++) {
//            Manifest manifest = new Manifest();
//            manifest.setLoadNr(2);
//            manifest.setLoadDate(LocalDate.now());
//            manifest.setJumperId(jumperIds[i]); // Set different JumperId value from the array
//            manifest.setPlaneID("ES-ECG");
//            manifest.setLoadMaster("jam");
//
//            session.save(manifest);
//
//            Jumper jumper = session.get(Jumper.class, jumperIds[i]); // Retrieve the corresponding Jumper by jumperId
//            JumperJumpsId jumperJumpsId = new JumperJumpsId(jumperIds[i], 1);
//            JumperJumps jumperJumps = new JumperJumps(jumperJumpsId, jumper, "ES-ECG", LocalDate.now());
//
//            session.save(jumperJumps);
//
//        }
//        trn.commit();

////

//        Transaction trn = session.beginTransaction(); // throws double value entry for table jumper_jumps, col- jumper_id
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

//        JumperDAO jumperDAO = new JumperDAO();
//        System.out.println(jumperDAO.getPersonalCodes());



