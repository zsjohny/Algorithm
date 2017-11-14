class Solution:
    """
    @param height: A list of integer
    @return: The area of largest rectangle in the histogram
    """
    def largestRectangleArea(self, height):

        stack=[]; i=0; area=0
        while i<len(height):
            if stack==[] or height[i]>height[stack[len(stack)-1]]:
                stack.append(i)
            else:
                curr=stack.pop()
                width=i if stack==[] else i-stack[len(stack)-1]-1
                area=max(area,width*height[curr])
                i-=1
            i+=1
        while stack!=[]:
            curr=stack.pop()
            width=i if stack==[] else len(height)-stack[len(stack)-1]-1
            area=max(area,width*height[curr])
        return area

x = Solution()
print x.largestRectangleArea([2,2,5,6,2,3,7,7,4,9])
print x.largestRectangleArea([9,3,5,12,10,6,7,20,22,8,13])