//扑克牌顺子
public class JZ61 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组
     * @return bool布尔型
     */
    public boolean IsContinuous(int[] numbers) {
        // write code here
        // 从小到大冒泡排序
        // Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length-i; j++) {
                if (numbers[j - 1] > numbers[j]) {
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        int count = 0;
        while (count < numbers.length && numbers[count] == 0) {
            count++;
        }
        for (int i = count+1; i < numbers.length; i++) {
            int sub=numbers[i]-numbers[i-1];
            if(sub==1){
                continue;
            }else if(sub>1){
                count-=sub-1;
                if(count<0)
                    return false;
            }else if(sub==0){
                return false;
            }
        }
        return true;
    }
}