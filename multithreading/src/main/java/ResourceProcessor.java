class ResourceProcessor {
    private Resource resource;
    public ResourceProcessor(Resource resource) {
        this.resource = resource;
    }
    public synchronized void increase() {
        resource.setValue(resource.getValue() + 1);
        System.out.println("Increased: " + resource.getValue());
    }
    public synchronized void decrease() {
        resource.setValue(resource.getValue() - 1);
        System.out.println("Decreased: " + resource.getValue());
    }
}
