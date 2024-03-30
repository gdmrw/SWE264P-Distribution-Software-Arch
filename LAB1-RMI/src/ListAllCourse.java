import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ListAllCourse extends UnicastRemoteObject implements MyRemoteInterface {


    protected ListAllCourse() throws RemoteException {
    }

    @Override
    public String listAllCourse(DataBase dataBase) throws RemoteException {
        // Get all course records.
        ArrayList vCourse = dataBase.getAllCourseRecords();

        // Construct a list of course information and return it.
        StringBuilder sReturn = new StringBuilder();
        for (int i=0; i<vCourse.size(); i++) {
            sReturn.append(i == 0 ? "" : "\n").append(((Course) vCourse.get(i)).toString());
        }
        return sReturn.toString();
    }

}
