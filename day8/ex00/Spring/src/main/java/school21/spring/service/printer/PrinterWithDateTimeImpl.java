package school21.spring.service.printer;

import school21.spring.service.renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
    Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String s) {
        renderer.render(LocalDateTime.now() + " " + s);
    }
}
