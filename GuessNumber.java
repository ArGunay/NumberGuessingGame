import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;




public class GuessNumber {

    public static void main(String[] args) {
        //GuessNumber game = new GuessNumber();
        Client client = new Client("research.inf.usi.ch",9999);
        BinarySearch search = new BinarySearch(client);
    }
}

