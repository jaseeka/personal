package com;

import com.common.utils.JsonUtils;
import sun.text.normalizer.UBiDiProps;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by jaseeka
 * Date 2015/9/27
 * Time 21:36
 */
public class Test {

    public static Boolean checkFor(int [] a){
        if (a.length < 2)
            return false;

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j])
                    return true;
            }
        }
        return false;
    }

    public static Boolean checkSet(int [] a){

        Set<Integer> set = new HashSet<Integer>();

        for (int i : a){
            if (!set.add(i)){
                return true;
            }
        }

        return false;
    }

    public static Boolean checkMap(int [] a){

//        int [] array = new int[100000];
        Map<Integer, Integer> falgMap = new HashMap<Integer, Integer>();
        for (int i=0; i<a.length; i++){
            int n = a[i];
            if (falgMap.get(n) != null){
                return true;
            }else {
                falgMap.put(n, 1);
            }
        }
        return false;
    }

    public static Boolean checkSort(int [] a){
        Arrays.sort(a);
        for (int i=0; i<a.length-1; i++){
            if (a[i] == a[i+1]){
                return true;
            }
        }

        return false;
    }

    public static void main(String [] args) {

        int [] array = new int[100000];

        for (int i=0; i<100000; i++){
            array[i] = new Random().nextInt();
        }

        System.out.println(JsonUtils.Object2Json(array));

        Date start = new Date();

        checkFor(array);

        Date end = new Date();

        System.out.println("checkFor time:" + (end.getTime() - start.getTime()));


        Date start1 = new Date();

        checkSet(array);

        Date end1 = new Date();

        System.out.println("checkSet time:" + (end1.getTime() - start1.getTime()));


        Date start2 = new Date();

        checkMap(array);

        Date end2 = new Date();

        System.out.println("checkMaps time:" + (end2.getTime() - start2.getTime()));

        Date start3 = new Date();

        checkSort(array);

        Date end3 = new Date();

        System.out.println("checkSort time:" + (end3.getTime() - start3.getTime()));


    }
}
