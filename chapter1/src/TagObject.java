public class TagObject {

    double weight = -1;
    double price = -1;
    int status = 0; // 0: unselected, 1: selected

    public TagObject(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    public double getAveragePrice() {
        return price / weight;
    }
}
