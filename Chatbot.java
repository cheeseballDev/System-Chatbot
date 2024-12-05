
import java.util.Scanner;

public class Chatbot extends ChatbotData implements Runnable, Miscellaneous {

    public Chatbot() {
        clearScreen();
    }

    public void runChatbot() {
        Chatbot chatbot = new Chatbot();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to Mika's restaurant! I am BOT Mika, how many I help you today?");
        while (true) {
            String userResponse = userInput.nextLine();
            System.out.println(getResponse(userResponse));
        }
    }

    public void reservation(Chatbot chatbot, Scanner userInput){
        while (true) {

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
