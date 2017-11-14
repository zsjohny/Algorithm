import collections

class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        n = len(nums)
        cntDict = collections.defaultdict(int)
        for i in nums:
            cntDict[i] += 1
        freqList = [[] for i in range(n + 1)]
        for p in cntDict:
            freqList[cntDict[p]] += p,
        ans = []
        for p in range(n, 0, -1):
            ans += freqList[p]
        return ans[:k]


x = Solution()
print x.topKFrequent([1,2,2,3,3,4,4,4,4,4,4,4,4,4,4,4,1,1,2,2,3], 3)
print x.topKFrequent([1,3,2,4,5,3,4,5,2,3,4,5,4,4,2,3,3], 2)