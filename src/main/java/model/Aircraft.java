package model;

import javax.persistence.*;

@Entity
@Table(name = "`aircraft`", schema = "`elak_baas`")
public class Aircraft {
    @Id
    private int id;
    @Column(name = "`plane_id`")
    private String planeId;
    @Column(name = "`capacity`")
    private int capacity;

    public Aircraft() {}

    public Aircraft(String planeId, int capacity) {
        this.planeId = planeId;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", planeId='" + planeId + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
