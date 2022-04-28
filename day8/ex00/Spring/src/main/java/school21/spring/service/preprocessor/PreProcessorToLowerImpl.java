package school21.spring.service.preprocessor;

public class PreProcessorToLowerImpl implements PreProcessor {

    @Override
    public String preProcess(String s) {
        return s.toLowerCase();
    }
}
