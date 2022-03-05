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

    public String getJobType(){
        return jobType;
    }

    public String getOwner() {
        return owner;
    }

    public void Focusing(){
        System.out.println("Job Type of the office: " + getJobType());
    }
}