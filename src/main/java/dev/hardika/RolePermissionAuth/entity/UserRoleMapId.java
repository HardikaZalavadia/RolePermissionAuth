package dev.hardika.RolePermissionAuth.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRolesMapId implements Serializable {
    private int uid;
    private int rid;
}
