package core.model;

import repository.GenericRepository;

public abstract class AbstractEntity {

    protected GenericRepository repository;

    public AbstractEntity(){
        this.getRepository(true);
    }
    public AbstractEntity(Boolean naturalCase){
        this.getRepository(naturalCase);
    }

    protected void getRepository(Boolean naturalCase){
        this.repository = new GenericRepository(naturalCase);
    }

}
