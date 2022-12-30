package entity;

import core.model.AbstractEntity;

import java.time.Year;

public class Thema extends AbstractEntity {

    protected Integer TID;
    protected String Leitfrage;
    protected String Erläuterung;
    protected Year Prüfjahr;

    @Override
    public String toString() {
        return this.getLeitfrage();
    }

    public Integer getTID() {
        return TID;
    }

    public String getLeitfrage() {
        return Leitfrage;
    }

    public void setLeitfrage(String leitfrage) {
        Leitfrage = leitfrage;
    }

    public String getErläuterung() {
        return Erläuterung;
    }

    public void setErläuterung(String erläuterung) {
        Erläuterung = erläuterung;
    }

    public Year getPrüfjahr() {
        return Prüfjahr;
    }

    public void setPrüfjahr(Year prüfjahr) {
        Prüfjahr = prüfjahr;
    }
}
