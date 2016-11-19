package net.swmaestro.portal.common.util;

import java.util.UUID;

/**
 * Created by junha on 2016. 10. 15..
 */
public class CommonUtil {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
