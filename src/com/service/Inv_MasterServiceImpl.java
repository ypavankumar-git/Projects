package com.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Inv_MasterDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Inv_Master;
@Service("inv_masterserviceimpl")
@Transactional
public class Inv_MasterServiceImpl implements Inv_MasterService{

	@Autowired
	private Inv_MasterDAO inv_masterdao;
	
	@Override
	public void saveInv_Master(Inv_Master inv_master) {
		inv_masterdao.saveInv_Master(inv_master);
	}

	@Override
	public void deleteInv_Master(int id) {
		inv_masterdao.deleteInv_Master(id);
		
	}

	@Override
	public List<Inv_Master> listAllInv_Masters() {
		List<Inv_Master> list= inv_masterdao.listAllInv_Masters(); 
		return list;
	}

	@Override
	public List<Inv_Master> listByUserId(int id) {
		List<Inv_Master> list= inv_masterdao.listByUserId(id); 
		return list;
	}

	@Override
	public List<Inv_Master> listByUserIdBetweenDates(String id,Date d1, Date d2) {
		List<Inv_Master> list= inv_masterdao.listByUserIdBetweenDates(id,d1,d2); 
		return list;
	}

	@Override
	public List<Inv_Master> listByUserIdAfterDate(Date d1) {
		
		return null;
	}

	@Override
	public int findLastInvoice() {
		List<Inv_Master> list= inv_masterdao.listAllInv_Masters(); 
		int last=0;
		Iterator itr=list.iterator();
		while(itr.hasNext()) {
		 last=((Inv_Master) itr.next()).getInv_no();
		 }
		return last;
	}
	public static void main(String[]args) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World", font);

		document.add(chunk);
//		TABLE
		
//		PdfPTable table = new PdfPTable(3);
//		addTableHeader(table);
//		addRows(table);
//		addCustomRows(table);

//		document.add(table);
//		document.close();
	}

}
