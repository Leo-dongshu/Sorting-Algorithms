# 排序算法
排序方法可以分为五种：插入排序、选择排序、交换排序、分配排序和归并排序。  
在排序过程中，全部记录存放在内存，则称为内排序，如果排序过程中需要使用外存，则称为外排序。  
首先来看一下八种排序之间的关系图：  
![](https://img-blog.csdn.net/20180409170941764?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hha2V5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  

## 1、 直接插入排序 
### （1）基本思想：
在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
### （2）理解图：
已知待序的一组记录的初始排列为：21, 25, 49, 25*, 16, 08   
![](https://img-blog.csdn.net/20180409171355865?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hha2V5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  
开始排序  
![](https://img-blog.csdn.net/20180409171414129?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hha2V5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  
![](https://img-blog.csdn.net/2018040917143441?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hha2V5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  
### （3）代码实现
```Java
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
```
