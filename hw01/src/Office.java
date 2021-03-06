
/**
 * Office sub class extends Buildings super class
 */
public class Office extends Buildings{
    private String jobType;
    private String owner;

    Office(){
        jobType = new String("pharmacy");
        owner = new String("unknown");
        height = 15;
        length = 7;
        side = 1;
    }

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
        try {
            if(!side.equals("right") && !side.equals("left"))
                throw new Exception("invalid side string side automatically initialized as right");
            else{
                if(side == "right")
                    this.side = 0;
                else if(side == "left")
                    this.side = 1;
            }
        } catch (Exception e) {
            System.err.println(e);
            this.side = 0;
        }
        this.height = height;
        this.length = length;
        this.position = position;
    }

    /**
     * Overriden abstract Focusing method
     * give the information of job type for Office
     */
    @Override
    public void Focusing(){
        System.out.println("Job Type of the office: " + getJobType());
    }

    public String getJobType(){
        return jobType;
    }

    public String getOwner() {
        return owner;
    }
}