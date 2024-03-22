package company.hdfcbank;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String str = "hello world";

//        R collect = str.chars().collect(Collectors.toSet());
        System.out.println();

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));

        }

        set.stream().forEach(System.out::println);
        System.out.println();

        int test = test();
        System.out.println(test);


    }

    private static int test() {

        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

}
