package model;

import java.time.LocalDate;
import java.util.List;

public class Manifest {
    private int loadNr;
    private LocalDate jumpDate;
    private String planeID;
    private String loadMaster;
    private List<Jumper> jumpers;
    private Jumper jumper;

    public Manifest(){}

    public Manifest(int loadNr, LocalDate jumpDate, String planeID, String loadMaster, List<Jumper> jumpers) {
        this.loadNr = loadNr;
        this.jumpDate = jumpDate;
        this.planeID = planeID;
        this.loadMaster = loadMaster;
        this.jumpers = jumpers;
    }

    public int getLoadNr() {
        return loadNr;
    }

    public void setLoadNr(int loadNr) {
        this.loadNr = loadNr;
    }

    public LocalDate getJumpDate() {
        return jumpDate;
    }

    public void setJumpDate(LocalDate jumpDate) {
        this.jumpDate = jumpDate;
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

    public List<Jumper> getJumpers() {
        return jumpers;
    }

    public void setJumpers(List<Jumper> jumpers) {
        this.jumpers = jumpers;
    }

    @Override
    public String toString() {
        return "Manifest{" +
                "loadNr=" + loadNr +
                ", jumpDate=" + jumpDate +
                ", planeID='" + planeID + '\'' +
                ", loadMaster='" + jumper.getPersonal_code() + '\'' +
                ", jumpers=" + jumpers +
                '}';
    }
}
