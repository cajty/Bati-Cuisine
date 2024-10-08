package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public   class  Helper {


    private static final Scanner input = ScannerSingleton.getScanner();

    public static int getValidNumberInput() {
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
        }
        return input.nextInt();
    }

    public static double getValidDoubleInput() {
        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");

        }
        return input.nextDouble();
    }



    public static LocalDate convertToDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();

        try {
            if (LocalDate.parse(dateStr, formatter).isAfter(today)) {
                return LocalDate.parse(dateStr, formatter);
            }
            return null;
        } catch (DateTimeParseException e) {
            return null;
        }
    }


    public static LocalDate[] inputAndValidateDates() {


        String dateStart;
        String dateEnd;
        LocalDate startDate = null;
        LocalDate endDate = null;


        while (startDate == null || endDate == null) {
            System.out.println("Entrez la date d'émission du devis (format : aaaa-mm-jj) :");
            dateStart = input.nextLine();
            startDate = convertToDate(dateStart);

            if ( startDate == null) {
                System.out.println("Invalid  date d'émission du devis");
                continue;
            }

            System.out.println("Entrez la date de validité du devis (format : aaaa-mm-jj) :");
            dateEnd = input.nextLine();
            endDate = convertToDate(dateEnd);
            if (endDate == null) {
                System.out.println("Invalid la date de validité du devis");
                continue;
            }

            if (startDate.isAfter(endDate)) {
                System.out.println("la date d'émission du devis date must  date d'émission du devis");
                startDate = null;
                endDate = null;
            }
        }

        return new LocalDate[]{startDate, endDate};
    }


    public static int geProjectIdFromUser() {

        int id = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter id of Project:");
                id = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next();
            }
        }

        return id;
    }
}
