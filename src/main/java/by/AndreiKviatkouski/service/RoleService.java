package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.models.Role;
import by.AndreiKviatkouski.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public Set<Role> getRoles() {
        return roleRepository.getRoles();
    }

    public Set<Role> getOnlyRoleUser() {
        Set<Role> roles = roleRepository.getRoles();
        roles.remove(roleRepository.getOne(2L));
        return roles;
    }
}
