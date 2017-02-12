package com.cenkerdemir.numbershapes;

/**
 * Created by cenkerdemir on 2/12/17.
 */

public class Number {

    Integer number = 0;

    public boolean isTriangle(){
        Integer x = 1;
        while (x*(x+1) <= number*2) {
            if (x*(x+1) == number*2) {
                return true;
            }
            x++;
        }
        return false;
    }

    public boolean isSquare(){
        Integer x = 1;
        while (x*x <= number) {
            if (x*x == number) {
                return true;
            }
            x++;
        }
        return false;
    }

}
