package com.maximopol.mycalc.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static String prepareStr(String str) {
        return str.
                replaceAll(" ", "").
                replaceAll("^-", "0-").
                replaceAll("\\(-", "(0-").
                replaceAll("e", Math.E + "").
                replaceAll("π", Math.PI + "").
                replaceAll("[-+*/]$", "");
    }

    public Parser() {
    }

    private boolean find(String str, String symbol) {
        Pattern pattern = Pattern.compile(symbol);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private String parse(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        matcher.find();

        String calculate_str = matcher.group(1);

        if (!Operation.isDouble(calculate_str)) {
            calculate_str = " " + Calculable.run(convertToExpression(calculate_str.split(" ")));
        }
        return str.replace(str.substring(matcher.start(), matcher.end()), calculate_str);
    }

    private String convertToExpression(String str) {
        for (String operation : new String[]{"-", "\\+", "\\*", "/", "\\^", "!"}) {
            str = str.replaceAll(operation, " " + operation + " ");
        }
        str = str.replaceAll("\\(", "\\( ");
        str = str.replaceAll("\\)", " \\)");

        return str;
    }

    private String[] convertToExpression(String[] str) {
        ArrayList<String> filter = new ArrayList<>();

        for (String atom : str) {
            if (atom.length() != 0) {
                filter.add(atom);
            }
        }
        Object[] arr = filter.toArray();

        return Arrays.copyOf(arr, arr.length, String[].class);
    }

    public String getExpression(String str) {

        str = convertToExpression(str);

        while (find(str, "\\(")) {

            str = parse(str, "\\(([^\\(\\)]*)\\)");
        }

        str = " " + Calculable.run(convertToExpression(str.split(" ")));
        return str.replaceAll(" ", "");
    }
}
