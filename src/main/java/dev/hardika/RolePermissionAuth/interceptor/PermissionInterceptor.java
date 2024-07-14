package dev.hardika.RolePermissionAuth.interceptor;



import dev.hardika.RolePermissionAuth.customAnnotation.LogicEnum;
import dev.hardika.RolePermissionAuth.customAnnotation.Permission;
import dev.hardika.RolePermissionAuth.service.PermissionService;
import dev.hardika.RolePermissionAuth.service.UserService;
import dev.hardika.RolePermissionAuth.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(Permission.class)) {
                Permission permission = method.getAnnotation(Permission.class);

                String token = request.getHeader("Authorization");
                String username = JWTUtils.getUsernameFromToken(token); // Implement this utility to decode JWT tokens
                List<String> userRoles = userService.getUserRoles(username);
                List<String> userPermissions = permissionService.getUserPermissions(userRoles);

                boolean accessGranted = permission.type() == LogicEnum.All
                        ? Stream.of(permission.permissions()).allMatch(p -> userPermissions.contains(p.name()))
                        : Stream.of(permission.permissions()).anyMatch(p -> userPermissions.contains(p.name()));

                if (!accessGranted) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
                    return false;
                }
            }
        }
        return true;
    }
}

