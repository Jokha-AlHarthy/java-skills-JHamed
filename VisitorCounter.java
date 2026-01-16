public class VisitorCounter {
    // Static variable to count total visitors
    private static int totalVisitors = 0;

    // Non-static variable for individual session
    private int sessionVisits;
    private String visitorName;

    // Constructor
    public VisitorCounter(String visitorName) {
        this.visitorName = visitorName;
        this.sessionVisits = 0;
        totalVisitors++;
    }

    // Non-static method
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }

    // Static method
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }

    // Static method to get total (getter)
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static void main(String[] args) {
        VisitorCounter v1 = new VisitorCounter("Ahmed");
        VisitorCounter v2 = new VisitorCounter("Yaqoop");
        VisitorCounter v3 = new VisitorCounter("Mubarak");

        v1.recordVisit();
        v2.recordVisit();
        v3.recordVisit();
        v2.recordVisit();
        v1.recordVisit();

        VisitorCounter.displayTotalVisitors();
    }
}
