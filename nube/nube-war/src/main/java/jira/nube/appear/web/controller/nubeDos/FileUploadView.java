package jira.nube.appear.web.controller.nubeDos;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.servlet.annotation.WebFilter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.primefaces.shaded.commons.io.FilenameUtils;
import org.primefaces.webapp.filter.FileUploadFilter;

@Named(value = "fileUploadView")
@RequestScoped

public class FileUploadView implements Serializable  {
    private static final Logger logger = Logger.getLogger(FileUploadEvent.class.getName());
    private UploadedFile uploadedFile;


    public void upload() throws IOException {
        //uploadedFile=event.getFile();
        String fileName= FilenameUtils.getBaseName(uploadedFile.getFileName());
        String fileType=FilenameUtils.getExtension(uploadedFile.getContentType());
        Path folderPath = Paths.get("/D:\\docs\\DIPLIMADOS\\JAVA\\Modulo 4\\NubeUnoDoc/");
        Path path=Files.createTempFile(folderPath,fileName+"-","."+fileType);
        try (InputStream inputFile=uploadedFile.getInputStream()){


            Files.copy(inputFile,path, StandardCopyOption.REPLACE_EXISTING);

            logger.log(Level.INFO, "ARCHIVO SUBIDO: ");
        }catch(IOException ex){
            logger.log(Level.INFO, "ERROR AL SUBIR ARCHIVO: " + ex.getMessage());
        }

    }

    /**************************/
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
