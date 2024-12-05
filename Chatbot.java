
import java.util.Arrays;
import java.util.Scanner;

public class Chatbot extends ChatbotData implements Runnable, Miscellaneous {

    public Chatbot() {
        clearScreen();
    }

    public void runChatbot() {
        ChatbotData cbData = new ChatbotData();
        Chatbot chatbot = new Chatbot();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to Mika's restaurant! I am BOT Mika, how many I help you today?");
        while (true) {            
            String userResponse = userInput.nextLine().toLowerCase();
            if(Arrays.asList(cbData.responsesContent()).contains(userResponse)){
                System.out.println(getResponse(userResponse));
                reservation(cbData, userInput);
            }else{
                System.out.println(getResponse(userResponse));
            }
        }
    }
    
    public void reservation(ChatbotData cbData, Scanner userInput){
        while (true) {            
            String userResponse = userInput.nextLine().toLowerCase();
            if(Arrays.asList(cbData.reservationsContents()).contains(userResponse.toLowerCase())){
                System.out.println(getReservationResponse(userResponse));
                ifNewCustomer(cbData, userInput);
            }else{
                System.out.println(getReservationResponse(userResponse));
            }
        }     
    }


    public void ifNewCustomer(ChatbotData cbData, Scanner userInput){
        System.out.println("New customer?");
        String userResponse = userInput.nextLine().toLowerCase();
        if(Arrays.asList(cbData.ifNewCustomerResponseContents()).contains(userResponse)){
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
