package ghozti.deathstarrun.utils;

import java.util.Random;

public class Randomizer {

    private int low, high;

    public Randomizer(){
        //sets default range from 1-100;
        low = 1;
        high = 1000;
    }

    public Randomizer(int low, int high){
        this.low = low;
        this.high = high;
    }

    public int getRandom(){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    public int[] getRandomList(){
        Random r = new Random();
        return new int[] {r.nextInt(high-low) + low, r.nextInt(high-low) + low};
    }

    public static int[] getPositionList(int lowX, int highX, int lowY, int highY){
        Random r = new Random();
        return new int[] {r.nextInt(highX-lowX) + lowX, r.nextInt(highY-lowY) + lowY};
    }
}
