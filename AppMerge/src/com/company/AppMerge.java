package com.company;

import java.io.IOException;

public class AppMerge {

    public static void main(String[] args) throws IOException {
        String arg[] = {}; //"-i","-a","out.txt","4.txt","2.txt", "1.txt"
        //"-s","-a","out.txt","4.txt","2.txt", "1.txt" для строк
        for (int i = 0; i < args.length; i++){
            arg = args;
        }
        Input input = new Input(arg);
        input.stdOUT();
    }
}
