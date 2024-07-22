package fr.ln.nextLine.Service.Impl;


import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Model.Entity.Activite;
import fr.ln.nextLine.Model.Mapper.ActiviteMapper;
import fr.ln.nextLine.Model.Repository.ActiviteRepository;
import fr.ln.nextLine.Service.ActiviteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiviteServiceImpl implements ActiviteService {

    ActiviteRepository activiteRepository;

    ActiviteServiceImpl(ActiviteRepository activiteRepository){
        this.activiteRepository = activiteRepository;
    }


    @Override
    public ResponseEntity<List<ActiviteDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ActiviteDTO> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ActiviteDTO> create(ActiviteDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<ActiviteDTO> update(Integer id, ActiviteDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return null;
    }
}
