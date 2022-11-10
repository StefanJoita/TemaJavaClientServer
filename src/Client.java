import java.util.Scanner;
import java.io.*;
import java.net.*;


public class Client
{
    private Socket socket;
    private BufferedReader bufferReader;
    private BufferedWriter bufferedWriter;
    private String tip;
    public Client(Socket _socket)//, String _tip) {
    { try {
            this.socket = _socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            closeEverything(socket, bufferedWriter, bufferReader);
        }
    }
    public void sendDetails() {
       while(socket.isConnected()) {
           try {

               Scanner scanner = new Scanner(System.in);
               String messageToSend = scanner.nextLine();
               if(messageToSend.equals("exit"))
               {
                   System.out.println("Deconectat!");
                   closeEverything(socket,bufferedWriter,bufferReader);
               }
               bufferedWriter.write(messageToSend);
               bufferedWriter.newLine();
               bufferedWriter.flush();

           } catch (IOException e) {
               closeEverything(socket, bufferedWriter, bufferReader);
           }
       }
    }
    public void closeEverything(Socket socket,BufferedWriter bufferedWriter, BufferedReader bufferReader) {
        try {
            if (bufferReader != null) {
                bufferReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introdu datele/print/exit");
        Socket socket=new Socket("localhost",1234);
        Client client=new Client(socket);//,tip);
        client.sendDetails();
    }
}