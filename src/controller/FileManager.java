package controller;

import model.ModelFile;
import org.w3c.dom.css.Counter;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;
    private ModelFile model;
    private static List<String> names;

    private static boolean esta;
    private int counter;
    public String reader(){
        String text = "";

        try {
            fileReader = new FileReader("src/resources/words.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line != null){
                System.out.println("Estoy dentro de la excepcion 2");
                text += line;
                text += "\n";
                line = input.readLine();
            }
        } catch (FileNotFoundException e) { // Entra a esta seccion cuando no encuentra el archivo
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Estoy dentro de la excepcion 4");
            e.printStackTrace();
        } finally {
            try {
                input.close();
            }  catch (IOException e) {
                System.out.println("Estoy dentro de la excepcion 6");
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

        return text;
    }

    public int countLines() {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/users.txt"))) {
                String line;
                if ((line = br.readLine()) != null) {
                    lineCount++;
                    System.out.println("Ingreso en la linea "  + line );
                    esta=true;
            }
            /*if(line==null){
                this.writer(Users);
                esta = false;
                System.out.println("No esta registrado el usuario " );
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    public void readUsers(String Users){
        counter = this.countLines();
        names = new ArrayList<>();
        model = new ModelFile();
        try{
            int k =0;
            if(esta==false){
                names.add(Users);
            }if(esta==true){
                fileReader = new FileReader("src/resources/users.txt");
                input = new BufferedReader(fileReader);
                String lineas = input.readLine();
                String text = "";
                while (lineas  != null && k<counter) {
                    if(lineas.equals(Users)){
                        text = model.getName(Users);
                        System.out.println("Estoy dentro del if de la funcion readUsers " +text);
                        k++;
                        break;
                    }
                    k++;
                }

                }else{
                System.out.println("no esta el registro");

            }

        }catch (FileNotFoundException e){

        }catch (IOException e){

        }
    }




    public void writer(String line){
        try {
            String text = "";
            text += line ;
            text += "\n";
            fileWriter = new FileWriter("src/resources/users.txt");
            output = new BufferedWriter(fileWriter);
            output.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

