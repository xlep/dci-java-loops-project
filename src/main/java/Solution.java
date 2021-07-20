import java.util.Scanner;

public class Solution {

  public static void main (String[] args) {

    do {
      // query for input
      Scanner inputScanner = new Scanner(System.in);
      System.out.println("Enter a number (leave empty to end):");

      // convert to int (or exit)
      String inputString = inputScanner.nextLine();
      if (inputString == null || "".equals(inputString)) {
        System.out.println("No input found. Terminating.");
        break;
      }
      int inputNumber = Integer.parseInt(inputString);

      // since we do not know how to use methods yet, I'll use blocks to separate the instructions
      // into smaller sections

      System.out.println("Characteristics of " + inputNumber);

      // even or odd
      {
        if (inputNumber % 2 == 0) {
          System.out.println("Is even.");
        } else {
          System.out.println("Is odd.");
        }
      }

      // Prime
      {
        int currentNumber = inputNumber;
        do {
          // any number between 2 and 100 needs to be checked
          int previousNumber = 2;

          boolean isPrime = true;
          while (previousNumber < currentNumber) {
            // if there is no remainder, we add it to our list of prime numbers
            if (currentNumber % previousNumber == 0) {
              isPrime = false;
            }
            previousNumber++;
          }

          // decide the output
          StringBuilder output = new StringBuilder();
          if (isPrime) {
            if (currentNumber == inputNumber) {
              output.append("Is a prime number.");
            } else {
              output.append("The next prime number is " + currentNumber);
            }
            System.out.println(output.toString());
            break;
          }
          currentNumber++;
        } while (true);
      }

      // Perfect number
      {
        int currentNumber = inputNumber;
        do {
          int previousNumbers = 1;
          int sumOfDivisors = 0;

          do {
            if (currentNumber % previousNumbers == 0) {
              sumOfDivisors += previousNumbers;
            }
            previousNumbers++;
          } while (previousNumbers < currentNumber);

          StringBuilder output = new StringBuilder();
          if (sumOfDivisors == currentNumber) {
            if (currentNumber == inputNumber) {
              output.append("Is a perfect number.");
            } else {
              output.append("The next perfect number is : " + currentNumber);
            }
            System.out.println(output.toString());
            break;
          }
          currentNumber++;
        } while (true);
      }

      // Fibonacci
      {
        int member1 = 0;
        int member2 = 1;
        int nextMember = 0;
        StringBuilder output = new StringBuilder();
        output.append("Fibonacci sequence until input: ");

        do {
          nextMember = member1 + member2;
          member1 = member2;
          member2 = nextMember;

          if (nextMember <= inputNumber) {
            output.append(nextMember + " ");
          }
        } while (nextMember < inputNumber);

        System.out.println(output.toString());
      }

      // Factorials
      {
        StringBuilder output = new StringBuilder();
        output.append(inputNumber + "! = ");

        int factorialResult = 1;
        for (int factorialsCount = inputNumber; factorialsCount >= 1; factorialsCount--) {
          factorialResult *= factorialsCount;
          output.append(factorialsCount);

          if (factorialsCount != 1) {
            output.append(" x ");
          }
        }
        output.append(" = " + factorialResult);
        System.out.println(output.toString());
      }

      System.out.println("\n\n\n\n");
    } while (true);
  }

}
