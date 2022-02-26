public abstract class Buildings {
    protected double length;
    protected String owner;
    protected double heigth;

    public String getOwner(){
        return owner;
    }

    public double getHeigth(){
        return heigth;
    }

    public double getLength(){
        return length;
    }

    abstract void Focus();
}