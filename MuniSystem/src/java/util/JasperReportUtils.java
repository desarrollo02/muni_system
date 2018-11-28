package util;

import java.text.SimpleDateFormat;

import javax.faces.context.FacesContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.io.File;

import java.sql.Connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.MalformedURLException;

import java.io.ByteArrayOutputStream;
import java.sql.DriverManager;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.PrinterName;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServletResponse;


import javax.sql.DataSource;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperReportUtils {


    private static String ruta = "";
    private static SimpleDateFormat sdf;

    public JasperReportUtils() {
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }

    public static void respondPDF2(String reportName, Map parameters,
                                   boolean inline, Connection conn, String usu,
                                   String path) {
        try {
            sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
            String disp = (inline) ? "inline" : "attachment";
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setHeader("Content-disposition",
                               disp + "; filename=\"" + reportName + "_" +
                               sdf.format(new Date()) + ".pdf\"");
            response.setContentType("application/pdf");

            ServletOutputStream servletOutputStream =
                response.getOutputStream();
            JasperPrint jasperPrint;
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
            
            String separador = System.getProperty("file.separator");
            parameters.put("SUBREPORT_DIR",
                           path + separador + "jasper" + separador);
            parameters.put("IMAGE_DIR",
                           path + separador + "jasper" + separador +
                           "imagenes" + separador);

            jasperPrint =
                    JasperFillManager.fillReport(servletContext.getRealPath(separador +
                                                                            "reportes" +
                                                                            separador +
                                                                            "jasper" +
                                                                            separador +
                                                                            reportName +
                                                                            ".jasper"),
                                                 parameters, conn);

            JasperExportManager.exportReportToPdfStream(jasperPrint,
                                                        servletOutputStream);

            // FacesContext.getCurrentInstance().addMessage(null, new
            // FacesMessage(FacesMessage.SEVERITY_INFO, "Se genero",
            // "hay datos"));
            FacesContext.getCurrentInstance().responseComplete();
            // FacesContext.getCurrentInstance().getExternalContext().getResponse();
            // FacesContext.getCurrentInstance().getExternalContext().redirect("www.google.com.py");

            // JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(),
            // "window.open('Report', 'myWindow');");

        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (JRException e) {
            // TODO Auto-generated catch block
            System.out.println("***************");
            e.printStackTrace();
        }
    }

    public static void respondPDF(String reportName, Map parameters,
                                  boolean inline, Connection conn,
                                  String usu) throws Exception {
        try {
            sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
            String disp = (inline) ? "inline" : "attachment";
            HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setHeader("Content-disposition",
                               disp + "; filename=\"" + reportName + "_" +
                               sdf.format(new Date()) + ".pdf\"");
            response.setContentType("application/pdf");

            ServletOutputStream servletOutputStream =response.getOutputStream();
            JasperPrint jasperPrint;
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
            String separador = System.getProperty("file.separator");

         

           parameters.put("logoCooperativa", separador + "imagenes" + separador+"logoprincipal.jpg");
            
           
            
            
          //  parameters.put("IMAGE_DIR",
            //               path + separador + "jasper" + separador +
              //             "imagenes" + separador); */
            String reporteADescargar =  "jasper" +separador + reportName + ".jasper";
            
            runReport(reportName,reporteADescargar, parameters);
           
       

        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (JRException e) {
            // TODO Auto-generated catch block
            System.out.println("***************");
            e.printStackTrace();
        }
    }

    public static FacesContext respondPDF2(String reportName, Map parameters,
                                           boolean inline, Connection conn) {
        try {
            sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
            String disp = (inline) ? "inline" : "attachment";
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setHeader("Content-disposition",
                               "inline" + "; filename=\"" + reportName + "_" +
                               sdf.format(new Date()) + ".pdf\"");
            response.setContentType("application/pdf");

            ServletOutputStream servletOutputStream =
                response.getOutputStream();
            JasperPrint jasperPrint;
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
            // jasperPrint =
            // JasperFillManager.fillReport("C:\\Users\\usuario\\Desktop\\reportPrueba.jasper",
            // null, conn);
            String path = servletContext.getRealPath("/reportes/");

            parameters.put("SUBREPORT_DIR", path + "/jasper/");
            parameters.put("IMAGE_DIR", path + "/jasper/imagenes/");

            jasperPrint =
                    JasperFillManager.fillReport(servletContext.getRealPath("/reportes/jasper/" +
                                                                            reportName +
                                                                            ".jasper"),
                                                 parameters, conn);

            JasperExportManager.exportReportToPdfStream(jasperPrint,
                                                        servletOutputStream);

            // FacesContext.getCurrentInstance().addMessage(null, new
            // FacesMessage(FacesMessage.SEVERITY_INFO, "Se genero",
            // "hay datos"));

            // RequestContext context = RequestContext.getCurrentInstance();
            // context.execute("window.open('resource.jsp', '_newtab')");

            // FacesContext.getCurrentInstance().getExternalContext().redirect("www.google.com.py");

            // JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(),
            // "window.open('Report', 'myWindow');");

        } catch (IOException e) {

            System.out.println(e.getMessage());
        } catch (JRException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        return FacesContext.getCurrentInstance();
    }

    /**
     * Manda un printjob a la cola de la impresora
     *
     * @Param jasperPrint El reporte compilado y llenado.
     * @Param printerName El nombre de la impresora que va a imprimir.
     */
    public static void imprimirReporte(JasperPrint jasperPrint,
                                       String printerName) throws JRException {
        if (printerName != null && printerName.length() > 0) {
            // create the print service exporter so that we can print to a named
            // printer
            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            // set the report to print
            exporter.setParameter(JRPrintServiceExporterParameter.JASPER_PRINT,
                                  jasperPrint);

            // tell the exporter to print 1 copy on A4 paper
            PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
            aset.add(new Copies(1));
            aset.add(new JobName("Documento GPA", null));
            // aset.add(MediaSizeName.ISO_A4);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                                  aset);

            // let the exporter know which printer we want to print on
            PrintServiceAttributeSet serviceAttributeSet =
                new HashPrintServiceAttributeSet();
            serviceAttributeSet.add(new PrinterName(printerName, null));

            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                                  serviceAttributeSet);

            // print it
            exporter.exportReport();
        } else {
            imprimirReporte(jasperPrint);
        }
    }

    /**
     * Imprime una reporte con un dialogo de impresion de por medio
     *
     * @Param jasperPrint El reporte compilado y llenado.
     */
    public static void imprimirReporte(JasperPrint jasperPrint) throws JRException {
        net.sf.jasperreports.engine.JasperPrintManager.printReport(jasperPrint,
                                                                   true);
    }

    /**
     * Llena un reporte compilado con los datos del Map de parametros
     *
     * @Param reportFile El archivo compilado *.jasper.
     * @Param parameters Map con parametros necesarios para el llenado del
     *        reporte.
     * @Return El reporte compilado y llenado listo para mostrar o imprimir.
     */
    public static JasperPrint llenarReporte(File reportFile, Map parameters,
                                            Connection conn) throws JRException {
        // agrega el EntityManager al los parametros
        // parameters.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER,
        // JpaResourceBean.getInstance().getEMF().createEntityManager());
        // cargar el archivo compilado en un objeto JasperReport
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
        JasperReport jasperReport =
            (JasperReport)JRLoader.loadObject(reportFile);
        // llenar y devolver el JasperPrint
        // return JasperFillManager.fillReport(jasperReport,
        return JasperFillManager.fillReport(jasperReport, parameters, conn);
    }

    public static JasperPrint llenarReporte(File reportFile, Map parameters,
                                            List<Map<String, ?>> listaDs) throws JRException {
        // agrega el EntityManager al los parametros
        // parameters.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER,
        // JpaResourceBean.getInstance().getEMF().createEntityManager());
        // cargar el archivo compilado en un objeto JasperReport
        JasperReport jasperReport =
            (JasperReport)JRLoader.loadObject(reportFile);
        // llenar y devolver el JasperPrint
        // return JasperFillManager.fillReport(jasperReport,
        return JasperFillManager.fillReport(jasperReport, parameters,
                                            new JRMapCollectionDataSource(listaDs));
    }

    public static byte[] getPDF(String reportPath, Map parameters,
                                Connection conn) throws JRException,
                                                        MalformedURLException {
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        File file =  new File(servletContext.getRealPath(ruta + "/seguro/reportes/" + reportPath));
        String pathSub =  servletContext.getRealPath(ruta + "/seguro/reportes/");
        String pathimg = servletContext.getRealPath(ruta + "/img/");
        parameters.put("SUBREPORT_DIR", pathSub + "/");
        parameters.put("IMAGE_DIR", pathimg + "/");
        return JasperExportManager.exportReportToPdf(llenarReporte(file, parameters, conn));
    }

    public static String getHTML(String reportPath, Map parameters,
                                 Connection conn) throws JRException,
                                                         MalformedURLException {
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        File file =
            new File(servletContext.getRealPath(ruta + "/reportes/jasper/" +
                                                reportPath));
        JRHtmlExporter htmlExporter = new JRHtmlExporter();
        htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                                  llenarReporte(file, parameters, conn));
        htmlExporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
                                  "ISO-8859-1");
        StringBuffer htmlStream = new StringBuffer("");
        htmlExporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER,
                                  htmlStream);
        htmlExporter.exportReport();
        return htmlStream.toString();
    }

    public static String getHTML(String reportPath, Map parameters,
                                 List<Map<String, ?>> listaDs) throws JRException,
                                                                      MalformedURLException {
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        JRHtmlExporter htmlExporter = new JRHtmlExporter();
        File file =
            new File(servletContext.getRealPath(ruta + "/reportes/jasper/" +
                                                reportPath));
        htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                                  llenarReporte(file, parameters, listaDs));
        htmlExporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
                                  "ISO-8859-1");
        htmlExporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
                                  false);
        StringBuffer htmlStream = new StringBuffer("");
        htmlExporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER,
                                  htmlStream);
        htmlExporter.exportReport();
        return htmlStream.toString();
    }

    public static String getHTML(String reportPath,
                                 Map parameters) throws JRException,
                                                        MalformedURLException {
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        JRHtmlExporter htmlExporter = new JRHtmlExporter();
        File file =
            new File(servletContext.getRealPath(ruta + "/reportes/jasper/" +
                                                reportPath));
        htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                                  JasperFillManager.fillReport((JasperReport)JRLoader.loadObject(file),
                                                               parameters,
                                                               new JREmptyDataSource()));
        htmlExporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
                                  "ISO-8859-1");
        StringBuffer htmlStream = new StringBuffer("");
        htmlExporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER,
                                  htmlStream);
        htmlExporter.exportReport();
        return htmlStream.toString();
    }

    public static byte[] getRTF(String reportPath, Map parameters,
                                Connection conn) throws JRException,
                                                        MalformedURLException {
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        File file =
            new File(servletContext.getRealPath(ruta + "/reportes/jasper/" +
                                                reportPath));
        JRRtfExporter rtfExporter = new JRRtfExporter();
        rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                                 llenarReporte(file, parameters, conn));
        ByteArrayOutputStream rtfStream = new ByteArrayOutputStream();
        rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, rtfStream);
        rtfExporter.exportReport();
        return rtfStream.toByteArray();
    }

    public static byte[] getPDF(JasperPrint jasperPrint) throws JRException,
                                                                MalformedURLException {
        @SuppressWarnings("unused")
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public static String getXML(String reportPath, Map parameters,
                                Connection conn) throws JRException {
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        File file =
            new File(servletContext.getRealPath(ruta + "/reportes/jasper/" +
                                                reportPath));
        return JasperExportManager.exportReportToXml(llenarReporte(file,
                                                                   parameters,
                                                                   conn));
    }

    public static byte[] getXLS(String reportPath, Map parameters,
                                Connection conn) throws JRException {
        ByteArrayOutputStream byteArrayOutputStream =
            new ByteArrayOutputStream();
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        File file =
            new File(servletContext.getRealPath(ruta + "/reportes/jasper/" +
                                                reportPath));
        JRXlsExporter exporterXLS = new JRXlsExporter();
        exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,
                                 llenarReporte(file, parameters, conn));
        exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
                                 byteArrayOutputStream);
        exporterXLS.exportReport();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] getXLS(String reportPath, Map parameters,
                                List<Map<String, ?>> listaDs) throws JRException {
        ByteArrayOutputStream byteArrayOutputStream =
            new ByteArrayOutputStream();
        ServletContext servletContext =
            (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        File file =
            new File(servletContext.getRealPath(ruta + "/reportes/jasper/" +
                                                reportPath));
        JRXlsExporter exporterXLS = new JRXlsExporter();
        exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,
                                 llenarReporte(file, parameters, listaDs));
        exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
                                 byteArrayOutputStream);
        exporterXLS.exportReport();
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * Devuelve el reporte al browser en pdf, indicar nombre, y si se muestra o
     * se baja
     **/
    public static void respondPDF1(String reportName, Map parameters,
                                   Connection conn, String usuario) {
        // auditarReportes(reportName, "IMPRIMIR_PDF", usuario);

        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");

        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.setHeader("Content-disposition",
                           "inline" + "; filename=\"" + reportName + "_" +
                           sdf.format(new Date()) + ".pdf\"");
        response.setContentType("application/pdf");
        OutputStream out;
        try {
            byte[] pdf =
                JasperReportUtils.getPDF(reportName + ".jasper", parameters,
                                         conn);
            response.setContentLength(pdf.length);
            out = response.getOutputStream();
            out.write(pdf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void respondFile(File file, String nombreSalida,
                                   boolean inline, String mimeType) {

        String disp = (inline) ? "inline" : "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + nombreSalida);
        response.setContentType(mimeType);
        OutputStream out;
        try {
            byte[] pdf = getBytesFromFile(file);
            response.setContentLength(pdf.length);
            out = response.getOutputStream();
            out.write(pdf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void respondImage(String image, boolean inline) {
        // auditarReportes(reportName, "IMPRIMIR_PDF", usuario);
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = (inline) ? "inline" : "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        int pos = image.lastIndexOf("\\");
        String nombreImagen = image;
        if (pos != -1)
            nombreImagen = nombreImagen.substring(pos);
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + nombreImagen);
        response.setContentType("image/x-png");
        OutputStream out;
        try {
            File f = new File(image);
            byte[] pdf = getBytesFromFile(f);
            response.setContentLength(pdf.length);
            out = response.getOutputStream();
            out.write(pdf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Devuelve el reporte al browser en rtf, indicar nombre, y si se muestra o
     * se baja
     **/
    public static void respondRTF(String reportName, Map parameters,
                                  boolean inline, Connection conn,
                                  String usuario) {
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = (inline) ? "inline" : "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + reportName + "_" +
                           sdf.format(new Date()) + ".rtf\"");
        response.setContentType("application/rtf");
        OutputStream out;
        try {
            byte[] rtf =
                JasperReportUtils.getRTF(reportName + ".jasper", parameters,
                                         conn);
            response.setContentLength(rtf.length);
            out = response.getOutputStream();
            out.write(rtf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void respondXLS(String reportName, Map parameters,
                                  Connection conn, String usuario) {
        // auditarReportes(reportName, "IMPRIMIR_EXCEL", usuario);
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + reportName + "_" +
                           sdf.format(new Date()) + ".xls\"");
        response.setContentType("application/vnd.ms-excel");
        OutputStream out;
        try {
            byte[] xls =
                JasperReportUtils.getXLS(reportName + ".jasper", parameters,
                                         conn);
            response.setContentLength(xls.length);
            out = response.getOutputStream();
            out.write(xls);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException ex) {

            System.out.println(ex.getMessage());
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void respondXLS(String reportName, Map parameters,
                                  List<Map<String, ?>> listaDs,
                                  String usuario) {
        // auditarReportes(reportName, "IMPRIMIR_EXCEL", usuario);
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + reportName + "_" +
                           sdf.format(new Date()) + ".xls\"");
        response.setContentType("application/vnd.ms-excel");
        OutputStream out;
        try {
            byte[] xls =
                JasperReportUtils.getXLS(reportName + ".jasper", parameters,
                                         listaDs);
            response.setContentLength(xls.length);
            out = response.getOutputStream();
            out.write(xls);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /** Guarda el reporte en pdf, indicar nombre, parametros y realPath **/
    public static void guardarPDF(String reportName, Map parameters,
                                  String realPath, Connection conn,
                                  String usuario) {
        try {
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
            File file =
                new File(servletContext.getRealPath(ruta + "/reportes/" +
                                                    reportName + "_" +
                                                    sdf.format(new Date()) +
                                                    ".jasper"));
            JasperExportManager.exportReportToPdfFile(llenarReporte(file,
                                                                    parameters,
                                                                    conn),
                                                      realPath);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Devuelve el reporte al browser en pdf a partir de un JasperPrint, indicar
     * nombre, y si se muestra o se baja
     **/
    public static void respondPDF(JasperPrint jasperPrint, String reportName,
                                  boolean inline, String usuario) {
        // auditarReportes(reportName, "IMPRIMIR_PDF", usuario);
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = (inline) ? "inline" : "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + reportName + "_" +
                           sdf.format(new Date()) + ".pdf\"");
        response.setContentType("application/pdf");
        OutputStream out;
        try {
            byte[] pdf = JasperReportUtils.getPDF(jasperPrint);
            response.setContentLength(pdf.length);
            out = response.getOutputStream();
            out.write(pdf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
	 * public static JasperPrint getCombinedReport(List reports) throws
	 * JRException { JasperPrint combinedReport = new JasperPrint(); // temp
	 * variable JasperPrint print = new JasperPrint(); for (int i = 0; i <
	 * reports.size(); i++) { print = (JasperPrint) reports.get(i);
	 *
	 * copyPages(combinedReport, print); copyFonts(combinedReport, print); }
	 * copyProperties(combinedReport, print); return combinedReport; }
	 */
    /*
	 * private static void copyFonts(final JasperPrint combinedReport,
	 * JasperPrint filledReport) throws JRException { List fonts =
	 * filledReport.getFontsList(); if (fonts == null) { return; } for (Iterator
	 * iter = fonts.iterator(); iter.hasNext();) { JRReportFont font =
	 * (JRReportFont) iter.next(); if
	 * (!combinedReport.getFontsMap().containsKey(font.getName())) {
	 * combinedReport.addFont(font); } } }
	 */

    private static void copyPages(final JasperPrint combinedReport,
                                  JasperPrint filledReport) {
        List pages = filledReport.getPages();

        if (pages == null) {
            return;
        }

        for (Iterator iter = pages.iterator(); iter.hasNext(); ) {
            JRPrintPage page = (JRPrintPage)iter.next();
            combinedReport.addPage(page);
        }
    }

    /**
	 * Set the properties of the target report to the properties of the source.
	 * You might want to change this up.
	 *
	 * @param source
	 * @param target
	 */
    /*
	 * private static void copyProperties(final JasperPrint target, JasperPrint
	 * source) { target.setDefaultFont(source.getDefaultFont());
	 * target.setName(source.getName());
	 * target.setOrientation(source.getOrientation());
	 * target.setPageHeight(source.getPageHeight());
	 * target.setPageWidth(source.getPageWidth()); }
	 */
    /**
	 * Se encarga de realizar la auditoria de los reportes.
	 *
	 * @param reportName
	 *            El nombre del reporte.
	 * @param accion
	 *            La accion realizada. En general puede ser dos valores:
	 *            'IMPRIMIR_EXCEL' o 'IMPRIMIR_PDF'.
	 * @param username
	 *            String que continene el nombre del usuario que solicito
	 *            imprimir el reporte.
	 */
    

    /**
     * Devuelve un List de byte (byte[]) recibiendo una lista de
     * Map<String,Object>
     *
     * @param nombreReporte
     * @param listaDS
     * @param parametros
     * @return
     */
    public static byte[] generarReporte(String nombreReporte,
                                        List<Map<String, ?>> listaDS,
                                        HashMap parametros) {
        byte[] reporte = null;
        try {
            // Locale locale = Locale.getDefault(); //new Locale("en", "US");
            // parametros.put(JRParameter.REPORT_LOCALE, locale);
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
            JasperPrint jp =
                JasperFillManager.fillReport(servletContext.getRealPath("/reportes/jasper/" +
                                                                        nombreReporte),
                                             parametros,
                                             new JRMapCollectionDataSource(listaDS));
            if (jp.getPages().size() > 0) {
                reporte = JasperExportManager.exportReportToPdf(jp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporte;
    }

    /**
     * Devuelve un List de byte (byte[]) recibiendo un DataSource del tipo
     * JRMapCollectionDataSource
     *
     * @param nombreReporte
     * @param listaDS
     * @param parametros
     * @return byte[]
     */
    public static byte[] generarReporte(String nombreReporte,
                                        JRMapCollectionDataSource listaDS,
                                        HashMap parametros) {
        byte[] reporte = null;
        try {
            // Locale locale = Locale.getDefault(); //new Locale("en", "US");
            // parametros.put(JRParameter.REPORT_LOCALE, locale);
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
            JasperPrint jp =
                JasperFillManager.fillReport(servletContext.getRealPath(ruta +
                                                                        "/reportes/jasper/" +
                                                                        nombreReporte),
                                             parametros, listaDS);
            if (jp.getPages().size() > 0) {
                reporte = JasperExportManager.exportReportToPdf(jp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporte;
    }

    /**
     * Genera el PDF recibiendo una lista de Map<String,Object>
     *
     * @param reportName
     * @param inline
     * @param listaDS
     * @param parametros
     */
    public static void respondPDF(String reportName, boolean inline,
                                  List<Map<String, ?>> listaDS,
                                  HashMap parametros) {
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = (inline) ? "inline" : "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + reportName + "_" +
                           sdf.format(new Date()) + ".pdf\"");
        response.setContentType("application/pdf");
        OutputStream out;
        try {
            byte[] pdf =
                JasperReportUtils.generarReporte(reportName + ".jasper",
                                                 listaDS, parametros);
            response.setContentLength(pdf.length);
            out = response.getOutputStream();
            out.write(pdf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Genera el PDF recibiendo una lista de Map<String,Object>
     *
     * @param reportName
     * @param nombre
     * @param inline
     * @param listaDS
     * @param parametros
     */
    public static void respondPDF(String reportName, String nombre,
                                  boolean inline, List<Map<String, ?>> listaDS,
                                  HashMap parametros) {
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = (inline) ? "inline" : "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + nombre + ".pdf\"");
        response.setContentType("application/pdf");
        OutputStream out;
        try {
            byte[] pdf =
                JasperReportUtils.generarReporte(reportName + ".jasper",
                                                 listaDS, parametros);
            response.setContentLength(pdf.length);
            out = response.getOutputStream();
            out.write(pdf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Genera el PDF recibiendo un DataSource del tipo JRMapCollectionDataSource
     *
     * @param reportName
     * @param inline
     * @param listaDS
     * @param parametros
     */
    public static void respondPDF(String reportName, boolean inline,
                                  JRMapCollectionDataSource listaDS,
                                  HashMap parametros) {
        sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        String disp = (inline) ? "inline" : "attachment";
        HttpServletResponse response =
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition",
                           disp + "; filename=\"" + reportName + "_" +
                           sdf.format(new Date()) + ".pdf\"");
        response.setContentType("application/pdf");
        OutputStream out;
        try {
            byte[] pdf =
                JasperReportUtils.generarReporte(reportName + ".jasper",
                                                 listaDS, parametros);
            response.setContentLength(pdf.length);
            out = response.getOutputStream();
            out.write(pdf);
            out.flush();
            out.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Returns the contents of the file in a byte array.

    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length &&
               (numRead = is.read(bytes, offset, bytes.length - offset)) >=
               0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " +
                                  file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
    
    public static void runReport(String nombre, String repPath, java.util.Map param) throws Exception
     {
       Connection conn = null;
       try
       {
         sdf = new SimpleDateFormat("ddMMyyyyHHmmss");  
         HttpServletResponse response = getResponse();
           try (ServletOutputStream out = response.getOutputStream()) {
               response.setHeader("Content-disposition","attachment" + "; filename=\"" + nombre + "_" +sdf.format(new Date()) + ".pdf\"");
               response.setContentType("application/pdf");
               ServletContext context = getContext();
               InputStream fs = context.getResourceAsStream(repPath);//we will put the report under folder "reports" under Web Content
               JasperReport template = (JasperReport) JRLoader.loadObject(fs);
               template.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
               conn =  getDataSourceConnection("java:/PostgresDS");
               JasperPrint print = JasperFillManager.fillReport(template, param, conn);
               ByteArrayOutputStream baos = new ByteArrayOutputStream();
               JasperExportManager.exportReportToPdfStream(print, baos);
               out.write(baos.toByteArray());
               out.flush();
               out.close();
           }
         FacesContext.getCurrentInstance().responseComplete();
       }
       catch (Exception jex)
       {
         jex.printStackTrace();
          System.out.println(jex.getMessage());
       }
       finally
       {    
         close(conn);
       }
     }
    
    public static void runReportB(String nombre, String repPath, java.util.Map param) throws Exception
     {
       Connection conn = null;
       try
       {
         sdf = new SimpleDateFormat("ddMMyyyyHHmmss");  
         HttpServletResponse response = getResponse();
           try (ServletOutputStream out = response.getOutputStream()) {
               response.setHeader("Content-disposition","attachment" + "; filename=\"" + nombre + "_" +sdf.format(new Date()) + ".pdf\"");
               response.setContentType("application/pdf");
               ServletContext context = getContext();
               InputStream fs = context.getResourceAsStream(repPath);//we will put the report under folder "reports" under Web Content
               JasperReport template = (JasperReport) JRLoader.loadObject(fs);
               template.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
               conn =  getDataSourceConnection("java:/PostgresDS");
               
               JasperPrint print = JasperFillManager.fillReport(template, param, conn);
               ByteArrayOutputStream baos = new ByteArrayOutputStream();
               JasperExportManager.exportReportToPdfStream(print, baos);
               out.write(baos.toByteArray());
               out.flush();
               out.close();
           }
         FacesContext.getCurrentInstance().responseComplete();
       }
       catch (Exception jex)
       {
         jex.printStackTrace();
          System.out.println(jex.getMessage());
       }
       finally
       {    
         close(conn);
       }
     }
    
    public  static ServletContext getContext()
      {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
      }
      
      public  static HttpServletResponse getResponse()
      {
        return (HttpServletResponse)getFacesContext().getExternalContext().getResponse();
      }
      
      public static FacesContext getFacesContext()
      {
        return FacesContext.getCurrentInstance();
      }
      
    public static Connection getDataSourceConnection(String dataSourceName) throws Exception
          {
          Context ctx = new InitialContext();
          DataSource ds = (DataSource)ctx.lookup(dataSourceName);
          return ds.getConnection();
        }  
//        {Connection conexion=null;
//         try{   
//          
//          Class.forName("org.postgresql.Driver");
//          conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/muni_system_db", "admin", "desarrollo2");
//         }catch(Exception e){
//             System.out.println(""+e);
//     
//          }  
//          return conexion;
//        }
      
    public static void close(Connection con)
      {
        if (con != null)
        {
          try
          {
            con.close();
          }
          catch (Exception e)
          {
          }
        }
      }  
}

