package entity;

import core.model.AbstractEntity;

public class ThemaFach extends AbstractEntity {

    public ThemaFach(){
        super();
    }

    protected Integer TFID;

    protected Integer TID;

    protected Integer FID;

    protected Boolean istRefFach;

    public Integer getTFID() {
        return TFID;
    }

    public Integer getTID() {
        return TID;
    }

    public void setTID(Integer TID) {
        this.TID = TID;
    }

    public Thema getThema(){
        return (Thema) this.repository.setEntity(Thema.class).find(this.TID,"TID");
    }

    public Integer getFID() {
        return FID;
    }

    public void setFID(Integer FID) {
        this.FID = FID;
    }

    public Fach getFach(){
        return (Fach) this.repository.setEntity(Fach.class).find(this.FID,"FID");
    }

    public Boolean getIstRefFach() {
        return istRefFach;
    }

    public void setIstRefFach(Boolean istRefFach) {
        this.istRefFach = istRefFach;
    }

}
