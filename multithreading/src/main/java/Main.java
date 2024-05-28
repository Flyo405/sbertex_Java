public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource(0);

        ResourceProcessor resourceProcessor = new ResourceProcessor(resource);

        Increaser increaser1 = new Increaser(resourceProcessor);
        Increaser increaser2 = new Increaser(resourceProcessor);
        Increaser increaser3 = new Increaser(resourceProcessor);

        increaser1.start();
        increaser2.start();
        increaser3.start();

        increaser1.join();
        increaser2.join();
        increaser3.join();

        Decreaser decreaser = new Decreaser(resourceProcessor);
        Increaser increaser = new Increaser(resourceProcessor);

        Thread decThread = new Thread(decreaser);
        Thread incThread = new Thread(increaser);

        decThread.start();

        synchronized (resourceProcessor) {
            while (resource.getValue() < 5) {
                resourceProcessor.wait();
            }

            for (int i = 0; i < 10; i++) {
                resourceProcessor.increase();
                if (resource.getValue() >= 5) {
                    resourceProcessor.notify();
                    break;
                }
            }

            while (resource.getValue() > 1) {
                resourceProcessor.wait();
            }

            for (int i = 0; i < 10; i++) {
                resourceProcessor.decrease();
                if (resource.getValue() <= 1) {
                    resourceProcessor.notify();
                    break;
                }
            }
        }
        incThread.start();
        incThread.join();
        decThread.join();
    }
}
