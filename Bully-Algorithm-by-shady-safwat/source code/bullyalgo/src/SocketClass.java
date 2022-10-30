import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClass {

    public static void main(String[] args) throws IOException {

        startServer();

    }

    // client server by creating thread
    public static void startSender(int processNo) {
        (new Thread() {
            @Override
            public void run() {
                try {
                    // setting the socket port
                    Socket s = new Socket("localhost", 60010);
                    // writing the output stream
                    BufferedWriter out = new BufferedWriter(
                            new OutputStreamWriter(s.getOutputStream()));
                    while (true) {
                        Elections elec = new Elections();
                        // init the processes
                        elec.initProcess(processNo);
                        // setting coordinator (last process is by default the coordinator)
                        elec.setcoordinator();
                        // check if the coordinator is here or not
                        elec.listenTocoordinator();
    
                        // terminate the coordinator
                        elec.terminateCoordinator();
                        // let user choose the action after the coordinator is terminated.
                        elec.chooseAction();

                        elec.randomTermination();
                    }
 
            }catch(Exception e){
                System.out.println(e);
            }
    }}).start();
    }

    // starting the server by creating thread
    public static void startServer() {
        (new Thread() {
            @Override
            public void run() {
                ServerSocket ss;
                try {
                    // setting the port
                    ss = new ServerSocket(60010);

                    Socket s = ss.accept();
                    // create the buffer reader to read the input stream
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(s.getInputStream()));
                    String line = null;
                    // to listen to the changes happend by client
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}