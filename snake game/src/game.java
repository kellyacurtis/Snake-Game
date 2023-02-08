import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class game implements KeyListener {
    private snake player;
    private apple apple;
    private JFrame gamewindow;
    private graphics graphics;
    //final dimensions of the game, can be changed here
    public final static int width = 30;
    public final static int length = 30;
    public final static int dimension = 20;

    public void setPlayer(snake player) {
        this.player = player;
    }

    public void setApple(apple apple) {
        this.apple = apple;
    }

    public void setGamewindow(JFrame gamewindow) {
        this.gamewindow = gamewindow;
    }

    public JFrame getGamewindow() {
        return gamewindow;
    }

    public snake getPlayer() {
        return player;
    }

    public apple getApple() {
        return apple;
    }

    public game() {
        gamewindow = new JFrame();
        player = new snake();
        apple = new apple(player);
        graphics = new graphics(this);
        gamewindow.add(graphics);
        gamewindow.setTitle("Kelly's Snake");
        gamewindow.setSize(width*dimension + 2, length*dimension + dimension + 4);
        gamewindow.setVisible(true);
        gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
       graphics.s = "RUNNING";
    }
    public void update() {
        if (graphics.s.equals("RUNNING")) {
            if(apple_collision()) {
                player.grow();
                apple.randomLocation(player);
            } else if (collision() || self_collision()) {
                graphics.s = "END";
            }
            else {
                player.move();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (graphics.s.equals("RUNNING")) {
            if (keyCode == KeyEvent.VK_UP && !player.getMove().equals("DOWN")) {
                player.up();
            } else if (keyCode == KeyEvent.VK_RIGHT && !player.getMove().equals("LEFT")) {
                player.right();
            } else if (keyCode == KeyEvent.VK_LEFT && !player.getMove().equals("RIGHT")) {
                player.left();
            } else if (keyCode == KeyEvent.VK_DOWN && !player.getMove().equals("UP")) {
                player.down();
            }
        } else {
            this.start();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
    private boolean collision() {
        if(player.getX() < 0 || player.getX() >= width*dimension
                || player.getY() < 0 || player.getY() >= length*dimension) {
                return true;
        }
        return false;
    }
    private boolean apple_collision() {
        if (player.getX() == apple.getX() * dimension && player.getY() == apple.getY() * dimension) {
            return true;
        }
        return false;
    }
    private boolean self_collision() {
        for(int i = 1; i < player.getBody().size(); i++) {
            if (player.getX() == player.getBody().get(i).x &&
                player.getY() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }

        public static void main(String[] args) {
            game newGame = new game();
        }

}
