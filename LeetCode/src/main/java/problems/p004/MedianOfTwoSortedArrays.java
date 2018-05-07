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
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
        	throw new NullPointerException();
        }
        
        if (nums1 == null || nums1.length == 0) {
        	return getMedian(nums2);
        }
        
        if (nums2 == null || nums2.length == 0) {
        	return getMedian(nums1);
        }
        
        if (nums1[nums1.length - 1] <= nums2[0]) {
        	getMedian(nums1, nums2);
        }
        
        if (nums2[nums2.length - 1] <=nums1[0]) {
        	return getMedian(nums2, nums1);
        }
		
		if ((nums1.length + nums2.length) % 2 == 0) {
			return (getElement(nums1, nums2, (nums1.length + nums2.length + 1) / 2)
					+ getElement(nums1, nums2, (nums1.length + nums2.length + 2) / 2))
					/ 2.0;
		} else {
			return getElement(nums1, nums2, (nums1.length + nums2.length + 1) / 2);
		}
    }
	
	private double getMedian(int[] nums) {
		if(nums.length % 2 == 1) {
			return nums[nums.length / 2];
		} else {
			return (nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2.0;
		}
	}
	
	private double getMedian(int[] nums1, int[] nums2) {
		int k1 = (nums1.length + nums2.length - 1) / 2;
        int k2 = (nums1.length + nums2.length) / 2;
        if (nums1.length == nums2.length) {
        	return (nums1[nums1.length - 1] + nums2[0]) / 2.0;
        }
        if (nums1.length > nums2.length) {
        	return (nums1[k1] + nums1[k2]) / 2.0;
        }
        return (nums2[k1 - nums1.length] + nums2[k2 - nums1.length]) / 2.0;
	}
	
	private int getElement(int[] nums1, int[] nums2, int k) {
		int start1 = 0;
		int start2 = 0;
		while(start1 < nums1.length && start2 < nums2.length) {
			if (k == 1) {
				return Math.min(nums1[start1], nums2[start2]);
			}
			
			int median1 = Integer.MAX_VALUE;
			int median2 = Integer.MAX_VALUE;
			
			if (start1 + k / 2 - 1 < nums1.length) {
				median1 = nums1[start1 + k / 2 - 1];
			}
			
			if (start2 + k /2 - 1 < nums2.length) {
				median2 = nums2[start2 + k / 2 - 1];
			}
			
			if (median1 < median2) {
				start1 += k / 2;
			} else {
				start2 += k / 2;
			}
			
			k -= k / 2;
		}
		 
		if(start1 >= nums1.length) {
			 return nums2[start2 + k - 1];
		 }
		 
		return nums1[start1 + k - 1]; 
	}
}
