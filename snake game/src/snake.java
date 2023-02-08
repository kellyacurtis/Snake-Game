import java.awt.Rectangle;
import java.util.ArrayList;

public class snake {
    private ArrayList<Rectangle> body;
    private int width = game.width;
    private int length = game.length;

    private String move;
    private int dimension = game.dimension;

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }
    public int getX() {
        return body.get(0).x;
    }
    public int getY() {
        return body.get(0).y;
    }
    public String getMove() {
        return move;
    }
    public snake() {
        body = new ArrayList<>();
        // create initial dimension of the snake body, changes within the game class
        Rectangle initial = new Rectangle(game.dimension, game.dimension);

        // initializes the snake in the center of the game
        initial.setLocation(game.width/2*game.dimension, game.length/2*game.dimension);
        body.add(initial);
        initial = new Rectangle(dimension, dimension);
        initial.setLocation((width/2-1)*dimension, (length/2) *dimension);
        body.add(initial);

        initial = new Rectangle(dimension, dimension);
        initial.setLocation((width/2-2)*dimension, (length/2) *dimension);
        body.add(initial);

        move = "Nothing";
    }
    public void move() {
        if (!move.equals("Nothing")) {
            Rectangle first = body.get(0);
            Rectangle initial = new Rectangle(game.dimension,game.dimension);
            if (move.equals("UP")) {
                initial.setLocation(first.x, first.y - game.dimension);

            } else if (move.equals("DOWN")) {
                initial.setLocation(first.x, first.y + game.dimension);
            } else if (move.equals("LEFT")) {
                initial.setLocation(first.x - game.dimension, first.y);
            } else {
                initial.setLocation(first.x + game.dimension, first.y);
            }
            body.add(0, initial);
            body.remove(body.size()-1);
        }
    }
    public void grow() {
        Rectangle first = body.get(0);
        Rectangle initial = new Rectangle(game.dimension,game.dimension);
        if (move.equals("UP")) {
            initial.setLocation(first.x, first.y - game.dimension);

        } else if (move.equals("DOWN")) {
                initial.setLocation(first.x, first.y + game.dimension);
        } else if (move.equals("LEFT")) {
                initial.setLocation(first.x - game.dimension, first.y);
        } else if (move.equals("RIGHT")) {
                initial.setLocation(first.x + game.dimension, first.y);
        }
        body.add(0, initial);
    }

    public void up() {
        move = "UP";
    }
    public void down() {
        move = "DOWN";
    }
    public void left() {
        move = "LEFT";
    }
    public void right() {
        move = "RIGHT";
    }

}
