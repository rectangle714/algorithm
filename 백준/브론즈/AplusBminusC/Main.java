package 백준.브론즈.AplusBminusC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int c = Integer.parseInt(br.readLine());

        System.out.println(Integer.parseInt(a) + Integer.parseInt(b) - c);
        System.out.println(Integer.parseInt(a + b) - c);
    }
}
