public class StreamContainer {
    private final String name;
    private final long count;

    public StreamContainer(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }

    public StreamContainer(String name) {
        this.name = name;
        this.count = 0;
    }

    @Override
    public String toString() {
        return "StreamContainer{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
