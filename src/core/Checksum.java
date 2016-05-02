package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Checksum {
    public static String md5Calc ( String s ) throws NoSuchAlgorithmException, IOException {

        MessageDigest md = MessageDigest.getInstance ( "MD5" );
        FileInputStream fis = new FileInputStream ( s );

        byte[] dataBytes = new byte[ 1024 ];

        int nread = 0;
        while ( ( nread = fis.read ( dataBytes ) ) != -1 ) {
            md.update ( dataBytes, 0, nread );
        }
        ;
        byte[] mdbytes = md.digest ();
        StringBuffer sb = new StringBuffer ();
        for ( int i = 0; i < mdbytes.length; i++ ) {
            sb.append ( Integer.toString ( ( mdbytes[ i ] & 0xff ) + 0x100, 16 ).substring ( 1 ) );
        }
        return sb.toString ();
    }
}


/*
        try {
            //String s = "TEST STRING";
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(s.getBytes(),0,s.length());
            String signature = new BigInteger (1,md5.digest()).toString(16);
            System.out.println("Signature: "+signature);

        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
*/