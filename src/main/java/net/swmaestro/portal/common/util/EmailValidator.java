package net.swmaestro.portal.common.util;

import java.util.regex.Pattern;

/**
 * Created by junha on 2016. 11. 13..
 */
public class EmailValidator {
    public static final String REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final Pattern PATTERN = Pattern.compile(REGEX);

    public static boolean isValid(String email) {
        return PATTERN.matcher(email).matches();
    }
}
