package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "`manifest`", schema = "`elak_baas`")
public class Manifest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "`jumper_id`")
    private String jumperId;
    @Column(name = "`load_nr`")
    private int loadNr;
    @Column(name = "`load_date`")
    private LocalDate loadDate;
    @Column(name = "`aircraft_id`")
    private String planeID;
    @Column(name = "`load_master`")
    private String loadMaster;


    public Manifest(){}

    public Manifest(int id, String jumperId, int loadNr, LocalDate loadDate, String planeID, String loadMaster) {
        this.id = id;
        this.jumperId = jumperId;
        this.loadNr = loadNr;
        this.loadDate = loadDate;
        this.planeID = planeID;
        this.loadMaster = loadMaster;
    }

    public String getJumperId() {
        return jumperId;
    }

    public void setJumperId(String jumperId) {
        this.jumperId = jumperId;
    }

    public int getLoadNr() {
        return loadNr;
    }

    public void setLoadNr(int loadNr) {
        this.loadNr = loadNr;
    }

    public LocalDate getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(LocalDate loadDate) {
        this.loadDate = loadDate;
    }

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public String getLoadMaster() {
        return loadMaster;
    }

    public void setLoadMaster(String loadMaster) {
        this.loadMaster = loadMaster;
    }


//    public List<String> getPersonalCodes() {
//        List<String> personalCodes = new ArrayList<>();
//        if (jumper != null) {
//            personalCodes.add(jumper.getPersonal_code());
//        }
//        return personalCodes;
//    }


    @Override
    public String toString() {
        return "Manifest{" +
                "id=" + id +
                ", jumperId='" + jumperId + '\'' +
                ", loadNr=" + loadNr +
                ", loadDate=" + loadDate +
                ", planeID='" + planeID + '\'' +
                ", loadMaster='" + loadMaster + '\'' +
                '}';
    }
}

