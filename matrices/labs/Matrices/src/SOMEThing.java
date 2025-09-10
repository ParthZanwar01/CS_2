public class SOMEThing {
    public static void main(String[] args) {

    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start>=nums.length) return target==0;
        if (start+1 < nums.length && nums[start] == nums[start+1]){
            int length = 0;
            for (int i = start;  i < nums.length; i++){
                if (nums[i] != nums[i+1]) break;
                length++;
            }
            return groupSumClump(start+length, nums, target-nums[start]*length) || groupSumClump(start+length, nums, target);
        }
        if (groupSumClump(start+1, nums, target-nums[start])) return true;
        return groupSumClump(start + 1, nums, target);
    }

}
