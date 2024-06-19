
//O1时间的插入，删除和获取随机元素
import java.util.*;

class RandomizedSet {

    // Set<Integer> set = new HashSet<Integer>();
    // Random random = new Random();

    // public RandomizedSet() {

    // }

    // public boolean insert(int val) {
    //     if (!set.contains(val)) {
    //         set.add(val);
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean remove(int val) {
    //     if (set.contains(val)) {
    //         set.remove(val);
    //         return true;
    //     }
    //     return false;
    // }

    // public int getRandom() {
    //     // hash set的随机访问需要先转换为ArrayList，时间复杂度为On
    //     return new ArrayList<>(set).get(random.nextInt(set.size()));
    // }

    //想让随机访问为O1，需要用ArrayList来存储元素
    //为了保持插入和删除O1，必须要hash map记录索引值和索引
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;
    public RandomizedSet() {
        nums = new ArrayList<>();
        indices=new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(!indices.containsKey(val)){
            indices.put(val,nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(indices.containsKey(val)){
            int index=indices.get(val);
            int last = nums.get(nums.size()-1);
            nums.set(index,last);
            nums.remove(nums.size()-1);
            indices.put(last,index);
            indices.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}