import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CourseConflictChecker extends UnicastRemoteObject implements MyRemoteInterface {
    protected CourseConflictChecker() throws RemoteException {
    }

    @Override
    public String checkConflict(String SID, String CID, String courseSection, DataBase dataBase) throws RemoteException {

        Student objStudent = dataBase.getStudentRecord(SID);
        Course objCourse = dataBase.getCourseRecord(CID, courseSection);
        String conflictStatus = "noConflict";
        if (objStudent == null) {
            return "Invalid student ID";
        }
        if (objCourse == null) {
            return "Invalid course ID or course section";
        }

        ArrayList vCourse = objStudent.getRegisteredCourses();

        for (int i=0; i<vCourse.size(); i++) {
            if (((Course) vCourse.get(i)).conflicts(objCourse)) {
                conflictStatus = "conflict";
                break;
            }else{
                conflictStatus = "noConflict";
            }
        }

        return conflictStatus;
    }

}
