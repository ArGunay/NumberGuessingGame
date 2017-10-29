import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client{


    private String cookie;
    private String host;
    private int port;
    

    Client(){

    }


    public void getMethod()
    throws IOException {

        Socket clientSocket = new Socket("research.inf.usi.ch",9999);
        String host = clientSocket.getInetAddress().getHostName(); 
        // System.out.println("HOST IS: "+ host);
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
        // System.out.println("Request Sent!");
        // System.out.println("======================================");

        
        // Receiving response from server
        String responseLine;

        //        String beacon = l.substring(l.indexOf("=")+1,l.length());
        List<String> li = new ArrayList<>();

        while ((responseLine = response.readLine()) != null) {
            // System.out.println(responseLine);
            li.add(responseLine);
        }

        // get 3rd element of the arraylist that is the set-cookie strig
        String l = li.get(3);

        // get the cookie number
        this.cookie = l.substring(l.indexOf("=")+1,l.length());
        // System.out.println("cookie = "+ this.cookie);

        System.out.println("======================================");
        System.out.println("Response Recieved!!");
        System.out.println("======================================");

            clientSocket.close();
            response.close();
            request.close();

    }

    // =================================================================================
    // ==================================          =====================================
    // ==================================   post   =====================================
    // ==================================          =====================================
    // =================================================================================


    public void postMethod(){
        

        try{

            Socket clientSocket = new Socket("research.inf.usi.ch",9999);
            
            String host = clientSocket.getInetAddress().getHostName(); 
            System.out.println("POST HOST " + host);
            String path = "check-number";
        
            PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),true);
            // System.out.println("POST REQ " + request);

            // Declare a listener to this url

            BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // System.out.println("POST RESP " + response);


            // Sending request to the server
            // Building HTTP request header

            request.print("POST /" + path + "/ HTTP/1.1\r\n");    //  System.out.println("POST PATH " + path);
            request.print("Host: " + host + "\r\n");             //   System.out.println("POST HOST " + host);
            request.print("Cookie: id="+ cookie + "\r\n");             System.out.println("POST cookie: id="+ cookie);
            request.print("accept: text/plain"+ "\r\n");
            request.print("Content-Length: 1"+ "\r\n");

            //request.print("Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n");
            request.print("Connection: close\r\n");
            request.print("\r\n");
            request.flush();

            System.out.println("======================================");
            System.out.println("POST REQUEST Sent!");
            System.out.println("======================================");


            String htmlContent = "10";
            request.print(htmlContent); //System.out.println("htmlcontent: " + htmlContent);
            request.flush();

            
            // Receiving response from server
            String responseLine;
        
            List<String> postResp = new ArrayList<>();

            String resPonse = "";

            while ((responseLine = response.readLine()) != null) 
            {
                System.out.println(responseLine);
                // process.add(responseLine);
                postResp.add(responseLine);
                resPonse += responseLine;
            }

            System.out.println("======================================");
            System.out.println("POST Response Recieved!!");
            System.out.println("======================================");
            
            
            //Closing socket resp and req
            clientSocket.close();
            response.close();
            request.close();
        } 
        catch(IOException e)
        { 
            System.out.println("REPLY METHOD ERROR " + e);
        }
    }
}







