
//汇总区间
import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length <= 0)
            return result;
        int index = 0;
        while (index < nums.length) {
            int start = nums[index];
            while (++index < nums.length && nums[index] == nums[index - 1] + 1)
                ;
            int end = nums[index - 1];
            if (start == end)
                result.add(Integer.toString(start));
            else {
                //这里用StringBuilder的话测试速度能超过100%，用String只能超过40%左右
                StringBuilder sb = new StringBuilder();
                sb.append(start).append("->").append(end);
                result.add(sb.toString());
            }

        }
        return result;
    }
}
