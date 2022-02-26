public class House extends Buildings{
    private int numberOfRooms;
    private String colour;

    House(){
        numberOfRooms = 3;
        colour = new String("white");
        owner = new String("unknown");
        heigth = 5.0;
        length = 5.0;
    }

    House(int RoomNumber, String Colour, String Owner){
        numberOfRooms = RoomNumber;
        colour = Colour;
        owner = Owner;
        heigth = 5.0;
        length = 5.0;
    }

    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    public String getColour(){
        return colour;
    }

    public void Focus(){
        System.out.println("Owner of the house: " + getOwner());
    }


}