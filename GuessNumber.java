import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class GuessNumber {

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();

        // TO BE USED WHEN GIVING COMPILE PARAMS
        // System.out.println("arg0 "+ args[0]);
        // System.out.println("arg1 "+ args[1]);
        // String hostImput = args[0];
        // Integer portNumberImput = Integer.parseInt(args[1]);
        // try{ 
        //         game.getMethod(hostImput, portNumberImput,"new-player");
        //     } catch (IOException e){ //can never happen}
        //         System.out.println("EXEP");
        //     }
        // }   
        
        
        try{
            Socket clientSocket = new Socket("research.inf.usi.ch",9999);
            game.connectionMethod(clientSocket);
            System.out.println("END-CONNECTION-METHOD");
            game.replyMethod(clientSocket, game.cookie);
            System.out.println("END-REPLY-METHOD");
            // clientSocket.close();
        } catch (IOException e){ //can never happen}
            System.out.println("EXEP");
        }
        System.out.println("END-OF-TRY");
    }

    String cookie;

    // public String getCookie(){
    //     return this.cookie;

    // }
    


    public void connectionMethod(Socket clientSocket)
    throws IOException {

        String host = clientSocket.getInetAddress().getHostName(); 
        System.out.println("HOST IS: "+ host);
        // Integer port = clientSocket.getPort();
        String path = "new-player";

        // Opening Connection based on the port number 80(HTTP) and 443(HTTPS)

        
        System.out.println("PORT: "+clientSocket.getPort()+ " inet: "+ clientSocket.getInetAddress());

        System.out.println();

        System.out.println("======================================");
        System.out.println("Connected");
        System.out.println("======================================");

        // Declare a writer to this url
        PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),true);

        // Declare a listener to this url
        BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        // Sending request to the server
        // Building HTTP request header
        request.print("GET /" + path + "/ HTTP/1.1\r\n");   // "+path+"
        request.print("Host: " + host + "\r\n");
        request.print("Connection: close\r\n");
        request.print("Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n");
        request.print("\r\n");
        request.flush();
        System.out.println("Request Sent!");
        System.out.println("======================================");

        // Receiving response from server
        String responseLine;

        //        String beacon = l.substring(l.indexOf("=")+1,l.length());
        List<String> li = new ArrayList<>();

        while ((responseLine = response.readLine()) != null) {
            System.out.println(responseLine);
            li.add(responseLine);


        }

        // get 3rd element of the arraylist that is the set-cookie strig
        String l = li.get(3);

        // get the cookie number
        this.cookie = l.substring(l.indexOf("=")+1,l.length());
        System.out.println("cookie = "+ this.cookie);

        System.out.println("======================================");
        System.out.println("Response Recieved!!");
        System.out.println("======================================");

        // response.close();
        // request.close();
        
    }


    // ==================================================================================
    // ==================================           =====================================
    // ==================================   REPLY   =====================================
    // ==================================           =====================================
    // ==================================================================================


    public void replyMethod(Socket clientSocket, String cookie){
        
        String host = clientSocket.getInetAddress().getHostName(); 
        String path = "check-number";

        try{

        
            PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),true);
            System.out.println("POST REQ " + request);
            // Declare a listener to this url
            BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("POST RESP " + response);

            // Sending request to the server
            // Building HTTP request header
            request.print("POST /" + path + "/ HTTP/1.1\r\n");      System.out.println("POST PATH " + path);
            request.print("Host: " + host + "\r\n");                System.out.println("POST HOST " + host);
            request.print("Connection: open\r\n");
            request.print("cookie: "+ cookie + "\r\n");             System.out.println("cookie: "+ cookie);
            request.print("number: " + 2 + "\r\n");
            request.print("Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n");
            request.print("\r\n");
            request.flush();
            System.out.println("POST REQ Sent!");
            System.out.println("======================================");

            // Receiving response from server
            String responseLine;
            System.out.println("RESPONSEEEE: "+ response.readLine());
            //        String beacon = l.substring(l.indexOf("=")+1,l.length());
            List<String> li = new ArrayList<>();

            while ((responseLine = response.readLine()) != null) 
            {
                
                System.out.println(responseLine);
                li.add(responseLine);

            }

            System.out.println("======================================");
            System.out.println("POST Response Recieved!!");
            System.out.println("======================================");
            
        } 
        catch(IOException e)
        { 
            System.out.println("REPLY METHOD ERROR " + e);
        }
    }
}


    // =================================================================================
    // ==================================          =====================================
    // ==================================   POST   =====================================
    // ==================================          =====================================
    // =================================================================================

//     private void sendPost(String host, int port, String path, String cookie) throws Exception {
        
//         String url = "research.inf.usi.ch";
//         URL obj = new URL(url);
//         HttpURLConnection con = (HttpURLConnection) obj.openConnection();



//         PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),true);
        
//         // Declare a listener to this url
//         BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


//         // Sending request to the server
//         // Building HTTP request header
//         request.print("POST /" + path + "/ HTTP/1.1\r\n");   // "+path+"
//         request.print("Host: " + host + "\r\n");
//         request.print("Connection: close\r\n");
//         request.print("Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n");
//         request.print("\r\n");
//         request.flush();
//         System.out.println("Request Sent!");
//         System.out.println("======================================");

//         // Receiving response from server
//         String responseLine;

//         //        String beacon = l.substring(l.indexOf("=")+1,l.length());
//         List<String> li = new ArrayList<>();

//         while ((responseLine = response.readLine()) != null) {
//             System.out.println(responseLine);
//             li.add(responseLine);

//         }




// // ==========-=-=-=-=-=-=-=-==-=-=-=---==-=--=-=-=-=-==--=-=-=-=-==--=-=-=-=-=-=-=-=-=-=-==-=-===-=-




//         // //add reuqest header
//         // con.setRequestMethod("POST");
//         // con.setRequestProperty("User-Agent", "Mozilla/4.0");
//         // con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//         // con.setRequestBody();

//         String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";//should get cookie?

//         // Send post request
//         con.setDoOutput(true);
//         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//         wr.writeBytes(urlParameters);
//         wr.flush();
//         wr.close();

//         int responseCode = con.getResponseCode();
//         System.out.println("\nSending 'POST' request to URL : " + url);
//         System.out.println("Set-cookie : " + urlParameters);
//         System.out.println("Response Code : " + responseCode);

//         BufferedReader in = new BufferedReader(
//                 new InputStreamReader(con.getInputStream()));
//         String inputLine;
//         StringBuffer response = new StringBuffer();

//         while ((inputLine = in.readLine()) != null) {
//             response.append(inputLine);
//         }
//         in.close();

//         //print result
//         System.out.println(response.toString());

//     }



