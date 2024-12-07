
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ChatbotData {
    //private HashMap<String, String> responses;
    private final HashMap<String, List<String>> responses;
    private final HashMap<String, List<String>> reservations;
    private final HashMap<String, List<String>> ifNewCustomerResponse;
    private String[] botMessage = new String[10];
    public ChatbotData() {
        responses = new HashMap<>();
        reservations = new HashMap<>();
        ifNewCustomerResponse = new HashMap<>();
        loadResponses();
        botMessage[0] = "I did not understand what you said. Can you please repeat that?\n> ";
        botMessage[1] = "Would you like a list of things I can assist you with?\n> ";
    }

    public String getBotMessage(int number) {
        return botMessage[number];
    }
    private void loadResponses() {
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
        ifNewCustomerResponse.put("yes", Arrays.asList("test", "test2"));
        ifNewCustomerResponse.put("no", Arrays.asList("test", "test2"));

        //responses.put("list", Arrays.asList("Here's the list of things:\n"));
    }

    public String[] responsesContent(){
        return responses.keySet().toArray(new String[0]);
    }

    public String[] reservationsContents(){
        return reservations.keySet().toArray(new String[0]);
    }

    public String[] ifNewCustomerResponseContents(){
        return ifNewCustomerResponse.keySet().toArray(new String[0]);
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
        for (String chatCustomerContent : ifNewCustomerResponse.keySet()){
            if (userResponse.toLowerCase().contains(chatCustomerContent)) {
                    List<String> chat = ifNewCustomerResponse.get(chatCustomerContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }
    
}