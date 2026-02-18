public class UserInfoSystem {
    // Create these variables with proper access modifiers
    private String name;
    private int age;
    private String email;
    private boolean isActive;


    //Create constructor that takes all parameters
    public UserInfoSystem(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    //Create getter and setter methods for all variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Create a method that displays user info nicely formatted
    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Email: "+email);
        System.out.println("Is the user active: "+(isActive? "Yes": "No"));
    }

    // Main method for testing
    public static void main(String []args){
        //Create 3 different users
        UserInfoSystem user1 = new UserInfoSystem("Jokha", 23, "jokha.hamed.official@gmail.com", true);
        UserInfoSystem user2 = new UserInfoSystem("Hamed", 58, "hamed.official@gmail.com", true);
        UserInfoSystem user3 = new UserInfoSystem("Rashid", 29, "Rashid.hamed.official@gmail.com", true);

        System.out.println("Jokha's email: " + user1.getEmail());

        user1.setAge(24);
        System.out.println("Jokha's age: "+ user1.getAge());


    }
}
