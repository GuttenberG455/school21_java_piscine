package school21.spring.service.printer;

import school21.spring.service.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    Renderer renderer;
    String prefix = "";


    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String s) {
        if (!prefix.isEmpty()) {
            prefix = prefix + " ";
        }
        renderer.render(prefix + s);
    }
}
