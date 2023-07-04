import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, "+name);
        String options = sc.nextLine();

        System.out.println("Okay, let's start");

        String[] optionsArray = options.split(",");



        int rating = readingRating(name);
        if(options.isEmpty()){
            mainLogic(rating, sc);

        }else{

            String[] option = optionsArray;

            Random random = new Random();
            String chosenOption = sc.next();


            // Find the index of the chosen option
            int chosenIndex = -1;
            for (int i = 0; i < option.length; i++) {
                if (option[i].equals(chosenOption)) {
                    chosenIndex = i;
                    break;
                }
            }

            // Rearrange the options based on the chosen option
            String[] rearrangedOptions = new String[option.length];
            int index = 0;

            // Add options after the chosen option
            for (int i = chosenIndex + 1; i < option.length; i++) {
                rearrangedOptions[index] = option[i];
                index++;
            }

            // Add options before the chosen option
            for (int i = 0; i < chosenIndex; i++) {
                rearrangedOptions[index] = option[i];
                index++;
            }
            int mid = option.length/2;

            for(String j : rearrangedOptions){
                String randomIn = random.toString();
            }

            int ranNum = random.nextInt(rearrangedOptions.length);
            String ranName = rearrangedOptions[ranNum];
            if(ranNum>mid){
                System.out.println("Well done. The computer chose" +" " + ranName + " and failed");
            }
            else if(ranNum<mid){
                System.out.println("Sorry, but the computer chose"+" "+ranName);
            }
        }
    }








    public static int readingRating(String name){
        File file = new File("rating.txt");
        int rating = 0;

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String temp = scanner.next();
                if(temp.equals(name)){
                    rating = scanner.nextInt();
                    return rating;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void mainLogic(int rating,Scanner sc){
        while(true){

            String input = sc.nextLine();
            Random random = new Random();
            String randomName;

            int randomNumber = random.nextInt(3)+1;
            if (randomNumber == 1) {
                randomName = "rock";
            } else if (randomNumber == 2) {
                randomName = "paper";
            } else {
                randomName = "scissors";
            }



            if(input.equals("rock")&&randomName.equals("paper")){
                System.out.println("Sorry, but the computer chose"+" "+randomName);


            }
            else if(input.equals("paper")&&randomName.equals("scissors")){
                System.out.println("Sorry, but the computer chose"+" "+randomName);

            }
            else if(input.equals("scissors")&&randomName.equals("rock")){
                System.out.println("Sorry, but the computer chose"+" "+randomName);

            }


            else if(input.equals("rock")&&randomName.equals("scissors")){
                System.out.println("Well done. The computer chose" +" " + randomName + " and failed");
                rating+= 100;
            }
            else if(input.equals("paper")&&randomName.equals("rock")){
                System.out.println("Well done. The computer chose" +" " + randomName + " and failed");
                rating+= 100;
            }
            else if(input.equals("scissors")&&randomName.equals("paper")){
                System.out.println("Well done. The computer chose" +" " + randomName + " and failed");
                rating+= 100;

            }


            else if(input.equals(randomName)){
                System.out.println("There is a draw"+" "+input);
                rating+=50;

            }
            else if(input.equals("!rating")){
                System.out.printf("Your rating %d",rating);
            }


            else if(input.equals("!exit")){
                System.out.println("Bye!");
                break;

            }


            else{
                System.out.println("Invalid input");
            }

        }
    }

}