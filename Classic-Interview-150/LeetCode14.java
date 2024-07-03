//最长公共前缀
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String first=strs[0];
        StringBuilder prefix = new StringBuilder();
        for(int i=0;i<first.length();i++){
            char ch=first.charAt(i);
            int j=1;
            for(;j<strs.length;j++){
                if(strs[j].length()<=i||strs[j].charAt(i)!=ch){
                    break;
                }
            }
            if(j==strs.length){
                prefix.append(ch);
            }else{
                break;
            }
        }
        return prefix.toString();
    }
}
