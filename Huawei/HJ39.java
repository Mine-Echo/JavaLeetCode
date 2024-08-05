
//判断两个IP是否属于同一子网
import java.util.Scanner;

public class HJ39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] maskStr = in.nextLine().split("\\.");
        String[] ip1Str = in.nextLine().split("\\.");
        String[] ip2Str = in.nextLine().split("\\.");
        in.close();
        int[] mask = transferToIntArray(maskStr);
        int[] ip1 = transferToIntArray(ip1Str);
        int[] ip2 = transferToIntArray(ip2Str);

        if (checkSubnetMask(mask) && checkIp(ip1) && checkIp(ip2)) {
            int childNet = mask[0] * 256 * 256 * 256
                    + mask[1] * 256 * 256
                    + mask[2] * 256 + mask[3];
            int ipInt1 = ip1[0] * 256 * 256 * 256
                    + ip1[1] * 256 * 256
                    + ip1[2] * 256 + ip1[3];
            int ipInt2 = ip2[0] * 256 * 256 * 256
                    + ip2[1] * 256 * 256
                    + ip2[2] * 256 + ip2[3];
            if ((ipInt1 & childNet) == (ipInt2 & childNet))
                System.out.println(0);
            else
                System.out.println(2);
        } else
            System.out.println(1);
    }

    public static int[] transferToIntArray(String[] stringArray) {
        int[] ret = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            ret[i] = Integer.parseInt(stringArray[i]);
        }
        return ret;
    }

    public static boolean checkSubnetMask(int[] mask) {
        int flag = 0;
        for (int i = 0; i < mask.length; i++) {
            int num = mask[i];
            if (flag == 1) {
                if (num != 0) {
                    return false;
                }
            } else {
                if (num == 0 || num == 128 || num == 192 || num == 224 || num == 240 ||
                        num == 248 ||
                        num == 252 ||
                        num == 254) {
                    flag = 1;
                } else if (num != 255) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkIp(int[] ip) {
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] > 255 || ip[i] < 0) {
                return false;
            }
        }
        return true;
    }
}