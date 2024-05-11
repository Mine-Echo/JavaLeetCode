class LCR122 {
    public static String pathEncryption(String path) {
        //方法1 调库
        // return path.replace("."," ");

        //方法2 自己实现
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='.')
                sb.append(' ');
            else
                sb.append(path.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(pathEncryption("abc.def.ghi.jkl"));
    }
}