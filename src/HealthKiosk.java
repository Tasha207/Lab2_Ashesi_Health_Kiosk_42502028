import java.util.Scanner;
import java.util.Random;
public class HealthKiosk {
    public static void main() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter service code (P/L/T/C):");

        //TASK ONE
        char inputletter = input.next().toUpperCase().charAt(0);
        String service = "";
        switch (inputletter) {
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                service = "Pharmacy Desk";
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                service = "Lab Desk";
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                service = "Triage Desk";
                break;
            case 'C':
                System.out.println("Go to: Counseling Desk");
                service = "Counseling Desk";
                break;

            default:
                System.out.println("Invalid service code");
                return;
        }

        //TASK TWO
        System.out.print("Enter health metric (1=BMI, 2=Dosage, 3=Trig): ");
        int choice = input.nextInt();

        double metricValue = 0;


        //OPTION A
        if (choice == 1) {
            System.out.print("Enter weight in kilograms: ");
            double weight = input.nextDouble();
            System.out.print("Enter height in meters: ");
            double height = input.nextDouble();
            double bmi = weight / (height * height);
            double bmiRounded = Math.round(bmi * 10) / 10.0;
            metricValue = Math.round(bmi);



            String category;
            if (bmiRounded < 18.5) {
                category = "Underweight";

            } else if (bmiRounded >= 18.5 && bmiRounded <= 24.9) {
                category = "Normal";
            } else if (bmiRounded >= 25.0 && bmiRounded <= 29.9) {
                category = "Overweight";
            } else {
                category = "Obese";
            }
            System.out.println("BMI: " + bmiRounded);
            System.out.println("Category: " + category);
        }

        //OPTION B
        if (choice == 2) {
            System.out.println("Enter dosage: ");
            double dosage = input.nextDouble();
            //pharmacy dispenses 250mg per day
            int tablets = (int) Math.ceil(dosage / 250.0);
            System.out.println("Tablets needed are : " + tablets);
            metricValue = tablets;
        }

        //OPTION C
        if (choice == 3) {
            System.out.println("Enter an angle");
            double angle = input.nextDouble();
            double radians = Math.toRadians(angle);
            double sinVal = Math.round(Math.sin(radians) * 1000) / 1000.0;
            double cosVal = Math.round(Math.cos(radians) * 1000) / 1000.0;

            System.out.println("Sin is " + sinVal + " and Cos is " + cosVal);
            metricValue = Math.round(Math.sin(radians) * 100);
        }

        //TASK THREE
        char randChar = (char) ('A' + rand.nextInt(26));
        String id = "" + randChar;
        for (int i = 0; i < 4; i++) {
            id += (rand.nextInt(7) + 3);
        }
        System.out.println("ID: " + id);

        if (id.length() != 5) {
            System.out.print("ID length is inaccurate");
        }
        else if (!Character.isLetter(id.charAt(0))) {
            System.out.println("First value must be a letter");
        }
        else if (!Character.isDigit(id.charAt(1)) || !Character.isDigit(id.charAt(2)) || !Character.isDigit(id.charAt(3)) || !Character.isDigit(id.charAt(4))) {
            System.out.print("Second to fifth values must be numbers");
        }
        else {
            System.out.println("ID OK");
        }

        //TASK FOUR
        System.out.println("Enter name: ");
        String name = input.next();
        char basechar = Character.toUpperCase(name.charAt(0));
        char shifted = (char) ('A' + (basechar - 'A' + 2) % 26);

        String lastTwo = id.substring(id.length() - 2);
        String code = shifted + lastTwo + "-" + (int) metricValue;

        System.out.println("Display Code: " + code);

        //TASK FIVE
        System.out.println(service + " | " + " ID: " + id + " | " + "Code: "+ code );



        }
    }



