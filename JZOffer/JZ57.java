
//和为S的两个数字
import java.util.ArrayList;

public class JZ57 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        // 暴力遍历法
        // ArrayList<Integer> ret = new ArrayList<>();
        // for (int i = 0; i < array.length; i++) {
        // for (int j = i + 1; j < array.length; j++) {
        // if ((array[i] + array[j]) == sum) {
        // ret.add(array[i]);
        // ret.add(array[j]);
        // return ret;
        // }
        // }
        // }
        // return ret;

        // 网上看到的，用两个指针，一个指向最低，一个指向最高
        int left = 0, right = array.length - 1;
        ArrayList<Integer> ret = new ArrayList<>();
        while (left < right) {
            int s = array[left] + array[right];
            if (s < sum)
                left++;
            else if (s > sum)
                right--;
            else {
                ret.add(array[left]);
                ret.add(array[right]);
                return ret;
            }
        }
        return ret;
    }
}