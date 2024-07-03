//整数转罗马数字
public class LeetCode12 {
    public String intToRoman(int num) {
        StringBuilder roman=new StringBuilder();
        while(num>0){
            int highest=num/(int)Math.pow(10,(int)Math.log10(num));
            if(highest==4||highest==9){
                if(num-900>=0){
                    num-=900;
                    roman.append("CM");
                }else if(num-400>=0){
                    num-=400;
                    roman.append("CD");
                }else if(num-90>=0){
                    num-=90;
                    roman.append("XC");
                }else if(num-40>=0){
                    num-=40;
                    roman.append("XL");
                }else if(num-9>=0){
                    num-=9;
                    roman.append("IX");
                }else{
                    num-=4;
                    roman.append("IV");
                }
            }else{
                if(num-1000>=0){
                    num-=1000;
                    roman.append('M');
                }else if(num-500>=0){
                    num-=500;
                    roman.append('D');
                }else if(num-100>=0){
                    num-=100;
                    roman.append('C');
                }else if(num-50>=0){
                    num-=50;
                    roman.append('L');
                }else if(num-10>=0){
                    num-=10;
                    roman.append('X');
                }else if(num-5>=0){
                    num-=5;
                    roman.append('V');
                }else{
                    num-=1;
                    roman.append("I");
                }
            }
        }
        return roman.toString();
    }
}
