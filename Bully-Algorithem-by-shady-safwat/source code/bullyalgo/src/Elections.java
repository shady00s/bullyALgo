
import java.util.ArrayList;
import java.util.Scanner;

public class Elections extends Thread {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Processes> workingProcesses = new ArrayList<Processes>();
    private int coordinatorIndex = 0;

    // create the process dependes on the user number of processes and save them
    // into working process array
    public void initProcess(int noOfProcesses) {
        for (int i = 0; i < noOfProcesses; i++) {
            System.out.println("\n Process no " + i + " is initialized. ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            Processes process = new Processes();
            process.setProcessID(i);
            process.setStatus("active");
            process.setIscoordinator(false);

            workingProcesses.add(process);
        }
    }
    // setting the biggest process id to be coordinator

    public void setcoordinator() {
        System.out.println("\n Setting the coordinator.");
        // getting the biggest process value

        for (var i = 0; i < workingProcesses.size(); i++) {

            coordinatorIndex = Math.max(coordinatorIndex, workingProcesses.get(coordinatorIndex).getProcessID());

        }

        int coordinatorIndex = workingProcesses.size() - 1;

        Processes coordinator = workingProcesses.get(coordinatorIndex);
        coordinator.setIscoordinator(true);

        System.out.println("\n the coordinator is process number: " + coordinatorIndex);

    }

    // check if all process listen to the coordinator
    public void listenTocoordinator() {
        System.out.println("\n Checking  all processes.");

        for (var i = 0; i < workingProcesses.size(); i++) {
            // check if the coordinator is avilable or not by check if is coordinator is
            // true else its removed or its employee process
            if (!workingProcesses.get(i).getIscoordinator()) {
                System.out.println(
                        "\nProcess number " + workingProcesses.get(i).getProcessID() + " is listing to coordinator.");
            } else {
                System.out.println("\nProcess number " + workingProcesses.get(i).getProcessID() + " is The coordinator.");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }

    }

    // removing the coordinator process
    public void terminateCoordinator() {
        int oldIndex = 0;
        for (var i = 0; i < workingProcesses.size(); i++) {
            if (workingProcesses.get(i).getIscoordinator() == true) {

                oldIndex = i;
                workingProcesses.remove(i);

            }
        }
        System.out.println("\n Process number " + oldIndex + " is stopped. ");
    }

    public void chooseAction() {

        System.out.println("\n The coordinator is stopped , please enter the action you want to do.");
        System.out.println("\n 1.make election automatically.\n 2.make election manually.");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("\n creating elections.");
                setcoordinator();
                listenTocoordinator();
                break;
            case 2:
            System.out.println("\n Please enter the process number to be the coordinator");

            int process = scanner.nextInt();
            manualElection(process);
            listenTocoordinator();
            break;
            default:
                System.out.println("\n Wrong chocie aborting...");
        }

    }

    // choose cordinator manually
    public void manualElection(int index) {
        if (index > workingProcesses.size() - 1) {
            System.out.println("Wrong index , aborting...");
        } else {

            workingProcesses.get(index).setIscoordinator(true);
            System.out.println(
                    "process number " + workingProcesses.get(index).getProcessID() + " is now the coordinator");

        }
    }

    public void randomTermination(){
        // remove random process
        Double  randomIndex = Math.floor( Math.random() * workingProcesses.size());
        int index = randomIndex.intValue();

        // check if the process is coordinator if its cordinator then let user take the action

        if(workingProcesses.get(index).getIscoordinator() == true){
            workingProcesses.remove(index);

            chooseAction();

        }else{
            workingProcesses.remove(index);
            listenTocoordinator();
        }
        



        

        
        

    }
}
