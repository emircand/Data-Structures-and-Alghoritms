
/**
 * Office sub class extends Buildings super class
 */
public class Office extends Buildings{
    private String jobType;
    private String owner;
    
    /**
     * class constructor specified by parameters
     * @param jobType job type of Office
     * @param owner owner of Office
     * @param side  location side on the street
     * @param position  location position on the street
     * @param height height of Office
     * @param length length of Office
     */
    Office(String jobType, String owner,
    String side, int position, int height, int length){
        this.jobType = jobType;
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
     * get method for jobType field
     * @return job type of the office as String
     * */
    public String getJobType(){
        return jobType;
    }
    
    /**
     * get method for owner field
     * @return owner of the office as String
     * */
    public String getOwner() {
        return owner;
    }

    /**
     * Overridden abstract Focusing method
     * give the information of job type for Office
     */
    @Override
    public void Focusing(){
        System.out.println("Job Type of the office: " + getJobType());
    }
    
    /**
     * Overridden abstract getName method
     * give the name of Class
     */
    @Override
    public String getName() {
    	return String.format("Office");
    }
}
