public class CircleQueue {
    private int length = 0;

    private final String[] array;

    private int head = 0;
    private int end = 0;

    private boolean full = false;

    public CircleQueue(int length) {
        this.length = length;
        this.array = new String[length];
    }

    public void add(String s) {
        end++;

        if (end == length) {
            end = 0;

            full = true;
        }

        if (full && (end == head)) {
            head++;

            if (head == length) {
                head = 0;
            }
        }

        array[end] = s;
    }

    public String head() {
        if (full) {
            return array[head];
        }
        else {
            return array[head + 1];
        }
    }

    public String end() {
        return array[end];
    }

    public String[] showAll() {
        int resultLength = length;

        if (!full) {
            resultLength = end;
        }

        String[] result = new String[resultLength];

        int index = 0;

        if (full) {
            for (int i = head; i < length; i++) {
                result[index] = array[i];

                index++;
            }
        }

        for (int i = 0; i <= end; i++) {
            if (!full && (i == 0)) {
                continue;
            }

            result[index] = array[i];

            index++;
        }

        return result;
    }
}
