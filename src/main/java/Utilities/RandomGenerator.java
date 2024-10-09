package Utilities;

import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    // Generate valid first name
    public static String generateRandomFirstName() {
        Random random = new Random();
        String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "Chris", "Sarah"};
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        return firstName.length() <= 32 ? firstName : firstName.substring(0, 32);
    }

    // Generate valid last name
    public static String generateRandomLastName() {
        Random random = new Random();
        String[] LAST_NAMES = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown"};
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return lastName.length() <= 32 ? lastName : lastName.substring(0, 32);
    }

    // Generate valid email
    public static String generateRandomEmail() {
        Random random = new Random();
        String[] ADJECTIVES = {"quick", "brown", "lazy", "happy", "smart", "funny", "curious"};
        String[] NOUNS = {"fox", "dog", "cat", "horse", "bird", "fish", "tree"};
        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[random.nextInt(NOUNS.length)];
        int randomNum = random.nextInt(9000) + 1000;

        String gmail = adjective + noun + randomNum + "@gmail.com";
        return gmail;
    }

    // Generate invalid email
    public static String generateInvalidEmail() {
        String[] invalidEmails = {
                "user@",           // Missing domain
                "@example.com",    // Missing username
                "user@example",     // Missing top-level domain
                "user@.com",       // Invalid format
                "user@-example.com" // Invalid domain
        };
        return invalidEmails[new Random().nextInt(invalidEmails.length)];
    }

    // Generate valid password
    public static String generateRandomPassword(int length) {
        Random random = new Random();
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return password.toString();
    }

    // Generate invalid password
    public static String generateInvalidPassword() {
        String[] invalidPasswords = {
                "123",             // Too short
                "pass",            // Too short
                "",                // Empty password
                "abc",             // Too short
                "123456789012345678901" // Too long
        };
        return invalidPasswords[new Random().nextInt(invalidPasswords.length)];
    }

    // Generate valid telephone number
    public static String generateRandomTelephoneNumber() {
        Random random = new Random();
        return String.format("+%d (%d) %03d-%04d",
                random.nextInt(10) + 1,  // Country code (1-9)
                random.nextInt(900) + 100, // Area code (100-999)
                random.nextInt(1000), // Prefix (000-999)
                random.nextInt(10000)); // Line number (0000-9999)
    }

    // Generate invalid telephone number
    public static String generateInvalidTelephoneNumber() {
        String[] invalidPhoneNumbers = {
                "12",               // Too short
                "abc-def-ghij",     // Non-numeric
                "+1 (800) 123-456", // Invalid area code (not within range)
                "123456789012345678901234567890123", // Too long
                "" // Empty
        };
        return invalidPhoneNumbers[new Random().nextInt(invalidPhoneNumbers.length)];
    }

    // Generate a random integer between 11 and 12
    public static int generateRandomInt() {
        Random rand = new Random();
        return rand.nextInt(2) + 11; // Generates a random number between 11 and 12
    }

    public static String generateRandomProduct() {
        Random random = new Random();
        String[] PRODUCTS = {
                "Laptop", "iPhone", "iPad", "Tablet", "Smartwatch", "Headphones", "Camera"};
        return PRODUCTS[random.nextInt(PRODUCTS.length)];
    }

    public static void hoverAndClickRandomCategory(List<WebElement> categoryElements) {
        if (!categoryElements.isEmpty()) {
            int randomSubCategoryIndex = new Random().nextInt(categoryElements.size());
            categoryElements.get(randomSubCategoryIndex).click();
        } else {
            throw new RuntimeException("No categoryElements found.");
        }
    }

    // Generate a random integer between 12 and 15 also 18
    public static int generateRandomNumberInFirstThreeCategory() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 12; // Generate a random number between 12 and 14

        // Ensure the number is either 12, 15, or 18
        if (randomNumber == 13) {
            randomNumber = 15;
        }
        return randomNumber;
    }

    public static String generateRandomCity() {
        String[] CITIES = {
                "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
                "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose",
                "Austin", "Jacksonville", "San Francisco", "Columbus", "Fort Worth",
                "Charlotte", "Indianapolis", "Seattle", "Denver", "Washington D.C."
        };
        Random random = new Random();
        int index = random.nextInt(CITIES.length);
        return CITIES[index];
    }

    public static String generateAddress() {
        String[] CITIES = {
                "New York", "Los Angeles", "Chicago", "Houston", "Phoenix"
        };
        String[] STREETS = {
                "Main St", "High St", "Broadway", "Elm St", "Maple Ave"
        };
        Random random = new Random();
        int streetNumber = random.nextInt(9999) + 1; // Random street number
        String street = STREETS[random.nextInt(STREETS.length)];
        String city = CITIES[random.nextInt(CITIES.length)];
        String zip = String.format("%05d", random.nextInt(100000)); // Random zip code

        return streetNumber + " " + street + ", " + city + " " + zip;
    }

    public static String generatePostalCode() {
        Random random = new Random();
        // Generate a random 5-digit postal code
        return String.format("%05d", random.nextInt(100000));
    }
}