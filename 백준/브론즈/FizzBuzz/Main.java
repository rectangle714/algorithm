package 백준.브론즈.FizzBuzz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = 0;
        for(int i = 0; i < 3; i++) {
            try {
                val = Integer.parseInt(br.readLine());
            } catch (Exception exception) { }

            val++;
        }

        if(val % 3 == 0) {
            if(val % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else {
            if(val % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(val);
            }
        }
    }
}
