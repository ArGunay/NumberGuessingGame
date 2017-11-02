import java.io.IOException;

public class GuessNumber {

    public static void main(String[] args) throws IOException {

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        Boolean win = false;

        while(!win){
            
            Client client = new Client(host, port);
            BinarySearch search = new BinarySearch(client);

            if (search.guess()){
                win = true;
            }
        }
    }       
}
