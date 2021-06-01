package br.com.controlefrota.service.relatorio;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.model.RelatorioConsumosModel;
import br.com.controlefrota.repository.ConsumoRepository;
public class ConsumoPDFExport {

	private List <Consumo> relatorioConsumos;
	private List <ConsumoModel> totalConsumoGasolina;
	private List <ConsumoModel> totalConsumoAlcool;
	private List <ConsumoModel> totalConsumoDisel;
	
	private RelatorioConsumosModel rel;
	
	private int totalNotas;
	private float totalConsumosEmReais;
	private float totalLitrosAbastecidos;
	

	private int totalNotasGasolina = 0;
	private float totalConsumosEmReaisGasolina = 0;
	private float totalLitrosAbastecidosGasolina = 0;
	

	private int totalNotasAlcool;
	private float totalConsumosEmReaisAlcool;
	private float totalLitrosAbastecidosAlcool;
	

	private int totalNotasDisel;
	private float totalConsumosEmReaisDisel;
	private float totalLitrosAbastecidosDisel;
	
	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	RelatorioService relatorioService;
	
	
	public ConsumoPDFExport(List<Consumo> relatorioConsumos,List <ConsumoModel> totalConsumoGasolina,
			List <ConsumoModel> totalConsumoAlcool, List <ConsumoModel> totalConsumoDisel) {
		
		this.relatorioConsumos = relatorioConsumos;
		this.totalConsumoGasolina = totalConsumoGasolina;
		this.totalConsumoAlcool = totalConsumoAlcool;
		this.totalConsumoDisel = totalConsumoDisel;
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
	
	private void writeTableDataGasolina(PdfPTable table) {

		for(ConsumoModel consumoGasolina:totalConsumoGasolina) {
			this.totalNotasGasolina += 1;
			this.totalLitrosAbastecidosGasolina += consumoGasolina.getLitros();
			this.totalConsumosEmReaisGasolina += consumoGasolina.getValor();
		}
		
		
		
		table.addCell(String.valueOf(this.totalNotasGasolina));
		table.addCell(String.valueOf(this.totalLitrosAbastecidosGasolina));
		table.addCell("R$ "+String.valueOf(this.totalConsumosEmReaisGasolina));
	}
	private void writeTableDataAlcool(PdfPTable table) {

		for(ConsumoModel consumoAlcool:totalConsumoAlcool) {
			this.totalNotasAlcool += 1;
			this.totalLitrosAbastecidosAlcool += consumoAlcool.getLitros();
			this.totalConsumosEmReaisAlcool += consumoAlcool.getValor();
		}
		
		
		
		table.addCell(String.valueOf(this.totalNotasAlcool));
		table.addCell(String.valueOf(this.totalLitrosAbastecidosAlcool));
		table.addCell("R$ "+String.valueOf(this.totalConsumosEmReaisAlcool));
	}
	private void writeTableDataDisel(PdfPTable table) {

		for(ConsumoModel consumoDisel:totalConsumoDisel) {
			this.totalNotasDisel += 1;
			this.totalLitrosAbastecidosDisel += consumoDisel.getLitros();
			this.totalConsumosEmReaisDisel += consumoDisel.getValor();
		}
		
		
		
		table.addCell(String.valueOf(this.totalNotasDisel));
		table.addCell(String.valueOf(this.totalLitrosAbastecidosDisel));
		table.addCell("R$ "+String.valueOf(this.totalConsumosEmReaisDisel));
	}
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		Font font2 = FontFactory.getFont(FontFactory.HELVETICA);
		font2.setSize(26);
		document.add(new Paragraph("Relatório de Consumos:",font2));
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(18);
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("Total de consumos:",font));
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		
		writerTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		
//		Caso eu precise gerar duas tabelas eu uso o codigo abaixo
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("Total de consumos a GASOLINA:",font));
		PdfPTable table2 = new PdfPTable(3);
		table2.setWidthPercentage(100);
		table2.setSpacingBefore(15);
		table2.setSpacingAfter(10);
//		
		writerTableHeader(table2);
		writeTableDataGasolina(table2);
//		
		document.add(table2);
		
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("Total de consumos a ÁLCOOL:",font));
		PdfPTable table3 = new PdfPTable(3);
		table3.setWidthPercentage(100);
		table3.setSpacingBefore(15);
		table3.setSpacingAfter(10);
//		
		writerTableHeader(table3);
		writeTableDataAlcool(table3);
//		
		document.add(table3);
		
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("Total de consumos a DIESEL:",font));
		PdfPTable table4 = new PdfPTable(3);
		table4.setWidthPercentage(100);
		table4.setSpacingBefore(15);
		table4.setSpacingAfter(10);
//		
		writerTableHeader(table4);
		writeTableDataDisel(table4);
//		
		document.add(table4);
		
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("       ",font));
		document.add(new Paragraph("       ",font));
		
		LocalDate dataAtual = LocalDate.now();
		
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	    String text = dataAtual.format(formatters);
		
		document.add(new Paragraph("Data: " + text));
		document.close();
	}
}
