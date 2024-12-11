
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        showDialogue("Welcome to Kyoto's Finest! I am BOT Mika, how many I help you today?\n> ".toCharArray());
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
            if (Arrays.asList(chatbotData.getYesResponsesContents()).contains(userResponse)) {
                attempts = 0;
                runChatbot();
            } else if (Arrays.asList(chatbotData.getNoResponsesContents()).contains(userResponse)){
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
            if(Arrays.asList(chatbotData.getReservationsContents()).contains(userResponse)){
                showDialogue(getReservationResponse(userResponse).toCharArray());
                ifNewCustomer(chatbotData, userInput);
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
    */

    public void ifNewCustomer(ChatbotData chatbotData, Scanner userInput){
        while(true){
            System.out.println("\nAre you a new to this restaurant?");
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

    public void tableReservation(ChatbotData chatbotData, Scanner userInput){
        while(true){
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getTableCoupleReservationContents()).contains(userResponse)) {
                showDialogue(getTableCoupleReseravationResponse(userResponse).toCharArray());
                tableCouple(chatbotData, userInput);
            } else if (Arrays.asList(chatbotData.getTablePartyReservationContents()).contains(userResponse)){
                showDialogue(getTablePartyReseravationResponse(userResponse).toCharArray());
                tableParty(chatbotData, userInput);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }

    public void tableCouple(ChatbotData chatbotData, Scanner userInput){
        while(true){
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if(Arrays.asList(chatbotData.getCoupleTablePreferenceContents()).contains(userResponse)){
                chatbotData.getCoupleTablePreference(userResponse);
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
            }
            showDialogue("Any special touches like flowers or something?\n".toCharArray());
            while(true){
                if (Arrays.asList(chatbotData.getYesResponsesContents()).contains(userResponse)) {
                    showDialogue("What would they be?\n".toCharArray());
                    String specialRequests = userInput.nextLine();
                    chatbotData.setSpecialRequests(specialRequests);
                    tablePartyConfirmation(chatbotData, userInput);
                } else if (Arrays.asList(chatbotData.getNoResponsesContents()).contains(userResponse)){
                    showDialogue("Alright! Sending you to table reservation page now!\n".toCharArray());
                    tableCoupleConfirmation(chatbotData, userInput);
                } else {
                    showDialogue(getBotMessage(0).toCharArray());
                }
                }
            }
        }
    
    public void tableCoupleConfirmation(ChatbotData chatbotData, Scanner userInput){
        showDialogue("You are reserving a couple's table "); //WIP
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
            if (Arrays.asList(chatbotData.getYesResponsesContents()).contains(userResponse)) {
                showDialogue("What would they be?\n".toCharArray());
                String specialRequests = userInput.nextLine();
                chatbotData.setSpecialRequests(specialRequests);
                tablePartyConfirmation(chatbotData, userInput);
            } else if (Arrays.asList(chatbotData.getNoResponsesContents()).contains(userResponse)){
                showDialogue("Alright! Sending you to table reservation page now!\n".toCharArray());
                tablePartyConfirmation(chatbotData, userInput);
            } else {
                showDialogue(getBotMessage(0).toCharArray());
            }
            }
        }
    }

    public void tablePartyConfirmation(ChatbotData chatbotData, Scanner userInput){
        showDialogue(("You are reserving a table for " + chatbotData.getPartyAmount() + " people set at " + chatbotData.getDateAndTime() + " with an additional request(s) of " + chatbotData.getSpecialRequests() +  " . Is this correct?\n").toCharArray());
        while (true) {
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getYesResponsesContents()).contains(userResponse)) {
                showDialogue("Alright! Your table is now reserved, please show up at the alloted time and enjoy your meals!".toCharArray());
                System.exit(0);
            } else if (Arrays.asList(chatbotData.getNoResponsesContents()).contains(userResponse)){
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
