package dev.hardika.RolePermissionAuth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserRoleMapId.class)
public class UserRoleMap {
    @Id
    private int uid;
    @Id
    private int rid;
}
