package OlympiadChallenge;

public class OlympiadChallenge {
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
        int tallestBackTower = 
        int matrixColumnSize = (columns*4)+1+(rows*2);
        int matrixRowSize = (rows*2)+(tallestBackTower*3)+1;
        String[][] art = new String[][];
    }
}