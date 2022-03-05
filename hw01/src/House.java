public class House extends Buildings{
    private int numberOfRooms;
    private String colour;
    private String owner;

    House(){
        numberOfRooms = 3;
        colour = new String("white");
        owner = new String("unknown");
        side = 1;
        height = 5;
        length = 5;
    }

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

    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    public String getColour(){
        return colour;
    }

    public String getOwner() {
        return owner;
    }

    public void Focusing(){
        System.out.println("Owner of the house: " + getOwner());
    }


}