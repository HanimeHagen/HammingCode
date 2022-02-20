package de.hanimehagen.hammingcode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        int result = 0;

        for(int i = 0; calcPower(2, i) <= input.length(); i++) {
            if(!String.valueOf(input.charAt(calcPower(2, i) - 1)).equalsIgnoreCase(checkKBit(i, input))) {
                result += calcPower(2, i);
            }
        }

        if(result != 0) {
            System.out.println("There was an Error with the Bit at position " + result);
        } else {
            System.out.println("There was no error");
        }

    }

    public static int calcPower(int base, int exponent) {
        int result = 1;
        for(; exponent != 0; --exponent) {
            result *= base;
        }
        return result;
    }

    public static String checkKBit(int kBit, String input) {
        int p = calcPower(2, kBit);
        int k = p - 1;
        int temp = 0;
        String sub = input.substring(k);
        int index = 0;
        boolean add = true;
        for(int i = 0; i < sub.length(); i++) {
            if(add && i != 0 && sub.charAt(i) == '1') {
                temp++;
            }
            index++;
            if(index >= p) {
                index = 0;
                add = !add;
            }
        }
        if ((temp % 2) == 0) {
            return "0";
        } else {
            return "1";
        }
    }

}
