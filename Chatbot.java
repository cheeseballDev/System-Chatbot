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
        String userResponse;
        Scanner userInput = new Scanner(System.in);
        showDialogue("Greetings guest! I am BOT Mika, may I have your name please?\n> ".toCharArray());
        setUsername(userInput.nextLine());
        clearScreen();
        showDialogue(("Welcome to Kyoto's Finest " + getUsername() + "! how may I help you today?\n> ").toCharArray());
        while (attempts != 4) {
            userResponse = userInput.nextLine().trim().toLowerCase();
            clearScreen();
            if (attempts == 3) {
                while (true) {
                    clearScreen();
                    showDialogue("It seems you are having trouble, would you like a list of things I can assist you with?\n> ".toCharArray());
                    userResponse = userInput.nextLine().toLowerCase().trim();
                    if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(userResponse)) {
                        attempts = 0;
                        clearScreen();
                        showDialogue(getResponseStart("list").toCharArray());
                        break;
                    } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)){
                        clearScreen();
                        showDialogue(("Thank you "+ getUsername() + " for visiting Kyoto's Finest! Please come again soon!").toCharArray());
                        System.exit(0);
                    }
                    showDialogue(getBotMessage(0).toCharArray());
                }
            } else if (Arrays.asList(chatbotData.getReservationsContent()).contains(userResponse)) {
                showDialogue(getReservationResponse(userResponse).toCharArray());
                setNewCustomer(chatbotData, userInput);
            } else if (Arrays.asList(chatbotData.getResponsesContent()).contains(userResponse)) {
                clearScreen();
                attempts++;
                showDialogue(getResponseStart(userResponse).toCharArray());
            } else {
                clearScreen();
                showDialogue(getResponseStart(userResponse).toCharArray());
                attempts++;
                continue;
            }
        }
    }
    
    /* 
    public void setReservation(ChatbotData chatbotData, Scanner userInput){
        while (true) {            
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if(Arrays.asList(chatbotData.getReservationsContent()).contains(userResponse)){
                showDialogue(getReservationResponse(userResponse).toCharArray());
                setNewCustomer(chatbotData, userInput);
            }else{
                showDialogue(getReservationResponse(userResponse).toCharArray());
            }
        }     
    }
    */

    public void setNewCustomer(ChatbotData chatbotData, Scanner userInput){
        String userResponse;
        clearScreen();
        showDialogue(("Are you new to this restaurant?\n> ").toCharArray());
        while(true){
            userResponse = userInput.nextLine().toLowerCase().trim();
            if(Arrays.asList(getYesResponsesContent()).contains(userResponse)){
                clearScreen();
                showDialogue(("Would you like to get some food recommendations first?\n> ").toCharArray());
                while(true){
                    userResponse = userInput.nextLine().toLowerCase().trim();
                    if(Arrays.asList(getYesResponsesContent()).contains(userResponse)){
                        clearScreen();
                        foodRecommendation(chatbotData, userInput);
                    } else if (Arrays.asList(getNoResponsesContent()).contains(userResponse)) {
                        clearScreen();
                        setTableReservation(chatbotData, userInput);
                    } else{
                        clearScreen();
                        showDialogue(getBotMessage(0).toCharArray());
                    }
                }
            }else if (Arrays.asList(getNoResponsesContent()).contains(userResponse)){
                clearScreen();
                setTableReservation(chatbotData, userInput);
            }else{
                clearScreen();
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }

    public void foodRecommendation(ChatbotData chatbotData, Scanner userInput){
        showDialogue(foodRandomizer().toCharArray());
        showDialogue(("\nJust type 'next' if you want to proceed to the reservation page\n> ").toCharArray());
        while(true){
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if(userResponse.contains("next")){
                clearScreen();
                setTableReservation(chatbotData, userInput);
            }else{
                clearScreen();
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }

    public void setTableReservation(ChatbotData chatbotData, Scanner userInput){
        showDialogue(("Are you reserving a table for a couple or for a party?\n> ").toCharArray());
        while(true){
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getTableCoupleReservationContent()).contains(userResponse)) {
                clearScreen();
                showDialogue(getTableCoupleReseravationResponse(userResponse).toCharArray());
                setTableCouple(chatbotData, userInput);
            } else if (Arrays.asList(chatbotData.getTablePartyReservationContent()).contains(userResponse)){
                clearScreen();
                showDialogue(getTablePartyReseravationResponse(userResponse).toCharArray());
                setTableParty(chatbotData, userInput);
            } else {
                clearScreen();
                showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }

    public void setTableCouple(ChatbotData chatbotData, Scanner userInput) {
        /* 
        while(true){
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if(Arrays.asList(chatbotData.getCoupleTablePreferenceContent()).contains(userResponse)){
                clearScreen();
                chatbotData.setCoupleTablePreference(userResponse);
                showDialogue("Date and time?\n> ".toCharArray());
                while(true){
                    String dateAndTime = userInput.nextLine().trim();
                        try {
                            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
                            format.parse(dateAndTime);
                            chatbotData.setDateAndTime(dateAndTime);
                            break;
                        } catch (ParseException e) {
                            printErrorMessage("Incorrect time. Please try again");
                        }
                    }
                clearScreen();

                showDialogue("Any special touches like flowers?\n> ".toCharArray());
                while(true){
                    String specialTouchesResponse = userInput.nextLine().toLowerCase().trim();
                    if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(specialTouchesResponse)){
                        clearScreen();
                        showDialogue("What would they be?\n> ".toCharArray());
                        String specialRequests = userInput.nextLine();
                        chatbotData.setSpecialRequest(specialRequests);
                        confirmTableCouple(chatbotData, userInput);
                    }else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(specialTouchesResponse)){
                        clearScreen();
                        showDialogue("Alright! Sending you to table reservation page now!\n> ".toCharArray());
                        confirmTableCouple(chatbotData, userInput);
                    }
                    showDialogue(getBotMessage(0).toCharArray());
                } 
            } else if (Arrays.asList(chatbotData.getHelpResponsesContent()).contains(userResponse)){
                clearScreen();
                showDialogue("Our table locations include the following:\n - Near window\n - Aisle\n - Corner\n - Booth\n - Entrance\n - Quiet area\n> ".toCharArray());
                continue;
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)) {
                showDialogue("Okay, I'll just set one randomly for you.".toCharArray());
                clearScreen();
                chatbotData.setCoupleTablePreference(tableRandomizer());
                showDialogue("Date and time?\n> ".toCharArray());
                while(true){
                    String dateAndTime = userInput.nextLine().trim();
                        try {
                            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
                            format.parse(dateAndTime);
                            chatbotData.setDateAndTime(dateAndTime);
                            break;
                        } catch (ParseException e) {
                            printErrorMessage("Incorrect time. Please try again");
                        }
                    }
                clearScreen();

                showDialogue("Any special touches like flowers?\n> ".toCharArray());
                while(true){
                    String specialTouchesResponse = userInput.nextLine().toLowerCase().trim();
                    if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(specialTouchesResponse)){
                        clearScreen();
                        showDialogue("What would they be?\n> ".toCharArray());
                        String specialRequests = userInput.nextLine();
                        chatbotData.setSpecialRequest(specialRequests);
                        confirmTableCouple(chatbotData, userInput);
                    }else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(specialTouchesResponse)){
                        clearScreen();
                        showDialogue("Alright! Sending you to table reservation page now!\n> ".toCharArray());
                        confirmTableCouple(chatbotData, userInput);
                    }
                    showDialogue(getBotMessage(0).toCharArray());
                } 
            } else {
                clearScreen();
                showDialogue(getBotMessage(0).toCharArray());
                continue; 
            }
        }
        */
        while(true){
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if(Arrays.asList(chatbotData.getCoupleTablePreferenceContent()).contains(userResponse)){
                chatbotData.setCoupleTablePreference(userResponse);
                break;
            } else if (Arrays.asList(chatbotData.getHelpResponsesContent()).contains(userResponse)){
                clearScreen();
                showDialogue("Our table locations include the following:\n - Near window\n - Aisle\n - Corner\n - Booth\n - Entrance\n - Quiet area\n> ".toCharArray());
                continue;
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)) {
                showDialogue("Okay, I'll just set one randomly for you then.\n".toCharArray());
                chatbotData.setCoupleTablePreference(tableRandomizer());
                break;
            } else {
                clearScreen();
                showDialogue(getBotMessage(0).toCharArray());
                continue; 
            }
        }
        showDialogue("Date and time?\n> ".toCharArray());
                while(true){
                    String dateAndTime = userInput.nextLine().trim();
                        try {
                            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
                            format.parse(dateAndTime);
                            chatbotData.setDateAndTime(dateAndTime);
                            break;
                        } catch (ParseException e) {
                            printErrorMessage("Incorrect time. Please try again");
                        }
                    }
                clearScreen();

                showDialogue("Any special touches like flowers?\n> ".toCharArray());
                while(true){
                    String specialTouchesResponse = userInput.nextLine().toLowerCase().trim();
                    if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(specialTouchesResponse)){
                        clearScreen();
                        showDialogue("What would they be?\n> ".toCharArray());
                        String specialRequests = userInput.nextLine();
                        chatbotData.setSpecialRequest(specialRequests);
                        confirmTableCouple(chatbotData, userInput);
                    }else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(specialTouchesResponse)){
                        clearScreen();
                        showDialogue("Alright! Sending you to table reservation page now!\n> ".toCharArray());
                        confirmTableCouple(chatbotData, userInput);
                    }
                    showDialogue(getBotMessage(0).toCharArray());
                }

    }
    

    public void confirmTableCouple(ChatbotData chatbotData, Scanner userInput){
        clearScreen();
        showDialogue(("You are reserving a couple's table with table preference of " + chatbotData.getCoupleTablePreference() + " part set at " + chatbotData.getDateAndTime() + " with an additional request(s) of " + chatbotData.getSpecialRequest() +  " . Is this correct?\n> ").toCharArray());
        while (true) {
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(userResponse)) {
                clearScreen();
                showDialogue("Alright! Your table is now reserved, please show up at the alloted time and enjoy your date!".toCharArray());
                System.exit(0);
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)){
                clearScreen();
                showDialogue("Understood, sending you back to table settings.".toCharArray());
                setTableCouple(chatbotData, userInput);
            }
            clearScreen();
            showDialogue(getBotMessage(0).toCharArray());
            }
    }

    public void setTableParty(ChatbotData chatbotData, Scanner userInput){
        while(true){
            int amount = userInput.nextInt();
            userInput.nextLine();
            chatbotData.setPartyAmount(amount);
            clearScreen();
            showDialogue("Date and time?\n".toCharArray());
            while(true){
                String dateAndTime = userInput.nextLine();
                try{
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
                    format.parse(dateAndTime);
                    chatbotData.setDateAndTime(dateAndTime);
                    break;
                }catch(ParseException e){
                    printErrorMessage("Incorrect time. Please try again");
                    clearScreen();
                }
            }
            clearScreen();
            showDialogue("Any special requests?\n> ".toCharArray());
            while (true) {
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(userResponse)) {
                showDialogue("What would they be?\n> ".toCharArray());
                String specialRequests = userInput.nextLine();
                chatbotData.setSpecialRequest(specialRequests);
                confirmTableParty(chatbotData, userInput);
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)){
                clearScreen();
                showDialogue("Alright! Sending you to table reservation page now!\n> ".toCharArray());
                confirmTableParty(chatbotData, userInput);
            } 
            clearScreen();
            showDialogue(getBotMessage(0).toCharArray());
            }
        }
    }

    public void confirmTableParty(ChatbotData chatbotData, Scanner userInput){
        showDialogue(("You are reserving a table for " + chatbotData.getPartyAmount() + " people set at " + chatbotData.getDateAndTime() + " with an additional request(s) of " + chatbotData.getSpecialRequest() +  " . Is this correct?\n> ").toCharArray());
        while (true) {
            String userResponse = userInput.nextLine().toLowerCase().trim();
            if (Arrays.asList(chatbotData.getYesResponsesContent()).contains(userResponse)) {
                clearScreen();
                showDialogue("Alright! Your table is now reserved, please show up at the alloted time and enjoy your meals!".toCharArray());
                System.exit(0);
            } else if (Arrays.asList(chatbotData.getNoResponsesContent()).contains(userResponse)){
                clearScreen();
                showDialogue("Understood, sending you back to table settings.".toCharArray());
                setTableParty(chatbotData, userInput);
            } else {
                clearScreen();
                showDialogue(getBotMessage(0).toCharArray());
            }
            }
    }

    /*
     * MISC METHODS
     */

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
        System.out.print("MIKA: ");
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