package dev.hardika.RolePermissionAuth.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PerRoleMap extends BaseModel {

    private boolean status;

    @Embeddable
    @Getter
    @Setter
    public static class PerRoleId implements Serializable {
        private UUID perId;
        private UUID roleId;
    }
}
