public class ExceptionHandling {

    public static void main(String[] args) {

        try {
            // This code will throw an exception
            int data = 100 / 0;
        } catch (ArithmeticException e) {
            // This code will be executed if an exception is thrown
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Rest of the code...");
    }
}