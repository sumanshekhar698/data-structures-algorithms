package company.microsoft_dublin;

import java.util.*;

class MaxPermissibleBuildingHeight {

    public static void main(String[] args) {
        MaxPermissibleBuildingHeight solution = new MaxPermissibleBuildingHeight();
        int[] arr1 = {9, 4, 3, 7, 7};//max possible building height
        //Rules No two building of same height and maximize the sum heights of the building

        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(solution.solution(arr1)));
    }

    public int[] solution(int[] A) {
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(new AbstractMap.SimpleEntry<>(A[i], i));
        }

        Collections.sort(list, (x, y) -> -x.getKey().compareTo(y.getKey()));

        int current = Integer.MAX_VALUE;
        int[] heights = new int[A.length];
        int[] results = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            heights[i] = Math.min(current, list.get(i).getKey());
            current = heights[i] - 1;

            results[list.get(i).getValue()] = heights[i];
        }

        return results;
    }
}