package com.game;

import java.awt.*;

//Now we are going to make something called an interface, briefly speaking
//it also acts as a class just that we can't add anything inside the methods
public interface IGameObject {
    void update(float deltaTime);
    void render(Graphics2D graphicsRender);
}
