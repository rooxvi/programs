package io.ravi.programs;

public class ConvertDecimalToBinary {

    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(5));
    }
    public static long convertDecimalToBinary(int decimal){
        long binary = 0;
        int remainder;
        int i=1;
        while (decimal!=0){
            remainder = decimal % 2;
            System.out.print("remainder : "+remainder + " " );
            decimal /= 2;
            System.out.print("decimal : "+decimal + " " );
            binary += remainder * i;
            System.out.print("binary : "+binary + " " );
            i *=10;
            System.out.println(" ");
        }
        return binary;
    }
}
