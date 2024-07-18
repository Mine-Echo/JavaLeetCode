
//坐标移动
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] moves = input.split(";");
        int x = 0, y = 0;
        for (int i = 0; i < moves.length; i++) {
            String move = moves[i];
            // System.out.println(move);
            if (move == null || move.equals("") || move.length() > 3)
                continue;
            try {
                int num = Integer.parseInt(move.substring(1));
                switch (move.charAt(0)) {
                    case 'A':
                        x -= num;
                        break;
                    case 'D':
                        x += num;
                        break;
                    case 'W':
                        y += num;
                        break;
                    case 'S':
                        y -= num;
                        break;
                    default:
                        continue;
                }
            } catch (Exception e) {

            }
        }
        System.out.println(x + "," + y);
        in.close();
    }
}