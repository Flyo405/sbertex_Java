class ExternalService<T extends RequestValidator, U extends ResponseValidator> {
    private T RequestValidator;
    private U ResponseValidator;

    public ExternalService(T requestValidator, U responseValidator) {
        this.RequestValidator = requestValidator;
        this.ResponseValidator = responseValidator;
    }

    public boolean processRequest(String request) {
        if (!RequestValidator.validateRequest(request)) {
            System.out.println("Invalid request");
            return false;
        }


        String response = "Some response from external service";

        if (!ResponseValidator.validateResponse(response)) {
            System.out.println("Invalid response");
            return false;
        }

        return true;
    }
}
