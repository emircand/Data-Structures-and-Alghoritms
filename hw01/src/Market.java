public class Market extends Buildings{
    private String openingTime;
    private String closingTime;

    Market(){
        openingTime = new String("09:30");
        closingTime = new String("21:00");
        owner = new String("unknown");
    }

    Market(String OpeningTime, String ClosingTime, String Owner){
        openingTime = OpeningTime;
        closingTime = ClosingTime;
        owner = Owner;
        heigth = 5.0;
        length = 20.0;
    }

    public String getOpeningTime(){
        return openingTime;
    }

    public String getClosingTime(){
        return closingTime;
    }

    public void Focus(){
        System.out.println("The market closing at: " + getClosingTime());
    }
}