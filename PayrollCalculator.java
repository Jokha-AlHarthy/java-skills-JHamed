public class PayrollCalculator {

    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Invalid input: negative values.");
            return 0.0;
        }

        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    return hoursWorked * hourlyRate;
                } else {
                    return 40 * hourlyRate + (hoursWorked - 40) * hourlyRate * 1.5;
                }

            case "PART_TIME":
                if (hoursWorked <= 25) {
                    return hoursWorked * hourlyRate;
                } else {
                    System.out.println("PART_TIME cannot work more than 25 hours.");
                    return 0.0;
                }

            case "CONTRACTOR":
                return hoursWorked * hourlyRate;

            case "INTERN":
                if (hoursWorked <= 20) {
                    return hoursWorked * hourlyRate * 0.80;
                } else {
                    System.out.println("INTERN cannot work more than 20 hours.");
                    return 0.0;
                }

            default:
                System.out.println("Invalid employee type: " + employeeType);
                return 0.0;
        }
    }


    // Method to calculate tax deduction based on pay brackets
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax;
        if(grossPay <= 500){
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if(hasHealthInsurance){
            tax-=50;
        }

        return Math.max(tax, 0);
    }

    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        if(employeeTypes.length != hours.length || hours.length != rates.length ||  rates.length != names.length){
            System.out.println("Input arrays must have the same length");
            return;
        }

        double highestPay = Double.MIN_VALUE;
        double lowestPay = Double.MAX_VALUE;
        String highestName = "";
        String lowestName = "";
        int overTimeCount = 0;
        double totalPay = 0;

        System.out.printf("%-10s %-12s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Pay", "Tax");

        for(int i = 0; i < names.length; i++){
            double pay = calculateWeeklyPay(employeeTypes[i],hours[i],rates[i]);
            double tax = calculateTaxDeduction(pay,true);
            double net = pay - tax;

            System.out.printf("%-10s %-12s %-10.2f %-10.2f %-10.2f\n", names[i], employeeTypes[i], hours[i], pay, tax);

            totalPay += pay;

            if(pay > highestPay){
                highestPay = pay;
                highestName = names[i];
            }

            if(pay < lowestPay){
                lowestPay = pay;
                lowestName = names[i];
            }

            if (employeeTypes[i].equals("FULL_TIME") && hours[i] > 40){
                overTimeCount++;
            }
        }
        double averagePay = totalPay / names.length;
        System.out.println("Highest paid: " + highestName + "($" + highestPay + ")");
        System.out.println("Lowest paid: " + lowestName + "($" + lowestPay + ")");
        System.out.println("Average Pay: " + averagePay);
        System.out.println("Employees with overtime: "+overTimeCount);
    }

    public static void main(String[] args){
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        processPayroll(types, hours, rates, names);
    }
}
