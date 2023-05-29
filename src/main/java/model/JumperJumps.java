package model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "jumper_jumps", schema = "elak_baas")
public class JumperJumps {
    @EmbeddedId
    private JumperJumpsId id;

//    @Column(name = "jumper_id")
//    private String jumperID;

    @ManyToOne
    @MapsId("jumperId")
    @JoinColumn(name = "jumper_id")
    private Jumper jumper;

    @Column(name = "aircraft")
    private String aircraft;

    @Column(name = "jump_date")
    private LocalDate jumpDate;



    public JumperJumps() {
    }

    public JumperJumps(JumperJumpsId id, Jumper jumper, String aircraft, LocalDate jumpDate) {
        this.id = id;
        this.jumper = jumper;
        this.aircraft = aircraft;
        this.jumpDate = jumpDate;
    }

    public JumperJumpsId getId() {
        return id;
    }

    public void setId(JumperJumpsId id) {
        this.id = id;
    }

    public Jumper getJumper() {
        return jumper;
    }

    public void setJumper(Jumper jumper) {
        this.jumper = jumper;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public LocalDate getJumpDate() {
        return jumpDate;
    }

    public void setJumpDate(LocalDate jumpDate) {
        this.jumpDate = jumpDate;
    }

    @Override
    public String toString() {
        return "JumperJumps{" +
                "id=" + id +
                ", jumper=" + jumper +
                ", aircraft=" + aircraft +
                ", jumpDate=" + jumpDate +
                '}';
    }
}
