package com.game;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GamePanel extends Panel implements MouseMotionListener, MouseInputListener {
    private Grid grid;


    public GamePanel(Color color) {
        super(color);

        grid = new Grid();
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        grid.update(delta);
    }

    @Override
    public void render() {
        super.render();
        grid.render(graphicsRender);
        //it will be render and dispose when this panel will be running
        super.clear();


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        grid.mouseMoved(e);
    }
}
