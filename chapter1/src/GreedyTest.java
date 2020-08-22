public class GreedyTest {

    public static void main(String[] args) throws Exception {
        TagObject[] objects = {
            new TagObject(3,30), new TagObject(3,20), new TagObject(2,20),
            new TagObject(2,30),};

        double currentWeight = 7;

        double totalPrice = 0;

        for (int m = 0; m < objects.length; m++) {
            int bestAveragePriceIndex = -1;

            double bestAveragePrice = -1;

            for (int i = 0; i < objects.length; i++) {
                TagObject object = objects[i];

                if (object.status == 2) {
                    continue;
                }

                if (bestAveragePrice < object.getAveragePrice() && object.status == 0) {
                    bestAveragePrice = object.getAveragePrice();

                    bestAveragePriceIndex = i;
                }
            }

            if (bestAveragePriceIndex == -1) {
                break;
            }

            TagObject object = objects[bestAveragePriceIndex];

            if (currentWeight >= object.weight) {
                totalPrice = totalPrice + object.price;

                object.status = 1;

                currentWeight = currentWeight - object.weight;
            }
            else {
                object.status = 2;
            }
        }

        System.out.println(totalPrice);
    }

}
