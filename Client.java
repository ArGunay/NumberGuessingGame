import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

// ========================== CLIENT ====================================
public class Client{

    // =================== FIELDS ====================
    private String cookie;
    private String host;
    private int port;

    // =============== CONSTRUCTOR ==============
    Client(String host, int port){
        this.host = host;
        this.port = port;
    }

    // =================================================================================
    // ==================================          =====================================
    // ==================================   GET    =====================================
    // ==================================          =====================================
    // =================================================================================

    public void getMethod() throws IOException {

        // System.out.println("======================================");
        // System.out.println("GET REQUEST!");
        // System.out.println("======================================");
    

        Socket clientSocket = new Socket(this.host,this.port);
        String host = clientSocket.getInetAddress().getHostName(); 

        String path = "new-player";

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

        System.out.println();
        // Receiving response from server
        String responseLine;


        ArrayList<String> li = new ArrayList<>();

        while ((responseLine = response.readLine()) != null) {
            System.out.println("respLine: " + responseLine);
            li.add(responseLine);
        }

        // get 3rd element of the arraylist that is the set-cookie strig
        String l = li.get(3);

        // get the cookie number
        this.cookie = l.substring(l.indexOf("=")+1,l.length());

        clientSocket.close();
        response.close();
        request.close();

    }

    // =================================================================================
    // ==================================          =====================================
    // ==================================   post   =====================================
    // ==================================          =====================================
    // =================================================================================


    public String postMethod(String number) throws IOException {
        
        // System.out.println();
        // System.out.println("======================================");
        // System.out.println("POST REQUEST!");
        // System.out.println("======================================");


        

        Socket clientSocket = new Socket(this.host,this.port);
        
        String host = clientSocket.getInetAddress().getHostName(); 

        String path = "check-number";
    
        PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),true);


        // Declare a listener to this url
        BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

       
        // Sending request to the server
        // Building HTTP request header
        request.print("POST /" + path + "/ HTTP/1.1\r\n");    
        request.print("Host: " + host + "\r\n");             
        request.print("Cookie: id="+ cookie + "\r\n");      // System.out.println("COOKIE: " + cookie);      
        request.print("accept: text/plain"+ "\r\n");
        request.print("Content-Length: "+ number.length()+"\r\n");
        request.print("accept-charset: UTF-8 \r\n");

        request.print("Connection: close\r\n");
        request.print("\r\n");
        request.flush();


        //String htmlContent = number;
       // System.out.println("htmlcontent: " + htmlContent); 
       String htmlContent = number;
        request.print(htmlContent); 
        request.flush();

        
        // Receiving response from server
        String responseLine;
    


        
        String s = "";
        while ((responseLine = response.readLine()) != null) 
        {
           // System.out.println(responseLine);
            s += " " + responseLine;
        }
        //Closing socket resp and req
        clientSocket.close();
        response.close();
        request.close();

        
        return s;
    } 
        
    
}







