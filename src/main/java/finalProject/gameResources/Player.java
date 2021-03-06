package finalProject.gameResources;

import java.util.*;

class Player {
    private String name;
    private FieldCell[][] myField = new FieldCell[10][10];
    private FieldCell[][] enemyField = new FieldCell[10][10];
    private int win;

    protected Player(String name) {
        this.name = name;
        for (FieldCell[] line : myField) {
            Arrays.fill(line, FieldCell.EMPTY);
        }
        for (FieldCell[] line : enemyField) {
            Arrays.fill(line, FieldCell.EMPTY);
        }
        win = 0;
    }

    protected FieldCell[][] getMyField() {
        return myField;
    }


    protected FieldCell[][] getEnemyField() {
        return enemyField;
    }


    protected String getName() {
        return name;
    }

    protected int getWin() {
        return win;
    }

    protected boolean shot(boolean hit, Player enemy, Scanner scanner) {
        if (!hit) {
            return false;
        }
        GameLogic.playerNewTurnImitation(this);
        System.out.print("\n\n                                                                          ??????? ?????????? ???????? x y: ");
        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x < 0 || x > 9 || y < 0 || y > 9) {
                throw new IllegalArgumentException();
            }
            if (enemy.myField[x][y].equals(FieldCell.SHIP)) {
                enemy.myField[x][y] = FieldCell.SUNKEN_SHIP;
                this.enemyField[x][y] = FieldCell.SUNKEN_SHIP;
                if (GameLogic.lookForSmthAround(enemy.getMyField(),x,y,FieldCell.SHIP)){
                    System.out.println("                                                                                        ?????!!!");
                } else {
                    System.out.println("                                                                                       ?????????!!!");
                    for (int i = 0; i<this.enemyField.length;i++){
                        for (int j = 0; j < this.enemyField.length;j++){
                            if (GameLogic.lookForSmthAround(this.enemyField,i,j,FieldCell.SUNKEN_SHIP) && this.enemyField[i][j] == FieldCell.EMPTY){
                                this.enemyField[i][j] = FieldCell.SHIP_HALO;
                            }
                        }
                    }
                }

                List<FieldCell> winOrNot = new ArrayList<>();
                for (FieldCell[] line :enemy.myField){
                    winOrNot.addAll(Arrays.asList(line));
                }
                if (!winOrNot.contains(FieldCell.SHIP)) {
                    this.win = 1;
                    throw new NoSuchFieldException("???? ?? ??????? ???????");
                }
                System.out.print("\n                                                                           << ??? ??????????? ??????? Enter >>");
                scanner.nextLine();
                scanner.nextLine();
                shot(true, enemy, scanner);
            } else {
                enemyField[x][y] = FieldCell.SHIP_HALO;
                System.out.println("                                                                                        ????!!!");
                System.out.print("\n\n                                                                           << ??? ??????????? ??????? Enter >>");
                scanner.nextLine();
                scanner.nextLine();
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("                                                                                    ?????????? ?? ??????");
            System.out.print("\n\n                                                                             << ??? ?????????? ????? ??????? Enter >>");
            scanner.nextLine();
            shot(true, enemy, scanner);
        } catch (NoSuchFieldException e) {
            System.out.println("                                                                                   !!!?? ????????!!!");
            System.out.print("\n\n                                                                           << ??? ??????????? ??????? Enter >>");
            scanner.nextLine();
            scanner.nextLine();
        }
        return false;
    }
}