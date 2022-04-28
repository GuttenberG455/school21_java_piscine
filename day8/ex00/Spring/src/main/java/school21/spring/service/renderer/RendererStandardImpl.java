package school21.spring.service.renderer;

import school21.spring.service.preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String s) {
        System.out.println(preProcessor.preProcess(s));
    }
}
