package com.apple.shen.community;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
        myTest();
    }

    public void myTest(){
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int arr_length = a.length;
        int arr_max = 0;
        int arr_max_pos = 0;
        int count = 0;
        int arr_max_left = 0;
        int arr_max_right = 0;
        for(int i = 0; i < arr_length; i++){
            if(arr_max < a[i]){
                arr_max = a[i];
                arr_max_pos = i;
            }
        }

        for(int i = 0; i < arr_max_pos; i++){
            if(arr_max_left < a[i]){
                arr_max_left = a[i];
            }else{
                count += arr_max_left - a[i];
            }
        }

        for(int j = arr_length-1; j > arr_max_pos; j--){
            if(arr_max_right < a[j]){
                arr_max_right = a[j];
            }else{
                count += arr_max_right - a[j];
            }
        }

        System.out.println("count: " + count);

    }
}
