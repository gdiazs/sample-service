package net.bac.sample.repository.dao;

public interface GenericDao<T> {

  public int insert(T t) ;
  public boolean delete(T t);
  public T find(T t);
  public boolean update(T old, T newOne);
}
