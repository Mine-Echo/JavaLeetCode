//验证回文串
public class LeetCode125 {
    public static boolean isPalindrome(String s) {
        // String str=s.replaceAll("[^0-9a-zA-Z]", "");
        // str=str.toLowerCase();
        // int left=0,right = str.length()-1;
        // while(left<right){
        // if(str.charAt(left)==str.charAt(right)){
        // left++;
        // right--;
        // }else {
        // return false;
        // }
        // }
        // return true;

        // 原地判断，Java库里有提供一些函数Character.isLetterOrDigit(s.charAt(left)
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while(left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
    }
}
