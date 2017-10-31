import java.io.IOException;



public class BinarySearch{

    Client client;
    
    Boolean win = false;

    
    BinarySearch(Client client) throws IOException {
        this.client = client;
        this.client.getMethod();
        
    }

    public boolean guess() throws IOException {
      
        // long low =0;
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
        

        // if(client.postMethod(mid).contains("=")){
        //     System.out.println("YOU WIN");
        // } else{
        //     System.out.println("YOU LOOSE");
        // }

















    // public void binarySearch(){
    //     
        
    //     while(high >= low) {
    //     int middle = ((low + high)/2);
        
    //     }if (client.postMethod(middle).contains("=")){
    //             System.out.println("WIIIIIIIN NIGGGAAAA!! number was:" + middle);
                
    //     } else if (client.postMethod(middle).contains(">")){
    //         System.out.println("TOO HIGH BITCH");
    //         low = middle + 1;
    //     } else if (client.postMethod(middle).contains("<")){
    //         System.out.println("TOO LOW MAAAN");
    //         high = middle - 1;
    //     }
    // }


