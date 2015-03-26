package OlympiadChallenge;

public class OlympiadChallenge {
    private static final String CORNER = "+";
    private static final String HORIZ_EDGE = "-";
    private static final String VERT_EDGE = "|";
    private static final String INWARD_EDGE = "/";
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
     * @return Prints out the ASCII art representation of this block scheme. 
     */
    public static void generateArt(int rows, int columns, String blockScheme) {
        int tallestBackTower = getTallestBackTower(blockScheme); 
        int matrixColumnSize = (columns*4)+1+(rows*2);
        int matrixRowSize = (rows*2)+(tallestBackTower*3)+1;
        System.out.println("tallestBackTower is: " + tallestBackTower);
        System.out.println("matrixColumnSize is: " + matrixColumnSize);
        System.out.println("matrixRowSize is: " + matrixRowSize);
        String[][] artInProgress = new String[matrixRowSize][matrixColumnSize];
        for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                int towerHeight = getTowerHeight(rowIndex, columnIndex, rows, columns, 
                                                 blockScheme);
                System.out.println("towerHeight is: " + towerHeight);
                artInProgress = fillTowerInMatrix(rowIndex, columnIndex, rows, columns,
                                                  towerHeight, artInProgress, blockScheme);
                System.out.println("art so far is");
                printArt(artInProgress);
            }
        }                      
        String[][] finishedArt = fillInBlanks(artInProgress);
        //String[][] finishedArt = artInProgress;
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
        System.out.println("numOfRows is: " + numOfRows);
        System.out.println("towerRow: " + towerRow);
        System.out.println("rows is: " + rows);
        System.out.println("rows[0]: " + rows[0]);
        System.out.println("wtf: " + towerRow);
        String row = rows[towerRow];
        String[] heights = row.split(",", numOfColumns);
        return Integer.parseInt(heights[towerColumn]);
    }

    private static String[][] fillTowerInMatrix(int towerRow, int towerColumn, int matrixRows, int matrixColumns,
                                         int towerHeight, String[][] matrixSoFar, String blockScheme) {
        int leftOffset = (towerColumn * 4) + ((matrixRows - towerRow - 1)*2);
        int vertOffset = (matrixSoFar.length - ((matrixRows - towerRow - 1) * 2));
        System.out.println("left offset is: " + leftOffset + " " + matrixSoFar.length + " " + matrixRows);
        System.out.println("vert offset is: " + vertOffset);
        for (int towerIndex = 0; towerIndex < towerHeight; towerIndex++) {
            System.out.println("in for loop");
            //Fill in bottom edge
            System.out.println("matrixRows: " + matrixRows);
            System.out.println("towerIndex: " + towerIndex);
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
            //Fill in right side
            matrixSoFar[vertOffset - (towerIndex * 3) - 2][leftOffset + 5] = INWARD_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 3][leftOffset + 6] = CORNER;
            matrixSoFar[vertOffset - (towerIndex * 3) - 4][leftOffset + 6] = VERT_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 5][leftOffset + 6] = VERT_EDGE;
            matrixSoFar[vertOffset - (towerIndex * 3) - 6][leftOffset + 6] = CORNER;
            matrixSoFar[vertOffset - (towerIndex * 3) - 5][leftOffset + 5] = INWARD_EDGE;
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
        return matrixSoFar;
    }

    private static String[][] fillInBlanks(String[][] matrix) {
        for (int columnIndex = 0; columnIndex < matrix.length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < matrix[0].length; rowIndex++) {
                if (matrix[columnIndex][rowIndex] == null) {
                    matrix[columnIndex][rowIndex] = " ";
                }
            }
        }
        return matrix;
    }

    public static void printArt(String[][] art) {
        System.out.println("art is: " + art);
        for (int columnIndex = 0; columnIndex < art.length; columnIndex++) {
            String row = "";
            for (int rowIndex = 0; rowIndex < art[0].length; rowIndex++) {
                row = row + art[columnIndex][rowIndex];
            }
            System.out.println(row);
        }
    }

    public static boolean blockToRightExists(int row, int column, int height, int numOfRows,
                                             int numOfColumns, String blockScheme) {
        String[] splitRows = blockScheme.split(":", numOfRows);
        String towerRow = splitRows[row];
        String[] splitColumns = towerRow.split(",", numOfColumns);
        System.out.println("split Columns size: " + splitColumns.length);
        System.out.println("column+1: " + column);
        System.out.println("column: " + column);
        int neighborHeight = (column+2) > numOfColumns ? -1 : Integer.parseInt(splitColumns[column]);
        System.out.println("neighborHeight" + neighborHeight);
        if (neighborHeight >= height) {
            return true;
        } else {
            return false;
        }
    }
}
