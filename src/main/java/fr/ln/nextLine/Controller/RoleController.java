package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Integer id) {

        return roleService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createRole (@RequestBody RoleDTO roleDTO) {

        return roleService.create(roleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Integer id, @RequestBody RoleDTO roleDTO) {

        return roleService.update(id, roleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id) {

        return roleService.delete(id);

    }
}
