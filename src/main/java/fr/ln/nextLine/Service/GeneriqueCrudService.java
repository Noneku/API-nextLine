package fr.ln.nextLine.Service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GeneriqueCrudService<T> {

    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getById(Integer id);
    ResponseEntity<?> create(T entity);
    ResponseEntity<?> update(Integer id, T entity);
    ResponseEntity<?> delete(Integer id);

}
