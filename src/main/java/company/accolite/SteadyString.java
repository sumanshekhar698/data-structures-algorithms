package company.accolite;

import java.util.HashMap;

public class SteadyString {
//    https://www.hackerrank.com/challenges/bear-and-steady-gene/problem

    public static void main(String[] args) {
        String gene = "AAGTGCCT";
        System.out.println(steadyGene(gene));

    }

    public static int steadyGene(String gene) {// Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int n = gene.length();


        for (int i = 0; i < gene.length(); i++) {
            map.merge(gene.charAt(i), 1, Integer::sum);
        }

        int a[] = new int[256];
        int len = 0;
        for (char key : map.keySet()) {
            if (map.get(key) <= n / 4) {
                continue;
            } else {
                a[key] = map.get(key) - (n / 4);
                System.out.println(key + " " + a[key]);
                len += map.get(key) - (n / 4);
            }
        }
        if (len == 0) {
            return 0;
        }
        int c = 0;
        int start = 0;
        int ans = Integer.MAX_VALUE;
        int b[] = new int[256];
        for (int i = 0; i < n; i++) {
            b[gene.charAt(i)]++;
            if (b[gene.charAt(i)] <= a[gene.charAt(i)]) {
                c++;
            }
            if (c == len) {
                System.out.println(c);
                while (start < n && (b[gene.charAt(start)] > a[gene.charAt(start)]) || a[gene.charAt(start)] == 0) {
                    if (b[gene.charAt(start)] > a[gene.charAt(start)]) {
                        b[gene.charAt(start)]--;
                    }
                    start++;
                }
                if (i - start + 1 < ans) {
                    ans = i - start + 1;
                }
            }


        }
        return ans;


    }
}
