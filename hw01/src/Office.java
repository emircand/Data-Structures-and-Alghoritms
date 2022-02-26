public class Office extends Buildings{
    private String jobType;

    Office(){
        jobType = new String("pharmacy");
        owner = new String("unknown");
        heigth = 15.0;
        length = 7.0;
    }

    Office(String JobType, String Owner){
        jobType = JobType;
        owner = Owner;
        heigth = 15.0;
        length = 7.0;
    }

    public String getJobType(){
        return jobType;
    }

    public void Focus(){
        System.out.println("Job Type of the office: " + getJobType());
    }
}