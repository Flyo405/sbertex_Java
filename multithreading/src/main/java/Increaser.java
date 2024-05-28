class Increaser extends Thread {
    private final ResourceProcessor resourceProcessor;

    public Increaser(ResourceProcessor resourceProcessor) {
        this.resourceProcessor = resourceProcessor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            resourceProcessor.increase();
        }
    }
}
