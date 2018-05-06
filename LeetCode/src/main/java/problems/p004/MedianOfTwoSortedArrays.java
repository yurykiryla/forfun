package problems.p004;

/**
 * 
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be 
 * O(log (m+n)).
 * 
 * @author Катя
 *
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1 = 0;
        int start2 = 0;
        int end1 = nums1.length - 1;
        int end2 = nums2.length - 1;
        int mid1 = 0;
        int mid2 = 0;

        while (start1 < end1 || start2 < end2) {
            mid1 = (end1 - start1) / 2 + start1;
            mid2 = (end2 - start2) / 2 + start2;
            
            if (nums1[mid1] < nums2[mid2]) {
                start1 = mid1 + 1;
                end2 = mid2;
            } else {
                end1 = mid1;
                start2 = mid2 + 1;
            }
        }
        if (nums1[start1] == nums2[start2]) {
            return nums1[start1];
        } else if((nums1.length + nums2.length) % 2 == 0){
            return (nums1[start1] + nums2[start2]) / 2.0;
        } else if(nums1[start1] < nums2[start2] 
        		&& start1 + start2 == nums1.length - start1 - 1 + nums2.length - start2) {
            return nums1[start1];
        } else {
            return nums2[start2];
        }
    }
}
