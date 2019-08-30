public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canCross(new int[]{
                0,1,3,4,5,7,9,10,12}));
    }

    public boolean canCross(int[] stones) {
        if(stones.length > 2){
            for(int i = stones.length-2;i>0;i--){
                if((stones[i]-stones[0])+1 < stones[i+1] - stones[i]){
                    return false;
                }
            }
        }
        return jump(stones, 0, 0);
    }


    public boolean jump(int[] stones, int currPos, int prevJump) {
        boolean result = false;
        for (int i = stones.length - 1; i > currPos; i--) {
            int length = stones[i] - stones[currPos];
            if (length <= prevJump + 1 && length >= prevJump - 1) {
                if (i == stones.length - 1) {
                    result = true;
                    break;
                } else {
                    result = jump(stones, i, stones[i] - stones[currPos]);
                    if (result) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}