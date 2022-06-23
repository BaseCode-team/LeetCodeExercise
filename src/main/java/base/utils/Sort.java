import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * TODO 类描述
 * 各种排序算法
 *
 * @Author: Sinkia
 * @Date: 2022/6/23 23:44
 */
public class Sort {

    /**
    * 选择排序
    * */
    void selectSort(int[] nums){
        int length = nums.length;
        int min = -1;
        for(int i = 0;i < length - 1;i++){
            min = i;
            for(int j = i + 1;j < length;j++){
                if(nums[min] > nums[j])
                    min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    /**
     * 冒泡排序
     * */
    void bubbleSort(int[] nums){
        int length = nums.length;
        for(int i = 0;i < length - 1;i++){
            for(int j = 0;j < length - 1 - i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    /**
     * 直接插入排序
     * */
    void insertSort(int[] nums){
         int len = nums.length;
         for(int i = 1;i < len;i++){
             int temp = nums[i];
             for(int j = i;j > 0;j--){
                 if(nums[j - 1] > temp){
                     nums[j] = nums[j-1];
                     if(j == 1){
                         nums[j-1] = temp;
                         break;
                     }
                 }else {
                     nums[j] = temp;
                     break;
                 }
             }
         }
    }

    /**
     * 快速排序
     * */
    void quickSort(int[] nums,int start,int end){
        if(start >= end)
            return;
        int temp = 0;
        int target = nums[start];
        int left = start;
        int right = end;
        while (left < right){
            while (nums[right] >= target && left < right)
                right--;
            while (nums[left] <= target && left < right)
                left++;

            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        nums[start] = nums[left];
        nums[left] = target;
        quickSort(nums,start,left - 1);
        quickSort(nums,left + 1,end);
    }

    /**
     * 归并排序
     * */
    void mergeSort(int[] nums, int start,int end){
        int mid = (start + end) / 2;
        if (start < end){
            mergeSort(nums,start,mid);
            mergeSort(nums,mid + 1,end);
            //左右归并
            merge(nums,start,mid,end);
        }
    }
    void merge (int[] nums,int low,int mid,int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        //把较小的数先移到新数组中
        while (i <= mid && j <= high){
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        //把左边剩余的数移入数组
        while (i <= mid)
            temp[k++] = nums[i++];
        //把右边剩余的数移入数组
        while (j <= high)
            temp[k++] = nums[j++];
        //新数组中的数覆盖nums数组
        for(int t = 0;t < temp.length;t++)
            nums[t + low] = temp[t];
    }

    /**
     * 希尔排序
     * */
    void hillSort(int[] nums){
        int len = nums.length;
        for(int i = len/2;i > 0;i /= 2){
            for(int j = i;j < len;j++){
                for(int k = j;k > i - 1;k -= i){
                    if(nums[k] < nums[k - i]){
                        int temp = nums[k];
                        nums[k] = nums[k - i];
                        nums[k - i] = temp;
                    }
                }
            }
        }
    }

    /**
     * 桶排序
     * */
    void bucketSort(int[] nums){
        int len = nums.length;

        int max = nums[0];
        for (int m : nums){
            if(m > max)
                max = m;
        }
        //从个位数开始，对数组进行排序
        for(int i = 1;max / i > 0;i *= 10){
            int[] temp = new int[len];
            int[] bucket = new int[10];

            //把数据出现的次数储存在buckets中
            for(int val : nums){
                bucket[(val / i) % 10]++;
            }
            //更改bucket[j]
            for(int j = 1;j < 10;j++){
                bucket[j] += bucket[j - 1];
            }
            for(int j = len - 1;j >= 0;j--){
                temp[bucket[(nums[j] / i) % 10] - 1] = nums[j];
                bucket[(nums[j] / i) % 10]--;
            }
            System.arraycopy(temp,0,nums,0,len);
        }
    }

    //Test
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] n = {23,9,6,13,21,17,11};
        sort.selectSort(n);
        Random random = new Random();
        int[] nums = random.randomCommon(0,20,10);
        System.out.println(Arrays.toString(nums));
        //sort.selectSort(nums);
        //sort.bubbleSort(nums);
        //sort.insertSort(nums);
        //sort.quickSort(nums,0,nums.length - 1);
        //sort.hillSort(nums);
        //sort.mergeSort(nums,0,nums.length - 1);
        //sort.bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Random{

    /**
     * 生成指定范围内N个不重复的数
     * 此处采取最简单的双重循环去重
     * */
    int[] randomCommon(int min,int max,int n){
        if(n > (max - min + 1) || max < min)
            return null;
        int[] nums = new int[n];
        int count = 0;
        while (count < n){
            int num = (int)(Math.random() * (max - min)) + min;
            boolean flag =true;
            for(int i = 0;i < nums.length;i++){
                if(num == nums[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                nums[count++] = num;
            }
        }
        return nums;
    }

    /**
     * 生成指定范围内N个不重复的数
     * @Param min指定范围最小值
     * @Param max指定范围最大值
     * @Param n随机数个数
     * 这里利用HashSet的特性，只能存放不同的值达到无重复的效果
     * */
    void randomSet(int min, int max, int n, HashSet<Integer> set){
        if(n > (max - min + 1) || max < min)
            return;
        for(int i = 0;i < n;i++){
            int num = (int)(Math.random() * (max - min)) + min;
            set.add(num);
        }
        int setSize = set.size();
        //如果存入数小于指定生成的个数，则递归调用再生成剩余个数的随机数，直到达到指定大小
        if(setSize < n)
            randomSet(min,max,n - setSize,set);
    }
}
