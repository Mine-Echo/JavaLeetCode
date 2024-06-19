//论文的H指数

// import java.util.Arrays;
// import java.util.Comparator;

public class LeetCode274 {
    public int hIndex(int[] citations) {
        // 遍历一边数组
        // num[i]记录引用数位i的论文数
        // int[] num = new int[1000 + 1];
        // for (int i = 0; i < citations.length; i++) {
        //     num[citations[i]]++;
        // }
        // int h = num.length - 1;
        // int count = 0;
        // for (; h >= 0; h--) {
        //     count += num[h];
        //     if (count >= h)
        //         break;
        // }
        // return h;

        // 网上的解法：排序然后比较下标和元素，时间复杂度比较高Onlogn
        // Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        // Arrays.sort(arr, Comparator.reverseOrder());
        // for (int i = arr.length - 1; i >= 0; i--) {
        //     if (arr[i] >= i + 1)
        //         return i + 1;
        // }
        // return 0;

        // 我的方法还可以再次改进一下，降低一点空间复杂度
        int[] num = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length)
                num[citations.length]++;
            else
                num[citations[i]]++;
        }
        int h = num.length - 1;
        int count = 0;
        for (; h >= 0; h--) {
            count += num[h];
            if (count >= h)
                break;
        }
        return h;

    }
}
