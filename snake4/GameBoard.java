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
public class GameBoard {
    private int boardWidth = 1000;
    private int boardHeight = 700;
    private int xCells = boardWidth / 10;
    private int yCells = boardHeight / 10;
    private static CellData board[][];

    public GameBoard() {
        board = new CellData[xCells][yCells];
    }

    public void cleanBoard() {
        for (int i = 0; i < xCells; i++) {
            board[i][0] = CellData.WALL;
        }
        for (int i = 0; i < xCells; i++) {
            board[i][yCells - 1] = CellData.WALL;
        }
        for (int j = 0; j < yCells; j++) {
            board[0][j] = CellData.WALL;
        }
        for (int j = 0; j < yCells; j++) {
            board[xCells - 1][j] = CellData.WALL;
        }
        for (int i = 1; i < xCells - 1; i++) {
            for (int j = 1; j < yCells - 1; j++) {
                board[i][j] = CellData.EMPTY;
            }
        }
    }

    public void setDataCell(int x, int y, CellData cellData) {
        board[x][y] = cellData;
    }

    public CellData[][] getBoard() {
        return board;
    }

    public int getxCells() {
        return xCells;
    }

    public int getyCells() {
        return yCells;
    }


}