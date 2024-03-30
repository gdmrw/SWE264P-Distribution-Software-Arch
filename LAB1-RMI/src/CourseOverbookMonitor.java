import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CourseOverbookMonitor extends UnicastRemoteObject implements MyRemoteInterface {
    protected CourseOverbookMonitor() throws RemoteException {
    }

    public String checkOverbook(String CID, String courseSection, DataBase dataBase) throws RemoteException {
        Course objCourse = dataBase.getCourseRecord(CID, courseSection);
        ArrayList vStudent = objCourse.getRegisteredStudents();
        int limit = 3;  //set limit here
        if (vStudent.size() > limit) {
            return "Course Overbook monitor: Warning! Overbooked! Expected:" + limit + " Now:" + vStudent.size();
        }else {
            return  "";
        }
    }
}
