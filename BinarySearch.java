import java.io.IOException;

public class BinarySearch{
    // save the client
    Client client;
    
    BinarySearch(Client client) throws IOException {
        this.client = client;
        this.client.getMethod();
        
    }

    public boolean guess() throws IOException {
      
            long low = -2000000000;
            long high = 2000000000;
            
            while(high >= low)
            {
                long middle  = (low + high)/2;
                System.out.println("request[POST]: " +middle);

                String resp = client.postMethod(Long.toString(middle));

                if(resp.contains("Game over, you lost!")){
                    System.out.println("Game over, you lost!");
                    return false;
                }

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
            
        return true;
    }
    
}