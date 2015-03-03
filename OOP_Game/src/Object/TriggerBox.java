package Object;


import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serathano
 */
public class TriggerBox extends GameObject{

    public TriggerBox(String ref, float x, float y) {
        super(ref, x, y);
    }

    @Override
    public void update() {
        //eh. check for collision?
    }

    @Override
    public void render(Graphics g) {
        //do NOTHING. Does not render.
    }
    
}
