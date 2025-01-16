package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Jm.JMascara;
import modelo.composto.AssistenciaCompleta;
import modelo.composto.EquipamentoCompleto;
import modelo.composto.SeguradoCompleto;

public class Laudo  {
	
	private static void addParagraph(Document document, String text, Font font, int alignment) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(alignment);
        document.add(paragraph);
    }
	
	private static void addParagraph(Document document, String text1, String text2, Font font1, Font font2, int alignment) 
			throws DocumentException{
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(alignment);
		Chunk chunk1 = new Chunk(text1, font1);
		Chunk chunk2 = new Chunk(text2, font2);
		paragraph.add(chunk1);
		paragraph.add(chunk2);
		document.add(paragraph);
	}

    // Método para adicionar uma célula à tabela
    private static void addTableCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(5);
        table.addCell(cell);
    }

    public static void gerarLaudo(AssistenciaCompleta assCom, SeguradoCompleto segCom, EquipamentoCompleto equiCom) {
        try {
        	Assistencia assistencia = assCom.getAssistencia();
        	Endereco enderecoAss = assCom.getEndereco();
        	Segurado segurado = segCom.getSegurado();
        	Endereco enderecoSeg = segCom.getEndereco();
        	Equipamento equipamento = equiCom.getEquipamento();
        	List<Orcamento> orcamentos = equiCom.getOrcamentos();
        	
        	//aplica as mascaras novamente
        	String cnpj = JMascara.GetJmascaraCpfCnpj(assistencia.getCnpj());
        	String telefone = String.valueOf(assistencia.getTelefone());
        	String telefoneComMascara = JMascara.GetJmascaraFone(telefone);

            String destino = "ModeloDeLaudo.pdf";

            // Criar o documento e configurar o escritor
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(destino));

            // Abrir o documento
            document.open();

            // Fontes
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD , 20, BaseColor.BLACK);
            Font subTituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD , 14, BaseColor.BLACK);
            
            Font negritoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font redNegritoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, BaseColor.RED);
            
            Font textFont = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.BLACK);
            Font redTextFont = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.RED);
            
            Font textSimplesFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

            // Título
            addParagraph(document, "LAUDO TÉCNICO / ORÇAMENTO", tituloFont, Element.ALIGN_CENTER);
            addParagraph(document, assistencia.getNomeAssistencia(), tituloFont, Element.ALIGN_CENTER);

            // Dados da empresa
            addParagraph(document, enderecoAss.toString(), textFont, Element.ALIGN_CENTER);
            addParagraph(document, "CNPJ: " + cnpj, textFont, Element.ALIGN_CENTER);
            addParagraph(document, "TELEFONE: " + telefoneComMascara, textFont, Element.ALIGN_CENTER);
            addParagraph(document, "E-mail: " + assistencia.getEmail(), textFont, Element.ALIGN_CENTER);
            document.add(Chunk.NEWLINE);

            // Técnico responsável
            addParagraph(document, "TÉCNICO RESPONSÁVEL: ", assistencia.getNomeTecnicoCompleto(), negritoFont, redNegritoFont, Element.ALIGN_CENTER);
            document.add(Chunk.NEWLINE);

            // Dados do cliente e equipamentos
            addParagraph(document, "Conforme solicitação do " + segurado.getNome() + ", residente na" + 
            enderecoSeg.toString(), textSimplesFont, Element.ALIGN_LEFT);    
            document.add(Chunk.NEWLINE);
            
            addParagraph(document, "Segue avaliação técnica dos seguinte equipamento danificado:", textSimplesFont, Element.ALIGN_LEFT);
            document.add(Chunk.NEWLINE);
            
            addParagraph(document, "DADOS DO EQUIPAMENTO", subTituloFont, Element.ALIGN_CENTER);
            document.add(Chunk.NEWLINE);
            
            addParagraph(document, "Equipamento: ", equipamento.getNomeEquipamento(), textFont, redTextFont, Element.ALIGN_LEFT);
            addParagraph(document, "Marca: ", equipamento.getMarca(), textFont, redTextFont, Element.ALIGN_LEFT);
            addParagraph(document, "Modelo: ", equipamento.getModelo(), textFont, redTextFont, Element.ALIGN_LEFT);
            addParagraph(document, "Numero de Série: ", equipamento.getNumeroSerie(), textFont, redTextFont, Element.ALIGN_LEFT);
            document.add(Chunk.NEWLINE);
            
            addParagraph(document, "Componentes(peças) danificados nos equipamentos: ", textFont, Element.ALIGN_LEFT);
            addParagraph(document, equipamento.getPecasDanificadas(), redTextFont, Element.ALIGN_LEFT);
            addParagraph(document, "Causa conclusiva do dano na peça/ componentes (motivo do dano): ", textFont, Element.ALIGN_LEFT);
            addParagraph(document, equipamento.getMotivoDano(), redTextFont, Element.ALIGN_LEFT);
            addParagraph(document, "Há possibilidade de reparo dos equipamentos? ", textFont, Element.ALIGN_LEFT);
            addParagraph(document, equipamento.getPossibilidadeReparo(), redTextFont, Element.ALIGN_LEFT);
            addParagraph(document, "Se for perda total do equipamento, qual o motivo da perda total do equipamento? ",
            		textFont, Element.ALIGN_LEFT);
            addParagraph(document, equipamento.getMotivoPt(), redTextFont, Element.ALIGN_LEFT);
            

            // Orçamento
            Double valorTotal = 0.0;
            addParagraph(document, "ORÇAMENTO DE REPARO DO EQUIPAMENTO", negritoFont, Element.ALIGN_CENTER);
            document.add(Chunk.NEWLINE);
            
            PdfPTable tabela = new PdfPTable(2);
            tabela.setWidthPercentage(50);
            tabela.setWidths(new int[]{2, 1});
            tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            for(Orcamento orcamento : orcamentos) {
            	valorTotal += orcamento.getValor();
            	String valor = String.valueOf(orcamento.getValor());
            	addTableCell(tabela, orcamento.getDescricao(), textFont);
            	addTableCell(tabela, valor, textFont);
            	
            }
            //addParagraph(document, "VALOR TOTAL	" + valorTotal, negritoFont, Element.ALIGN_LEFT);
            addTableCell(tabela, "VALOR TOTAL", negritoFont);
            String valor = String.valueOf(valorTotal);
            addTableCell(tabela, valor, negritoFont);
            document.add(tabela);           
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            // Assinatura e carimbo
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100); // Define que a tabela usa 100% da largura disponível

            // Adiciona os elementos na tabela
            //addTableCell(table, "Assinatura do técnico responsável", textFont);
            Paragraph paragrafoEsquerdo = new Paragraph("Assinatura do técnico responsável");
            PdfPCell elementoEsquerdo = new PdfPCell(paragrafoEsquerdo);
            elementoEsquerdo.setBorder(PdfPCell.NO_BORDER); // Remove as bordas da célula
            elementoEsquerdo.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            Paragraph paragrafoDireito = new Paragraph("Carimbo da empresa com CNPJ");
            PdfPCell elementoDireito = new PdfPCell(paragrafoDireito);
            elementoDireito.setBorder(PdfPCell.NO_BORDER); // Remove as bordas da célula
            elementoDireito.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            table.addCell(elementoEsquerdo);
            table.addCell(elementoDireito);
            document.add(table);
            
            document.add(Chunk.NEWLINE);
            
            addParagraph(document, "Data de entrada do equipamento na assistência: _____/___/_____", textFont, Element.ALIGN_LEFT);

            // Nova página para as fotos
            document.newPage();

            // Fotos dos equipamentos
            document.add(new Paragraph("Fotos do Equipamento:", tituloFont));

//            // Adicionar imagens ao PDF
//            try {
//                Image foto1 = Image.getInstance(imagem1);
//                foto1.scaleToFit(400, 300);
//                foto1.setAlignment(Element.ALIGN_CENTER);
//                document.add(foto1);
//
//                document.add(Chunk.NEWLINE);
//
//                Image foto2 = Image.getInstance(imagem2);
//                foto2.scaleToFit(400, 300);
//                foto2.setAlignment(Element.ALIGN_CENTER);
//                document.add(foto2);
//            } catch (Exception e) {
//                document.add(new Paragraph("Erro ao carregar as fotos: verifique os caminhos das imagens.", textFont));
//            }

            // Fechar o documento
            document.close();
            System.out.println("PDF criado com sucesso em: " + destino);

            File pdfFile = new File(destino);
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("Abrindo PDF...");
                } catch (Exception ex) {
                    System.out.println("Não foi possível abrir o PDF automaticamente. Verifique o local do arquivo.");
                    ex.printStackTrace();
                }
            } else {
                System.out.println("A função de abertura automática não é suportada neste sistema.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    
    public static void main(String[] args) {
    	Assistencia assistencia = new Assistencia(
    			"Nome Assistencia",
    			"323.234.563-56",
    			1599773213223l,
    			"Tecnico",
    			"meuemail@gmail.com"
    			);
    	
    	Endereco endereco = new Endereco(
    			"essa é a rua",
    			112,
    			"velho",
    			"Salto",
    			"vegetativo",
    			18160000l
    			);
    	
    	Segurado segurado = new Segurado(
    			"Josias"
    			);
    	Endereco endereco2 = new Endereco(
    			"essa é a rua",
    			112,
    			"velho",
    			"Salto",
    			"vegetativo",
    			18160000l
    			);
    	
    	Equipamento equipamento = new Equipamento(
    			"a",
    			"b",
    			"c",
    			"d",
    			"e",
    			"f",
    			"g",
    			"h"
    			);
    	
    	Orcamento orcamento = new Orcamento(
    			"este é um exemplo",
    			25.0
    			);
    	
    	Orcamento orcamento2 = new Orcamento(
    			"este é um exemplo",
    			25.0
    			);
    	ArrayList<Orcamento> orcamentos = new ArrayList<>();
    	orcamentos.add(orcamento);
    	orcamentos.add(orcamento2);
    	
    	AssistenciaCompleta assCom = new AssistenciaCompleta(assistencia, endereco);
    	SeguradoCompleto segCom = new SeguradoCompleto(segurado, endereco2);
    	EquipamentoCompleto equiCom = new EquipamentoCompleto(orcamentos, equipamento);
		gerarLaudo(assCom, segCom, equiCom);
	}
}
