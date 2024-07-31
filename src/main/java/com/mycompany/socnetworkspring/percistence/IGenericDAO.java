package com.mycompany.socnetworkspring.percistence;

import java.util.List;
import java.util.Optional;

public interface IGenericDAO <T> {
    T create(T obj);
    T update(T obj);
    void delete(Long id);
    List<T> findAll();
    Optional <T> findById(Long id);
}
