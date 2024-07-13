package dev.hardika.RolePermissionAuth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User_Role")
public class Role extends BaseModel{
    private String name;
}
