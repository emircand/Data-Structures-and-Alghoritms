package com.emircand.ArrayList;

/**
 * House subclass extends Buildings superclass
 */
public class House extends Buildings{
    private int numberOfRooms;
    private String colour;
    private String owner;

    /**
     * class constructor specified by parameters
     * @param numberOfRooms number of rooms info for House
     * @param colour colour of House
     * @param owner owner of House
     * @param side  location side on the street
     * @param position  location position on the street
     * @param height height of House
     * @param length length of House
     */
    House(int numberOfRooms, String colour, String owner, 
    String side, int position, int height, int length){
        this.numberOfRooms = numberOfRooms;
        this.colour = colour;
        this.owner = owner;
        if(side == "right") 
            this.side = 0;
        else if(side == "left") 
            this.side = 1;
        this.height = height;
        this.length = length;
        this.position = position;
    }

    /**
     * get method for numberOfRooms variable
     * @return total number of rooms in House
     */
    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    /**
     * get method for colour variable
     * @return colour of House
     */
    public String getColour(){
        return colour;
    }

    /**
     * get method for owner variable
     * @return owner of House
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Overriden abstract Focusing method
     * give the information of owner for House
     */
    @Override
    public void Focusing(){
        System.out.println("Owner of the house: " + getOwner());
    }


}
