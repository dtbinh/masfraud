package masfraud.base.dao;

import java.util.List;

import masfraud.base.to.AccrualLogTO;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

/**
 * 
 * @author Mauricio
 *
 * @param <T>
 */
public abstract class AbstractMongoDBDAO<T> {

	private MongoOperations mongoOperations;

    public AbstractMongoDBDAO(MongoTemplate mongoTemplate) {
        mongoOperations = mongoTemplate;
    }

    protected abstract String getCollectionName();
	
	
	public T insert(T T) throws Exception {
		return save(T);
	}
	
	public T update(T T) throws Exception {
		return save(T);
	}
	
	/**
	 * 
	 * @param T
	 * @return
	 * @throws UpdateException
	 */
	private T save(T T) throws Exception {
        mongoOperations.save(T, getCollectionName());
		return T;
	}
	
	public void remove(T t) throws Exception {
		mongoOperations.remove(t, getCollectionName());
	}
	
	public void removeByKey(Object object) throws Exception {
		mongoOperations.remove(object, getCollectionName());
	}
	
	public void removeByQuery(Query query)throws Exception {
		mongoOperations.remove(query, getCollectionName());
	}
	
	public List<T> findAll(Class<T> klass) throws Exception {
		return (List<T>) mongoOperations.findAll(klass, getCollectionName());
	}
	
	public T findById(Class<T> klass, Object chave) throws Exception {
		return mongoOperations.findById(chave, klass, getCollectionName());
	}
	
	public T findBy(Query query,Class<T> klass) throws Exception {
		return mongoOperations.findOne(query, klass, getCollectionName());
	}

    public List<T> find(Query query,Class<T> klass) throws Exception {
        return mongoOperations.find(query, klass, getCollectionName());
    }
	
	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public long count() {
		return this.mongoOperations.getCollection(this.getCollectionName()).count();
	}

	public MongoOperations getMongoOperations() {
		return mongoOperations;
	}


}
