package com.company;

public class MaxHeap {
   public static void heapify(int[] array){
      for (var i=array.length/2-1;i>=0;i--)
          heapify(array,i);
      }
      private  static void heapify(int[] array,int index) {
          var largerindex = index;
          var leftchildindex = index * 2 + 1;
          if (leftchildindex<array.length&&array[leftchildindex] > array[largerindex])
              largerindex=leftchildindex;
          var rightchildindex=index*2+2;
          if (rightchildindex<array.length&&array[rightchildindex]>array[largerindex])
              largerindex=rightchildindex;

          if (index==largerindex)
              return;

          swap(array,index,largerindex);
          heapify(array,largerindex);

      }

      private static int parentIndex(int index) {
          return (index - 1) / 2;
      }
       public static void swap(int [] array,int index1,int index2) {
           var tmp = array[index1];
           array[index1] = array[index2];
           array[index2] = tmp;
       }
      public static boolean isMaxHeap(int [] array){
       return  isMaxHeap(array,0);
      }
      private static boolean isMaxHeap(int [] array,int index){
       var lastparentindex=(array.length-2)/2;
       if (index>lastparentindex)
           return true;
       var leftchildindex=index*2+1;
       var rightchildindex=index*2+2;
       var isvalidparent=array[index]>array[leftchildindex]&&
                         array[index]>array[rightchildindex];
       return isvalidparent&&
               isMaxHeap(array,leftchildindex)&&
               isMaxHeap(array,rightchildindex);
      }
}
