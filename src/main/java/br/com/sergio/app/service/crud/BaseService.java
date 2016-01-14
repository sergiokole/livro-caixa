package br.com.sergio.app.service.crud;

import java.io.Serializable;
import java.util.Collection;

public interface BaseService<T, ID extends Serializable> {

	T create(T create);

	Collection<T> read();
	
	T read(ID id);
	
	T update(T update);
	
	void delete(ID id);
}
