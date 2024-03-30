import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ListAllStudents extends UnicastRemoteObject implements MyRemoteInterface {

    protected ListAllStudents() throws RemoteException {
    }

    @Override
    public String listAllStudent(DataBase dataBase) throws RemoteException {
        // Get all student records.
        ArrayList vStudent = dataBase.getAllStudentRecords();

        // Construct a list of student information and return it.
        String sReturn = "";
        for (int i=0; i<vStudent.size(); i++) {
            sReturn += (i == 0 ? "" : "\n") + ((Student) vStudent.get(i)).toString();
        }
        return sReturn;
    }
}
