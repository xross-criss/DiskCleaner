package core;

import main.Main;

import java.awt.*;
import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;

public class ConsoleWindow {

    public static void console (String [] args) throws IOException, InterruptedException, URISyntaxException {
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
        }else{
            THEMAINCLASSNAMEGOESHERE.main(new String[0]); //TODO
            System.out.println("Program has ended, please type 'exit' to close the console");
        }
    }
}