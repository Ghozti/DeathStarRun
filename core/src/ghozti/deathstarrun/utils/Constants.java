package ghozti.deathstarrun.utils;

public class Constants {

    /*
     * @AUTHOR - Ghozti
     *
     * THIS CLASS IS A CLASS TO HOLD ALL NON CHANGING IMPORTANT VALUES IN THE GAME FOR DIFFERENT THINGS. SUCH AS THE PLAYER, SHIPS, BACKGROUND ETC
     * WE USE THIS CLASS TO ORGANIZE VALUES AND MAKE THEM EASY TO MODIFY IF NEEDED WITHOUT ISSUES.
     */

    public static class Player{

    }

    public static class ScrollingBackGround{
        public static final float MAX_SPEED = 6;
        public static final float INIT_SPEED = 2;
        public static final float SPEED_INCREASE_RATE = .2F;
    }

    // FOR DIFFERENT SHIPS

    public static class ShipIDs{
        public static final int X_WING = 0;
        public static final int TIE_FIGHTER = 1;
    }

    public static class XWing{
        public static final float MAX_SPEED = 3;
        public static final float MAX_ROTATION = 8;
        public static final float ROTATION_SPEED = 0.08f;
    }

    public static class TieFighter{
        public static final float MAX_SPEED = 6;
    }
}
