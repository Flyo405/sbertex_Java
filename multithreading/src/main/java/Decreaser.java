class Decreaser implements Runnable {
    private ResourceProcessor resourceProcessor;

    public Decreaser(ResourceProcessor resourceProcessor) {
        this.resourceProcessor = resourceProcessor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resourceProcessor.decrease();
        }
    }
}
