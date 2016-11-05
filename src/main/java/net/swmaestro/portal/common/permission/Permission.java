package net.swmaestro.portal.common.permission;

import net.swmaestro.portal.auth.JWTAuthentication;

import java.io.Serializable;

/**
 * Created by junha on 2016. 11. 6..
 */
public interface Permission {
    public boolean isOwner(int authUserId, Serializable targetId);
}
