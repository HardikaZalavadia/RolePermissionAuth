package dev.hardika.RolePermissionAuth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String password;
    private String email;

    @ManyToMany
    private List<Role> roles;
}
