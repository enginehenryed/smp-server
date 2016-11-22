package net.swmaestro.portal.user.utils;

import net.swmaestro.portal.user.vo.UserResult;

/**
 * Created by dbgsprw on 2016. 11. 20..
 */
public class UserUtils {

    public static void makeUserResultSafe(UserResult userResult) {
        if (userResult != null) {
            userResult.setUserPhone(null);
            userResult.setUserCreatedAt(null);
            userResult.setUserGender(null);
            userResult.setUserStatus(null);
            userResult.setUserUpdatedAt(null);
        }
    }
}

