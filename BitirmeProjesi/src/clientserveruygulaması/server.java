package clientserveruygulaması;


import java.io.*;
import java.net.*;

public class server {

public static void main(String[] args) throws IOException {
String clientGelen;
ServerSocket serverSocket = null;
Socket clientSocket = null;
int sayi;

try {

serverSocket = new ServerSocket(7755);
} catch (Exception e) {
System.out.println("Port Hatası!");
}
System.out.println("SERVER BAŞLANTI İÇİN HAZIR...");

clientSocket = serverSocket.accept();

PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

while((clientGelen = in.readLine()) != null) {
System.out.println("Client'dan gelen veri = " + clientGelen);
sayi = Integer.valueOf(clientGelen);
out.println(sayi*sayi);
}
out.close();
in.close();
clientSocket.close();
serverSocket.close();
}
}