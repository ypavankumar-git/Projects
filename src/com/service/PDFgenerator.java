package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Inv_Master;
import com.model.Item;
import com.model.User;
@Service("pdfservice")
@Transactional
public class PDFgenerator {
   
	public void getpdf(List<Item> list,User user,Inv_Master inv_master) {
	    
//		String path = request.getRealPath("/");
//		File pdf = new File(path+);
//		pdf.setWritable(true);
		Document document = new Document();
	    try
	    {
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Invoice_"+inv_master.getInv_no()+".pdf"));
	        document.open();
	        document.add(new Paragraph("CUSTOMER NAME:"+user.getUname().toUpperCase()));
	        document.add(new Paragraph("INVOIVE NO:"+inv_master.getInv_no()));
	        document.add(new Paragraph("DATE:"+inv_master.getInv_date()));
	        
	        PdfPTable table = new PdfPTable(3); // 3 columns.
	        table.setWidthPercentage(100); //Width 100%
	        table.setSpacingBefore(10f); //Space before table
	        table.setSpacingAfter(10f); //Space after table
	 
	        //Set Column widths
	        float[] columnWidths = {1f, 1f, 1f};
	        table.setWidths(columnWidths);
	        
	        PdfPCell cell1 = new PdfPCell(new Paragraph("ITEM"));
	        cell1.setBorderColor(BaseColor.BLUE);
	        cell1.setPaddingLeft(10);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell1);
	        
	        PdfPCell cell2 = new PdfPCell(new Paragraph("CATEGORY"));
	        cell2.setBorderColor(BaseColor.BLUE);
	        cell2.setPaddingLeft(10);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell2);
	        
	        PdfPCell cell3 = new PdfPCell(new Paragraph("PRICE"));
	        cell3.setBorderColor(BaseColor.BLUE);
	        cell3.setPaddingLeft(10);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell3);
	        
	        Iterator itr=list.iterator();
	        while(itr.hasNext()) {
	        
	        Item item=(Item) itr.next();
	        String name=item.getItem_name();
	        String category=item.getCategory();
	        String price=((Integer)item.getPrize()).toString();
	        
	        PdfPCell cell4 = new PdfPCell(new Paragraph(name));
	        cell4.setBorderColor(BaseColor.BLUE);
	        cell4.setPaddingLeft(10);
	        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell4);
	        
	        PdfPCell cell5 = new PdfPCell(new Paragraph(category));
	        cell5.setBorderColor(BaseColor.BLUE);
	        cell5.setPaddingLeft(10);
	        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell5);
	        
	        PdfPCell cell6 = new PdfPCell(new Paragraph(price));
	        cell6.setBorderColor(BaseColor.BLUE);
	        cell6.setPaddingLeft(10);
	        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell6);
	        
	 
	        //To avoid having the cell border and the content overlap, if you are having thick cell borders
	        //cell1.setUserBorderPadding(true);
	        //cell2.setUserBorderPadding(true);
	        //cell3.setUserBorderPadding(true);
	 
	        
	        
	        }
	        PdfPCell cell7 = new PdfPCell(new Paragraph(""));
	        cell7.setBorderColor(BaseColor.BLUE);
	        cell7.setPaddingLeft(10);
	        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell7);
	        
	        PdfPCell cell8 = new PdfPCell(new Paragraph("TOTAL COST"));
	        cell8.setBorderColor(BaseColor.BLUE);
	        cell8.setPaddingLeft(10);
	        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell8);
	        
	        PdfPCell cell9 = new PdfPCell(new Paragraph(((Integer)inv_master.getBillamount()).toString()));
	        cell9.setBorderColor(BaseColor.BLUE);
	        cell9.setPaddingLeft(10);
	        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table.addCell(cell9);
	        
	        document.add(table);
	 
	        document.close();
	        writer.close();
	    } catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}
   }

