import java.util.*;

import javax.naming.NameNotFoundException;

import java.io.*;
import java.lang.reflect.Array;

public class Lab {
    public static void main(String [] args)throws Exception{
        String filename = null;


        try{
            filename = args[0];
            if (!filename.endsWith(".arxml")){
                throw new NotVaildAutosarFileException("Your file should end with '.arxml' ");
            }
            File file = new File(filename);
            InputStream inputstream = new FileInputStream(file);
            int l;
            StringBuilder builder = new StringBuilder();

            if ( !((file).length () > 0)){
                throw new EmptyAutosarFileException("Your file is empty");
            } 

            while((l=inputstream.read())!=-1){
                builder.append((char)l);

            }
            String data = builder.toString();
            Scanner sc = new Scanner(data);

            ArrayList<Containers> containers = new ArrayList<Containers>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.contains("<CONTAINER")){
                    String UUID = line.substring(line.indexOf("=")+1,line.indexOf(">"));
                    String shortNameLine = sc.nextLine();
                    String shortNAme = shortNameLine.substring(shortNameLine.indexOf(">")+1, shortNameLine.indexOf("</"));
                    String longNameLine = sc.nextLine();
                    String longName = longNameLine.substring(longNameLine.indexOf(">")+1,longNameLine.indexOf("</") );

                    Containers container = new Containers(UUID, shortNAme, longName);

                    containers.add(container);

                } 
            }
            Collections.sort(containers);
            String newfileString = filename.substring(0, filename.indexOf(".")) + "_mod.arxml";
            FileOutputStream outputStream = new FileOutputStream(newfileString);
            
            Scanner sc2 = new Scanner(data);


            outputStream.write((sc2.nextLine().getBytes()));
            outputStream.write("\n<AUTOSAR>\n".getBytes());

            for(int i =0;i<containers.size();i++){
                outputStream.write(((containers.get(i)).toString()).getBytes());
            }

            outputStream.write("<AUTOSAR>".getBytes());

        }

        catch (NotVaildAutosarFileException e ){
            System.out.println("Error: "+e.getMessage());
        }

        catch (EmptyAutosarFileException e){
            System.out.println("Error: "+e.getMessage());
        }

       // catch (NotVaildAutosarFileException e){}
        
        
    }
}


//exeptionhandling

class NotVaildAutosarFileException extends Exception{
    NotVaildAutosarFileException(String s){
        super(s);
    }
}

class EmptyAutosarFileException extends Exception{
    EmptyAutosarFileException(String s){
        super(s);
    }
}