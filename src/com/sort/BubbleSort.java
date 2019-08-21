package com.sort;

import java.util.Arrays;
import com.sort.common.CreateArray;

/**
 *	冒泡排序算法:
 *	x x x x x x x x x x x
 *  i                   j
 *  i j
 *    i                 j
 *  ...
 *	i表示轮数，每轮j和j-1比较，小值往前换位，j--，直到与i相遇，第一轮结束，i++，j回到末尾继续下一轮
 *
 * @author LIDONGSHU
 */

public class BubbleSort {
	public static void main(String[] args) {
		//调用方法生成20长度的随机整数数组
		int[] arr = CreateArray.newArray(20);
		
		//执行冒泡排序算法给list排序，返回排序后的新数组
		int[] array = bubbleSort(arr);
		System.out.println(Arrays.toString(array));
	}

	//冒泡排序算法
	private static int[] bubbleSort(int[] arr) {
		//i表示轮数
		for (int i = 0; i < arr.length-1; i++) {
			//j表示每轮从末尾开始遍历，较小值不断往前调换
			for (int j = arr.length-1; j > i; j--) {
				if(arr[j] < arr[j-1]) {
					//较小值往前换位
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}
}
