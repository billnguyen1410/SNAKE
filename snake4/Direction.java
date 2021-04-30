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
public enum Direction {
    LEFT {
        Direction opposite() {
            return RIGHT;
        }
        int getX(){
            return -1;
        }
        int getY(){
            return 0;
        }
    },
    RIGHT {
        Direction opposite() {
            return LEFT;
        }
        int getX(){
            return 1;
        }
        int getY(){
            return 0;
        }
    },
    UP {
        Direction opposite() {
            return DOWN;
        }
        int getX(){
            return 0;
        }
        int getY(){
            return -1;
        }
    },
    DOWN {
        Direction opposite() {
            return UP;
        }
        int getX(){
            return 0;
        }
        int getY(){
            return 1;
        }
    };

    abstract Direction opposite();
    abstract int getX();
    abstract int getY();
}
