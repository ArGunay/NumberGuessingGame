Ardil Gunay

Computer Networking

Assignment 1: HTTP Number-Guessing Game

The purpose of this assignment was to create a client that interacts with a server, playing the number-guessing game.
This is the implementation i came up with. There are 3 classes:
GuessNumber, Client and BinarySearch.
GuessNumber is the class that runs the main thread. The while loop executes untill a win situation occurs in the search.
The Client class handles the two methods that we need in order to comunicate with the server. It has a getMethod() and a postMethod(String).
They are similar in their implementation, since booth open a connection, send the GET/POST method and print the answer from the server. 
In order to make this happen I had to use the java.io, java,net and java.util.ArrayList libraries (see import statements in Client class).
The BinarySearch class is a simple binary search in which the searching process is implemented. While checking if the higher number is greater than the lower number we send the POST method with the number that is the average of the two. then we control the answer and continue to reply accordingly. If the answer contains "=" then we end the loop in the main thread by retourning a boolean.

To write this assignment I had to search for tutorials and materials in order to understand how the mechanisms between client and server work.
Especially the "https://github.com/iamprem/HTTPclient-server" repository has been of great help to understand how to set up the client side.

I also have discudded the code with Eljon Harlicay, which helped me to resolve some issues I had with the post request.