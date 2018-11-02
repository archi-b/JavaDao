package br.com.archib.javadao.dao;

import java.util.List;

public interface IDaoBase<T> {
    /**
     * @param instance
     */
    public void save(T instance);
    /**
     * @param id
     * @return
     */
    public T findById(Integer id);
    /**
     * @return
     */
    public List<T> findAll();
    /**
     * @param begin
     * @param end
     * @return
     */
    public List<T> findAll(Integer begin, Integer end);
    /**
     * @param example
     * @return
     */
    public List<T> findByExample(T example);
    /**
     * @param example
     * @param begin
     * @param end
     * @return
     */
    public List<T> findByExample(T example, Integer begin, Integer end);
    /**
     * @param isntance
     */
    public void remove(T isntance);
}
