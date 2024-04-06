import java.util.Scanner;

public class SimpleCalculator {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        double firstNumber, secondNumber;
        int operation;

        for(;;) {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Choose an operation:");
            System.out.println("[1]Addition.\n[2]Subtraction.\n[3]Division.\n[4]Multiplication.\n");

            operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("What's the first number of the operation?");
                    firstNumber = scanner.nextDouble();
                    System.out.println("What's the second number of the operation?");
                    secondNumber = scanner.nextDouble();
                    System.out.println("The result is: " + (firstNumber + secondNumber));
                    break;

                case 2:
                    System.out.println("What's the first number of the operation?");
                    firstNumber = scanner.nextDouble();
                    System.out.println("What's the second number of the operation?");
                    secondNumber = scanner.nextDouble();
                    System.out.println("The result is: " + (firstNumber - secondNumber));
                    break;

                case 3:
                    System.out.println("What's the first number of the operation?");
                    firstNumber = scanner.nextDouble();
                    System.out.println("What's the second number of the operation?");
                    secondNumber = scanner.nextDouble();
                    System.out.println("The result is: " + (firstNumber / secondNumber));
                    break;

                case 4:
                    System.out.println("What's the first number of the operation?");
                    firstNumber = scanner.nextDouble();
                    System.out.println("What's the second number of the operation?");
                    secondNumber = scanner.nextDouble();
                    System.out.println("The result is: " + (firstNumber * secondNumber));
                    break;

                default:
                    System.out.println("Error, try again later.");
            }

            try {
                // Coloca a thread atual para dormir por 2 segundos (2000 milissegundos)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // Lidar com a exceção, se a thread for interrompida enquanto dorme
                e.printStackTrace();
            }
        }

    }
}
