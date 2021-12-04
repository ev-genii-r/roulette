package com.topolia.roulette.service.games;

import java.util.Date;

public class ThreePictures {
    public static int[] getRandomPosition(){
        Date date = new Date();
        int randomPos = (int)(date.getTime()%9);
        int randomOff = (int)(date.getSeconds()%5);
        randomOff++;
        System.out.println(randomPos);
        System.out.println(randomOff);
        int[] ms = new int[9];
        for(int i = 1; i < 4; i++){
            for(int j=0; j < 3; j++){
                ms[randomPos] = i;
                randomPos += randomOff;
                if(randomPos > 8){
                    randomPos -= 9;
                }
                if(ms[randomPos] != 0){
                    randomPos++;
                }
                if(randomPos > 8){
                    randomPos -= 9;
                }
            }
        }
        return ms;
    }
}
