package company.dotdash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDomains {

    public static void main(String... args) {
        // input of counts, domain
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };


        Map<String, Integer> countMap = printClickCountByDomain(counts);

        // expected output
        // [com] => [1345]
        // [stackoverflow.com] => [10]
        // [sports.yahoo.com] => [50]
        // [google.com] => [900]
        // [sports] => [1]
        // [org] => [3]
        // [wikipedia.org] => [3]
        // [mobile.sports] => [1]
        // [mail.yahoo.com] => [60]
        // [en.wikipedia.org] => [2]
        // [mobile.sports.yahoo.com] => [10]
        // [uk] => [1]
        // [yahoo.com] => [410]
        // [com.com] => [5]
        // [m.wikipedia.org] => [1]
        // [google.co.uk] => [1]
        // [co.uk] => [1]
        // [overflow.com] => [20]


//        System.out.println(Arrays.toString("google.com".split("\\.")));
        for (String key : countMap.keySet()) {
            System.out.println(String.format("[%s] => [%d]\n", key, countMap.get(key)));
        }
    }

    private static Map<String, Integer> printClickCountByDomain(String[] counts) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String count : counts) {
            String[] split = count.split(",");

            int freq = Integer.parseInt(split[0]);
//            System.out.println(freq);


            ArrayList<String> subDomainStrings = splitSubDomains(split[1]);
            for (String subDomain : subDomainStrings) {
                if (map.containsKey(subDomain)) {
                    map.put(subDomain, map.get(subDomain) + freq);
                } else {
                    map.put(subDomain, freq);

                }
            }

        }

        return map;

    }

    private static ArrayList<String> splitSubDomains(String countStr) {

//        'google.co.uk', 'co.uk', 'uk'
        ArrayList<String> subDomains = new ArrayList<>();
        String[] split = countStr.split("\\.");//NOW WORKING


        String temp = "";
        if (split.length > 0) {
            temp = split[split.length - 1];
            subDomains.add(temp);
        }

        for (int i = split.length - 2; i >= 0; i--) {
            temp = split[i] + "." + temp;
            subDomains.add(temp);
        }

        return subDomains;


    }
}
