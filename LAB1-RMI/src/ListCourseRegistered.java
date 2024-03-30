import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListCourseRegistered extends UnicastRemoteObject implements MyRemoteInterface {
    protected ListCourseRegistered() throws RemoteException {
    }
    @Override
    public String listCourseRegistered(String CID, String Section , DataBase dataBase) throws RemoteException{

        // Get the list of students who registered for the given course.
        Course objCourse = dataBase.getCourseRecord(CID, Section);
        if (objCourse == null) {
            return "Invalid course ID or course section";
        }
        ArrayList vStudent = objCourse.getRegisteredStudents();

        // Construct a list of student information and return it.
        String sReturn = "";
        for (int i=0; i<vStudent.size(); i++) {
            sReturn += (i == 0 ? "" : "\n") + ((Student) vStudent.get(i)).toString();
        }
        return sReturn;
    }
}
