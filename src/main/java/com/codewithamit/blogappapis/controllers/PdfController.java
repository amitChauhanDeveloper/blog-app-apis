package com.codewithamit.blogappapis.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    @GetMapping("/generate-tax-invoice")
    public void generateTaxInvoice(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=tax-invoice.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        addTextToDocument(document);
        addTableToDocument(document);

        document.close();
    }

    private void addTextToDocument(Document document) throws DocumentException {
        document.add(new Paragraph("Tax Invoice"));
        document.add(new Paragraph("From :"));
        document.add(new Paragraph("601, Shikhar Complex, Near Adani House, Mithakhali Six Road, Navrangpura,"));
        document.add(new Paragraph("Ahmedabad-380009. Gujarat, India."));
        document.add(new Paragraph("Date : 29-02-2024"));
        document.add(new Paragraph("To :"));
        document.add(new Paragraph("User One,"));
        document.add(new Paragraph("Kalol,"));
        document.add(new Paragraph("Gandhi Nagar-382721,"));
        document.add(new Paragraph("Gujarat,"));
        document.add(new Paragraph("India"));
        document.add(new Paragraph("GST No:"));
        document.add(new Paragraph("Invoice No : LTB/23-24/00669"));

        // ... (previous text content)
    }

    private void addTableToDocument(Document document) throws DocumentException {
        // Add table with column headers
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);

        // Header row
        PdfPCell cell = new PdfPCell(new Phrase("Sr No.", getHeaderFont()));
        cell.setBackgroundColor(BaseColor.YELLOW);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Particular", getHeaderFont()));
        cell.setBackgroundColor(BaseColor.YELLOW);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Amount", getHeaderFont()));
        cell.setBackgroundColor(BaseColor.YELLOW);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Subtotal", getHeaderFont()));
        cell.setBackgroundColor(BaseColor.YELLOW);
        table.addCell(cell);

        // Add table rows
        addTableRow(table, "1", "Elite Zyapaari", "₹ 2499.00");
        addTableRow(table, "", "CGST TAX @9%", "₹ 224.91");
        addTableRow(table, "", "SGST TAX @9%", "₹ 224.91");
        addTableRow(table, "", "", "₹ 2948.82");

        document.add(table);

        // ... (remaining content)
    }

    private void addTableRow(PdfPTable table, String srNo, String particular, String amount) {
        table.addCell(srNo);
        table.addCell(particular);
        table.addCell(amount);

        PdfPCell subtotalCell = new PdfPCell(new Phrase("")); // Subtotal column
        subtotalCell.setBackgroundColor(BaseColor.PINK);
        table.addCell(subtotalCell);
    }

    private Font getHeaderFont() {
        Font font = new Font();
        font.setColor(BaseColor.WHITE);
        font.setStyle(Font.BOLD);
        return font;
    }
}
