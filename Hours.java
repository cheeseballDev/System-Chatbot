import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Hours extends ChatbotData {
    private final HashMap<String, List<String>> hours;

    public Hours() {
        hours = new HashMap<>();
        loadResponses();
        }

    public void loadResponses() {
        hours.put("hours", Arrays.asList("Kyoto's Finest's operating hours ranges from 11:00 AM to 9:30 PM (JST)\n\nIs there anything else you need?\n> "));
        hours.put("opening", Arrays.asList("Kyoto's Finest opens at 11:00 AM (JST)\n\nIs there anything else you need?\n> "));
        hours.put("closing", Arrays.asList("Kyoto's Finest opens at 11:00 AM (JST)\n\nIs there anything else you need?\n> "));
    }

    @Override
    public String[] getResponsesContent(){
        return hours.keySet().toArray(new String[0]);
    }

    @Override
    public String getResponse(String userResponse) {
        for (String chatContent : hours.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = hours.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        return getBotMessage(0);
    }
}
