import java.io.IOException;

public class BinarySearch{
    // save the client
    Client client;
    
    BinarySearch(Client client) throws IOException {
        this.client = client;
        // do the call when object is created to get the cookie
        this.client.getMethod();
    }

    // the guess method is a binary search that once received the answer from the server
    // checks if it is higher, lower or correctly guessed,
    // if the guess is correct returns a boolean to end the while loop in the main thread.
    public boolean guess() throws IOException {
            // low and high values 
            long low = -2000000000;
            long high = 2000000000;
            

            // Binary search
            while(high >= low)
            {

                long middle  = (low + high)/2;
                System.out.println("request[POST]: " +middle);

                String resp = client.postMethod(Long.toString(middle));

                // control statement of game over returns false to make restart the game
                if(resp.contains("Game over, you lost!")){
                    System.out.println("Game over, you lost!");
                    return false;
                }
                //equal statement ends the while loop in main thread
                else if (resp.contains("=")){
                    System.out.println("YOU WIN! NUMBER WAS: " + middle); 
                    return true;   
                
                } else if (resp.contains(">")){
                    System.out.println("reply[200]: too high!");
                    high = middle - 1;
                    
                } else if (resp.contains("<")){
                    System.out.println("reply[200]: too low!");
                    low = middle + 1;
                    
                }
            }
            
        return false;
    }
    
}