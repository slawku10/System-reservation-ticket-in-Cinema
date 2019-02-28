package application.pdf;

import application.kino.model.Reservation;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class PdfItext {

    private static Font timesNewRoman;
    private static List<Reservation> reservations;

    public static ByteArrayOutputStream createPdf(List<Reservation> res) throws FileNotFoundException, DocumentException, IOException {
        BaseFont timesNew = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.EMBEDDED);
        timesNewRoman = new Font(timesNew, 12);
        reservations = res;

        Document document = new Document();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteStream);

        document.open();
        addMetaData(document);
        addFirstPage(document);
        document.close();

        return byteStream;
    }

    private static void addMetaData(Document document) {
        document.addTitle("Potwierdzenie");
        document.addSubject("Potwierdzenie");
        document.addKeywords("potwierdzenie");
        document.addAuthor("KinoCK");
        document.addCreator("KinoCK");
    }

    private static void addFirstPage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);

        preface.add(new Paragraph(
                "Potwierdzenie Rezerwacji", timesNewRoman
        ));

        Anchor anchor = new Anchor();
        anchor.setName("Table");

        Chapter chapter = new Chapter(new Paragraph(anchor), 1);
        Paragraph subPara = new Paragraph();
        Section section = chapter.addSection(subPara);

        addEmptyLine(subPara, 2);

        addTable(section);

        document.add(preface);
        document.add(subPara);
        document.add(section);
    }

    private static void addTable(Section section) {
        PdfPTable table = new PdfPTable(5);

        PdfPCell c1 = new PdfPCell(new Phrase("Sala", timesNewRoman));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        PdfPCell c2 = new PdfPCell(new Phrase("Film", timesNewRoman));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c2);

        PdfPCell c3 = new PdfPCell(new Phrase("Miejsce", timesNewRoman));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c3);

        PdfPCell c4 = new PdfPCell(new Phrase("Cena", timesNewRoman));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c4);

        PdfPCell c5 = new PdfPCell(new Phrase("Rodzaj biletu", timesNewRoman));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c5);

        table.setHeaderRows(1);

        reservations.stream().map((reservation) -> {
            table.addCell(new Phrase(reservation.getIdShowing().getIdHall().getId().toString(), timesNewRoman));
            return reservation;
        }).map((reservation) -> {
            table.addCell(new Phrase(reservation.getIdShowing().getIdFilm().getName(), timesNewRoman));
            return reservation;
        }).map((reservation) -> {
            table.addCell(new Phrase(String.valueOf(reservation.getPlace()), timesNewRoman));
            return reservation;
        }).map((reservation) -> {
            table.addCell(new Phrase(String.valueOf(reservation.getPrice()), timesNewRoman));
            return reservation;
        }).forEachOrdered((reservation) -> {
            table.addCell(new Phrase(reservation.getPlaceKind(), timesNewRoman));
        });

        section.add(table);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
