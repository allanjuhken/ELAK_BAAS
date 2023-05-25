package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "`manifest`", schema = "`elak_baas`")
public class Manifest {
    @Id
    private int loadNr;
    @Column(name = "`load_date`")
    private LocalDate loadDate;
    @Column(name = "`aircraft_id`")
    private String planeID;
    @Column(name = "`load_master`")
    private String loadMaster;
    @Column(name = "`on_board`")
    private String jumpersCodes; // modified, str instead of list
    @ManyToOne
    @JoinColumn(name = "personal_code")
    public Jumper jumper;


    public Manifest(){}

    public Manifest(int loadNr, LocalDate loadDate, String planeID, String loadMaster, Jumper jumper) {
        this.loadNr = loadNr;
        this.loadDate = loadDate;
        this.planeID = planeID;
        this.loadMaster = loadMaster;
        this.jumper = jumper; // modified. List asemel Jumper
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

//    public List<Jumper> getJumpers() {
//        return jumpers;
//    }
//
//    public void setJumpers(List<Jumper> jumpers) {
//        this.jumpers = jumpers;
//    }
    public Jumper getJumper() {
        return jumper;
    }

    public void setJumper(Jumper jumper) {
        this.jumper = jumper;
    }


    public List<String> getPersonalCodes() {
        List<String> personalCodes = new ArrayList<>();
        if (jumper != null) {
            personalCodes.add(jumper.getPersonal_code());
        }
        return personalCodes;
    }



    @Override
    public String toString() {
        return "Manifest{" +
                "loadNr=" + loadNr +
                ", loadDate=" + loadDate +
                ", planeID='" + planeID + '\'' +
                ", loadMaster='" + loadMaster + '\'' + // (jumper != null ? jumper.getPersonal_code() : "")
                //", jumpers=" + jumpers +
                '}';
    }

}
