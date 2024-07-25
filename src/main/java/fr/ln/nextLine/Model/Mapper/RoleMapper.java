package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Model.Entity.Role;

public class RoleMapper {

    private RoleMapper () {}

    public static RoleDTO toDTO(Role role) {

        if (role == null) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setNomRole(role.getNomRole());

        return roleDTO;
    }

    public static Role toEntity(RoleDTO roleDTO) {

        if (roleDTO == null) {
            return null;
        }

        Role role = new Role();

        role.setId(roleDTO.getId());
        role.setNomRole(roleDTO.getNomRole());

        return role;
    }
}
