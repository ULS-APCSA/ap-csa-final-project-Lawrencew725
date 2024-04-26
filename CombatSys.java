public class CombatSys {
    public static MapElement[][] mainMap = null;
    public static Enemy[] enemyArr = null;
    public static Player player = null;
    
    /** 
     * @param map the main map of the game
     * @param enemys the array that stores the enemy in the game
     * @param P the player
     */
    public static void setParameter(MapElement[][] map, Enemy[] enemys, Player P){
        mainMap = map;
        enemyArr = enemys;
        player = P;
        System.out.println("Debug info:");
        for(Enemy i : enemyArr){
            System.out.println(i);
        }

        /*if(enemyArr[currentElement.IOBE].HP <= 0){
            enemyArr[currentElement.IOBE].DIE();
        }*/

    }
    
    /** 
     * @param ID the ID AKA the index of the enemy in the enemyArr array
     */
    public static void combat(int ID){
        System.out.println("Debug info: ID of the current enemy is " + ID);
        if(enemyArr[ID].HP > 0){
            System.out.println("You have encounter an enemy");
            player.damage(enemyArr[ID], 25);
            int enemyDMG = (int) (Math.random() * 25);
            System.out.println("it has delt " + enemyDMG + " to you.");
            enemyArr[ID].damage(player, enemyDMG);
            enemyArr[ID].move(); 
        }else{
            enemyArr[ID].DIE();
        }

    }

    public static void incersionSort(int[] arr){
        int currentValue = 0;
        int previousIndex = 0;
        for(int i = 1; i < arr.length; i++){
          currentValue = arr[i];
          previousIndex = i - 1;
          while(previousIndex >= 0 && arr[previousIndex] > currentValue){
            arr[previousIndex + 1] = arr[previousIndex];
            previousIndex--;
          }
          arr[previousIndex + 1] = currentValue;
        }
      }
}
