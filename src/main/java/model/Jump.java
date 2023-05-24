package model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "`jumps`", schema = "`elak_baas`")

public class Jump {
    @Id
    private int jumpNr;
    @Column(name = "`jumper_id`")
    private String jumperID;
    @Column(name = "`jump_date`")
    private LocalDate jumpDate;
    @Column(name = "`aircraft`")
    private String aircraft;
    @ManyToOne
    @JoinColumn(name = "jumper_personal_code")
    private Jumper jumper;

    public Jump(){}

    public Jump(int jumpNr, String jumperID, LocalDate jumpDate, String aircraft) {
        this.jumpNr = jumpNr;
        this.jumperID = jumperID;
        this.jumpDate = jumpDate;
        this.aircraft = aircraft;
    }

    public int getJumpNr() {
        return jumpNr;
    }

    public void setJumpNr(int jumpNr) {
        this.jumpNr = jumpNr;
    }

    public String getJumperID() {
        return jumperID;
    }

    public void setJumperID(String jumperID) {
        this.jumperID = jumperID;
    }

    public LocalDate getJumpDate() {
        return jumpDate;
    }

    public void setJumpDate(LocalDate jumpDate) {
        this.jumpDate = jumpDate;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Jumper getJumper() {
        return jumper;
    }

    public void setJumper(Jumper jumper) {
        this.jumper = jumper;
    }

    @Override
    public String toString() {
        return "Jump{" +
                "jumpNr=" + jumpNr +
                ", jumperID='" + jumper.getPersonal_code() + '\'' +
                ", jumpDate=" + jumpDate +
                ", aircraft='" + aircraft + '\'' +
                '}';
    }
}
