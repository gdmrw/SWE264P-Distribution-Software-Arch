import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListCourseCompleted extends UnicastRemoteObject implements MyRemoteInterface{

    protected ListCourseCompleted() throws RemoteException {
    }
    @Override
    public String listCourseCompleted(String SID, DataBase dataBase) throws RemoteException {
        // Parse the parameters.


        // Get the list of courses the given student has completed.
        Student objStudent = dataBase.getStudentRecord(SID);
        if (objStudent == null) {
            return "Invalid student ID";
        }
        ArrayList vCourseID = objStudent.getCompletedCourses();

        // Construct a list of course information and return it.
        String sReturn = "";
        for (int i=0; i<vCourseID.size(); i++) {
            String sCID = (String) vCourseID.get(i);
            String sName = dataBase.getCourseName(sCID);
            sReturn += (i == 0 ? "" : "\n") + sCID + " " + (sName == null ? "Unknown" : sName);
        }
        return sReturn;
    }
}
