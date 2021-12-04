package com.topolia.roulette.service.games;

public class WheelSpeen {
    public static int prize(String strNumber){
        int number = Integer.parseInt(strNumber);
        switch (number){
            case 0: return 0;
            case 1: return -100;
            case 2: return 100;
            case 3: return 200;
            case 4: return -200;
            case 5: return -300;
            case 6: return 300;
            case 7: return -50;
        }
        return 0;
    }
}
