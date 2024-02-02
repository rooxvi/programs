package io.ravi.sony;

//Largest drop (Easy)
//Given an array of temperature for each day of the week consecutively.
//
//Find the largest drop of temperature between any 2 days.
//
//| Mon | Tues | Wed | Thurs | Fri | Sat | Sun |
//        |-----+------+-----+-------+-----+-----+-----|
//        | 76  | 72   | 80  | 78    | 68  | 72  | 82  |
//
//Result: 12
//
//The biggest drop is between Wed and Friday (80 → 68)
public class LargestTemperatureDrop {

    // Function to find the largest temperature drop
    // Time complexity: O(n)
    public static int findLargestTemperatureDrop(int[] temperatures) {
        if (temperatures == null || temperatures.length < 2) {
            throw new IllegalArgumentException("At least two days' temperatures are required");
        }

        int largestDrop = 0;
        int currentHighestTemp = temperatures[0];

        for (int i = 1; i < temperatures.length; i++) {
            if(currentHighestTemp < temperatures[i]){
                currentHighestTemp = temperatures[i];
            }
            largestDrop = Math.max(largestDrop, temperatures[i - 1] - temperatures[i]);
            largestDrop = Math.max(largestDrop,currentHighestTemp - temperatures[i]);
        }

        return largestDrop;
    }

    public static void main(String[] args) {
        // Example array of temperatures
        int[] temperatures = {76, 72, 80, 78, 68, 72, 82};

        // Finding the largest temperature drop
        int result = findLargestTemperatureDrop(temperatures);

        // Displaying the result
        System.out.println("Largest temperature drop: " + result);
    }

}
