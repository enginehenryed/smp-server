package net.swmaestro.portal.common.permission;

import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.user.handler.UserHandler;
import net.swmaestro.portal.user.vo.User;
import net.swmaestro.portal.user.vo.UserResult;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by junha on 2016. 10. 29..
 */
public class PortalPermissionEvaluator implements org.springframework.security.access.PermissionEvaluator {

    private Logger log = Logger.getLogger(this.getClass());

    private final Map<String, Permission> permissionMap;

    @Resource(name="userHandler")
    private UserHandler userHandler;

    PortalPermissionEvaluator(Map<String, Permission> permissionMap) {
        this.permissionMap = permissionMap;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permissionText) {
        log.debug(String.format("Permission `%s` attempt.", permissionText));

        if (targetDomainObject != null) {
            throw new RuntimeException("targetDomainObject of hasPermission(Object targetDomainObject, Object permissionText) must be NULL.");
        }

        JWTAuthentication jwtAuthentication = (JWTAuthentication) authentication;
        UserResult user = jwtAuthentication.getUser();
        assert user != null;

        boolean isPermitted = false;
        switch ((String) permissionText) {
            case "ADMIN":
                try {
                    isPermitted = userHandler.checkIsAdmin(user.getUserId());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                } finally {}
                break;

            case "MENTOR":
                try {
                    isPermitted = userHandler.checkIsMentor(user.getUserId());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                } finally {}
                break;

            default:
                throw new IllegalArgumentException("permissionText of hasPermission(Object targetDomainObject, Object permissionText) allow ONLY 'ADMIN', 'MENTOR'. Use hasPermission(Serializable targetId, String targetType, Object permissionText) instead for check permissions for object.)");
        }

        if (isPermitted) {
            log.debug(String.format("Permission `%s` PERMITTED.", permissionText));
        } else {
            log.debug(String.format("Permission `%s` NOT permitted.", permissionText));
        }

        return isPermitted;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permissionText) {
        log.debug(String.format("Permission `%s` attempt for targetType `%s` with targetId `%s`.", permissionText, targetType, targetId));

        JWTAuthentication jwtAuthentication = (JWTAuthentication) authentication;
        UserResult user = jwtAuthentication.getUser();
        assert user != null;

        if (targetType == null) {
            throw new IllegalArgumentException("Argument targetType must not be null.");
        }

        Permission permission = permissionMap.get(targetType);
        if (permission == null) {
            throw new IllegalArgumentException(String.format("targetType argument `%s` not accepted. It must be listed on permissionMap(1st parameter of constructor).", targetType));
        }

        boolean isPermitted = false;
        switch ((String) permissionText) {
            case "OWNER":
                isPermitted = permission.isOwner(user.getUserId(), targetId);
                break;

            default:
                throw new IllegalArgumentException(String.format("permissionText `%s` not accepted on targetType `%s`.", permissionText, targetType));
        }

        if (isPermitted) {
            log.debug(String.format("Permission `%s` PERMITTED for targetType `%s` with targetId `%s`.", permissionText, targetType, targetId));
        } else {
            log.debug(String.format("Permission `%s` NOT permitted for targetType `%s` with targetId `%s`.", permissionText, targetType, targetId));
        }

        return isPermitted;
    }


}
