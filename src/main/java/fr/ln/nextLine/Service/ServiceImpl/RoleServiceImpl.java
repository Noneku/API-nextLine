package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Model.Entity.Role;
import fr.ln.nextLine.Model.Mapper.RoleMapper;
import fr.ln.nextLine.Model.Repository.RoleRepository;
import fr.ln.nextLine.Service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }


    @Override
    public ResponseEntity<List<RoleDTO>> getAll() {

        List<RoleDTO> roleDTOs = roleRepository.findAll()
                .stream()
                .map(RoleMapper::toDTO)
                .toList();

        if (roleDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RoleDTO> getById(Integer id) {

        Optional<Role> role = roleRepository.findById(id);

        return role.map(
                        value -> new ResponseEntity<>(RoleMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<RoleDTO> create(RoleDTO roleDTO) {

        Role role = RoleMapper.toEntity(roleDTO);
        Role createdRole = roleRepository.save(role);
        RoleDTO createdRoleDTO = RoleMapper.toDTO(createdRole);

        return new ResponseEntity<>(createdRoleDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RoleDTO> update(Integer id, RoleDTO roleDTO) {

        if (roleRepository.existsById(id)) {

            Role role = RoleMapper.toEntity(roleDTO);
            role.setId(id);
            Role updatedRole = roleRepository.save(role);
            RoleDTO updatedRoleDTO = RoleMapper.toDTO(updatedRole);

            return new ResponseEntity<>(updatedRoleDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Role> roleOptional = roleRepository.findById(id);

        if (roleOptional.isPresent()) {

            roleRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
