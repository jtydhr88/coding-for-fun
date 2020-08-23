public class ChineseNumber {

    public static final String[] chnNumChar = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static final String[] chnUnitSection = {"", "万", "亿", "万亿"};

    public static final String[] chnUnitChar = {"", "十", "百", "千"};

    public static void main(String[] args) throws Exception {
        int num = 100986500;

        int unitPos = 0;

        String result = "";

        if (num == 0) {
            result = chnNumChar[num];
        }

        while (num != 0) {
            int currentNum = num % 10000;

            String currentNumString = String.valueOf(currentNum);

            boolean zero = false;

            String r = "";

            for (int i = 0; i < currentNumString.length(); i++) {
                char currentChar = currentNumString.charAt(i);

                int number = Character.getNumericValue(currentChar);

                if (number != 0) {
                    r = r + chnNumChar[number];

                    r = r + chnUnitChar[3 - (4 - currentNumString.length()) - i];

                    zero = false;
                }
                else {
                    if (!zero) {
                        r = r + chnNumChar[0];
                    }

                    zero = true;
                }
            }

            if (r.endsWith("零")) {
                r = r.substring(0, r.length() - 1);
            }

            num = num / 10000;

            if (num != 0 & currentNum < 1000 && currentNum > 0) {
                r = chnNumChar[0] + r;
            }

            r = r + chnUnitSection[unitPos];

            result = r + result;

            unitPos = unitPos + 1;
        }

        System.out.println(result);
    }

}
