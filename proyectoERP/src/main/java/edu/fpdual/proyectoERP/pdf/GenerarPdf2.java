package edu.fpdual.proyectoERP.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

 



// TODO: Auto-generated Javadoc
/**
 * The Class GenerarPdf2.
 */
public class GenerarPdf2 {
	
	
	
    
    /** The fuente negra 10. */
    @SuppressWarnings("unused")
    private Font fuenteNegra10 = FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.BOLD);

/** The fuente azul 25. */
//    private Font fuente8 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.NORMAL);
    @SuppressWarnings("unused")
    private Font fuenteAzul25 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 25, Font.BOLD);
    private Font fuenteNaranja = FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.BOLD);
 

    /** The str consulta SQL. */
    String strConsultaSQL;
    
    /** The con. */
    // Apuntador a la conexion
    Connection con = null;
    
    /** The st 1. */
    // Para ejecutar operaciones SQL
    Statement st1;
    
    /** The rs. */
    // Para guardar los resultados de una operacion SELECT
    ResultSet rs;
    
    /** The document. */
    Document document;
    
    /** The writer. */
    PdfWriter writer;
    
    /** The str rotulo PDF. */
    String strRotuloPDF;
    
    /** The scan. */
    private static Scanner scan;
    
    /** The str nombre del PDF. */
    private static String strNombreDelPDF;

 

    /**
     * Creates the document.
     *
     * @param file the file
     * @param v1 the v 1
     * @param v2 the v 2
     * @param v3 the v 3
     * @param texto the texto
     * @return the document
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws URISyntaxException the URI syntax exception
     * @throws DocumentException the document exception
     */
    public Document createDocument(File file, int v1, int v2, int v3, String texto) throws IOException, URISyntaxException, DocumentException {
        Document document = new Document();

 

        try (FileOutputStream fileStream = new FileOutputStream(file)) {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fileStream);

 

            pdfWriter.setEncryption("user".getBytes(), "1234".getBytes(), PdfWriter.ALLOW_PRINTING,
                    PdfWriter.ENCRYPTION_AES_256);

 
            Image img = Image.getInstance("royal.jpeg");
            img.scaleAbsolute(10, 10);
            img.setAbsolutePosition(0f, 0f);

            Paragraph paragraph = new Paragraph();
            paragraph.add("ROYAL SHEEP ERP"+"\n");
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph.setPaddingTop(2);
            paragraph.setFont(fuenteNegra10);
            Paragraph paragraph1 = new Paragraph();
            paragraph1.add("INFORME PEDIDOS"+"\n");
            paragraph1.add("\n");
            paragraph1.setPaddingTop(1);
            paragraph1.setExtraParagraphSpace(1);
            paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph1.setFont(fuenteNaranja);
            fuenteNaranja.setColor(243,134,52);
            Paragraph paragraph2 = new Paragraph();
            paragraph2.add("\n");


            document.open();
            
            document.add(img);
            document.add(paragraph);
            document.add(paragraph1);


            
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            PdfPTable table = new PdfPTable(4);
            addTableHeader(table);
            addRows(table, v1, v2, v3, texto);
//            addCustomRows(table);
//            agregarTabla(table);

 

            document.add(table);

 

            document.close();

 

        }
        return document;
    }

 

    /**
     * Adds the table header.
     *
     * @param table the table
     */
    private void addTableHeader(PdfPTable table) {
        Stream.of("Order_ID", "Employee_ID", "Customer_ID", "OrderDate").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }

 

//    TODO Probar
//    addRows con parametros

 

    /**
 * Adds the rows.
 *
 * @param table the table
 * @param v1 the v 1
 * @param v2 the v 2
 * @param v3 the v 3
 * @param v4 the v 4
 */
private void addRows(PdfPTable table, int v1, int v2, int v3, String v4) {
//        for (Iterator<Order> iterator = OrderManager.findAll(con).iterator(); iterator.hasNext();) {
//            ListItem order1 = new ListItem();
        Scanner sc = new Scanner(System.in);
        table.addCell(String.valueOf(v1));
        table.addCell(String.valueOf(v2));
        table.addCell(String.valueOf(v3));
        table.addCell(String.valueOf(v4));
        sc.close();
    }

 

    /**
     * Abrir PDF.
     */
    // Abrir pdf
    public static void abrirPDF() {
        /* Abrir el archivo PDF */
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + strNombreDelPDF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * The main method.
     *
     * @param args the arguments
     * @throws MalformedURLException the malformed URL exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws URISyntaxException the URI syntax exception
     * @throws DocumentException the document exception
     */
    public static void main(String[] args)
            throws MalformedURLException, IOException, URISyntaxException, DocumentException {
        scan = new Scanner(System.in);
        System.out.println("Introduce el nombre del pdf a guardar: ");
        strNombreDelPDF = scan.next() + ".pdf";
        
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        String texto = null;
        
        new GenerarPdf2().createDocument(
                new File("C:\\Users\\pablo.villar.serrano\\Desktop\\prueba7.pdf" + strNombreDelPDF), v3, v3, v3, texto);
        abrirPDF();
    }

}