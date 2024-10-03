import java.util.InputMismatchException;
import java.util.Scanner;

// Main class
public class ChineseZodiacCalculator {

    // Interface for displaying zodiac info
    interface ZodiacInfo {
        void displayZodiacInfo();
    }

    // Nested class representing a Zodiac sign
    class Zodiac implements ZodiacInfo {
        private String sign;
        private String luckyColor;
        private int luckyNumber;
        private String prediction;

        // Constructor for initializing Zodiac properties
        public Zodiac(String sign, String luckyColor, int luckyNumber, String prediction) {
            this.sign = sign;
            this.luckyColor = luckyColor;
            this.luckyNumber = luckyNumber;
            this.prediction = prediction;
        }

        // Method to display zodiac info
        public void displayZodiacInfo() {
            System.out.println("Your Chinese Zodiac sign is: " + sign);
            System.out.println("Lucky Color: " + luckyColor);
            System.out.println("Lucky Number: " + luckyNumber);
            System.out.println("Prediction: " + prediction);
        }
    }

    // Method to determine the Zodiac sign based on the birth year
    public Zodiac determineZodiac(int year) {
        switch (year % 12) {
            case 0:
                return new Zodiac("Monkey", "Gold", 9, "Foster success through compromise and collaborative ventures.");  
            case 1:
                return new Zodiac("Rooster", "Yellow", 5, "Blessed with the support and favor of auspicious stars, leading to a relatively prosperous personal fortune.");
            case 2:
                return new Zodiac("Dog", "Gray-Red", 7, "A year filled with both obstacles and successes. ");
            case 3:
                return new Zodiac("Pig", "Sky-Black or Black-Pink", 69420, "With opportunities for passionate and affectionate relationships. ");
            case 4:
                return new Zodiac("Rat", "White-Gold", 8, "Be open to change and willing to take calculated risks to advance their careers. ");
            case 5:
                return new Zodiac("Ox", "Blue-Green", 3, "Promising for the careers, with steady progress and good results..");
            case 6:
                return new Zodiac("Tiger", "Green-Orange", 1, "A year of courage and leadership.");
            case 7:
                return new Zodiac("Rabbit", "Purple-White", 2, "Confidence and optimism, achieving success in their careers and relationships.");
            case 8:
                return new Zodiac("Dragon", "Red-Gold", 6, "Representing authority, prosperity, and good fortune. ");
            case 9:
                return new Zodiac("Snake", "Black-Red", 4, "Expected to bring opportunities for career advancement.");
            case 10:
                return new Zodiac("Horse", "Silver-Blue", 9, "Actively build your network to achieve success.");
            case 11:
                return new Zodiac("Goat", "Pink-Green", 5, "A dynamic journey filled with both challenges and opportunities.");
            default:
                throw new IllegalArgumentException("Invalid year.");
        }
    }

    // Main method
    public static void main(String[] args) {
        ChineseZodiacCalculator calculator = new ChineseZodiacCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // Get birth year from the user
            System.out.print("Enter your birth year (e.g., 1996): ");
            int birthYear = scanner.nextInt();
            if (birthYear < 1900 || birthYear > 2100) {
                throw new IllegalArgumentException("Year must be between 1900 and 2100.");
            }

            // Get birth month from the user
            System.out.print("Enter your birth month (1-12): ");
            int birthMonth = scanner.nextInt();
            if (birthMonth < 1 || birthMonth > 12) {
                throw new IllegalArgumentException("Month must be between 1 and 12.");
            }

            // Get birth day from the user
            System.out.print("Enter your birth day (1-31): ");
            int birthDay = scanner.nextInt();
            if (birthDay < 1 || birthDay > 31) {
                throw new IllegalArgumentException("Day must be between 1 and 31.");
            }

            // Determine the user's zodiac sign
            Zodiac userZodiac = calculator.determineZodiac(birthYear);
            userZodiac.displayZodiacInfo();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}