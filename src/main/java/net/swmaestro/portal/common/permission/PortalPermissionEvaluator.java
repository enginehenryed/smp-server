package net.swmaestro.portal.common.permission;

import net.swmaestro.portal.user.handler.UserHandler;
import org.apache.log4j.Logger;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by junha on 2016. 10. 29..
 */
public class PortalPermissionEvaluator implements PermissionEvaluator {
    Logger log = Logger.getLogger(this.getClass());

    @Resource(name="userHandler")
    private UserHandler userHandler;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permissionText) {
        log.error(String.format("[1] %s %s", targetDomainObject, permissionText));
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permissionText) {
        log.error(String.format("[2] %s %s %s", targetId, targetType, permissionText));

        Object targetDomainObject = null;
        if (targetType.equals("User")) {
            try {
                targetDomainObject = userHandler.selectUser((int)targetId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (targetDomainObject != null) {
            return hasPermission(authentication, targetDomainObject, permissionText);
        }

        return false;
    }
}
