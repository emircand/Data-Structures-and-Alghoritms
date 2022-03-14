public class Market extends Buildings{
    private String openingTime;
    private String closingTime;
    private String owner;

    Market(){
        openingTime = new String("09:30");
        closingTime = new String("21:00");
        owner = new String("unknown");
    }

    /**
     * class constructor specified with parameters
     * @param openingTime opening time of Market
     * @param closingTime closingTİme of Market
     * @param owner owner of Market
     * @param side  location side on the street
     * @param position  location position on the street
     * @param height height of the market
     * @param length length of the market
     */
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

    /**
     * get method for openingTime
     * @return Opening Time of the market
     */
    public String getOpeningTime(){
        return openingTime;
    }

    /**
     * get method for closingTime
     * @return Closing Time of the market
     */
    public String getClosingTime(){
        return closingTime;
    }

    /**
     * get method for owner
     * @return Owner of the market
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Overriden abstract Focusing method
     * give the information of closingTime for Market
     */
    @Override
    public void Focusing(){
        System.out.println("The market closing at: " + getClosingTime());
    }
}