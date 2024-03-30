import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StudentRegistration extends UnicastRemoteObject implements MyRemoteInterface {

    protected StudentRegistration() throws RemoteException {
    }
    @Override
    public DataBase register(String SID, String CID, String courseSection, DataBase dataBase ) throws RemoteException {

//         Get the student and course records.
        Student objStudent = dataBase.getStudentRecord(SID);
        Course objCourse = dataBase.getCourseRecord(CID, courseSection);
        if (objStudent == null) {
            return dataBase;
        }
        if (objCourse == null) {
            return dataBase;
        }

//         Check if the given course conflicts with any of the courses the student has registered.
        ArrayList vCourse = objStudent.getRegisteredCourses();
        for (int i=0; i<vCourse.size(); i++) {
            if (((Course) vCourse.get(i)).conflicts(objCourse)) {
                return dataBase;
            }
        }
        dataBase.makeARegistration(SID,CID,courseSection);
        return dataBase;
    }
}
