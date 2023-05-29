package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JumperJumpsId implements Serializable {
    @Column(name = "jumper_id")
    private String jumperId;

    @Column(name = "jump_nr")
    private int jumpNr;

    // Constructors, getters, and setters

    public JumperJumpsId() {
    }

    public JumperJumpsId(String jumperId, int jumpNr) {
        this.jumperId = jumperId;
        this.jumpNr = jumpNr;
    }

    public String getJumperId() {
        return jumperId;
    }

    public void setJumperId(String jumperId) {
        this.jumperId = jumperId;
    }

    public int getJumpNr() {
        return jumpNr;
    }

    public void setJumpNr(int jumpNr) {
        this.jumpNr = jumpNr;
    }
}

