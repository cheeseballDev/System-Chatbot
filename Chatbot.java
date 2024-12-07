
import java.util.Arrays;
import java.util.Scanner;

public class Chatbot extends ChatbotData implements Runnable, Miscellaneous {

    private int attempts = 0;

    public Chatbot() {
        clearScreen();
    }

    public void runChatbot() {
        ChatbotData chatbotData = new ChatbotData();
        Scanner userInput = new Scanner(System.in);

        showDialogue("Welcome to Mika's restaurant! I am BOT Mika, how many I help you today?\n> ".toCharArray());
        String userResponse;
        while (true) {
            while (attempts != 3) {       
                userResponse = userInput.nextLine().toLowerCase().trim();     
                if (!Arrays.asList(chatbotData.responsesContent()).contains(userResponse)){
                    showDialogue(getResponseStart(userResponse).toCharArray());
                    attempts++;
                    continue;
                }
                showDialogue(getResponseStart(userResponse).toCharArray());
                reservation(chatbotData, userInput);
            }
            showDialogue("\nWould you like a list of things I can assist you with?\n> ".toCharArray());
            userResponse = userInput.nextLine().toLowerCase().trim();
            if (userResponse.contains("yes")) {
                System.out.println("LIST OF THINGS:\n> Reservation\n> Menu\n> Operating hours");
                attempts = 0;
            } else if (userResponse.contains("no")){
                showDialogue("Thank you for visiting Mika's restaurant! Please come again soon!".toCharArray());
                System.exit(0);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }
    
    public void reservation(ChatbotData chatbotData, Scanner userInput){
        attempts = 0;
        while (true) {            
            String userResponse = userInput.nextLine().toLowerCase();
            if(Arrays.asList(chatbotData.reservationsContents()).contains(userResponse.toLowerCase())){
                showDialogue(getReservationResponse(userResponse).toCharArray());
                ifNewCustomer(chatbotData, userInput);
            }else{
                showDialogue(getReservationResponse(userResponse).toCharArray());
            }
        }     
    }


    public void ifNewCustomer(ChatbotData chatbotData, Scanner userInput){
        System.out.println("New customer?");
        String userResponse = userInput.nextLine().toLowerCase();
        if(Arrays.asList(chatbotData.ifNewCustomerResponseContents()).contains(userResponse)){
            System.out.println(getIfNewCustomerResponse(userResponse));
        }else{
            System.out.println(getIfNewCustomerResponse(userResponse));
        }
    }


    public void run() {
        try {
            Thread.sleep(35);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    @Override
    public void showDialogue(char[] dialogue) {
        char[] characters = dialogue;
        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            run();
        }
    }
    
    @Override
    public void printErrorMessage(String errorMessage) {
        clearScreen();
        System.out.print(errorMessage);
        char[] characters = {'.', ' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            run();
        }
        clearScreen();
    }
    
}
