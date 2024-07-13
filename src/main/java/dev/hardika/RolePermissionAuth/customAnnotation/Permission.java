package dev.hardika.RolePermissionAuth.customAnnotation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = {PermissionValidation.class})
public @interface Permission {
    PermissionEnum[] permissions() default {PermissionEnum.READ};
    LogicEnum type() default LogicEnum.ALL;

}
