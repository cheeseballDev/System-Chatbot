
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ChatbotData {
    //private HashMap<String, String> responses;
    private final HashMap<String, List<String>> responses;
    private final HashMap<String, List<String>> reservations;
    protected final Set<String> yesResponses;
    protected final Set<String> noResponses;
    private final HashMap<String, List<String>> ifNewCustomerResponse;
    private final HashMap<String, List<String>> ifNotNewCustomerResponse;
    private final HashMap<String, List<String>> tableCoupleReservation;
    private final HashMap<String, List<String>> tablePartyReservation;
    private int partyAmount;
    private String dateAndTime;
    private String specialRequests;
    
    private String[] botMessage = new String[10];

    public ChatbotData() {
        yesResponses = new HashSet<>();
        noResponses = new HashSet<>();
        responses = new HashMap<>();
        reservations = new HashMap<>();
        ifNewCustomerResponse = new HashMap<>();
        ifNotNewCustomerResponse = new HashMap<>();
        tableCoupleReservation = new HashMap<>();
        tablePartyReservation = new HashMap<>();

        loadResponses();
        botMessage[0] = "I did not understand what you said. Can you please repeat that?\n> ";
        botMessage[1] = "Would you like a list of things I can assist you with?\n> ";
    }

    public String getBotMessage(int number) {
        return botMessage[number];
    }

    private void loadResponses() {
        yesResponses.add("yes");
        yesResponses.add("yeah");
        yesResponses.add("yuh");
        yesResponses.add("yep");
        yesResponses.add("y");
        yesResponses.add("sure");
        yesResponses.add("okay");
        yesResponses.add("ok");

        noResponses.add("no");
        noResponses.add("nah");
        noResponses.add("nope");
        noResponses.add("n");
        noResponses.add("never");
        

        /* 
        responses.put("hello", "Hi. I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello. I am BOT Mika, How may I help you?");
        responses.put("hello", "Hi! I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello! I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello! I am BOT Mika, your personal dining assistant. How may I help you?");
        responses.put("hello", "hi! Craving for something delicious or would you like to book a reservation?");
        responses.put("hi", "hello! I am BOT Mika, your personal dining assistant. Would you like to order or book a reservation?");
        responses.put("hello", "hi! would you like to order or book a reservation?");

        //order
        responses.put("Amazing", "wonderful! We have lots to offer, here's our menu.");
        responses.put(" ", "What would you like to order?");

        //Reservation
        responses.put("Great", "Gladly, Is this your first time dining with us?");


        //yes
        responses.put(" ", "Welcome! We’re so excited to have you. Is this for a group gathering or a personal date?");

        //date
        responses.put("that's lovely", "That's great, Do you have any special preferences for seating, like a quiet corner or window view?");

        //group
        responses.put("Wonderful", "Sounds exciting, How many people will be joining you?");

        
        //no
        responses.put("Welcome back", "Welcome back! Are you reserving for a group gathering or a personal date this time?");

        //date
        responses.put("that's great ", "That's lovely, would you it be the usual seating or would like to change your preference for today?");
        responses.put(" ", "Do you have any special preferences for seating, like a quiet corner or window view?");

        //group
        responses.put("Wonderful", "Sounds exciting, How many people will be joining you?");
        
        */
        reservations.put("reserve", Arrays.asList("Would you like to book a reservation?", "test 2"));
        reservations.put("reservation", Arrays.asList("test2", "test"));
        responses.put("hello", Arrays.asList("Hi! I am BOT Mika. Please check our list by typing list for all of our available choices.\n> ", "Irasshaimase! I am BOT Mika. Please check our list for all available choices.\n> "));
        responses.put("hi", Arrays.asList("Konnichiwa! I am BOT Mika. Please check our list by typing list for all of our available choices.\n> ", "Hello! I am BOT Mika. Please check our list for all available choices.\n> "));
        responses.put("list", Arrays.asList(""));
        responses.put("features", Arrays.asList(""));
        ifNewCustomerResponse.put("yes", Arrays.asList("test", "test2"));
        ifNotNewCustomerResponse.put("no", Arrays.asList("Table for a couple or for a party?\n", "Reserving for what purpose?\n"));
        tableCoupleReservation.put("couple", Arrays.asList("test1", "test2"));
        tablePartyReservation.put("party", Arrays.asList("How many poeple are attending?\n", "How many people are you reserving for?\n"));
        //tableCoupleReservationPref

        /*
         * add opening hours, operaitng hours, menu
         */

        //responses.put("list", Arrays.asList("Here's the list of things:\n"));
    }



    public String[] responsesContent(){
        return responses.keySet().toArray(new String[0]);
    }

    public String[] reservationsContents(){
        return reservations.keySet().toArray(new String[0]);
    }

    public String[] yesResponsesContents(){
        return yesResponses.toArray(new String[0]);
    }

    public String[] noResponsesContents(){
        return noResponses.toArray(new String[0]);
    }

    public String[] ifNewCustomerResponseContents(){
        return ifNewCustomerResponse.keySet().toArray(new String[0]);
    }

    public String[] ifNotNewCustomerResponseContents(){
        return ifNotNewCustomerResponse.keySet().toArray(new String[0]);
    }

    public String[] tableCoupleReservationContents(){
        return tableCoupleReservation.keySet().toArray(new String[0]);
    }

    public String[] tablePartyReservationContents(){
        return tablePartyReservation.keySet().toArray(new String[0]);
    }

    public void setPartyAmount(int amount){
        this.partyAmount = amount;
    }

    public int getPartyAmount(){
        return partyAmount;
    }

    public void setDateAndTime(String dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public String getDateAndTime(){
        return dateAndTime;
    }

    public void setSpecialRequests(String specialRequests){
        this.specialRequests = specialRequests;
    }
    
    public String getSpecialRequests(){
        return specialRequests;
    }

    public String getResponseStart(String userResponse) {
        for (String chatContent : responses.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = responses.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        for (String chatContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = reservations.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        //return responses.getOrDefault(userResponse.toLowerCase().trim(), "I did not understand what you said.\nCan you please repeat that?");
        // This if statement checks whether the user is struggling
        return botMessage[0];
    }

    public String getReservationResponse(String userResponse){
        for (String chatReservationContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatReservationContent)) {
                    List<String> chat = reservations.get(chatReservationContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String getIfNewCustomerResponse(String userResponse){
        for (String chatNewCustomerContent : ifNewCustomerResponse.keySet()){
            if (userResponse.toLowerCase().contains(chatNewCustomerContent)) {
                    List<String> chat = ifNewCustomerResponse.get(chatNewCustomerContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String getIfNotNewCustomerResponse(String userResponse){
        for (String chatNotNewCustomerContent : ifNotNewCustomerResponse.keySet()){
            if (userResponse.toLowerCase().contains(chatNotNewCustomerContent)) {
                    List<String> chat = ifNotNewCustomerResponse.get(chatNotNewCustomerContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String getTableCoupleReseravationResponse(String userResponse){
        for (String chatTableCoupleContent : tableCoupleReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTableCoupleContent)) {
                    List<String> chat = tableCoupleReservation.get(chatTableCoupleContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String getTablePartyReseravationResponse(String userResponse){
        for (String chatTablePartyContent : tablePartyReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTablePartyContent)) {
                    List<String> chat = tablePartyReservation.get(chatTablePartyContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }
    
}