package utils;

import com.github.javafaker.Faker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FakeDataGenerator {

    private static final String SEPARATOR = ", ";

    public static void main(String[] args) {
        FakeDataGenerator.fakeDataGenerator();
    }

    public static void fakeDataGenerator() {
        Faker faker = new Faker();
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Input num of identities to create: ");
        if (input.hasNextInt()) {
            number = input.nextInt();
            if (number < 0) {
                throw new InputMismatchException("Number must be higher than 0");
            }
        } else {
            throw new InputMismatchException("Invalid data type. Please input integer");
        }

        for (int i = 0; i < number; i++) {
            String email = faker.internet().emailAddress();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String city = faker.address().cityName();
            String nineDigitPersonalIdNumber = faker.number().digits(9);
            System.out.println(email + SEPARATOR + firstName + SEPARATOR + lastName + SEPARATOR + city + SEPARATOR +
                    nineDigitPersonalIdNumber);
        }

        input.close();
    }
}