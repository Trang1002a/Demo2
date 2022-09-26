package Repository;

import java.util.List;

public interface IGenericRepository<T, ID> {
	List<T> find();
	T findById(ID id);
	T add(T entity);
	T update(T entity);
	Boolean remove(ID id);
}
