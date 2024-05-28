public class Service {
    public static void main(String[] args) {
        ExternalService<ExampleRequestValidator,ExampleResponseValidator> externalService = new ExternalService<>(new ExampleRequestValidator(), new ExampleResponseValidator());

        String request = "request data";

        if (externalService.processRequest(request)) {
            System.out.println("Request processed successfully");
        } else {
            System.out.println("Request processing failed");
        }
    }
}
