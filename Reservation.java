import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Reservation extends ChatbotData {
    private final HashMap<String, List<String>> reservations; 
    private final HashMap<String, List<String>> tableCoupleReservation;
    private final HashMap<String, List<String>> tablePartyReservation;

    private int partyAmount;
    private String dateAndTime;
    private String specialRequests;
    private String tablePreferenceString;


    public Reservation() {
        reservations = new HashMap<>();
        tableCoupleReservation = new HashMap<>();
        tablePartyReservation = new HashMap<>();

        // RESERVATIONS
        reservations.put("reserve", Arrays.asList("Sure thing! Let me ask you something first though...\n", "No problem! Let me ask you something first though...\n"));
        reservations.put("reservation", Arrays.asList("Sure thing! Let me ask you something first though...\n", "No problem! Let me ask you something first though...\n"));
                
        // TABLE PREFERENCE 
        tableCoupleReservation.put("couple", Arrays.asList("Sure thing! Any preferences for your seats?\n", "Of course! Do you have any seating preferences?\n"));
        tablePartyReservation.put("party", Arrays.asList("How many people are attending?\n", "How many people are you reserving for?\n"));
    }

    @Override
    public String getResponse(String userResponse){
        for (String chatContent : reservations.keySet()){
            if (userResponse.contains(userResponse)) {
                    List<String> chat = reservations.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        return getBotMessage(0);
    }


    public String getTableCoupleReseravationResponse(String userResponse){
        for (String chatTableCoupleContent : tableCoupleReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTableCoupleContent)) {
                    List<String> chat = tableCoupleReservation.get(chatTableCoupleContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return getBotMessage(0);
    }

    public void setCoupleTablePreference(String userResponse){
        for (String preferenceContent : getTablePreferenceContent()){
            if(userResponse.toLowerCase().contains(preferenceContent)){
                this.tablePreferenceString = userResponse;
            }
        }
    }

    public String getTablePartyReseravationResponse(String userResponse){
        for (String chatTablePartyContent : tablePartyReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTablePartyContent)) {
                    List<String> chat = tablePartyReservation.get(chatTablePartyContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return getBotMessage(0);
    }

    @Override
    public String[] getResponsesContent(){
        return reservations.keySet().toArray(new String[0]);
    }

    public String[] getTableCoupleReservationContent(){
        return tableCoupleReservation.keySet().toArray(new String[0]);
    }

    public String[] getTablePartyReservationContent(){
        return tablePartyReservation.keySet().toArray(new String[0]);
    }


    public void setPartyAmount(int amount){
        this.partyAmount = amount;
    }

    public int getPartyAmount(){
        return partyAmount;
    }

    public String getDateAndTime(){
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public void setSpecialRequest(String specialRequests){
        this.specialRequests = specialRequests;
    }
    
    public String getSpecialRequest(){
        return specialRequests;
    }

    public String getCoupleTablePreference(){
        return tablePreferenceString;
    }

    
}
