import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketProblemTest {

    static final int[] bucketCapabilities = {8, 5, 3};

    static List<List<int[]>> allList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int[] bucketStates = {8, 0, 0};

        List<int[]> stateList = new ArrayList<>();

        stateList.add(bucketStates);

        pullWater(bucketStates, stateList);
    }

    public static void pullWater(int[] currentBucketStates, List<int[]> stateList) {
        for (int i = 0; i < currentBucketStates.length; i++) {
            if (currentBucketStates[i] == 0) {
                continue;
            }

            for (int j = 0; j < currentBucketStates.length; j++) {
                if (j == i) {
                    continue;
                }

                if (currentBucketStates[j] == bucketCapabilities[j]) {
                    continue;
                }

                int currentCapabilities = bucketCapabilities[j] - currentBucketStates[j];

                int remain = currentBucketStates[i] - currentCapabilities;

                int[] newStates = currentBucketStates.clone();

                if (remain >= 0) {
                    newStates[i] = remain;

                    newStates[j] = bucketCapabilities[j];
                }
                else {
                    newStates[i] = 0;

                    newStates[j] = currentBucketStates[j] + currentBucketStates[i];
                }

                for (int[] s : stateList) {
                    if (s[0] == newStates[0]  && s[1] == newStates[1] && s[2] == newStates[2]) {
                        for (int[] ss : stateList) {
                            System.out.println(ss[0] + " " + ss[1] + " " + ss[2]);
                        }

                        System.out.println("");

                        allList.add(stateList);

                        return;
                    }
                }

                stateList.add(newStates);

                pullWater(newStates, stateList);
            }
        }
    }

}

