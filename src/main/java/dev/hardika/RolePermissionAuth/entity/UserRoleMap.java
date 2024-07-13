package dev.hardika.RolePermissionAuth.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class UserRoleMap extends BaseModel{

    @Getter
    @Setter
    public static class UserRoleId implements Serializable {
        private UUID userId;
        private UUID roleId;
    }
}
