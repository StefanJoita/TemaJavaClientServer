import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
class ClientHandler extends Thread {

    public static ArrayList<Human>  humans=new ArrayList<Human>();
    private Socket socket;
    private BufferedReader bufferReader;
    private BufferedWriter bufferedWriter;

    public ClientHandler(Socket socket)
    {
        try
        {
            this.socket=socket;
            this.bufferedWriter=new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
            this.bufferReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e)
        {
            closeEverything(socket,bufferedWriter,bufferReader);
        }
    }
    @Override
    public void run() {
        String message;
        while(socket.isConnected())
        {   try {

                message = bufferReader.readLine();
                String[] words = message.split(" ");
                //mare switch ca sa tratam tipurile de mesaj venite de la client
                switch (words[0])
                {
                    case "exit":
                    {
                        System.out.println("Client Deconectat!");
                        closeEverything(socket,bufferedWriter,bufferReader);
                        break;
                    }
                    case "Student" : {
                        System.out.println("A intrat un student");
                        //TO DO
                        //mai trebuie sa verific daca a introdus toate detaliile corect
                        Human student = new Student(words[1], words[2], words[3], Integer.parseInt(words[4]), Integer.parseInt(words[5]));
                        humans.add(student);
                        break;
                    }
                    case "Profesor" : {
                        //TO DO
                        //mai trebuie sa verific daca a introdus toate detaliile corect
                        System.out.println("A intrat un profesor");
                        Human profesor = new Profesor(words[1], words[2], words[3], Integer.parseInt(words[4]), words[5]);
                        humans.add(profesor);
                        break;
                    }
                    case "print":
                    {
                        System.out.println("Se va printa lista ordonata de participanti:");
                        sortHumans();
                        for(Human j:humans)
                            System.out.println(j.toString());
                    }


                }

        }
            catch(IOException e)
            {
                closeEverything(socket,bufferedWriter,bufferReader);
                break;
            }
        }
    }
    void sortHumans()
    {
        Collections.sort(humans);
    }
    public void closeEverything(Socket socket,BufferedWriter bufferedWriter, BufferedReader bufferReader) {
        try
        {
            if(bufferReader!=null)
            {
                bufferReader.close();
            }
            if(bufferedWriter!=null)
            {
                bufferedWriter.close();
            }
            if(socket!=null)
            {
                socket.close();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}