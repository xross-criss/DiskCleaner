package core;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import simpletypes.IntegrationStatus;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteXMLFile {
    int IDReadFile = 0;
    private Element file;

    Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    String Date_register_add = sdf.format(today);


    public void SaveDataAsXMLFile ( String FileName, String localizationOfDirectory, int sizeOfFile, long checksumOfFile, IntegrationStatus IntegrationStatus ) {


        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance ();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder ();

            // root elements
            Document doc = docBuilder.newDocument ();
            Element rootElement = doc.createElement ( "Directory" );
            doc.appendChild ( rootElement );

            // file elements
            Element file = doc.createElement ( "File" );
            rootElement.appendChild ( file );

            // set attribute to file element
            Attr attr = doc.createAttribute ( "id" );
            attr.setValue ( String.valueOf ( IDReadFile ) );
            file.setAttributeNode ( attr );

            // FileName element
            Element filename = doc.createElement ( "File Name" );
            filename.appendChild ( doc.createTextNode ( FileName ) );
            file.appendChild ( filename );

            // Localization element
            Element localization = doc.createElement ( "Localization" );
            localization.appendChild ( doc.createTextNode ( localizationOfDirectory ) );
            file.appendChild ( localization );

            // Size element
            Element size = doc.createElement ( "Size" );
            size.appendChild ( doc.createTextNode ( String.valueOf ( sizeOfFile ) ) );
            file.appendChild ( size );

            // Checksum element
            Element checksum = doc.createElement ( "Checksum" );
            checksum.appendChild ( doc.createTextNode ( String.valueOf ( checksumOfFile ) ) );
            file.appendChild ( checksum );

            // Date of adding element to register
            Element date1 = doc.createElement ( "Date_of_adding_to_register" );
            date1.appendChild ( doc.createTextNode ( String.valueOf ( Date_register_add ) ) );
            file.appendChild ( date1 );

            // Date of integration of elements
            Element date2 = doc.createElement ( "Date_of_integration" );
            date2.appendChild ( doc.createTextNode ( null ) );
            file.appendChild ( date2 );

            // How many copies element
            Element copies = doc.createElement ( "Copies" );
            copies.appendChild ( doc.createTextNode ( null  ));
            file.appendChild ( copies );

            // Status elements
            Element status = doc.createElement ( "Status" );
            status.appendChild ( doc.createTextNode ( String.valueOf ( IntegrationStatus.SAVED ) ) );
            file.appendChild ( status );

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance ();
            Transformer transformer = transformerFactory.newTransformer ();
            DOMSource source = new DOMSource ( doc );
            StreamResult result = new StreamResult ( new File ( "C:\\file.xml" ) );

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform ( source, result );

            IDReadFile += 1; //TODO - czy na pewno dobrze pamiętam

            System.out.println ( "File saved!" );

        } catch ( ParserConfigurationException pce ) {
            pce.printStackTrace ();
        } catch ( TransformerException tfe ) {
            tfe.printStackTrace ();
        }
    }
}