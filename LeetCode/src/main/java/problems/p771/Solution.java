package problems.p771;

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 * 
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, 
 * so "a" is considered a different type of stone from "A".
 * 
 * @author Yury_Kiryla
 *
 */
public class Solution {
	public int numJewelsInStones(String J, String S) {

		return (int) S.chars()
				.mapToObj(x -> (char) x)
				.filter(x -> J.contains(x.toString()))
				.count();
	}
}
