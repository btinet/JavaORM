package entity;

import core.model.AbstractEntity;

public class Fach extends AbstractEntity {

    protected Integer FID;

    protected String Bezeichnung;

    @Override
    public String toString() {
        return this.getBezeichnung();
    }

    public Integer getFID() {
        return FID;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

}
