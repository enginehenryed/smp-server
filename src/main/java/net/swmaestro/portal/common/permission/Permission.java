package net.swmaestro.portal.common.permission;


import java.io.Serializable;

/**
 * Created by junha on 2016. 11. 6..
 */
public interface Permission {
    public boolean isOwner(int authUserId, Serializable targetId);
}
