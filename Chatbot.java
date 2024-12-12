
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Chatbot extends ChatbotData implements Runnable, Miscellaneous {
    Random random = new Random();
    private int rng = random.nextInt(30)+30;
    private int attempts = 0;

    public Chatbot() {
        clearScreen();
    }

    public void runChatbot() {
        ChatbotData chatbotData = new ChatbotData();
        Scanner userInput = new Scanner(System.in);

        showDialogue("Welcome to Kyoto's Finest! I am BOT Mika, may I have your name please?\n> ".toCharArray());
        String userResponse;
        while (true) {
            while (attempts != 4) {       
                userResponse = userInput.nextLine().toLowerCase().trim();    
                if (!Arrays.asList(chatbotData.getResponsesContent()).contains(userResponse)){
                    clearScreen();
                    showDialogue(getResponseStart(userResponse).toCharArray());
                    attempts++;
                    continue;
                } else if (attempts == 3) {
                    /*
                     * for prompt
                     */
                }
                clearScreen();
                showDialogue(getResponseStart(userResponse).toCharArray());
                reservation(chatbotData, userInput);
            }
            clearScreen();
            showDialogue("Would you like a list of things I can assist you with?\n> ".toCharArray());
            userResponse = userInput.nextLine().toLowerCase().trim();

            // add to prompt
            if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(userResponse)) {
                attempts = 0;
                runChatbot();
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)){
                showDialogue("Thank you for visiting Kyoto's Finest! Please come again soon!".toCharArray());
                System.exit(0);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }
    
    public void reservation(ChatbotData chatbotData, Scanner userInput){
        attempts = 0;
        while (true) {            
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if(Arrays.asList(chatbotData.getReservationsContent()).contains(userResponse)){
                showDialogue(getReservationResponse(userResponse).toCharArray());
                //ifNewCustomer(chatbotData, userInput);
            }else{
                showDialogue(getReservationResponse(userResponse).toCharArray());
            }
        }     
    }

    /* 
    public void ifNewCustomer(ChatbotData chatbotData, Scanner userInput){
        System.out.println("New customer?");
        String userResponse = userInput.nextLine().toLowerCase();
        if(Arrays.asList(chatbotData.ifNewCustomerResponseContents()).contains(userResponse)){
            showDialogue(getIfNewCustomerResponse(userResponse).toCharArray());
        }else{
            showDialogue(getIfNewCustomerResponse(userResponse).toCharArray());
        }
    }
    

    public void ifNewCustomer(ChatbotData chatbotData, Scanner userInput){
        while(true){
            System.out.println("\nNew customer?");
            String userResponse = userInput.nextLine().toLowerCase().trim();  
            if (Arrays.asList(chatbotData.getIfNewCustomerResponseContents()).contains(userResponse)) {
                showDialogue(getIfNewCustomerResponse(userResponse).toCharArray());
                System.exit(0);
            } else if (Arrays.asList(chatbotData.getIfOldCustomerResponseContents()).contains(userResponse)){
                showDialogue(getIfNotNewCustomerResponse(userResponse).toCharArray());
                tableReservation(chatbotData, userInput);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }
    */
    public void tableReservation(ChatbotData chatbotData, Scanner userInput){
        while(true){
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getTableCoupleReservationContent()).contains(userResponse)) {
                showDialogue(getTableCoupleReseravationResponse(userResponse).toCharArray());
                tableCouple(chatbotData, userInput);
            } else if (Arrays.asList(chatbotData.getTablePartyReservationContent()).contains(userResponse)){
                showDialogue(getTablePartyReseravationResponse(userResponse).toCharArray());
                tableParty(chatbotData, userInput);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }

    public void tableCouple(ChatbotData chatbotData, Scanner userInput){

    }

    public void tableParty(ChatbotData chatbotData, Scanner userInput){
        while(true){
            int amount = userInput.nextInt();
            userInput.nextLine();
            chatbotData.setPartyAmount(amount);
            showDialogue("Date and time?\n".toCharArray());
            while(true){
                String dateAndTime = userInput.nextLine();
                try{
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
                    format.parse(dateAndTime);
                    chatbotData.setDateAndTime(dateAndTime);
                    break;
                }catch(ParseException e){
                    showDialogue("Incorrect time\n".toCharArray());
                }
            }
            showDialogue("Any special requests?\n".toCharArray());
            while (true) {
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(userResponse)) {
                showDialogue("What would they be?\n".toCharArray());
                String specialRequests = userInput.nextLine();
                chatbotData.setSpecialRequest(specialRequests);
                tablePartyConfirmation(chatbotData, userInput);
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)){
                showDialogue("Alright! Sending you to table reservation page now!\n".toCharArray());
                tablePartyConfirmation(chatbotData, userInput);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
            }
        }
    }

    public void tablePartyConfirmation(ChatbotData chatbotData, Scanner userInput){
        showDialogue(("You are reserving a table for " + chatbotData.getPartyAmount() + " people set at " + chatbotData.getDateAndTime() + " with an additional request(s) of " + chatbotData.getSpecialRequest() +  " . Is this correct?\n").toCharArray());
        while (true) {
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(userResponse)) {
                showDialogue("Alright! Your table is now reserved, please show up at the alloted time and enjoy your meals!".toCharArray());
                System.exit(0);
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)){
                showDialogue("Understood, sending you back to table settings.".toCharArray());
                tableParty(chatbotData, userInput);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
            }
    }



    @Override
    public void run() {
        try {
            Thread.sleep(0);
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
