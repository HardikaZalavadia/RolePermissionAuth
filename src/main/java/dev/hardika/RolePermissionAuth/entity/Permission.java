package dev.hardika.RolePermissionAuth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "Permissions")
@Getter
@Setter
public class Permission extends BaseModel{
    private String name;
    @ManyToMany
    private List<Role> roles;

}
