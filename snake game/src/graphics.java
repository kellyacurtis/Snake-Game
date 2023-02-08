import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics2D;

public class graphics extends JPanel implements ActionListener {
    private Timer t = new Timer(80, this);
    //calls action performed every 100 ms
    public String s;

    private final snake snake;
    private final apple a;
    private final game game;

    public graphics(game g) {
        t.start();
        s = "START";
        game = g;
        snake = g.getPlayer();
        a = g.getApple();
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(Color.black);
        graphics2D.fillRect(0, 0, game.width * game.dimension+5, game.length * game.dimension+5);
        if (s == "START") {
            graphics2D.setColor(Color.white);
            graphics2D.drawString("Press Any Key", game.width/2 * game.dimension - 40, game.length/2 * game.dimension - 20);
        } else if(s == "RUNNING") {
            //paint background first to update the location elements in the game
            graphics2D.setColor(Color.red);
            graphics2D.fillRect(a.getX() * game.dimension, a.getY() * game.dimension, game.dimension, game.dimension);

            graphics2D.setColor(Color.pink);
            for (Rectangle r : snake.getBody()) {
                graphics2D.fill(r);
            }
        } else {
            //end the game with score
            graphics2D.setColor(Color.white);
            graphics2D.drawString("Your score: " + (snake.getBody().size()-3), game.width/2 * game.dimension - 40, game.length/2 * game.dimension - 20);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }

}
