package com.companies;

public class CamelToSnakeWisen {
    public static void main(String[] args) {
        // Given string str
        String str = "whatIsYourName";
        // Print the modified string
        System.out.print(camelToSnake(str));
    }

    public static String camelToSnake(String str) {

        StringBuilder result = new StringBuilder("");
        if (str.length() == 0)
            return result.toString();

        StringBuilder tempSb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {

            if (Character.isUpperCase(str.charAt(i))) {
                result.append(tempSb.toString().toUpperCase() + "_");

                tempSb.delete(0, tempSb.length());
                tempSb.append(str.charAt(i));
                continue;
            }
            tempSb.append(str.charAt(i));

        }

        return result.toString() + tempSb.toString().toUpperCase();
    }
}