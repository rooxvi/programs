package io.ravi.programs;

public class ReverseNumber {

    public static void main(String[] args) {
        reverse(12345,0);
    }

    public static void reverse(int number) {
        if (number < 10) {
            System.out.print(number);
            return;
        }
        System.out.print(number % 10);
        reverse(number / 10);
    }

    public static void reverse(int number,int sum){
        if(number == 0){
            System.out.println(sum);
            return;
        }

        if(number > 0){
            sum = sum * 10 + (number%10);
        }
        reverse(number/10,sum);
    }
}


class ReverseInt{
    public static void main(String[] args) {
        int x = -1463847412;
        System.out.println(x );
        System.out.println(reverse(x));
    }

    public static int reverse(int x){
        return reverse(x,0);
    }

    private static int reverse(int x,int value){
        if(x==0){
            return value;
        }
        int rem =  x%10;
        if(value < Integer.MIN_VALUE/10 || (value == Integer.MIN_VALUE/10 && rem < Integer.MIN_VALUE%10)){ //Integer.MIN_VALUE%10 = -8
            return 0;
        }

        if(value > Integer.MAX_VALUE/10 || (value == Integer.MAX_VALUE/10 && rem > Integer.MAX_VALUE%10)){ //Integer.MAX_VALUE%10 = 7
            return 0;
        }
        value = value * 10 + rem;
        return reverse(x/10,value);

    }
}
