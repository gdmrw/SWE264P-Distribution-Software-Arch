import java.util.AbstractList;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CourseOverbookMonitor extends CommandEventHandler{
    /**
     * Constructs a command event handler. At the time of creation, it subscribes to the given
     * command event by default.
     *
     * @param objDataBase    reference to the database object
     * @param iCommandEvCode command event code to receive the commands to process
     * @param iOutputEvCode  output event code to send the command processing result
     */
    public CourseOverbookMonitor(DataBase objDataBase, int iCommandEvCode, int iOutputEvCode) {
        super(objDataBase, iCommandEvCode, iOutputEvCode);
    }

    @Override
    protected String execute(String param) {
        // Parse the parameters.
        StringTokenizer objTokenizer = new StringTokenizer(param);
        String sSID = objTokenizer.nextToken();
        String sCID = objTokenizer.nextToken();
        String sSection = objTokenizer.nextToken();
        String sConflict = objTokenizer.nextToken();

        Course objCourse = this.objDataBase.getCourseRecord(sCID, sSection);
        Student objStudent = this.objDataBase.getStudentRecord(sSID);

        if (objStudent == null) {
            return "";  // avoid double print
        }
        if (objCourse == null) {
            return "";  // avoid double print
        }

        if (sConflict.equals("conflict")) {   //conflict check
            return "";
        }

        ArrayList vStudent = objCourse.getRegisteredStudents();
        int limit = 3;  //set limit here
        int actualSize =(vStudent.size() + 1);
        if (vStudent.size() > limit - 1) {
            return "Course Overbook monitor: Warning! Overbooked! Expected:" + limit + " Now:" + actualSize;
        }else {
            return  "";
        }


    }
}
