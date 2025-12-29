package com.scms.credit_service.context;

public class UserContext {

    private static final ThreadLocal<String> username = new ThreadLocal<>();
    private static final ThreadLocal<String> role = new ThreadLocal<>();

    public static void set(String user, String r) {
        username.set(user);
        role.set(r);
    }

    public static String getUsername() {
        return username.get();
    }

    public static String getRole() {
        return role.get();
    }

    public static void clear() {
        username.remove();
        role.remove();
    }
}
