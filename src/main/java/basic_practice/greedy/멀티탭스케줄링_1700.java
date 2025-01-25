package basic_practice.greedy;

import java.util.*;

public class 멀티탭스케줄링_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] appliances = new int[k];
        for (int i = 0; i < k; i++) {
            appliances[i] = sc.nextInt();
        }

        Set<Integer> pluggedIn = new HashSet<>();
        int plugOutCount = 0;

        for (int i = 0; i < k; i++) {
            int currentAppliance = appliances[i];

            if (pluggedIn.contains(currentAppliance)) {
                continue;
            }

            if (pluggedIn.size() < n) {
                pluggedIn.add(currentAppliance);
                continue;
            }

            int farthestIndex = -1;
            int applianceToUnplug = -1;

            for (int plugged : pluggedIn) {
                int nextUseIndex = 0;
                for (int j = i + 1; j < k; j++) {
                    if (appliances[j] == plugged) {
                        nextUseIndex = j;
                        break;
                    }
                }

                if (nextUseIndex == 0) {
                    applianceToUnplug = plugged;
                    break;
                }
                if (nextUseIndex > farthestIndex) {
                    farthestIndex = nextUseIndex;
                    applianceToUnplug = plugged;
                }
            }


            pluggedIn.remove(applianceToUnplug);
            plugOutCount++;
            pluggedIn.add(currentAppliance);
        }

        System.out.println(plugOutCount);
    }
}
