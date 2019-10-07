package com.cas.atomic.cocunrrent;

import java.util.*;

/*
冒泡排序
 list--set
 */
public class Demo11 {



    public static void main(String[] args) {
        test1();




    }

    static void  test(){
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        Set<Object>set=new HashSet<>();
        set.addAll(list);
        System.out.println(set);
    }
    static void  test1(){
           //冒泡排序 从小到大
  int [] q=new int[]{32,22,13,25,11116,23,3,1122,121,132,121,12,122,12};
        for (int i = 0; i <q.length; i++) {
            for (int j = 0; j <q.length-1-i; j++) {
                   if(q[j]>q[j+1]){
                        int temp =q[j+1];
                              q[j+1]=q[j];
                              q[j]=temp;
                   }

            }


        }
        for (int i = 0; i < q.length; i++) {
            System.out.println(q[i]);
        }

    }

}
