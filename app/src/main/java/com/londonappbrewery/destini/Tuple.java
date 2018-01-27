package com.londonappbrewery.destini;

import java.util.Objects;

/**
 * Created by Rayan on 1/27/2018.
 */

public class Tuple {
    int num;
    boolean up;

    Tuple(int n, boolean u) {
        num = n;
        up = u;
    }
    @Override
    public boolean equals(Object o) {
        if( !(o instanceof Tuple) ) return false;
        Tuple other = (Tuple) o;
        return (num == other.num) && (up == other.up);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + num;
        result = 31 * result + (up? 1:0);
        return result;
    }

}
