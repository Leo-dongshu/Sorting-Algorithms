package com.sort;

import com.sort.common.CreateArray;
import java.util.Arrays;

/**
 * 归并排序算法
 *
 * 步骤：
 * 1、把长度为n的输入序列分成两个长度为n/2的子序列。
 * 2、对这两个子序列分别采用归并排序。
 * 3、将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {
    public static void main(String[] args) {
        //获取随机整数数组
        int[] arr = CreateArray.newArray(24);
        System.out.println(Arrays.toString(arr));

        //执行归并排序算法
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /** 拆分数组
     */
    public static void mergeSort(int[] arr) {
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergeSort(arr,0,arr.length-1,temp);
    }
    private static void mergeSort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            mergeSort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }

    /**
     *  合并数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
