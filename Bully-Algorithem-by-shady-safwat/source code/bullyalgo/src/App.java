import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bully algorithm By shady safwat \n\n\n");

        
        System.out.println("\n please enter number of processes");

        int noOfProcesses = scan.nextInt();
        // starting the server at port 60010
        SocketClass.startServer();

        SocketClass.startSender(noOfProcesses);

   
        
    }
}
