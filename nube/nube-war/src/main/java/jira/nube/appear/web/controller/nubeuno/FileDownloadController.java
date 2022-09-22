package jira.nube.appear.web.controller.nubeuno;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.primefaces.model.StreamedContent;

import java.io.Serializable;

@Named(value="fileDonwloadController")
@SessionScoped
public class FileDownloadController implements Serializable {

    private StreamedContent file;




    /********************************/
    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
}
