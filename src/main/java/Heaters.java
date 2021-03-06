import java.util.Arrays;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class Heaters {
//    public int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
//
//        int j = 0, result = 0;
//        for (int i = 0; i < houses.length; i++) {
//            int currentHouse = houses[i];
//            while (j + 1 < heaters.length && Math.abs(currentHouse - heaters[j + 1]) <= Math.abs(currentHouse - heaters[j])) {
//                j++;
//            }
//            result = Math.max(result, Math.abs(heaters[j] - currentHouse));
//        }
//        return result;
//    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int index = Arrays.binarySearch(heaters, houses[i]);
            if (index < 0) { // Note that this guarantees that the return value will be >= 0 if and only if the key is found
                index = (-1) * (index + 1);
            }
            int dist1 = index == 0 ? Integer.MAX_VALUE : Math.abs(houses[i] - heaters[index - 1]); //小于我的
            int dist2 = index == heaters.length ? Integer.MAX_VALUE : Math.abs(houses[i] - heaters[index]); // 大于等于我的
            result = Math.max(result, Math.min(dist1, dist2));
        }
        return result;
    }

    public static void main(String[] args) {
//        Heaters test = new Heaters();
//        System.out.print(test.findRadius(a, b));

        int[] a = {1,2,3};
        System.out.print(Arrays.binarySearch(a, 0));
    }

}
