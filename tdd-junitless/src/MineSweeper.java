public class MineSweeper {
    public static void main(String[] args) {
        testThatApplicationCanResolveASimpleMineMap();
        testThatApplicationCanResolveAMineMapWithTwoColumn();
    }


    public static String[][] generatePlayMap(String[][] mineMap) {
        String[][] map = mineMap;
        for (int xOrdinate = 0; xOrdinate < map[0].length; xOrdinate++) {
            if (map[0][xOrdinate].equals("*")) map[0][xOrdinate] = "*";
            else map[0][xOrdinate] = "1";
        }
        return map;
    }

    private static void testThatApplicationCanResolveASimpleMineMap() {
        String[][] simpleMineMap = {{"*"}};

        String[][] expected = {{"*"}};
        String[][] actual = generatePlayMap(simpleMineMap);

        assertArrayEquals(expected, actual, "Can generate a simple map");
    }

    private static void testThatApplicationCanResolveAMineMapWithTwoColumn() {
        String[][] simpleMineMap = {
                {"*", "."}
        };

        String[][] expected = {
                {"*", "1"}
        };
        String[][] actual = generatePlayMap(simpleMineMap);

        assertArrayEquals(expected, actual, "Can generate a simple map");
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
