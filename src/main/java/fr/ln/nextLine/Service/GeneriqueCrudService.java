package fr.ln.nextLine.Service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GeneriqueCrudService<T> {

    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getById(Integer id);
    ResponseEntity<T> create(T entity);
    ResponseEntity<T> update(Integer id, T entity);
    ResponseEntity<Void> delete(Integer id);

}
