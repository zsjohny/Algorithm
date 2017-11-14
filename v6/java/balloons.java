
class Solution {
    public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        nums.insert(nums.begin(), 1);
        nums.push_back(1);
        vector<vector<int> > dp(nums.size(), vector<int>(nums.size() , 0));
        return burst(nums, dp, 1 , n);
    }
    int burst(vector<int> &nums, vector<vector<int> > &dp, int left, int right) {
        if (left > right) return 0;
        if (dp[left][right] > 0) return dp[left][right];
        int res = 0;
        for (int k = left; k <= right; ++k) {
            res = max(res, nums[left - 1] * nums[k] * nums[right + 1] + burst(nums, dp, left, k - 1) + burst(nums, dp, k + 1, right));
        }
        dp[left][right] = res;
        return res;
    }
};