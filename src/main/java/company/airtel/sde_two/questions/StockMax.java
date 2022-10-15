package company.airtel.sde_two.questions;

public class StockMax {

    public static void main(String[] args) {
        int[] sample = {7, 14, 2, 18, 24};
        int profit = maxProfit(sample);
        System.out.println(profit);
        profit = maxProfitOnce(sample);
        System.out.println(profit);
    }

    private static int maxProfit(int[] sample) {

        int maxProfit = 0;
        for (int i = 0; i < sample.length - 1; i++) {
            if (sample[i + 1] > sample[i])
                maxProfit += sample[i + 1] - sample[i];
        }

        return maxProfit;
    }

    private static int maxProfitOnce(int[] sample) {

//        7, 14, 2, 18, 24
        int min = Integer.MAX_VALUE;
        int maxProfitSingleDay = 0;
        for (int i = 0; i < sample.length; i++) {
            min = Integer.min(min, sample[i]);
            maxProfitSingleDay = Integer.max(maxProfitSingleDay, sample[i] - min);
        }

        return maxProfitSingleDay;
    }
}
