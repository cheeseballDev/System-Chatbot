
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ChatbotData {
    //private HashMap<String, String> responses;
    private final HashMap<String, List<String>> responses;
    private final HashMap<String, List<String>> reservations;
    private String[] botMessage = new String[10];
    private int attempts = 0;
    public ChatbotData() {
        responses = new HashMap<>();
        reservations = new HashMap<>();
        loadResponses();
        botMessage[0] = "I did not understand what you said.\nCan you please repeat that?";
        botMessage[1] = "Would you like a list of things I can assist you with?";
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
        reservations.put("reservation", Arrays.asList("Would you like to book a reservation?"));
        responses.put("hello", Arrays.asList("いらっしゃいませ !. I am BOT Mika, How may I help you?", "Hi! I am BOT Mika, How may I assist you?"));
        responses.put("hi", Arrays.asList("ようこそ. I am BOT Mika, How may I help you?", "Hello! I am BOT Mika, How may I assist you?"));
    }

    public String getResponse(String userResponse) {
        for (String chatContent : responses.keySet()){
            if (userResponse.matches(chatContent)) {
                List<String> chat = responses.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        //return responses.getOrDefault(userResponse.toLowerCase().trim(), "I did not understand what you said.\nCan you please repeat that?");

        // This if statement checks whether the user is struggling
        if (attempts != 3) {
            attempts++;
            return botMessage[0];
        }
        return botMessage[1];
        
    }

    public String getReservationResponse(String userResponse){
        for (String chatReservationContent : reservations.keySet()){
            if (userResponse.matches(chatReservationContent)) {
                List<String> chat = reservations.get(chatReservationContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
            if (attempts != 3) {
                attempts++;
                return botMessage[0];
            }
            return botMessage[1];
    }
}