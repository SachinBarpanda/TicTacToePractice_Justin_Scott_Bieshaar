package com.game;

import javax.swing.*;
import java.awt.*;

public class Main {
    //If you are interested you can record yourself and see how you are making yourself miserable
    //while you are doing this project. As I have told you earlier, it is not important to make the
    //project work, rather you should be able to write the project to the end so you see everything
    //that you have to learn.

    //If any error occur during the making I will record it just to show you how
    //I solve the problem in other words debug it.
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    public static int ROWS = 4;
    public static int MATCH = 3;
    public static int SIZE = ROWS * ROWS;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tic-Tac-Toe");
        /*After game panel is added */

        GamePanel game = new GamePanel(new Color(0X464646));
        frame.add(game);
        frame.addMouseListener(game);
        frame.addMouseMotionListener(game);

        /*            */


//        frame.setSize(WIDTH, HEIGHT);
        frame.pack();
        frame.setResizable(false );
        frame.setVisible(true);
        //So yeah this is called a Frame that you just created.
        //but you can see the terminating button is on from here
        //so we are going to use this
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //It's closing now
    }
    //If you pay a little attention you should be able to make this part works

}
