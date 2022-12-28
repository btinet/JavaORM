package core.model;

public abstract class AbstractRepositoryFactory extends AbstractModel implements RepositoryFactoryInterface
{
    protected Class<?> entity;

    public AbstractRepositoryFactory(){
        super();
    }


    public void setEntity(Class<?> entity){
            this.entity = entity;
    }

}
