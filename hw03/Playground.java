package com.emircand.ArrayList;

/**
 * Playground subclass extends Buildings superclass
 */
public class Playground extends Buildings{
    /**
     * class constructor specified by parameters 
     * @param side  location side on the street
     * @param position  location position on the street
     * @param height height of Playground
     * @param length length of Playground
     */
    Playground(String side, int position, int height, int length){
        if(side == "right") 
            this.side = 0;
        else if(side == "left") 
            this.side = 1;
        this.length = length;
        this.height = height;
        this.position = position;
        this.height = height;
    }

    /**
     * Overridden abstract Focusing method
     * give the information of length of Playground
     */
    @Override
    public void Focusing(){
        System.out.println("length of the playground: " + getLength());
    }
}
