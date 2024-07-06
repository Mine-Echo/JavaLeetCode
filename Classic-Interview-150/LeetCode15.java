
//三数之和
import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;
// import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashSet;

public class LeetCode15 {

    // private List<List<Integer>> res;
    public  List<List<Integer>> threeSum(int[] nums) {
        // 暴力算法，超时
        // List<List<Integer>> result = new ArrayList<>();
        // for (int i = 0; i < nums.length - 2; i++) {
        //     for (int j = i + 1; j < nums.length - 1; j++) {
        //         for (int k = j + 1; k < nums.length; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> list = new ArrayList<>();
        //                 list.add(nums[i]);
        //                 list.add(nums[j]);
        //                 list.add(nums[k]);
        //                 result.add(list);
        //             }
        //         }
        //     }
        // }
        // // 加上网上的去重方法
        // ArrayList<List<Integer>> listSort = new ArrayList<>();
        // for (List<Integer> integers : result) {
        //     List<Integer> integersSort = integers.stream().sorted().collect(Collectors.toList());
        //     listSort.add(integersSort);
        // }
        // return listSort.stream().distinct().collect(Collectors.toList());

        // 自己想的一种On2的解法，排序+双指针（和官方的题解差不多）
        // 从小到大排序
        Arrays.sort(nums);
        // 用双指针
        List<List<Integer>> result = new ArrayList<>();
        int fix = 0;
        while (fix < nums.length - 2) {
            int left = fix + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[fix] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[fix]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    // 避免出现重复
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    // 避免出现重复
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            fix++;
            // 避免出现重复
            while (fix < nums.length && nums[fix] == nums[fix - 1]) {
                fix++;
            }
        }
        return result;

        // 网上看到的最快的做法，但是如果不用AbstractList而是直接在当前函数写init里面的代码的话速度就很慢，比上面我写的慢很多
        // return new AbstractList<List<Integer>>() {
        //     public List<Integer> get(int index) {
        //         init();
        //         return res.get(index);
        //     }

        //     public int size() {
        //         init();
        //         return res.size();
        //     }

        //     /**
        //      * 初始化操作，找到数组中所有满足条件的三元组
        //      */
        //     private void init() {
        //         if (res != null)
        //             return;

        //         Arrays.sort(nums);
        //         int l, r, sum;
        //         Set<List<Integer>> tempRes = new HashSet<>();

        //         // 遍历数组，找到所有不重复的三元组使得和为 0
        //         for (int i = 0; i < nums.length - 2; ++i) {
        //             l = i + 1;
        //             r = nums.length - 1;
        //             while (l < r) {
        //                 sum = nums[i] + nums[l] + nums[r];
        //                 if (sum == 0)
        //                     tempRes.add(Arrays.asList(nums[i], nums[l], nums[r]));
        //                 if (sum < 0)
        //                     ++l;
        //                 else
        //                     --r;
        //             }
        //         }
        //         res = new ArrayList<>(tempRes);
        //     }
        // };
    }

}
