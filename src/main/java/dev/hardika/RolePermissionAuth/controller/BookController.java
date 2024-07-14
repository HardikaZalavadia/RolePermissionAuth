package dev.hardika.RolePermissionAuth.controller;

import dev.hardika.RolePermissionAuth.customAnnotation.LogicEnum;
import dev.hardika.RolePermissionAuth.customAnnotation.Permission;
import dev.hardika.RolePermissionAuth.customAnnotation.PermissionEnum;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Permission(permissions = {PermissionEnum.AllowRead, PermissionEnum.AllowWrite}, type = LogicEnum.All)
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public String getBook(@PathVariable int id, @RequestParam(value = "num") Optional<Integer> num) {
        System.out.println(num);
        return "hello";
    }
}
