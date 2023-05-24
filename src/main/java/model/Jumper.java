package model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "`jumper`", schema = "`elak_baas`")
public class Jumper {
    @Id
    private String personal_code;
    @Column(name = "`name`")
    private String name;
    @Column(name = "`email`")
    private String email;
    @Column(name = "`phone_nr`")
    private String phone;
    @Column(name = "`licence`")
    private String licence;
    @Column(name = "`account_balance`")
    private long balance;
    @Column(name = "`vvh`")
    private LocalDate reservePractice;
    @Column(name = "`health_declaration`")
    private LocalDate healthDeclaration;

    public Jumper(){}

    public Jumper(String personal_code, String name, String email, String phone,
                  String licence, long balance, LocalDate reservePractice, LocalDate healthDeclaration) {
        this.personal_code = personal_code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.licence = licence;
        this.balance = balance;
        this.reservePractice = reservePractice;
        this.healthDeclaration = healthDeclaration;
    }

    public String getPersonal_code() {
        return personal_code;
    }

    public void setPersonal_code(String personal_code) {
        this.personal_code = personal_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public LocalDate getReservePractice() {
        return reservePractice;
    }

    public void setReservePractice(LocalDate reservePractice) {
        this.reservePractice = reservePractice;
    }

    public LocalDate getHealthDeclaration() {
        return healthDeclaration;
    }

    public void setHealthDeclaration(LocalDate healthDeclaration) {
        this.healthDeclaration = healthDeclaration;
    }

    @Override
    public String toString() {
        return "Jumper{" +
                "personal_code='" + personal_code + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", licence='" + licence + '\'' +
                ", balance=" + balance +
                ", reservePractice=" + reservePractice +
                ", healthDeclaration=" + healthDeclaration +
                '}';
    }
}
