package homework.commands;

import homework.Catalog;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.io.Writer;

public class ReportCommand extends Command {
    public ReportCommand(Catalog catalog){
        this.catalog=catalog;
    }

    public void reportHTML(){
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init();
        Template template = Velocity.getTemplate("templates/HTMLdocument.vm");

        VelocityContext context = new VelocityContext();
        context.internalPut("documents", catalog.getDocs());
        Writer writer = new StringWriter();
        template.merge(context, writer);

        System.out.println(writer);
    }
}
