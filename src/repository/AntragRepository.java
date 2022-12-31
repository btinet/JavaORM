package repository;

import core.model.AbstractRepositoryFactory;
import entity.Antrag;

public class AntragRepository extends AbstractRepositoryFactory {

    public AntragRepository(Boolean naturalCase){
        super(naturalCase);
        super.setEntity(Antrag.class);
    }

}
