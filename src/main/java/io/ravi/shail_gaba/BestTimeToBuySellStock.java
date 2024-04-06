package io.ravi.shail_gaba;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        //int[] arr = {7, 1, 5, 3, 6, 4}; // 5
        int[] arr = {7,6,4,3,1}; //0
        System.out.println(profit(arr));
    }

    private static int profit(int[] array) {
        int currentLow = Integer.MAX_VALUE;
        int currentMaxProfit = 0;

        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] < array[index + 1]) {
                currentMaxProfit = Math.max(currentMaxProfit, array[index + 1] - array[index]);
            }

            if (currentLow > array[index]){
                currentLow = array[index];
            }

            currentMaxProfit = Math.max(currentMaxProfit, array[index] - currentLow);
        }

        return currentMaxProfit;
    }

    private static int profit1(int[] array) {
        int currentLowPrice = array[0];
        int currentMaxProfit = 0;

        for (int index = 1; index < array.length; index++) {
            int currentProfit = array[index] - currentLowPrice;
            currentMaxProfit = Math.max(currentMaxProfit, currentProfit);
            currentLowPrice = Math.min(currentLowPrice,array[index]);
        }

        return currentMaxProfit;
    }
}
