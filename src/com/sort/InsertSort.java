package com.sort;

import java.util.Arrays;
import com.sort.common.CreateArray;

/**
 * 直接插入排序算法
 * 
 * x x x x x x x x x x x x x
 *     i
 *         j
 *         
 * j从1开始遍历，记录每轮要比较的数的起始位置；
 * 每轮i从j的位置出发，与前值比较，较小值往前置换，i记录本轮被排序数的位置。
 * 
 * @author LIDONGSHU
 */
public class InsertSort {
	public static void main(String[] args) {
		//生成20长度的随机整数数组
		int[] arr = CreateArray.newArray(20);
		System.out.println(Arrays.toString(arr));
		
		//执行直接插入排序算法排序
		int[] array = insertSort(arr);
		System.out.println(Arrays.toString(array));
	}
	
	//直接插入排序算法
	private static int[] insertSort(int[] arr) {
		//从位置1开始每轮遍历
		for (int j = 1; j < arr.length; j++) {
			//i从j的位置依次与前值比较
			for (int i = j; i > 0; i--) {
				//若小于前值则交换位置
				if(arr[i] < arr[i-1]) {
					int t = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = t;
				}
				//若大于前值，则表示不用再与前面值比较,进入下一轮
				continue;
			}
		}
		return arr;
	}
}
