package com.company;

import java.io.*;

public class Input {

    private String txt = "";
    private String wall = "wall";

    private String mainPath = System.getProperty("user.dir") + File.separator;
    private String[] argInput,listTXT;

    private INTMerge INTMerge;
    private MSD msd;

    public Input(String[] arg){
        argInput = arg;
    }
    private void readTXT() throws IOException {
        for (int i = argInput.length - 1; 3 <= i; i--){
            FileReader fileReader = new FileReader(mainPath + argInput[i]);
            BufferedReader br = new BufferedReader(fileReader);
            String strLine;
            while ((strLine = br.readLine())!=null){
                if (!strLine.isEmpty()){
                    txt = txt.concat(strLine + wall);
                }
            }
            br.close();
        }
    }
    private void sortTXT(String typeData){
        if (typeData.intern()=="-i"){
            listTXT = txt.split(wall);
            INTMerge = new INTMerge(listTXT);
            INTMerge.display();
            INTMerge.sort();
        }
        else if (typeData.intern()=="-s"){

        }
    }
    private void writeTXT(File file, String typeData) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        if (typeData.intern()=="-a"){
            int cut = 0;
            while (cut < INTMerge.length()){
                System.out.print(INTMerge.getTheArray()[cut]+" ");
                pw.println(INTMerge.getTheArray()[cut]);
                cut++;
            }
        }
        else if (typeData.intern()=="-d"){
            int cut = INTMerge.length() - 1;
            while (cut != -1){
                pw.println(INTMerge.getTheArray()[cut]);
                System.out.print(INTMerge.getTheArray()[cut]+" ");
                cut--;
            }
        }
        else
            System.out.print("\n" + "Please, enter {-a} or {-d}." + "\n" +
                    "For example -s -a out.txt in1.txt in2.txt in3.txt");
        pw.close();
    }
    public void stdOUT() throws IOException{
        File newFile = new File(argInput[2]);
        if (!newFile.exists())
            newFile.createNewFile();
        readTXT();
        sortTXT(argInput[0]);
        writeTXT(newFile,argInput[1]);
    }
}
