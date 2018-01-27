package com.harlan.config;

public class StaticParams {

    public static class PathRegex {
        // 首页以及css、js、img等静态资源访问无需权限
        public static final String ROOT = "/";
        public static final String INDEX = "/index";
        public static final String PAGE = "/page/**";
        public static final String ARCHIVE = "/archives/**";
        public static final String POST = "/posts/**";
        public static final String JS = "/js/**";
        public static final String CSS = "/css/**";
        public static final String IMG = "/img/**";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String WEBJARS = "/webjars/**";
        public static final String ABOUT = "/about/**";

        // 管理员权限
        public static final String AUTH_ADMIN = "/harlan/**";

        // 用户权限
        public static final String AUTH_USER = "/user/**";
    }

    public static class UserRole {

        // 两种角色
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        public static final String ROLE_USER = "ROLE_USER";
    }
}
