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
import java.util.Random;

public class Apple {
    private int randomXPos;
    private int randomYPos;
    Random r = new Random();
    GameBoard board = new GameBoard();

    public Apple(){
    }

    public void createNewApple(){
        randomXPos = r.nextInt(board.getxCells()-2)+1;
        randomYPos = r.nextInt(board.getyCells()-2)+1;
    }

    public int getRandomXPos(){
        return randomXPos;
    }

    public int getRandomYPos(){
        return randomYPos;
    }

}
