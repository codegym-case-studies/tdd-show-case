public class MineSweeper {
    public static void main(String[] args) {
        testThatApplicationCanResolveASimpleMineMap();
        testThatApplicationCanResolveAMineMapWithTwoColumn();
        testThatApplicationCanResolveAMineMapWithThreeColumn();
    }

    public static String[][] generatePlayMap(String[][] mineMap) {
        String[][] map = mineMap;

        final int MAP_WIDTH = map[0].length;

        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String curentCell = map[0][xOrdinate];

            if (curentCell.equals("*")) {
                map[0][xOrdinate] = "*";
            } else {
                int minesAround = 0;

                boolean hasNeighbourAtLeft = xOrdinate - 1 >= 0;
                boolean hasMineAtLeft = hasNeighbourAtLeft && map[0][xOrdinate - 1].equals("*");
                if (hasMineAtLeft) minesAround++;

                boolean hasNeighbourAtRight = xOrdinate + 1 < MAP_WIDTH;
                boolean hasMineAtRight = hasNeighbourAtRight && map[0][xOrdinate + 1].equals("*");
                if (hasMineAtRight) minesAround++;

                map[0][xOrdinate] = String.valueOf(minesAround);
            }
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

        assertArrayEquals(expected, actual, "Can generate a map with two column");
    }


    private static void testThatApplicationCanResolveAMineMapWithThreeColumn() {
        String[][] simpleMineMap = {
                {"*", ".", "*", ".", "."}
        };

        String[][] expected = {
                {"*", "2", "*", "1", "0"}
        };
        String[][] actual = generatePlayMap(simpleMineMap);

        assertArrayEquals(expected, actual, "Can calculate mine in one row");
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
                if (!expected[i][j].equals(simpleMineMap[i][j])) {
                    result = false;
                }
            }

        }

        String prefix = result ? "PASS: " : "FAILED: ";
        System.out.println(prefix + message);
        return result;
    }

}
