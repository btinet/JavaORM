package entity;

import core.model.AbstractEntity;

public class Lehrkraft extends AbstractEntity {

    protected Integer LID;
    protected String Anrede;
    protected String Vorname;
    protected String Name;

    public Integer getLID() {
        return LID;
    }

    public String getAnrede() {
        return Anrede;
    }

    public void setAnrede(String anrede) {
        Anrede = anrede;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
