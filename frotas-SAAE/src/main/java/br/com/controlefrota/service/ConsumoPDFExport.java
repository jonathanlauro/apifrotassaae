package br.com.controlefrota.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.model.RelatorioConsumos;
import br.com.controlefrota.repository.ConsumoRepository;
public class ConsumoPDFExport {

	private List <Consumo> RelatorioConsumos;
	
	private RelatorioConsumos rel;
	
	private int totalNotas;
	private Float totalConsumosEmReais;
	private Float totalLitrosAbastecidos = (float) 0.0;
	
	@Autowired
	ConsumoRepository consumoRepository;
	
	
	public ConsumoPDFExport(List<Consumo> relatorioConsumos) {
		this.RelatorioConsumos = relatorioConsumos;
	}
	
	private void writerTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		cell.setPadding(5);
		
		cell.setPhrase(new Phrase("Total de notas fiscais",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total de litros abastecidos",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total de abastecimentos",font));
		table.addCell(cell);
	}
	private void writeTableData(PdfPTable table) {

		table.addCell(String.valueOf(this.totalNotas));
		table.addCell(String.valueOf(this.totalLitrosAbastecidos));
		table.addCell(String.valueOf(this.totalConsumosEmReais));
	} 
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(26);
		document.add(new Paragraph("Consumos:",font));
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		
		writerTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();
	}
}
