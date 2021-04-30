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
import java.util.LinkedList;

public class SnakeGame {
    private int gameSpeed = 100;
    private LinkedList<Point> body;
    private Point head;
    private static boolean eatenApple = false;
    private static boolean isDead = false;
    private static Direction snakeDirection;
    Snake theSnake = new Snake();
    Apple theApple = new Apple();
    GameBoard board = new GameBoard();

    public SnakeGame() {
    }

    public void initializeGame() {
        board.cleanBoard();
        theSnake.createSnake(board.getxCells() / 2, board.getyCells() / 2);
        theApple.createNewApple();
        addAppleToGameBoard();
    }

    public boolean collidesWith(CellData cellData) {
        body = theSnake.getBody();
        head = body.get(0);
        CellData cell = board.getBoard()[head.getX()][head.getY()];
        return (cell == cellData);

    }

    public boolean snakeIsDead() {
        if (collidesWith(CellData.WALL)
                || collidesWith(CellData.SNAKE)) {
            isDead = true;
            return true;
        } else {
            isDead = false;
            return false;
        }
    }

    public void takeAppleFromGameBoard() {
        board.setDataCell(theApple.getRandomXPos(), theApple.getRandomYPos(), CellData.EMPTY);
    }

    public void addAppleToGameBoard() {
        board.setDataCell(theApple.getRandomXPos(), theApple.getRandomYPos(), CellData.APPLE);
    }

    public void updateApple() {

        if (collidesWith(CellData.APPLE)) {
            takeAppleFromGameBoard();
            theSnake.eat();
            theApple.createNewApple();
            eatenApple = true;
        } else {
            eatenApple = false;
        }
    }

    public void storeDirectionOfSnake(Direction direction) {
        snakeDirection = direction;
    }

    public void changeSnakeDirection(){
        if (snakeDirection != null) {
            theSnake.changeDirection(snakeDirection);
        }
    }
    public void addSnakeToBoard() {
        body = theSnake.getBody();
        for (int i = 0; i < body.size(); i++) {
            board.setDataCell(body.get(i).getX(), body.get(i).getY(), CellData.SNAKE);
            board.setDataCell(theSnake.getTailCell().getX(), theSnake.getTailCell().getY(), CellData.EMPTY);
        }
    }

    public void updateSnake() {
        theSnake.update();
    }

    public void updateBoard(){
        addAppleToGameBoard();
        addSnakeToBoard();
    }

    public void removeSnake() {
        body = theSnake.getBody();
        theSnake.clearBody();
        for (int i = 0; i < body.size(); i++) {
            board.setDataCell(body.get(i).getX(), body.get(i).getY(), CellData.EMPTY);
        }
    }
    public int getGameSpeed() {
        return gameSpeed;
    }

    public boolean hasEatenApple() {
        return eatenApple;
    }

    public boolean isDead() {
        return isDead;
    }
}