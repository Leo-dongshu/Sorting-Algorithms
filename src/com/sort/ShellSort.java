package com.sort;

import java.util.Arrays;

import com.sort.common.CreateArray;

/**
 * 希尔排序（最小增量排序）
 * 算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差d.
 * 对每组中全部元素进行直 接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
 * 当增量减到1时，进行直接插入排序后，排序完成。 
 * 
 *       x x x x x x x x x x x x x x x x x x x x x x x x x  length=25 d=int25/2=12
 * d1=12 x                       x                       x  每组下标相差d1的值进行直接插入排序
 *         x                       x
 *           x                       x
 *                  ...                     ...
 *                           x                       x
 *                             x                       x
 * d2=11 x                     x                       x
 *         x                     x                       x
 *           x                     x           
 *             x                     x
 *  ...              ...
 * d12=1 x x x x x x x x x x x x x x x x x x x x x x x x x  当d=1时，直接插入排序完后，希尔排序完成
 * 
 * @author LIDONGSHU
 */
public class ShellSort {
	public static void main(String[] args) {
		//获取随机整数数组
		int[] arr = CreateArray.newArray(20);
		System.out.println(Arrays.toString(arr));
		
		//执行希尔排序算法
		int[] array = shellSort(arr);
		System.out.println(Arrays.toString(array));
	}
	//希尔排序算法
	private static int[] shellSort(int[] arr) {
		if(arr.length>=2) {
			//定义希尔排序的起始增量arr.length/2
			int d = arr.length / 2;
			//以d为增量开始循环分组,直到d=1
			while (d>=1) {
				//每组下标相差d的数排序
				for (int i = 0; i < d; i++) {
					//获取当前组相差d的值
					for (int j = i+d; j < arr.length; j += d) {
						//获取的值j与前值z比较,较小值换到前面
						for (int z = j-d; z >=0 && arr[j]<arr[z]; z -= d) {
							int t = arr[j];
							arr[j] = arr[z];
							arr[z] = t;
						}
					}
				}
				d--;
			}
		}
		return arr;
	}
}
