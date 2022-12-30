package entity;

import core.model.AbstractEntity;

public class LehrkraftFach extends AbstractEntity {

    protected Integer LFID;
    protected Integer LID;
    protected Integer FID;

    public Integer getLFID() {
        return LFID;
    }

    public Integer getLID() {
        return LID;
    }

    public void setLID(Integer LID) {
        this.LID = LID;
    }

    public Integer getFID() {
        return FID;
    }

    public void setFID(Integer FID) {
        this.FID = FID;
    }

}
