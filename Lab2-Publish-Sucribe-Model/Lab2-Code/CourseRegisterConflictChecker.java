import java.util.ArrayList;
import java.util.StringTokenizer;

public class CourseRegisterConflictChecker extends CommandEventHandler {
    /**
     * Constructs a command event handler. At the time of creation, it subscribes to the given
     * command event by default.
     *
     * @param objDataBase    reference to the database object
     * @param iCommandEvCode command event code to receive the commands to process
     * @param iOutputEvCode  output event code to send the command processing result
     */
    public CourseRegisterConflictChecker(DataBase objDataBase, int iCommandEvCode, int iOutputEvCode) {
        super(objDataBase, iCommandEvCode, iOutputEvCode);
    }

    @Override
    protected String execute(String param) {

        StringTokenizer objTokenizer = new StringTokenizer(param);
        String sSID     = objTokenizer.nextToken();
        String sCID     = objTokenizer.nextToken();
        String sSection = objTokenizer.nextToken();
        String conflict = "notConflict";

        Student objStudent = this.objDataBase.getStudentRecord(sSID);
        Course objCourse = this.objDataBase.getCourseRecord(sCID, sSection);
        if (objStudent == null) {
            return "Invalid student ID";
        }
        if (objCourse == null) {
            return "Invalid course ID or course section";
        }




        ArrayList vCourse = objStudent.getRegisteredCourses();


        for (int i=0; i<vCourse.size(); i++) {
            if (((Course) vCourse.get(i)).conflicts(objCourse)) {
                conflict = "conflict";
                break;
            }else{
                conflict = "notConflict";
            }
        }

        EventBus.announce(EventBus.EV_REGISTER_STUDENT, sSID + " " + sCID + " " + sSection + " " + conflict);
        return "";

//        EventBus.announce(EventBus.EV_SHOW, "\n");


    }
}
