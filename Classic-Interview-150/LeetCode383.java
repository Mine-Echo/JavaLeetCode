//赎金信
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[26];
        char[] magazineChar = magazine.toCharArray();
        char[] ransomNoteChar = ransomNote.toCharArray();
        for (int i = 0; i < magazineChar.length; i++) {
            nums[magazineChar[i] - 97]++;
        }
        for (int i = 0; i < ransomNoteChar.length; i++) {
            nums[ransomNoteChar[i] - 97]--;
            if (nums[ransomNoteChar[i] - 97] < 0)
                return false;
        }
        return true;
    }
}
