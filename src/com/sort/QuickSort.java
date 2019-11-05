package com.sort;

import com.sort.common.CreateArray;
import java.util.Arrays;

/**
 * 快速排序算法
 *
 * 步骤：
 *  1、从数列中挑出一个元素，称为 "基准"（pivot），
 *  2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *  在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 *  3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {
    public static void main(String[] args) {
        //获取随机整数数组
        int[] arr = CreateArray.newArray(24);
        System.out.println(Arrays.toString(arr));

        //执行快速排序算法
        int[] array = quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(array));
    }

    /** 快速排序算法实现
     * @param arr 待排序数组
     * @param low 低位助手,用来找比基准位大的数
     * @param high 高位助手,用来找比基准位小的数
     */
    private static int[] quickSort(int[] arr, int low, int high) {
        int start=low;//起始位置 0
        int end=high; //结束位置 arr.length-1
        int base=arr[low]; //基准数 ：一般是第一位
        int tempIndex=low; //找到的符合要求的位置：因为要把它的值付给基准数所在位置 所以要记录该位置 可以看做是助手移动到的位置
        while(low<high){
            //高助手从右向左找一个比基准位小的数 找到后给到低助手当前所在位置
            //没有找到的话 高助手向前移动一位
            while(low<high&&base<=arr[high]){
                high--;
            }
            //找到时 把找到的数赋值给低助手所在位置
            arr[low]=arr[high];
            tempIndex=high;//记录当前助手位置

            //然后低助手从左向右找一个比基准数大的数 ，找到后给到高助手当前所在位置
            //没有找到的话 低助手向后移动一位
            while(low<high&&base>=arr[low]){
                low++;
            }
            //找到后赋值给高助手当前所在位置
            arr[high]=arr[low];
            tempIndex=low;//记录当前助手位置

            //直到循环结束  -->低助手和高助手会重叠，基准数赋到当前重叠位置就是中轴位置
            arr[tempIndex]=base;

        }
        //以上第一次排序结束  把数列分成了左右两个部分
        //最后在对上面左右两个部分数列分别递归
        if(low-start>1){//左部分至少有两个数据
            quickSort(arr,0,low-1);
        }
        if(end-high>1){
            quickSort(arr,high+1,end);
        }
        return arr;
    }
}
