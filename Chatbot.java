
import java.util.Arrays;
import java.util.Scanner;

public class Chatbot extends ChatbotData implements Runnable, Miscellaneous {

    public Chatbot() {
        clearScreen();
    }

    public void runChatbot() {
        ChatbotData chatbotData = new ChatbotData();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to Mika's restaurant! I am BOT Mika, how many I help you today?");
        while (true) {            
            String userResponse = userInput.nextLine().toLowerCase();
            if(Arrays.asList(chatbotData.responsesContent()).contains(userResponse)){
                System.out.println(getResponseStart(userResponse));
                reservation(chatbotData, userInput);
            }
            System.out.println(getResponseStart(userResponse));
        }
    }
    
    public void reservation(ChatbotData chatbotData, Scanner userInput){
        while (true) {            
            String userResponse = userInput.nextLine().toLowerCase();
            if(Arrays.asList(chatbotData.reservationsContents()).contains(userResponse.toLowerCase())){
                System.out.println(getReservationResponse(userResponse));
                ifNewCustomer(chatbotData, userInput);
            }else{
                System.out.println(getReservationResponse(userResponse));
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

    
    
    private void checkCondition(String userResponse) {
        //if (userResponse.equals()) {
        //}
    }

    public void run() {
        try {
            Thread.sleep(50);
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
