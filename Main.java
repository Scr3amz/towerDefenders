import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),
            m = scanner.nextInt();
        int [] platesWidth = new int[n];
        int [] shouldersWidth = new int[m];
        int maxVolunteerCount = 0;

        for (int i = 0; i < n; i++) {
            platesWidth[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            shouldersWidth[i] = scanner.nextInt();
        }

        int lightMax = platesWidth[n-1];
        int[] lightWidth = new int[n];
        lightWidth[n-1] = lightMax;
        int freePlatesCount = 1;
        if (n>1) {
            for (int i = n - 2; i >= 0; i--) {
                if (platesWidth[i] > lightMax) {
                    lightWidth[i] = platesWidth[i] - lightMax;
                    freePlatesCount += 1;
                    lightMax = platesWidth[i];
                } else {
                    lightWidth[i] = 0;
                }
            }
        } else {
            lightWidth[0] = platesWidth[0];
        }
        Arrays.sort(lightWidth);
        Arrays.sort(shouldersWidth);

        for (int person = m-1; person>=0 && maxVolunteerCount < freePlatesCount; person --) {

            for (int plate = n-1 - maxVolunteerCount; plate >=0; plate--) {

                if (shouldersWidth[person] <= lightWidth[plate]) {
                    maxVolunteerCount += 1;
                    break;
                } else {
                    break;
                }
            }
        }

        System.out.println("\n" + maxVolunteerCount);
    }
}