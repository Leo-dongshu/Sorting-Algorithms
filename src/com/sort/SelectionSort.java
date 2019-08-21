package com.sort;

import java.util.Arrays;
import com.sort.common.CreateArray;

/**
 * 简单选择排序
 * 
 * x x x x x x x x x x x x x x x x x x x x x 
 * i                   x
 * 
 * 每轮从i出发，找到最小值，与i交换
 * 
 * @author LIDONGSHU
 */
public class SelectionSort {
	public static void main(String[] args) {
		//获取随机整数数组
		int[] arr = CreateArray.newArray(21);
		System.out.println(Arrays.toString(arr));
		
		//执行简单选择排序
		int[] array = selectionSort(arr);
		System.out.println(Arrays.toString(array));
	}
	//简单选择排序算法
	private static int[] selectionSort(int[] arr) {
		//每轮选出最小值与i换位
		for (int i = 0; i < arr.length-1; i++) {
			//从i出发，找到最小值下标
			int minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j:minIndex;
			}
			//最小值与i下标数换位
			int t = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = t;
		}
		return arr;
	}
}
