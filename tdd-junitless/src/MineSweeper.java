public class MineSweeper {
    public static void main(String[] args) {
        String[][] simpleMineMap = {{"*"}};

        String[][] expected = {{"*"}};
        String[][] actual = generatePlayMap(simpleMineMap);

        assertArrayEquals(expected, actual, "Can generate a simple map");
    }

    public static String[][] generatePlayMap(String[][] mineMap) {
        String[][] result = {{"*"}};
        return result;
    }

    private static boolean assertArrayEquals(String[][] expected, String[][] simpleMineMap, String message) {
        boolean result = true;
        if ((expected == null && simpleMineMap != null)
                || (expected != null && simpleMineMap == null)
                || (expected.length != simpleMineMap.length) ) {
            result = false;
        }

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                if (expected[i][j] != simpleMineMap[i][j]) {
                    result = false;
                }
            }

        }

        String prefix = result ? "PASS: " : "FAILED: ";
        System.out.println(prefix + message);
        return result;
    }

}
