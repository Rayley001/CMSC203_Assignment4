public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot other) {
        if (other == null) {
            this.x = 0;
            this.y = 0;
            this.width = 1;
            this.depth = 1;
        } else {
            this.x = other.x;
            this.y = other.y;
            this.width = other.width;
            this.depth = other.depth;
        }
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getDepth() { return depth; }
    public void setDepth(int depth) { this.depth = depth; }

    private int right() { return x + width; }
    private int bottom() { return y + depth; }

    public boolean overlaps(Plot p) {
        if (p == null) return false;
        if (p.x >= this.right()) return false;
        if (p.right() <= this.x) return false;
        if (p.y >= this.bottom()) return false;
        if (p.bottom() <= this.y) return false;
        return true;
    }

    public boolean encompasses(Plot p) {
        if (p == null) return false;
        return p.x >= this.x && p.y >= this.y &&
               p.right() <= this.right() && p.bottom() <= this.bottom();
    }

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}