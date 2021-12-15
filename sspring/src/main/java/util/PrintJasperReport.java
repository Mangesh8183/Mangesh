package util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import com.mysql.jdbc.Connection;

public class PrintJasperReport {

	public static void printreport(String reportFileName, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, Map<String, Object> mapParameters) throws JRException, NamingException, SQLException, IOException
	{
		 JasperReport jasperReport =  getCompiledFile(reportFileName, httpServletRequest);
         generateReportPDF(httpServletResponse, mapParameters, jasperReport,DBConnection.getconnection());
	}
	private static JasperReport getCompiledFile(String fileName, HttpServletRequest request) throws JRException
	{
	    File reportFile = new File( request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
	    // If compiled file is not found, then compile XML template
	    //JasperCompileManager.compileReportToFile(request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jrxml"),request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
	    return jasperReport;
    } 
	private static void generateReportPDF (HttpServletResponse resp, Map<String, Object> mapParameters, JasperReport jasperReport, Connection conn)throws JRException, NamingException, SQLException, IOException {
     byte[] bytes = null;
	        bytes = JasperRunManager.runReportToPdf(jasperReport,mapParameters,conn);
	       // resp.reset();
	        //resp.resetBuffer();
	        resp.setContentType("application/pdf");
	        resp.setContentLength(bytes.length);
	        resp.setHeader("Document", "Pdf");
	        ServletOutputStream ouputStream = resp.getOutputStream();
	       
	        ouputStream.write(bytes, 0, bytes.length);
	        ouputStream.flush();
	        ouputStream.close();
		}
}