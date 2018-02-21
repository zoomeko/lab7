package week_7.service_calls;

/** The instructions are in grades/Lab 7 Questions.md  */

public class Question_2_HVAC {

    /** Program to manage service calls to furnaces and AC units
     * All this does is launch the ServiceCallManager and start it managing calls */

    public static void main(String[] args) {

        ServiceCallManager manager = new ServiceCallManager();
        manager.manageCalls();
    
    }
}
