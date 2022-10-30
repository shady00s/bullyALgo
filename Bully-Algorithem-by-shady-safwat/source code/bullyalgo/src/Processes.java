
// the process class
public class Processes {
    private int processID;
    private String status;
    private Boolean iscoordinator;
    
  
    
    public int getProcessID(){
        return processID;
    }

    public void setProcessID(int process){
        this.processID = process;
    }   

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }   

    public Boolean getIscoordinator(){
        return iscoordinator;
    }

    public void setIscoordinator(Boolean iscoordinator){
        this.iscoordinator = iscoordinator;
    }   

}
