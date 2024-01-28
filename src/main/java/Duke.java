import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("    _______________________________________________________");
        System.out.println("     Hello! I'm TALKTOMEORILLDIE");
        System.out.println("     What can I do for you?");
        System.out.println("    _______________________________________________________");

        Scanner inputs = new Scanner(System.in); //this is the scanner obj

        Task[] tasks = new Task[100];
        int tasknum = 0;

        while (true) {
            String echo = inputs.nextLine(); //this is getting the input

            if (echo.equals("bye") || echo.equals("Bye")) {
                System.out.println("    _______________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("    _______________________________________________________");
                break;
            }

            if (echo.equals("list") || echo.equals("List")) {
                System.out.println("    _______________________________________________________");
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < tasknum; i++) {
                    System.out.println("     " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("    _______________________________________________________");
            } else if (echo.startsWith("mark") || echo.startsWith("Mark")) {
                int pos = echo.indexOf(" ");
                if (pos != -1 && pos + 1 < echo.length()) {
                    String taskStr = echo.substring(pos + 1);

                    int taskNumber = Integer.parseInt(taskStr) - 1; //cause array
                    if (taskNumber >= 0 && taskNumber < tasknum) {
                        tasks[taskNumber].markAsDone();
                        System.out.println("    ____________________________________________________________");
                        System.out.println("     Nice! I've marked this task as done:");
                        System.out.println("       " + tasks[taskNumber]);
                        System.out.println("    ____________________________________________________________");
                    } else erroring(tasknum, taskNumber);
                }
            } else if (echo.startsWith("unmark") || echo.startsWith("Unmark")) {
                int pos = echo.indexOf(" ");
                if (pos != -1 && pos + 1 < echo.length()) {
                    String taskStr = echo.substring(pos + 1);

                    int taskNumber = Integer.parseInt(taskStr) - 1;
                    if (taskNumber >= 0 && taskNumber < tasknum) {
                        tasks[taskNumber].markAsNotDone();
                        System.out.println("    ____________________________________________________________");
                        System.out.println("     Nice! I've marked this task as not done:");
                        System.out.println("       " + tasks[taskNumber]);
                        System.out.println("    ____________________________________________________________");
                    } else {
                        erroring(tasknum, taskNumber);
                    }
                }
            } else if (echo.startsWith("todo") || echo.startsWith("Todo")) {
                int pos = echo.indexOf(" ");
                if (pos != -1 && pos + 1 < echo.length()) {
                    String taskStr = echo.substring(pos + 1);

                    tasks[tasknum] = new Todo(taskStr);

                    tasks[tasknum].markAsNotDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       " + tasks[tasknum]);
                    tasknum++;
                    System.out.println("     Now you have " + (tasknum) + " tasks in the list.");
                    System.out.println("    ____________________________________________________________");
                } else {
                    erroring(tasknum, tasknum);
                }
            } else if (echo.startsWith("deadline") || echo.startsWith("Deadline")) {
                int pos = echo.indexOf(" ");
                int posBy = echo.indexOf("/");
                if (pos != -1 && pos + 1 < echo.length() && posBy != -1 && posBy + 1 < echo.length()) {
                    String taskStr = echo.substring(pos + 1, posBy - 1);
                    String taskStrby = echo.substring(posBy + 4);

                    tasks[tasknum] = new Deadline(taskStr, taskStrby);

                    tasks[tasknum].markAsNotDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       " + tasks[tasknum]);
                    tasknum++;
                    System.out.println("     Now you have " + (tasknum) + " tasks in the list.");
                    System.out.println("    ____________________________________________________________");
                } else {
                    erroring(tasknum, tasknum);
                }
            } else if (echo.startsWith("event") || echo.startsWith("Event")) {
                int pos = echo.indexOf(" ");
                int posFrom = echo.indexOf("/from");
                int posTo = echo.indexOf("/to");
                if (pos != -1 && pos + 1 < echo.length() && posFrom != -1 && posFrom + 1 < echo.length() && posTo != -1 && posTo + 1 < echo.length()) {
                    String taskStr = echo.substring(pos + 1,posFrom - 1);
                    String taskStrFrom = echo.substring(posFrom + 6, posTo - 1);
                    String taskStrTo = echo.substring(posTo + 4);

                    tasks[tasknum] = new Event(taskStr, taskStrFrom, taskStrTo);

                    tasks[tasknum].markAsNotDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       " + tasks[tasknum]);
                    tasknum++;
                    System.out.println("     Now you have " + (tasknum) + " tasks in the list.");
                    System.out.println("    ____________________________________________________________");
                } else {
                    erroring(tasknum, tasknum);
                }
            } else {
                System.out.println("    _______________________________________________________");
                System.out.println("     added:" + echo);
                tasks[tasknum] = new Task(echo);
                tasknum++;
                System.out.println("    _______________________________________________________");
            }
        }
    }

    private static void erroring(int tasknum, int taskNumber) {
        if (taskNumber >= tasknum) {
            System.out.println("    ____________________________________________________________");
            System.out.println("    ERROR! YOU DON'T HAVE THAT MANY TASKS. TRY AGAIN.");
            System.out.println("    ____________________________________________________________");
        } else {
            System.out.println("    ____________________________________________________________");
            System.out.println("    NEGATIVE TASKS? THAT DOESN'T EXIST. TRY AGAIN.");
            System.out.println("    ____________________________________________________________");
        }
    }
}



