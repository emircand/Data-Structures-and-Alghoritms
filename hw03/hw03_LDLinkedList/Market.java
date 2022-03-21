/**
 * Market subclass extended from Buildings superclass
 * */
public class Market extends Buildings{
    private String openingTime;
    private String closingTime;
    private String owner;

    /**
     * class constructor specified with parameters
     * @param openingTime opening time of Market
     * @param closingTime closingTime of Market
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
     * Overridden abstract Focusing method
     * give the information of closingTime for Market
     */
    @Override
    public void Focusing(){
        System.out.println("The market closing at: " + getClosingTime());
    }
    
    /**
     * Overridden abstract getName method
     * give the name of Class
     */
    @Override
    public String getName() {
    	return String.format("Market");
    }
}
