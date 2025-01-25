package basic_practice.greedy;

import java.io.*;
import java.util.*;

public class 우체국_2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        List<Village> villages = new ArrayList<>();

        long totalPopulation = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            villages.add(new Village(x, a));
            totalPopulation += a;
        }

        Collections.sort(villages);
        long currentPopulation = 0;
        long halfPopulation = (totalPopulation + 1) / 2;

        for (Village village : villages) {
            currentPopulation += village.population;

            if (currentPopulation >= halfPopulation) {
                System.out.println(village.position);
                break;
            }
        }
    }

    static class Village implements Comparable<Village> {
        int position;
        int population;

        Village(int position, int population) {
            this.position = position;
            this.population = population;
        }

        @Override
        public int compareTo(Village o) {
            return Integer.compare(this.position, o.position);
        }
    }
}
