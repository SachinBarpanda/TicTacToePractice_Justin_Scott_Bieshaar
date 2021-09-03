package com.game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Grid implements IGameObject {

    private ArrayList<Placement> placements = new ArrayList<>(Main.SIZE);

    private int gridThickness = 16;

    public Grid(){
        for (int i = 0; i <Main.SIZE ; i++) {
            int xIndex = i % Main.ROWS;
            int yIndex = i / Main.ROWS;
            int size = Main.WIDTH / Main.ROWS;

            placements.add(new Placement(xIndex*size, yIndex * size, xIndex,
                    yIndex, size, size));
        }
    }

    @Override
    public void update(float deltaTime) {
        for(Placement placement : placements){
            placement.update(deltaTime);
        }
    }

    @Override
    public void render(Graphics2D graphicsRender) {

        for(Placement placement : placements){
            placement.render(graphicsRender);
        }
        renderGraphics(graphicsRender);
    }

    private void renderGraphics(Graphics2D graphicsRender) {
        graphicsRender.setColor(new Color(0x2e2e2e));

        int rowSize  = Main.WIDTH/Main.ROWS;
        for (int i = 0; i < Main.ROWS+1; i++) {
            graphicsRender.fillRect(i*rowSize-(gridThickness/2),0,gridThickness,Main.WIDTH);
            for (int j = 0; j < Main.ROWS+1; j++) {
                graphicsRender.fillRect(0,j*rowSize - (gridThickness/2),Main.WIDTH,gridThickness);
            }
        }
        graphicsRender.setColor(Color.WHITE);
    }

    public void mouseMoved(MouseEvent e) {
        for (Placement placement: placements) {
            placement.checkCollision(e.getX(), e.getY() - 30);
        }
    }
}
