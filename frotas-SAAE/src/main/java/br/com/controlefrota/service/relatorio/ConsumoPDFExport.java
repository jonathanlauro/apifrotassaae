package br.com.controlefrota.service.relatorio;

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
import br.com.controlefrota.model.RelatorioConsumosModel;
import br.com.controlefrota.repository.ConsumoRepository;
public class ConsumoPDFExport {

	private List <Consumo> relatorioConsumos;
	
	private RelatorioConsumosModel rel;
	
	private int totalNotas;
	private float totalConsumosEmReais;
	private float totalLitrosAbastecidos;
	
	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	RelatorioService relatorioService;
	
	
	public ConsumoPDFExport(List<Consumo> relatorioConsumos) {
		this.relatorioConsumos = relatorioConsumos;
	}
	
	private void writerTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		font.setSize(14);
		cell.setPadding(5);
		
		cell.setPhrase(new Phrase("Total de notas fiscais",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total de litros abastecidos",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total de abastecimentos",font));
		table.addCell(cell);
	}
	private void writeTableData(PdfPTable table) {

		for(Consumo consumo:relatorioConsumos) {
			this.totalNotas += 1;
			this.totalLitrosAbastecidos += consumo.getLitros();
			this.totalConsumosEmReais += consumo.getValor();
		}
		
		
		
		table.addCell(String.valueOf(this.totalNotas));
		table.addCell(String.valueOf(this.totalLitrosAbastecidos));
		table.addCell("R$ "+String.valueOf(this.totalConsumosEmReais));
	} 
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(26);
		document.add(new Paragraph("Total de consumos:",font));
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		
		writerTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		
//		Caso eu precise gerar duas tabelas eu uso o codigo abaixo
		
//		document.add(new Paragraph("Totalzinho:",font));
//		PdfPTable table2 = new PdfPTable(3);
//		table2.setWidthPercentage(100);
//		table2.setSpacingBefore(15);
//		table2.setSpacingAfter(10);
//		
//		writerTableHeader(table2);
//		writeTableData(table2);
//		
//		document.add(table2);
		
		
		document.close();
	}
}
