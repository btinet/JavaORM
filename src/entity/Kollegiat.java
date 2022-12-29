package entity;

import core.model.AbstractEntity;

public class Kollegiat extends AbstractEntity {

    protected int KID;
    protected String Name;
    protected String Vorname;
    protected int TutorID;
    protected int BetreuerID;

    public int getKID() {
        return KID;
    }

    public void setKID(int KID) {
        this.KID = KID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public int getTutorID() {
        return TutorID;
    }

    public void setTutorID(int tutorID) {
        TutorID = tutorID;
    }

    public int getBetreuerID() {
        return BetreuerID;
    }

    public void setBetreuerID(int betreuerID) {
        BetreuerID = betreuerID;
    }
}
