package core;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//movements in directories
public class FindFile {
    public static void FindFile ( String location ) {

        try {
            Files.walk ( Paths.get ( String.valueOf ( location ) ) )
                    .filter ( Files::isRegularFile )
                    .forEach ( path -> new Wrapper ( path.toString () ) ); //TODO - sprawdzić to cholerstwo
        } catch ( IOException e ) {
            e.printStackTrace ();
        }
    }
}