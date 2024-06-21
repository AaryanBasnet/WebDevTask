package com.example.webdevtask.service.implementor;

import com.example.webdevtask.entity.Role;
import com.example.webdevtask.pojo.RolePojo;
import com.example.webdevtask.repo.RoleRepo;
import com.example.webdevtask.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Override
    public void saveData(RolePojo rolePojo) {
        Role role = new Role();
        role.setId(rolePojo.getId());
        role.setRoleName(rolePojo.getRoleName());
        roleRepo.save(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        roleRepo.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepo.findById(Long.valueOf(id));
    }
}