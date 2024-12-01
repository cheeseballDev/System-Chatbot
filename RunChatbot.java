import java.util.Scanner;

public class RunChatbot{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chatbot botcha = new Chatbot();
        System.out.print("Enter message: ");
        while(true){
            System.out.print("");
            String message = sc.nextLine().toLowerCase();
            String introChat = botcha.getResponse(message);
            System.out.println(introChat);
            break;
        }
    }
}