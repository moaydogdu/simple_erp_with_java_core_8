package org.erp_case_1.repository;

import java.util.List;

/**
 * Custom Repository.
 *
 * @param <T> -> Type
 * @param <I> -> ID
 */
public interface CustomRepository<T, I> {
    List<T> findAll();

    T save(T entity);
}
