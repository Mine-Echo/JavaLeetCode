//翻转单词序列

public class JZ73 {
    public String ReverseSentence(String str) {
        String[] arr =str.split(" ");
        StringBuilder sb =new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]);
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
