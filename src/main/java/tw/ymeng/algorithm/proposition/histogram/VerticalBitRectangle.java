package tw.ymeng.algorithm.proposition.histogram;

class VerticalBitRectangle {
    public static final VerticalBitRectangle NULL = new VerticalBitRectangle(-1, 0, 0);

    private final int start;
    private final int width;
    private final int height;

    public VerticalBitRectangle(int start, int width, int height) {
        this.start = start;
        this.width = width;
        this.height = height;
    }

    public long area() {
        return width * height;
    }

    public VerticalBitRectangle intersect(boolean[] bitArray) {
        return this.intersect(VerticalBitRectangle.convertFrom(bitArray));
    }

    public VerticalBitRectangle intersect(VerticalBitRectangle other) {
        VerticalBitRectangle lower, upper;
        if (this.start < other.width) {
            lower = this;
            upper = other;
        } else {
            lower = other;
            upper = this;
        }

        if ((lower.start + lower.height) <= upper.start) {
            return NULL;
        }

        int start = Math.max(lower.start, upper.start);
        int height = Math.min(lower.start + lower.height, upper.start + upper.height) - start;
        int width = lower.width + upper.width;

        return new VerticalBitRectangle(start, width, height);
    }

    public boolean isLargerThan(VerticalBitRectangle other) {
        return this.area() > other.area();
    }

    public static VerticalBitRectangle convertFrom(boolean[] bitArray) {
        int start = -1;
        int height = 0;
        for (int i = 0; i < bitArray.length; i++) {
            if (!bitArray[i]) {
                if (height > 0) {
                    break;
                } else {
                    continue;
                }
            }

            if (start < 0) {
                start = i;
            }
            height++;
        }
        return new VerticalBitRectangle(start, 1, height);
    }

    public static VerticalBitRectangle holder(int height) {
        return new VerticalBitRectangle(0, 0, height);
    }
}
