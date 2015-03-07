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
public class TriggerBox extends TextBox{

    public TriggerBox(String ref, float x, float y, String text) {
        super(ref, x, y, "");
    }
    
    public TriggerBox(String ref, float x, float y, String text, int width, int height) {
        super(ref, x, y, "");
        setWidth(width);
        setHeight(height);
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
