package core.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public abstract class AbstractRepositoryFactory implements RepositoryFactoryInterface
{
    protected AbstractEntity entity;

    protected Boolean naturalCase = false;

    protected Boolean ucFirst = false;
    protected String alias;
    protected QueryBuilder queryBuilder;

    public AbstractRepositoryFactory(Boolean naturalCase){
        if(naturalCase){
            this.naturalCase = naturalCase;
        }
    }

    public AbstractRepositoryFactory setEntity(AbstractEntity entity){
            this.entity = entity;
            return this;
    }

    public AbstractRepositoryFactory setUcFirst()
    {
        this.ucFirst = true;
        return this;
    }

    public AbstractRepositoryFactory setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    protected QueryBuilder createQueryBuilder()
    {
        return this.queryBuilder = new QueryBuilder(this.naturalCase,this.ucFirst,this.entity,this.alias);
    }

    public AbstractEntity find(int id){
        return this.doFind(id, "id");
    }

    public AbstractEntity find(String field, int id){
        return this.doFind(id, field);
    }

    protected AbstractEntity doFind(int id, String field){
        try {
            try {
                return this.createQueryBuilder()
                        .selectOrm()
                        .andWhere(field + " = ?")
                        .setParameter(1,id)
                        .getQuery()
                        .getOnOrNullResult()
                        ;

            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
