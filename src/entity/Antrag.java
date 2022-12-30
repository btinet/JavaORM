package entity;

import core.model.AbstractEntity;

public class Antrag extends AbstractEntity {

    protected Integer AID;
    protected Boolean alsEinzelprüfung;
    protected String genehmigtAm;
    protected Integer TID;
    protected Integer KID;

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public Boolean getAlsEinzelprüfung() {
        return alsEinzelprüfung;
    }

    public void setAlsEinzelprüfung(Boolean alsEinzelprüfung) {
        this.alsEinzelprüfung = alsEinzelprüfung;
    }

    public String getGenehmigtAm() {
        return genehmigtAm;
    }

    public void setGenehmigtAm(String genehmigtAm) {
        this.genehmigtAm = genehmigtAm;
    }

    public Integer getTID() {
        return TID;
    }

    public void setTID(Integer TID) {
        this.TID = TID;
    }

    public Integer getKID() {
        return KID;
    }

    public void setKID(Integer KID) {
        this.KID = KID;
    }
}
