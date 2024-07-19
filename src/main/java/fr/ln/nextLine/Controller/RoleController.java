package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Model.Entity.Role;
import fr.ln.nextLine.Model.Mapper.RoleMapper;
import fr.ln.nextLine.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {

        List<Role> roles = roleService.getAllRoles();
        List<RoleDTO> roleDTOS = roles
                .stream()
                .map(RoleMapper::toDTO)
                .toList();

        return new ResponseEntity<>(roleDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Integer id) {

        Role role = roleService.getRoleById(id);

        return new ResponseEntity<>(RoleMapper.toDTO(role), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {

        Role role = RoleMapper.toEntity(roleDTO);
        Role createdRole = roleService.createRole(role);
        RoleDTO createdRoleDTO = RoleMapper.toDTO(createdRole);

        return new ResponseEntity<>(createdRoleDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Integer id, @RequestBody RoleDTO roleDTO) {

            Role role = RoleMapper.toEntity(roleDTO);
            Role updatedRole = roleService.updateRole(id, role);

            if (updatedRole != null) {
                RoleDTO updatedRoleDTO = RoleMapper.toDTO(updatedRole);
                return new ResponseEntity<>(updatedRoleDTO, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        boolean deleted = roleService.deleteRole(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
