package com.blogapi.BlogAPI.repositories;

import com.blogapi.BlogAPI.models.role.Role;
import com.blogapi.BlogAPI.models.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName name);
}
