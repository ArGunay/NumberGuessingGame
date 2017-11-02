import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

// ========================== CLASS CLIENT ====================================
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

    

        Socket clientSocket = new Socket(this.host,this.port);
        //Get the hostname from the socket
        String host = clientSocket.getInetAddress().getHostName(); 
        // the path to do the GET request
        String path = "new-player";
        // Declare a writer
        PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),true);
        // Declare a listener to this url
        BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        System.out.println("request[GET]");

        // Starting the GET request
        request.print("GET /" + path + "/ HTTP/1.1\r\n"); 
        request.print("Host: " + host + "\r\n");
        request.print("Connection: close\r\n");
        request.print("\r\n");
        request.flush();

        // Receiving response from server
        //readLine takes one line per time from the response
        // It is saved in an array.
        String serverResponse;
        ArrayList<String> outputResponse = new ArrayList<>();
        while ((serverResponse = response.readLine()) != null) {
            outputResponse.add(serverResponse);
        }

        //Get 3rd element of the arraylist that is the set-cookie strig
        String cookieString = outputResponse.get(3);

        // Print status of answer
        if(outputResponse.get(0).contains("204")){
            System.out.println("reply[204]: Welcome to the game!");
        }

        // get the cookie number
        this.cookie = cookieString.substring(cookieString.indexOf("=")+1, cookieString.length());

        // Close the connections
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


        Socket clientSocket = new Socket(this.host,this.port);
        
        String host = clientSocket.getInetAddress().getHostName(); 

        String path = "check-number";
    
        PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),true);


        // Declare a listener to this url
        BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String content = number;
        // Sending request to the server
        // Building HTTP request header
        request.print("POST /" + path + "/ HTTP/1.1\r\n");
        request.print("Host: " + host + "\r\n");
        request.print("Cookie: id="+ cookie + "\r\n");
        request.print("accept: text/plain"+ "\r\n");
        // content length needs to be the lenght of the number.
        request.print("Content-Length: "+ number.length()+"\r\n");
        request.print("Connection: close\r\n");
        request.print("\r\n");
        // sending the number choosen
        request.print(content); 
        request.flush();

        // Receiving response from server
        String serverResponse;
        
        String s = "";
        while ((serverResponse = response.readLine()) != null) 
        {
            s += " " + serverResponse;
        }

        //Closing socket resp and req
        clientSocket.close();
        response.close();
        request.close();
        return s;
    } 
}







