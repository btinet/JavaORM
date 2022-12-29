package core.model;

import java.util.HashMap;

public interface RepositoryFactoryInterface

{

    public AbstractRepositoryFactory setEntity(Class<? extends AbstractEntity> entity);

    public AbstractRepositoryFactory setUcFirst();

    public AbstractRepositoryFactory setAlias(String alias);

    public AbstractEntity find(int id);

    public AbstractEntity find(int id,String field);

    public AbstractEntity findOneBy(HashMap<String, String> condition);
}
