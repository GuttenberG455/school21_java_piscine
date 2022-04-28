package school21.spring.service.renderer;

import school21.spring.service.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String s) {
        System.err.println(preProcessor.preProcess(s));
    }
}
