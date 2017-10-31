import java.io.IOException;



public class BinarySearch{

    Client client;
    
    Boolean win = false;

    
    BinarySearch(Client client) throws IOException {
        this.client = client;
        this.client.getMethod();
       guess();
    }

    public void guess() throws IOException {
      
        // long low =0;
            long low = -2000000000;
            long high = 2000000000;
            
            while(high >= low){
                long middle  = (low + high)/2;
                String resp = client.postMethod(Long.toString(middle));
                

                if(resp.contains("Game over, you lost!") ||
                   resp.contains("Could not parse any number!")){
                   break;
                }

                if (resp.contains("=")){
                    System.out.println("WIIIIIIIN NIGGGAAAA!! number was:" + middle);    
                    break;
                } else if (resp.contains(">")){
                    System.out.println("TOO HIGH BITCH MIDDLE IS "+ middle);
                    high = middle - 1;
                    
                } else if (resp.contains("<")){
                    System.out.println("TOO LOW MAAAN MIDDLE IS " + middle);
                    low = middle + 1;
                    
                }
            }
            
        
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


