package com.sort.common;

import java.util.Random;

public class CreateArray {
	public static int[] newArray(int length) {
		//创建指定长度的整数随机数组
		int[] arr = new int[length];
		for (int i =0; i<length; i++) {
			arr[i]= new Random().nextInt(100);
		}
		//System.out.println(Arrays.toString(arr));
		return arr;
	}
}
