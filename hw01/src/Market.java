public class Market extends Buildings{
    private String openingTime;
    private String closingTime;
    private String owner;

    Market(){
        openingTime = new String("09:30");
        closingTime = new String("21:00");
        owner = new String("unknown");
    }

    Market(String openingTime, String closingTime, String owner, 
    String side, int position, int height, int length){
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.owner = owner;
        if(side == "right")
            this.side = 0;
        else if(side == "left")
            this.side = 1;
        this.height = height;
        this.length = length;
        this.position = position;
    }

    public String getOpeningTime(){
        return openingTime;
    }

    public String getClosingTime(){
        return closingTime;
    }

    public String getOwner() {
        return owner;
    }

    public void Focusing(){
        System.out.println("The market closing at: " + getClosingTime());
    }
}