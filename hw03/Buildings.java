package com.emircand.ArrayList;

/**
 * abstract Super Class of the subclasses (Market, House, Office and Playground)
 */
public abstract class Buildings {
    protected int length;
    protected int height;
    protected int position;
    protected int side;

    /**
     * abstract Focusing method to override at subclass
     */
    abstract void Focusing();
    
    /**
     * get method for position variable
     * @return the position of Building
     */
    public int getPosition(){
        return position;
    }

    /**
     * return the location side of street
     * @return  0 for right / 1 for left
     */
    public int getSide(){
        return side;
    }

    /**
     * get method for Height variable
     * @return height of the Building
     */
    public int getHeight() {
        return height;
    }

    /**
     * get method for Length variable
     * @return length of the Building
     */
    public int getLength() {
        return length;
    }

    /**
     * set method for height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * set method for length
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * set method for position
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * set method for side
     * @param side
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     * @Override equals method for Buildings 
     * @param obj comparable instance of Building Class
     * @return boolean value according to the method output
     */
    public boolean equals(Buildings obj) {
        if(this.getLength() == obj.getLength() && 
        this.getPosition() == obj.getPosition() &&
        this.getSide() == obj.getSide())
            return true;
        else return false;
    }
}
