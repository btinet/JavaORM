package core.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRepositoryFactory extends AbstractModel implements RepositoryFactoryInterface
{
    protected AbstractEntity entity;

    protected Boolean naturalCase = false;

    protected Boolean ucFirst = false;
    protected String alias;
    protected QueryBuilder queryBuilder;

    public AbstractRepositoryFactory(Boolean naturalCase){
        if(naturalCase){
            this.naturalCase = naturalCase;
            this.getConnection();
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
        return this.queryBuilder = new QueryBuilder(this.connection, this.naturalCase,this.ucFirst,this.entity,this.alias);
    }

    public AbstractEntity find(int id){
        return this.doFind(id, "id");
    }

    public AbstractEntity find(int id,String field){
        return this.doFind(id, field);
    }

    public AbstractEntity findOneBy(HashMap<String, String> condition){
        try {
            try {
                QueryBuilder query = this.createQueryBuilder()
                        .selectOrm()
                        ;
                int i = 1;
                for (Map.Entry<String, String> entry : condition.entrySet()){
                    if ("null".equals(entry.getValue())) {
                        query.andWhere(entry.getKey() + " IS NULL");
                    } else {
                        query.andWhere(entry.getKey() + " = ?");
                        query.setParameter(i, entry.getValue());
                        i++;
                    }
                }
                return query.getQuery()
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
