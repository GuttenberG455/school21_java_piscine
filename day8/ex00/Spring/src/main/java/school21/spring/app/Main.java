package school21.spring.app;

import school21.spring.service.preprocessor.PreProcessor;
import school21.spring.service.preprocessor.PreProcessorToLowerImpl;
import school21.spring.service.preprocessor.PreProcessorToUpperImpl;
import school21.spring.service.printer.Printer;
import school21.spring.service.printer.PrinterWithDateTimeImpl;
import school21.spring.service.printer.PrinterWithPrefixImpl;
import school21.spring.service.renderer.Renderer;
import school21.spring.service.renderer.RendererErrImpl;
import school21.spring.service.renderer.RendererStandardImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {

        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer renderer = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPrefix("Prefix ");
        printer.print("Hello!");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer prefixPrinter1 = context.getBean("printerWithPrefix", Printer.class);
        prefixPrinter1.print("Hello!") ;

        PreProcessor preProcessor1 = new PreProcessorToLowerImpl();
        Renderer rendererErr = new RendererErrImpl(preProcessor1);
        PrinterWithPrefixImpl prefixPrinter2 = new PrinterWithPrefixImpl(rendererErr);
        prefixPrinter2.setPrefix("( ‾́ ◡ ‾́ )");
        prefixPrinter2.print("Hohohoho");

        PreProcessor preProcessor2 = new PreProcessorToUpperImpl();
        Renderer rendererStd = new RendererStandardImpl(preProcessor2);
        PrinterWithDateTimeImpl dateAndTimePrinter1 = new PrinterWithDateTimeImpl(rendererStd);
        dateAndTimePrinter1.print("Hello");
    }
}
