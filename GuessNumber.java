import java.io.IOException;

public class GuessNumber {

    public static void main(String[] args) throws IOException {

        Boolean win = false;
        int gamenumber = 1;
        while(!win){
            System.out.println();
            System.out.println("=====================  GAME N#: "+ gamenumber +"==================");
            System.out.println();
            Client client = new Client("research.inf.usi.ch",9999);
            BinarySearch search = new BinarySearch(client);

            if (search.guess()){
                win = true;
            }
            System.out.println();
            ++gamenumber;
       }
    }
}
