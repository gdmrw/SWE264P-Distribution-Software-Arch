import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiRegistry {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("ListAllStudents",new ListAllStudents());
        registry.rebind("ListAllCourse", new ListAllCourse());
        registry.rebind("Logger", new Logger());
        registry.rebind("ListCourseCompleted", new ListCourseCompleted());
        registry.rebind("ListCourseRegistered",new ListCourseRegistered());
        registry.rebind("ListCourseStudentRegister",new ListCourseStudentRegister());
        registry.rebind("StudentRegistration",new StudentRegistration());
        registry.rebind("CourseConflictChecker",new CourseConflictChecker());
        registry.rebind("CourseOverbookMonitor",new CourseOverbookMonitor());
    }
}