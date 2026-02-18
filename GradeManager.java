public class GradeManager {
    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        String [] reserved = new String[names.length];
        for(int i = 0; i < names.length; i++){
            reserved[i] = new StringBuilder(names[i]).reverse().toString();
        }
        return reserved;
    }

    // Method to calculate letter grades
    public static char getLetterGrade(int score) {
        if(score>= 90){
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
           return 'D';
        }else {
            return 'F';
        }
    }

    // Method to find students who need to retake exam
    public static String[] findFailingStudents(String[] names, int[] scores) {
      int count = 0;
      for(int score : scores){
          if(score < 60){
              count++;
          }
      }
        String[] failed = new String[count];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failed[index++] = names[i];
            }
        }
        return failed;
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        System.out.println("Reversed Names: ");
        String [] reversed = reverseStudentNames(students);
        for(String name: reversed){
            System.out.println(name);
        }

        System.out.println("\n Letter Grades: ");
        for(int i = 0; i < scores.length; i++){
            System.out.println(students[i] + ": "+ getLetterGrade(scores[i]));
        }

        System.out.println("\n Failing students: ");
        String [] failed = findFailingStudents(students,scores);
        for(String name: failed){
            System.out.println(name);
        }


    }
}
