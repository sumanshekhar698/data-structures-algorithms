package company.microsoft_dublin;

public class NeighbourHoodSustainablity {

    public static void main(String[] args) {
        NeighbourHoodSustainablity village = new NeighbourHoodSustainablity();
        int arr[] = {1, -3, 2};
        int arr2[] = {-3, 2, 4, -5, 3};
        int arr3[] = {-2, 1, -3, 1};

        System.out.println(village.solution(arr3));
    }

    public int solutionCommented(int[] A) {

        int n = A.length, res = 0;

        for (int i = 0; i < n; i++) {        // iterating through buildings
            if (A[i] < 0) {
                int min = Integer.MAX_VALUE;
                if (i > 0) min = A[i - 1];
                if (i < n - 1) min = Math.min(min, A[i + 1]);     // min = minimum from either side

                if (min >= 0 && min + A[i] >= 0) continue;
                else {
                    int diff = Math.abs(A[i] + min);             // remaining pollution between forests and buildings
                    res += diff;
                    A[i] += diff;                 // update current elem
                }
            }
        }

        for (int i = 0; i < n; i++) {           // iterating through forests
            if (A[i] >= 0) {
                int adj = 0;
                if (i > 0) adj = A[i - 1];
                if (i < n - 1) adj += A[i + 1];

                if (adj + A[i] >= 0) continue;
                else {
                    int diff = Math.abs(A[i] + adj);
                    res += diff;
                    A[i] += diff;
                }
            }
        }

        return res;
    }

    public int solution(int[] A) {

        int n = A.length, res = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                int min = Integer.MAX_VALUE;
                if (i > 0) min = A[i - 1];
                if (i < n - 1) min = Math.min(min, A[i + 1]);

                if (min >= 0 && min + A[i] >= 0) continue;
                else {
                    int diff = Math.abs(A[i] + min);
                    res += diff;
                    A[i] += diff;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] >= 0) {
                int adj = 0;
                if (i > 0) adj = A[i - 1];
                if (i < n - 1) adj += A[i + 1];

                if (adj + A[i] >= 0) continue;
                else {
                    int diff = Math.abs(A[i] + adj);
                    res += diff;
                    A[i] += diff;
                }
            }
        }

        return res;
    }
}
