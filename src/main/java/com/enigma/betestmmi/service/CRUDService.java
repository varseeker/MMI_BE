package com.enigma.betestmmi.service;

import java.util.List;

public interface CRUDService<T> {
    public T getDataById(Integer id);
    public List<T> getAllData();
    public T createData(T t);
    public void deleteData(Integer id);
    public T updateData(T t);
}
