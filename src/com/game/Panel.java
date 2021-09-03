package com.game;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    //something called thread, remember when you buy a cpu it's written thread in their
    //it's the same thread which we will now use to run a specific programme.
    private Thread thread;
    //To render our scene . Render means to generate rather than showing just the picture, it will
    //generate the elements in the game when some keys are pressed.
    protected Graphics2D graphicsRender;
    //what will be rendered will be determined by this
    private Image img;
    private Color backgroundColor;

    public Panel(Color color){
        this.backgroundColor = color;
    //We are setting the weight and height for the panel
        setPreferredSize(new Dimension(Main.WIDTH,Main.HEIGHT));
        setFocusable(false);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        //this is a if statement which helps to check some condition before running
        if(thread == null){
            thread = new Thread(this);//'this' is the place where it is going to run
            thread.start();
        }
    }

    @Override
    public void run() {
        init();//start the loop here so we made a small copy here
        //get the current time
        long lastTime = System.nanoTime();
        //we set a memory for our fps here
        double nanoSecondPerupdate = 1000000000D/30;
        // delta time to pass nanosecond between ticks/frames
        float delta = 0;
        //this is something called loop this is similar to if but it can run multiple times
        //which is what we want to do while playing gaming that is to render the elements
        //again and again
        while(true){
            //get the time now
            long now = System.nanoTime();
            // calculate delta time based on our desired frames per second
            delta += (now - lastTime) / nanoSecondPerupdate;
            // give the value of the current to last time
            lastTime = now;

            if(delta>=1){
                //calling a piece of code with its help
                //we will see what it do
                update(delta);

                //render
                render();

                //reset delta so as to stop the render animation
                delta--;
            }
            //something called error handling
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();//something called as function from another class here it is 'e'
            }
        }
    }

    public void init(){
        img = createImage(Main.WIDTH, Main.HEIGHT);
        graphicsRender = (Graphics2D) img.getGraphics();
    }

    public void update (float delta){
        //will be used to create commands later
    }

    public void render(){
        //setting to render
        //this graphics Render class has a lot of commands that we are using which is actually
        //responsible for drawing stuff on the screen
        graphicsRender.clearRect(0,0,Main.WIDTH,Main.HEIGHT);
        graphicsRender.setFont(new Font("Arial",Font.CENTER_BASELINE,125));


        graphicsRender.setColor(backgroundColor);

        //draw background
        graphicsRender.fillRect(0,0, Main.WIDTH,Main.HEIGHT);
        //here we are clearing the graphics after drawing the rect
        graphicsRender.setColor(Color.WHITE);
    }
    //method for clearing the output so as to free some data of the RAM
    public void clear(){
        Graphics graphics = getGraphics();
        if(img!=null){
            //we are drawing a final image for the last screen
            graphics.drawImage(img,0,0,null);
        }
        //now we dispose the image
        graphics.dispose();
    }
}
