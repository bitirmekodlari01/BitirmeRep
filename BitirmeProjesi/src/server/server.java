package server;


import java.io.*;
import java.net.*;
import java.util.*;
public class server
{
	 static int[] colors;
private static ServerSocket serverSocket;
private static final int PORT = 1241;
public static int[] sehirler1;
public static void main(String[] args) throws Exception
{
	
	int[] i={0,1,2,3,5,6,7,8,9,10};
	 sehirler1=new int[] {11,12,13,14,15,16,17,18,19,20};
	 colors = boyama.main(i);
	 
	System.out.println("Color Assignment: "+Arrays.toString(colors));
try{
serverSocket = new ServerSocket(PORT);
}
catch (IOException ioEx){

System.exit(1);
}
do
{
Socket client = serverSocket.accept();
System.out.println("\nNew client accepted.\n");
ClientHandler handler = new ClientHandler(client);
handler.start(); //As usual, method calls run.

}
while (true);
}
}
class ClientHandler extends Thread
{
private Socket client;
private Scanner input;
private PrintWriter output;
public ClientHandler(Socket socket)
{
//Set up reference to associated socket...
client = socket;
try{
input = new Scanner(client.getInputStream());
output = new PrintWriter(client.getOutputStream(),true);
}
catch(IOException ioEx){
ioEx.printStackTrace();
}
}
public void run()
{
String received;
do
{
received = input.nextLine();

if(received.equals("renkver")){
	output.println(Arrays.toString(server.colors));
}else if(received.equals("sehirver")){
	output.println(Arrays.toString(server.sehirler1));
}else if(received.substring(0,1).equals("[")){
	String[] items2 = received.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

	for (int i = 0; i < items2.length; i++) {
	    try {
	    	server.colors[i] = Integer.parseInt(items2[i]);
	    } catch (NumberFormatException nfe) {
	        //NOTE: write something here if you need to recover from formatting errors
	    };
	}

	output.println("Saðolasýn");
	System.out.println("\n Soooon server colors:"+Arrays.toString(server.colors));

}
}
while (!received.equals("QUIT")); //Repeat above until 'QUIT' sent by client...
try
{
if (client!=null)
{
System.out.println("Closing down connection...");
client.close();
}
}
catch(IOException ioEx)
{
System.out.println("Unable to disconnect!");
}
}
}