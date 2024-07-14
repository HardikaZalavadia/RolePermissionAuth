package dev.hardika.RolePermissionAuth.interceptor;

import dev.hardika.RolePermissionAuth.customAnnotation.LogicEnum;
import dev.hardika.RolePermissionAuth.customAnnotation.Permission;
import dev.hardika.RolePermissionAuth.customAnnotation.PermissionEnum;
import dev.hardika.RolePermissionAuth.entity.User;
import dev.hardika.RolePermissionAuth.entity.UserRoleMap;
import dev.hardika.RolePermissionAuth.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PerRoleMapRepository perRoleMapRepository;

    @Autowired
    private UserRoleMapRepository userRoleMapRepository;

    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Permission permissionAnnotation = handlerMethod.getMethodAnnotation(Permission.class);

            if (permissionAnnotation != null) {
                PermissionEnum[] requiredPermissions = permissionAnnotation.permissions();
                LogicEnum logicType = permissionAnnotation.type();
                UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String username = userDetails.getUsername();
                User user = userRepository.findByEmail(username);
                if(user == null) {
                    throw new RuntimeException("User not found");
                }
                Set<String> userPermissions = userRoleMapRepository.findAllById_UserId(user.getId()).stream()
                        .map(UserRoleMap::getId)
                        .map(UserRoleMap.UserRoleId::getRoleId)
                        .flatMap(roleId -> perRoleMapRepository.findAllById_RoleId(roleId).stream())
                        .filter(perRoleMap -> perRoleMap.getStatus())
                        .map(perRoleMap -> permissionRepository.findById(perRoleMap.getId().getPid()).orElseThrow(() -> new RuntimeException("Permission not found")).getName())
                        .collect(Collectors.toSet());


                boolean hasPermission;
                if (logicType == LogicEnum.All) {
                    hasPermission = List.of(requiredPermissions).stream()
                            .map(Enum::name)
                            .allMatch(userPermissions::contains);
                } else {
                    hasPermission = List.of(requiredPermissions).stream()
                            .map(Enum::name)
                            .anyMatch(userPermissions::contains);
                }

                if (!hasPermission) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have the required permissions to access this resource");
                    return false;
                }
            }
        }

        return true;
    }

}
