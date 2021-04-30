/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake4;

/**
 *
 * @author Long Nguyen
 */
import java.awt.*;
import java.util.LinkedList;

public class Snake{
    private LinkedList<Point> body; // list holding points(x,y) of snake body
    private Point head;
    private static Direction headDirection;
    private static Point tailCell;
    private static boolean hasEatenApple = false;

    public Snake() {
        body = new LinkedList<>();
    }

    public void createSnake(int x, int y) {

        //creating 3-part starting snake
        body.addFirst(new Point(x,y));
        body.add(new Point(x - 1, y));
        body.add(new Point(x - 2, y));
        headDirection = Direction.RIGHT;
        tailCell = body.getLast();

    }

    public void clearBody(){body.clear();
    }
    public void changeDirection(Direction theDirection) {
        if (theDirection != headDirection.opposite())
            this.headDirection = theDirection;
    }

    //updating localisation of snake
    public void update() {
        addPartOfBody(headDirection.getX(), headDirection.getY());

    }

    private void addPartOfBody(int x, int y) {
        head = body.get(0);
        body.addFirst(new Point(head.getX() + x, head.getY() + y));
        tailCell = body.getLast();
        if (hasEatenApple == false) {
            body.removeLast();
        } else {
            hasEatenApple = false;
        }
    }
    public LinkedList<Point> getBody() {
        return (LinkedList<Point>) body.clone();
    }
    public Point getTailCell(){return tailCell;}
    public void eat() {
        hasEatenApple = true;
    }
}