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
     import javax.swing.*;

public class GameMain extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new GameInstant();
        frame.setTitle("Snake Game");
        frame.setSize(1000,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
