public class setUPMap{
    static int masterRow = 7;
    static int masterCol = 16;
    static MapElement[][] mainMap = null;
    public static void mainMapSetUp(MapElement[][] map, Player player){
        mainMap = map;
        masterRow = mainMap.length;
        masterCol = mainMap[0].length;
         setUpRows("-", 0);
         for(int row = 1; row < mainMap.length - 1; row++){
            setUpRows("+", row);
         }
         setUpRows("-", mainMap.length - 1);

        setUpCols("|", 0);
        setUpCols("|", masterCol - 2);
        playerSetUp(player);
        //printEverything(mainMap);

    }

    public static void setSignAll(String sign, MapElement[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = new MapElement(sign);
            if(sign.equals("-") || sign.equals("|")){
                arr[i].canBeOverlay = false;
            }
        }
    }

    public static void printEverything(MapElement[][] arr){
        for(MapElement[] i : arr){
            for (MapElement j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void addToMain(MapElement[] arr, int row, int col){
        if(col == -1){
            for (int i = 0; i < arr.length; i++){
                mainMap[row][i] = arr[i];
            }
        }else if (row == -1){
            for (int i = 0; i < arr.length; i++){
                mainMap[i][col] = arr[i];
            }
        }
    }

    public static void setUpRows(String sign, int row){
        MapElement[] rowElement = new MapElement[masterCol - 1];
        setSignAll(sign, rowElement);
        addToMain(rowElement, row, -1);
    }

    public static void setUpCols(String sign, int col){
        MapElement[] colElement = new MapElement[masterRow];
        setSignAll(sign, colElement);
        addToMain(colElement, -1, col);  
    }

    public static void playerSetUp(Player player){
        int spawnRow = (int) (Math.random() * 5 + 1);
        int spawnCol = (int) (Math.random() * 13 + 1);
        player.currentRow = spawnRow;
        player.currentCol = spawnCol;
        System.out.println("random spawn at: " + spawnRow + " , " + spawnCol);
        MapElement playerElement = mainMap[spawnRow][spawnCol];
        playerElement.IOBP = true;
        playerElement.setSign(player.getSign());

    }

    public static void enemySetUp(Enemy[] enemy){
        for(int i = 0; i < enemy.length; i++){
            enemy[i] = new Enemy(mainMap);
            Enemy current = enemy[i];
            current.IDnumber = i;
            MapElement enemyElement = mainMap[current.currentRow][current.currentCol];
            enemyElement.IOBE = i;
            enemyElement.setSign(current.getSign());
            enemyElement.signRestore = current.getSign();
        }
    }


}
