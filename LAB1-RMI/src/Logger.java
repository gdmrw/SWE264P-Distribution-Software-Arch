import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Logger extends UnicastRemoteObject implements MyRemoteInterface {
    protected Logger() throws RemoteException {
    }

    @Override
    public String log(String data) throws RemoteException {


        // Use try-with-resources to ensure the writer is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) { // true for append mode
            writer.write(data);
            writer.newLine(); // Add a new line for each message for readability
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
