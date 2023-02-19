package com.company;

import java.io.*;

public class Input {

    private String txt = "";
    private String wall = "wall";

    private String mainPath = System.getProperty("user.dir") + File.separator;
    private String[] argInput,listTXT;

    private MergeInt MergeInt;
    private MergeStr mergeStr;

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
    private void sortTXT(String typeData) throws IOException {
        File newFile = new File(argInput[2]);
        if (!newFile.exists())
            newFile.createNewFile();

        if (typeData.intern()=="-i"){
            listTXT = txt.split(wall);
            MergeInt = new MergeInt(listTXT);
            MergeInt.display();
            MergeInt.sort();
            write(newFile,typeData,argInput[1]);
        }
        else if (typeData.intern()=="-s"){
            listTXT = txt.split(wall);
            mergeStr = new MergeStr(listTXT);
            mergeStr.display();
            mergeStr.sort();
            write(newFile,typeData,argInput[1]);
        }
    }
    private void write(File file, String typeInt, String typeRec ) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        if (typeInt.intern()=="-i" && typeRec.intern() =="-a"){
            int cut = 0;
            while (cut < MergeInt.length()){
                System.out.print(MergeInt.getTheArray()[cut]+" ");
                pw.println(MergeInt.getTheArray()[cut]);
                cut++;
            }
        }
        else if (typeInt.intern()=="-i" && typeRec.intern() =="-d"){
            int cut = MergeInt.length() - 1;
            while (cut != -1){
                pw.println(MergeInt.getTheArray()[cut]);
                System.out.print(MergeInt.getTheArray()[cut]+" ");
                cut--;
            }
        }
        else if (typeInt.intern()=="-s" && typeRec.intern() =="-a"){
            int cut = 0;
            while (cut < mergeStr.length()){
                System.out.print(mergeStr.getTheArray()[cut]+" ");
                pw.println(mergeStr.getTheArray()[cut]);
                cut++;
            }
        }
        else if (typeInt.intern()=="-s" && typeRec.intern() =="-d"){
            int cut = mergeStr.length() - 1;
            while (cut != -1){
                pw.println(mergeStr.getTheArray()[cut]);
                System.out.print(mergeStr.getTheArray()[cut]+" ");
                cut--;
            }
        }
        else
            System.out.print("\n" + "Please, enter {-a} or {-d}." + "\n" +
                    "For example -s -a out.txt in1.txt in2.txt in3.txt");
        pw.close();
    }
    public void stdOUT() throws IOException{
        readTXT();
        sortTXT(argInput[0]);
    }
}
