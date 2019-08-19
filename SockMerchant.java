/*

John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Input Format

The first line contains an integer , the number of socks represented in .
The second line contains  space-separated integers describing the colors  of the socks in the pile.

Constraints

 where
Output Format

Return the total number of matching pairs of socks that John can sell.

Sample Input

9
10 20 20 10 10 30 50 10 20

Sample Output

3

*/

package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    public static Map<Integer,Integer> evaluateFrequencies(int n, int[] input){
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        for(int i: input){
            if(frequencies.containsKey(i))
                continue;
            int value = 0;
            for(int j: input){
                    if(!frequencies.isEmpty()) {
                        if(null != frequencies.get(i))
                            value = frequencies.get(i);
                    }
                    if(i==j)
                        frequencies.put(i, ++value);
                }
            }
        System.out.println(frequencies.toString());
        return frequencies;
    }

    public static int pairs(Map<Integer,Integer> frequencies){
        int pairs = 0;
        int odds = 0;
        for(Map.Entry<Integer, Integer> e: frequencies.entrySet()){
            if(e.getValue()%2==0)
                pairs = pairs+e.getValue()/2;
            else if(e.getValue()%2!=0 && e.getValue()>1){
                pairs = pairs+((e.getValue()-1)/2);
            }
            else if(e.getValue()==1)
                odds++;
        }
        System.out.println("Pairs = "+pairs);
        System.out.println("Odds = "+odds);
        return pairs;
    }

    public static void main(String[] args) {
        int[] input = {1 ,1 ,3 ,1 ,2 ,1 ,3 ,3 ,3 ,3};
        int n = 9;
        System.out.println(pairs(evaluateFrequencies(n, input)));

    }
}
