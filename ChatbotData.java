//import java.util.HashMap;
import java.util.*;
public class ChatbotData {
    //private HashMap<String, String> responses;
    private HashMap<String, List<String>> responses;
    public ChatbotData() {
        responses = new HashMap<>();
        loadResponses();
    }

    private void loadResponses() {
        /* 
        responses.put("hello", "Hi. I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello. I am BOT Mika, How may I help you?");
        */
        responses.put("hello", Arrays.asList("Hi. I am BOT Mika, How may I help you?", "Hi! I am BOT Mika, How may I assist you?"));
        responses.put("hi", Arrays.asList("Hello. I am BOT Mika, How may I help you?", "Hello! I am BOT Mika, How may I assist you?"));
    }

    public String getResponse(String userResponse) {
        for(String chatContent : responses.keySet()){
            List<String> chat = responses.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
        //return responses.getOrDefault(userResponse.toLowerCase().trim(), "I did not understand what you said.\nCan you please repeat that?");
        return "I did not understand what you said.\nCan you please repeat that?";
    }
}
