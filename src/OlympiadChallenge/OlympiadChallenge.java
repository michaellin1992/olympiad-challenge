package OlympiadChallenge;

public class OlympiadChallenge {
    private static final String CORNER = "+";
    private static final String HORIZ_EDGE = "-";
    private static final String VERT_EDGE = "|";
    private static final String INWARD_EDGE = "/";
    private static final String BLANK = " ";
    /** 
     * The method that will generate all your art.
     * 
     * @param rows Number of rows in the block scheme.
     * @param column Number of columns in the block scheme.
     * @param blockScheme A string that specifies the block scheme to print out. Numbers are
     * comma delimited, newlines are colon delimited. Example: If row = 1, column = 3, 
     * blockScheme = "1,1,1" means that the block scheme will have one row, with three columns,
     * with each column being one block tall. See the readme in the root directory for more info.
     *
     * Note that we are going to use row major notation for everything in the matrix representation 
     * of the art. E.G. if we have a 2x2 matrix, (0, 0) represents the top left corner, (1, 0) represents
     * the bottom left corner, (0, 1) represents the top right, (1, 1) is the bottom right.
     *
     * @return Prints out the ASCII art representation of this block scheme. 
     */
    public static void generateArt(int rows, int columns, String blockScheme) {
        int tallestBackTower = getTallestBackTower(blockScheme); 
        int matrixColumnSize = (columns*4)+1+(rows*2);
        int matrixRowSize = (rows*2)+(tallestBackTower*3)+1;
        String[][] artInProgress = new String[matrixRowSize][matrixColumnSize];
        for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                int towerHeight = getTowerHeight(rowIndex, columnIndex, rows, columns, 
                                                 blockScheme);
                artInProgress = fillTowerInMatrix(rowIndex, columnIndex, rows, columns,
                                                  towerHeight, artInProgress, blockScheme);
            }
        }                      
        String[][] finishedArt = fillInBlanks(artInProgress);
        printArt(finishedArt);
    }

    private static int getTallestBackTower(String blockScheme) {
        String[] backRow = blockScheme.split(":", 2);
        String[] splitBackRow = backRow[0].split(",", Integer.MAX_VALUE);
        int tallestTower = Integer.MIN_VALUE;
        for (String oneTower : splitBackRow) {
            int currentTower = Integer.parseInt(oneTower);
            if (currentTower > tallestTower) {
                tallestTower = currentTower;
            }
        }
        return tallestTower;
    }

    private static int getTowerHeight(int towerRow, int towerColumn, int numOfRows, int numOfColumns,
                                      String blockScheme) {
        String[] rows = blockScheme.split(":", numOfRows);
        String row = rows[towerRow];
        String[] heights = row.split(",", numOfColumns);
        return Integer.parseInt(heights[towerColumn]);
    }

    private static String[][] fillTowerInMatrix(int towerRow, int towerColumn, int matrixRows,
                                                int matrixColumns, int towerHeight, String[][] matrixSoFar,
                                                String blockScheme) {
        int leftOffset = (towerColumn * 4) + ((matrixRows - towerRow - 1)*2);
        int vertOffset = (matrixSoFar.length - ((matrixRows - towerRow - 1) * 2));
        for (int towerIndex = 0; towerIndex < towerHeight; towerIndex++) {
            //Fill in bottom edge
            matrixSoFar[vertOffset - (towerIndex * 3) - 1][leftOffset] = CORNER;
            matrixSoFar[vertOffset - (towerIndex * 3) - 1][leftOffset + 1] = HORIZ_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 1][leftOffset + 2] = HORIZ_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 1][leftOffset + 3] = HORIZ_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 1][leftOffset + 4] = CORNER;
            //Fill in right then left edge
            matrixSoFar[vertOffset - (towerIndex * 3) - 2][leftOffset] = VERT_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset] = VERT_EDGE;
            
            matrixSoFar[vertOffset - (towerIndex * 3) - 2][leftOffset + 4] = VERT_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset + 4] = VERT_EDGE;

            matrixSoFar[vertOffset - (towerIndex * 3) - 2][leftOffset + 1] = BLANK;
            matrixSoFar[vertOffset - (towerIndex * 3) - 2][leftOffset + 2] = BLANK;
            matrixSoFar[vertOffset - (towerIndex * 3) - 2][leftOffset + 3] = BLANK;

            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset + 1] = BLANK;
            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset + 2] = BLANK;
            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset + 3] = BLANK;

            //Fill in right side
            matrixSoFar[vertOffset - (towerIndex * 3) - 2][leftOffset + 5] = INWARD_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset + 6] = CORNER;
            matrixSoFar[vertOffset - (towerIndex * 3) - 4][leftOffset + 6] = VERT_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 5][leftOffset + 6] = VERT_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 6][leftOffset + 6] = CORNER;
            matrixSoFar[vertOffset - (towerIndex * 3) - 5][leftOffset + 5] = INWARD_EDGE;

            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset + 5] = BLANK;
            matrixSoFar[vertOffset - (towerIndex * 3) - 4][leftOffset + 5] = BLANK;

        }
        //Fill in the top
        matrixSoFar[vertOffset - (towerHeight * 3) - 1][leftOffset] = CORNER;
        matrixSoFar[vertOffset - (towerHeight * 3) - 1][leftOffset + 1] = HORIZ_EDGE;
        matrixSoFar[vertOffset - (towerHeight * 3) - 1][leftOffset + 2] = HORIZ_EDGE;
        matrixSoFar[vertOffset - (towerHeight * 3) - 1][leftOffset + 3] = HORIZ_EDGE;
        matrixSoFar[vertOffset - (towerHeight * 3) - 1][leftOffset + 4] = CORNER;

        matrixSoFar[vertOffset - (towerHeight * 3) - 2][leftOffset+1] = INWARD_EDGE;
        matrixSoFar[vertOffset - (towerHeight * 3) - 3][leftOffset+2] = CORNER;
        matrixSoFar[vertOffset - (towerHeight * 3) - 3][leftOffset+3] = HORIZ_EDGE;
        matrixSoFar[vertOffset - (towerHeight * 3) - 3][leftOffset+4] = HORIZ_EDGE;
        matrixSoFar[vertOffset - (towerHeight * 3) - 3][leftOffset+5] = HORIZ_EDGE;

        matrixSoFar[vertOffset - (towerHeight * 3) - 2][leftOffset+2] = BLANK;
        matrixSoFar[vertOffset - (towerHeight * 3) - 2][leftOffset+3] = BLANK;
        matrixSoFar[vertOffset - (towerHeight * 3) - 2][leftOffset+4] = BLANK;

        return matrixSoFar;
    }

    private static String[][] fillInBlanks(String[][] matrix) {
        for (int columnIndex = 0; columnIndex < matrix.length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < matrix[0].length; rowIndex++) {
                if (matrix[columnIndex][rowIndex] == null) {
                    matrix[columnIndex][rowIndex] = ".";
                }
            }
        }
        return matrix;
    }

    private static void printArt(String[][] art) {
        for (int columnIndex = 0; columnIndex < art.length; columnIndex++) {
            String row = "";
            for (int rowIndex = 0; rowIndex < art[0].length; rowIndex++) {
                row = row + art[columnIndex][rowIndex];
            }
            System.out.println(row);
        }
    }
}
