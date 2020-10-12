package com.maximopol.mycalc.logic;

public class Parser {
    public static String prepareStr(String str){
//        Math.E;
//        Math.PI;
        return str.
                replaceAll(" ", "").
                replaceAll("^-", "0-").
                replaceAll("\\(-", "(0-");
    }
}
