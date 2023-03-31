package homework.commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import homework.Catalog;
import homework.InvalidCatalog;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.awt.*;
import java.io.*;

public class ReportCommand extends Command {
    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void reportHTML() throws IOException, TemplateException, InvalidCatalog {
        if (catalog == null) {
            Exception e = new Exception("Nonexistent catalog (null)");
            throw new InvalidCatalog(e);
        } else {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setDirectoryForTemplateLoading(new File("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB5/src/main/java/templates"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            Template template = cfg.getTemplate("HTMLdocument.ftlh");
            OutputStream outputStream = new FileOutputStream("output.html");
            Writer out = new OutputStreamWriter(outputStream);
            template.process(catalog, out);
            Desktop helper = Desktop.getDesktop();
            File fileDocument = new File("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/output.html");
            fileDocument.createNewFile();
            if (fileDocument.exists()) {
                helper.open(fileDocument);
            } else {
                System.out.println("It does not exist");
            }
        }
    }
}
