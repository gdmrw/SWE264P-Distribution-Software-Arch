import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListCourseStudentRegister extends UnicastRemoteObject implements MyRemoteInterface {

    protected ListCourseStudentRegister() throws RemoteException {
    }
    @Override
    public String listCoursesStudentRegisterFor(String SID, DataBase dataBase) throws RemoteException{


        // Get the list of courses the given student has registered for.
        Student objStudent = dataBase.getStudentRecord(SID);
        if (objStudent == null) {
            return "Invalid student ID";
        }
        ArrayList vCourse = objStudent.getRegisteredCourses();

        // Construct a list of course information and return it.
        String sReturn = "";
        for (int i=0; i<vCourse.size(); i++) {
            sReturn += (i == 0 ? "" : "\n") + ((Course) vCourse.get(i)).toString();
        }
        return sReturn;

    }
}
