# Usage 
```shell
javac *.java
```
```shell
java SystemMain
```

---

## Idea with tasks

### Task A
> Add a component `Logger` listening `EV_SHOW` event, logger will write the data into `log.txt` file once receive the event signal. 
- Note: Logger will clear the data every time to avoid laggy. 

### Task B
> Add a component `CourseOverbookMonitor` listen to `EV_REGISTER_STUDENT` event simultaneously with `RegisterStudentHandler` when overbook happened to output a warning message will pop up but do not do anything to stop the booking.

### Task C
>Add a component `CourseRegisterConflictChecker` listen to a new event `EV_CONFLICT`, when a register student event happened, it will first go into this component and then go into the handler. Some adjustment has been made to other components to handle these changes. 

