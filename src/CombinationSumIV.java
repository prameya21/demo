public class CombinationSumIV
{
    /*
        Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

        Example:

        nums = [1, 2, 3]
        target = 4

        The possible combination ways are:
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)

        Note that different sequences are counted as different combinations.

        Therefore the output is 7.


        Follow up:
        What if negative numbers are allowed in the given array?
        How does it change the problem?
        What limitation we need to add to the question to allow negative numbers?

        Credits:
        Special thanks to @pbrother for adding this problem and creating all test cases.
     */

    public int combinationSum4(int[] nums, int target)
    {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++)
            for(int x:nums)
                dp[i]+=i-x<0?0:dp[i-x];

        return dp[target];
    }


    public static void main(String[] args)
    {
        CombinationSumIV obj=new CombinationSumIV();
        System.out.println(obj.combinationSum4(new int[]{1,2,3},3));
    }
}
