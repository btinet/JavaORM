package entity;

import core.model.AbstractEntity;

public class Antrag extends AbstractEntity {

    protected int AID;
    protected int alsEinzelprüfung;
    protected String genehmigtAm;
    protected int TID;
    protected int KID;

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public int getAlsEinzelprüfung() {
        return alsEinzelprüfung;
    }

    public void setAlsEinzelprüfung(int alsEinzelprüfung) {
        this.alsEinzelprüfung = alsEinzelprüfung;
    }

    public String getGenehmigtAm() {
        return genehmigtAm;
    }

    public void setGenehmigtAm(String genehmigtAm) {
        this.genehmigtAm = genehmigtAm;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public int getKID() {
        return KID;
    }

    public void setKID(int KID) {
        this.KID = KID;
    }
}
