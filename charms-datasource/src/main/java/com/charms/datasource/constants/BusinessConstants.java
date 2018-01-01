package com.charms.datasource.constants;

public class BusinessConstants {
    public static final String READ_AOP = "execution(* com.charms..*.service..*.find*(..)) "
            + "or execution(* com.charms..*.service..*.get*(..)) "
            + "or execution(* com.charms..*.service..*.load*(..)) "
            + "or execution(* com.charms..*.service..*.query*(..)) "
            + "or execution(* com.charms..*.service..*.select*(..)) "
            + "or execution(* com.charms..*.service..*.list*(..)) ";

    public static final String WRITE_AOP = "execution(* com.charms.*.service..*.insert*(..)) "
            + "or execution(* com.charms..*.service..*.save*(..)) "
            + "or execution(* com.charms..*.service..*.modify*(..)) "
            + "or execution(* com.charms..*.service..*.add*(..)) "
            + "or execution(* com.charms..*.service..*.del*(..)) "
            + "or execution(* com.charms..*.service..*.real*(..)) "
            + "or execution(* com.charms..*.service..*.retreat*(..)) "
            + "or execution(* com.charms..*.service..*.register*(..)) "
            + "or execution(* com.charms..*.service..*.record*(..)) "
            + "or execution(* com.charms..*.service..*.lock*(..)) ";

    public static final String READ_METHOD = "^(find|get|load|query|select|list).*$";

    public static final String WRITE_METHOD = "^(modify|insert|update|modify|save|add|del|real|retreat|register|record|lock).*$";
}
