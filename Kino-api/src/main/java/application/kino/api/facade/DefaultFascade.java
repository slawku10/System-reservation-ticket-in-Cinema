/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.kino.api.facade;

import java.util.List;

/**
 *
 * @author Maksymilian
 */
interface DefaultFascade<T> {
    int count();

    void create(T entity);

    void edit(T entity);
    
    T find(Object id);

    List<T> findAll();
    
    void remove(T entity);
    
    List<T> findRange(int[] range);  
}
