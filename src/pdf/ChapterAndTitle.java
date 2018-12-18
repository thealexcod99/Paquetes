package pdf;
 
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ChapterAndTitle {
    public static final String DEST = "pdf/chapter_title.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ChapterAndTitle().createPdf(DEST);
    }
 
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font chapterFont = FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD);
        Font paragraphFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.ITALIC);
        Chunk chunk = new Chunk("Titulo del PDF", chapterFont);
        Chapter chapter = new Chapter(new Paragraph(chunk), 1);
        chapter.setNumberDepth(0);
        chapter.add(new Paragraph("No se como de grande puede ser el párrafo este pero vamos a escribir hasta que por lo menos se produzca un salto de linea en el pdf generado para ver la estructura del párrafo.", paragraphFont));
        chapter.add(new Paragraph("Un párrafo nuevo simplemente.", paragraphFont));
        document.add(chapter);
        document.close();
    }
}