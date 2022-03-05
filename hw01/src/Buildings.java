public abstract class Buildings {
    protected int length;
    protected int height;
    protected int position;
    protected int side;

    abstract void Focusing();
    
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

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public boolean equals(Buildings obj) {
        if(this.getLength() == obj.getLength() && 
        this.getPosition() == obj.getPosition() &&
        this.getSide() == obj.getSide())
            return true;
        else return false;
    }
}