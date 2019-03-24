package com.holeman.blogbackend.user;

import com.holeman.blogbackend.common.model.Role;
import com.holeman.blogbackend.common.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
