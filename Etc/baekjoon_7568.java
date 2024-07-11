package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 덩치 */
public class baekjoon_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            list.add(new Person(weight, height));
        }

        for(int i=0; i<n; i++) {
            int rank = n;

            for(int j=0; j<n; j++) {
                if(i == j) { continue; }

                // 키와 몸무게가 같거나 더 작은 값일 때 rank를 올려준다.
                if(list.get(i).height > list.get(j).height || list.get(i).height == list.get(j).height) {
                    rank--;
                } else if(list.get(i).weight > list.get(j).weight || list.get(i).weight == list.get(j).weight) {
                    rank--;
                }
            }

            System.out.print(rank + " ");
        }

    }
}

class Person {
    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}