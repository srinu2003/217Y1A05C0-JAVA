public class Exception {

    public static void main(String[] args) {

        try {

            // This code may throw an exception
            int data = 100 / 0;

        } catch (ArithmeticException e) {

            // This code will be executed if an exception is thrown
            System.out.println("An exception has been caught: " + e.getMessage());

        } finally {

            // This code will always be executed, regardless of whether an exception is thrown
            System.out.println("This code will always be executed");

        }

    }

}