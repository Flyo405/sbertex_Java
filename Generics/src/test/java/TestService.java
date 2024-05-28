import org.junit.Test;
import static org.junit.Assert.*;

public class TestService {

    @Test
    public void testProcessValidRequestAndResponse() {
        ExampleRequestValidator requestValidator = new ExampleRequestValidator();
        ExampleResponseValidator responseValidator = new ExampleResponseValidator();

        ExternalService<ExampleRequestValidator, ExampleResponseValidator> externalService = new ExternalService<>(requestValidator, responseValidator);

        String validRequest = "Valid request data";

        assertTrue(externalService.processRequest(validRequest));
    }

    @Test
    public void testProcessInvalidRequest() {
        RequestValidator requestValidator = new ExampleRequestValidator();
        ResponseValidator responseValidator = new ExampleResponseValidator();

        ExternalService<RequestValidator, ResponseValidator> externalService = new ExternalService<>(requestValidator, responseValidator);

        String invalidRequest = "Invalid request data";

        assertFalse(externalService.processRequest(invalidRequest));
    }

    @Test
    public void testProcessInvalidResponse() {
        ExampleRequestValidator requestValidator = new ExampleRequestValidator();

        ExampleResponseValidator responseValidator = new ExampleResponseValidator() {
            @Override
            public boolean validateResponse(String response) {
                return false;
            }
        };

        ExternalService<ExampleRequestValidator, ExampleResponseValidator> externalService = new ExternalService<>(requestValidator, responseValidator);

        String validRequest = "Valid request data";

        assertFalse(externalService.processRequest(validRequest));
    }
}
