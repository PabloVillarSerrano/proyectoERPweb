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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

 

public class GenerarPdf2 {
    @SuppressWarnings("unused")
    private Font fuenteNegra10 = FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.BOLD);
//    private Font fuente8 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.NORMAL);
    @SuppressWarnings("unused")
    private Font fuenteAzul25 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 25, Font.BOLD);

 

    String strConsultaSQL;
    // Apuntador a la conexion
    Connection con = null;
    // Para ejecutar operaciones SQL
    Statement st1;
    // Para guardar los resultados de una operacion SELECT
    ResultSet rs;
    Document document;
    PdfWriter writer;
    String strRotuloPDF;
    private static Scanner scan;
    private static String strNombreDelPDF;

 

    public Document createDocument(File file, int v1, int v2, int v3, String texto) throws IOException, URISyntaxException, DocumentException {
        Document document = new Document();

 

        try (FileOutputStream fileStream = new FileOutputStream(file)) {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fileStream);

 

            pdfWriter.setEncryption("user".getBytes(), "1234".getBytes(), PdfWriter.ALLOW_PRINTING,
                    PdfWriter.ENCRYPTION_AES_256);

 

            document.open();
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

 

    // Abrir pdf
    public static void abrirPDF() {
        /* Abrir el archivo PDF */
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + strNombreDelPDF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



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