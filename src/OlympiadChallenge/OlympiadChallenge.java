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
        String[][] art = new String[matrixColumnSize][matrixRowSize];
        String[][] finishedArt = fillInBlanks(art);
        return finishedArt;
    }

    private int getTallestBackTower(String blockScheme) {
        String[] backRow = blockScheme.split(":", 2);
        int tallestTower = Integer.parseInt(backRow[0]);
        for (String oneTower : backRow) {
            int currentTower = Integer.parseInt(oneTower);
            if (currentTower > tallestTower) {
                tallestTower = currentTower;
            }
        }
        return tallestTower;
    }

    private String[][] fillTowerInMatrix(int towerRow, int towerColumn, int matrixRows, 
                                         int matrixColumns, int towerHeight, String[][] matrixSoFar) {
        int rightOffset = matrixSoFar.length - (matrixRows * 2);
        for (int towerIndex = 0; towerIndex < towerHeight; towerIndex++) {
            matrixSoFar[rightOffset][towerIndex * 3] = CORNER;
            matrixSoFar[rightOffset - 1][towerIndex * 3] = HORIZ_EDGE;
            matrixSoFar[rightOffset - 2][towerIndex * 3] = HORIZ_EDGE;
            matrixSoFar[rightOffset - 3][towerIndex * 3] = HORIZ_EDGE;
            matrixSoFar[rightOffset - 4][towerIndex * 3] = CORNER;
            
            matrixSoFar[rightOffset][(towerIndex * 3) + 1] = VERT_EDGE;
            matrixSoFar[rightOffset][(towerIndex * 3) + 2] = VERT_EDGE;
            
            matrixSoFar[rightOffset - 4][(towerIndex * 3) + 1] = VERT_EDGE;
            matrixSoFar[rightOffset - 4][(towerInex * 3) + 2] = VERT_EDGE;

            if (towerToRight()) {
                matrixSoFar[rightOffset + 1][(towerIndex * 3) + 1] = INWARD_EDGE;
                matrixSoFar[rightOffset + 2][(towerIndex * 3) + 2] = CORNER;
                matrixSoFar[rightOffset + 2][(towerIndex * 3) + 3] = VERT_EDGE;
                matrixSoFar[rightOffset + 2][(towerIndex * 3) + 4] = VERT_EDGE;
                matrixSoFar[rightOffset + 2][(towerIndex * 3) + 5] = CORNER;
                matrixSoFar[rightOffset + 1][(towerIndex * 3) + 4] = INWARD_EDGE;
            }
        }
        matrixSoFar[rightOffset][[(towerHeight - 1) * 3] + 4] = CORNER;
        matrixSoFar[rightOffset-1][[(towerHeight - 1) * 3] + 4] = HORIZ_EDGE;
        matrixSoFar[rightOffset-2][[(towerHeight - 1) * 3] + 4] = HORIZ_EDGE;
        matrixSoFar[rightOffset-3][[(towerHeight - 1) * 3] + 4] = HORIZ_EDGE;
        matrixSoFar[rightOffset-4][[(towerHeight - 1) * 3] + 4] = CORNER;

        matrixSoFar[rightOffset-3][[(towerHeight - 1) * 3] + 5] = INWARD_EGE;
        matrixSoFar[rightOffset-2][[(towerHeight - 1) * 3] + 6] = CORNER;
        matrixSoFar[rightOffset-1][[(towerHeight - 1) * 3] + 6] = HORIZ_EDGE;
        matrixSoFar[rightOffset][[(towerHeight - 1) * 3] + 6] = HORIZ_EDGE;
        matrixSoFar[rightOffset+1][[(towerHeight - 1) * 3] + 6] = HORIZ_EDGE;
        return matrixSoFar;
    }
}