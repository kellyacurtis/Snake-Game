import java.awt.Rectangle;

public class apple {
    private int x;
    private int y;

    public apple(snake player) {
        this.randomLocation(player);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void randomLocation(snake player) {
        //generate random location of apple depending on game dimensions (not on snake location)
        boolean snakelocation = true;
        while(snakelocation) {
            snakelocation = false;
            //loop until we get a new location for apple that is not snake location
            x = (int)(Math.random()*game.width-1);
            y = (int)(Math.random()*game.length-1);

            for (Rectangle r : player.getBody()) {
                if (r.x == x && r.y == y) {
                    System.out.println();
                    snakelocation = true;
                }
            }
        }
    }
}
