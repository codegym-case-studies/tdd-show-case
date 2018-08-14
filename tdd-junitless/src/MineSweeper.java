public class MineSweeper {
    public static void main(String[] args) {
        testThatApplicationCanResolveASimpleMineMap();
        testThatApplicationCanResolveAMineMapWithTwoColumn();
        testThatApplicationCanResolveAMineMapWithThreeColumn();
        testThatApplicationCanResolveAMineMapWithMultiRow();
    }

    public static String[][] generatePlayMap(String[][] mineMap) {
        String[][] map = mineMap;

        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;

        for (int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
                String curentCell = mineMap[yOrdinate][xOrdinate];

                if (curentCell.equals("*")) {
                    map[yOrdinate][xOrdinate] = "*";
                } else {
                    final int[][] NEIGHBOURS_ORDINATE = {
                            {yOrdinate - 1, xOrdinate - 1}, {yOrdinate - 1, xOrdinate}, {yOrdinate - 1, xOrdinate + 1},
                            {yOrdinate, xOrdinate - 1}, {yOrdinate, xOrdinate + 1},
                            {yOrdinate + 1, xOrdinate - 1}, {yOrdinate + 1, xOrdinate}, {yOrdinate + 1, xOrdinate + 1},
                    };


                    int minesAround = 0;
                    for (int i = 0; i < NEIGHBOURS_ORDINATE.length; i++) {

                        int[] neighbourOrdinate = NEIGHBOURS_ORDINATE[i];
                        int xOrdinateOfNeighbour = neighbourOrdinate[1];
                        int yOrdinateOfNeighbour = neighbourOrdinate[0];

                        boolean isOutOfMapNeighbour = xOrdinateOfNeighbour < 0
                                || xOrdinateOfNeighbour == MAP_WIDTH
                                || yOrdinateOfNeighbour < 0
                                || yOrdinateOfNeighbour == MAP_HEIGHT;
                        if (isOutOfMapNeighbour) continue;

                        boolean isMineOwnerNeighbour = mineMap[yOrdinateOfNeighbour][xOrdinateOfNeighbour].equals("*");
                        if (isMineOwnerNeighbour) minesAround++;
                    }

                    map[yOrdinate][xOrdinate] = String.valueOf(minesAround);
                }
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

    private static void testThatApplicationCanResolveAMineMapWithMultiRow() {
        String[][] simpleMineMap = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."}
        };

        String[][] expected = {
                {"*", "3", "*", "1", "0"},
                {"2", "*", "2", "1", "0"}
        };
        String[][] actual = generatePlayMap(simpleMineMap);

        assertArrayEquals(expected, actual, "Can calculate mine in multi row");
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
