package jira.nube.appear.web.controller.nubeuno;
import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;

import java.io.*;

@Model
public class NubeUno {
    private Part part;
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }


    public String uploadFile() throws IOException {
        // Extract file name from content-disposition header of file part
        String fileName = getFileName(part);
        String basePath = "/D:\\docs\\DIPLIMADOS\\JAVA\\Modulo 4\\NubeUnoDoc/";
        File outputFilePath = new File(basePath + fileName);
        // Copy uploaded file to destination path
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = part.getInputStream();
            outputStream = new FileOutputStream(outputFilePath);

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            printMessage("Success! File upload completed!");
        } catch (IOException e) {
            e.printStackTrace();
            printMessage("Error! File upload error!");
        } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
        }
        return null;
    }

    public void downloadFile(String file) {
        try{
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            String fileName=file;
            byte[] buffer=new byte[1024];
            int bytesRead;


            ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
            ec.setResponseContentType("image/png"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
            ec.setResponseContentLength(1024); // Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.

            ec.setResponseHeader("Content-Disposition", "attachment; filename=/D:\\docs\\DIPLIMADOS\\JAVA\\Modulo 4\\NubeUnoDoc/" + fileName + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.

            OutputStream outputFile = ec.getResponseOutputStream();
            InputStream inputFile= new FileInputStream(fileName);
            while((bytesRead = inputFile.read(buffer))>0){
                outputFile.write(buffer,0,bytesRead);
            }
            outputFile.flush();
            inputFile.close();
            outputFile.close();
            // Now you can write the InputStream of the file to the above OutputStream the usual way.
            // ...

            fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed
        }catch(IOException e){
            printMessage("No se puede descargar el archivo: "+e.getMessage());
        }
    }

    private void printMessage(String message) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
}
