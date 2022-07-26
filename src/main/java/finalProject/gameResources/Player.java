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


    // Метод выстрела
    protected boolean shot(boolean hit, Player enemy, Scanner scanner) {
        if (!hit) {
            return false;
        }
        GameLogic.playerNewTurnImitation(this);
        System.out.print("\n\n                                                                          Введите координаты стрельбы x,y: ");
        scanner.useDelimiter("[.,:;()?!\"\\s–]+");
        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // проверка координат
            if (x < 0 || x > 9 || y < 0 || y > 9) {
                throw new IllegalArgumentException("Координаты введены неверно");
            }

            // если в этих координатах корабль, меняем на подбитый корабль в двух полях
            if (enemy.myField[x][y].equals(FieldCell.SHIP)) {
                enemy.myField[x][y] = FieldCell.SUNKEN_SHIP;
                this.enemyField[x][y] = FieldCell.SUNKEN_SHIP;

                // проверка попал или убил. ArrayIndexOutOfBoundsException ignored - в данном случае требуется для правильной работы
                boolean popal = false;
                if (GameLogic.lookForSmthAround(enemy.getMyField(), x, y, FieldCell.SHIP)) {
                    popal = true;
                } else {
                    try {
                        if (enemy.myField[x][y - 1] == FieldCell.SUNKEN_SHIP) {
                            popal = GameLogic.lookForSmthAround(enemy.getMyField(), x, y - 1, FieldCell.SHIP);
                            try {
                                if (!popal && enemy.myField[x][y - 2] == FieldCell.SUNKEN_SHIP) {
                                    popal = GameLogic.lookForSmthAround(enemy.getMyField(), x, y - 2, FieldCell.SHIP);
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                    try {
                        if (enemy.myField[x][y + 1] == FieldCell.SUNKEN_SHIP) {
                            popal = GameLogic.lookForSmthAround(enemy.getMyField(), x, y + 1, FieldCell.SHIP);
                            try {
                                if (!popal && enemy.myField[x][y + 2] == FieldCell.SUNKEN_SHIP) {
                                    popal = GameLogic.lookForSmthAround(enemy.getMyField(), x, y + 2, FieldCell.SHIP);
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                    try {
                        if (enemy.myField[x + 1][y] == FieldCell.SUNKEN_SHIP) {
                            popal = GameLogic.lookForSmthAround(enemy.getMyField(), x + 1, y, FieldCell.SHIP);
                            try {
                                if (!popal && enemy.myField[x+2][y] == FieldCell.SUNKEN_SHIP) {
                                    popal = GameLogic.lookForSmthAround(enemy.getMyField(), x+2, y, FieldCell.SHIP);
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                    try {
                        if (enemy.myField[x - 1][y] == FieldCell.SUNKEN_SHIP) {
                            popal = GameLogic.lookForSmthAround(enemy.getMyField(), x - 1, y, FieldCell.SHIP);
                            try {
                                if (!popal && enemy.myField[x-2][y] == FieldCell.SUNKEN_SHIP) {
                                    popal = GameLogic.lookForSmthAround(enemy.getMyField(), x-2, y, FieldCell.SHIP);
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }

                // если попал - вывели попал
                if (popal) {
                    System.out.println("                                                                                        ПОПАЛ!!!");
                } else {
                    System.out.println("                                                                                       УНИЧТОЖЕН!!!");
                    List<Integer> coordinatesSunkenShip = new ArrayList<>();

                    // если убил - вывели УНИЧТОЖЕН и получили массив координат (как при вводе) подбитого корабля, нарисовали ореол
                    for (int i = 0; i < this.enemyField.length; i++) {
                        for (int j = 0; j < this.enemyField.length; j++) {
                            if (this.enemyField[i][j] == FieldCell.SUNKEN_SHIP) {
                                coordinatesSunkenShip.add(i);
                                coordinatesSunkenShip.add(j);
                            }
                        }
                    }
                    Integer[] kostil1 = coordinatesSunkenShip.toArray(new Integer[0]);
                    int[] kostil2 = new int[kostil1.length];
                    for (int i = 0; i < kostil1.length; i++) {
                        kostil2[i] = kostil1[i];
                    }
                    GameLogic.shipHalo(kostil2, this.enemyField);
                }

                // проверка победил стреляющий игрок или нет
                List<FieldCell> winOrNot = new ArrayList<>();
                for (FieldCell[] line : enemy.myField) {
                    winOrNot.addAll(Arrays.asList(line));
                }

                // если победил - выходим, если нет - опять стреляем shot()
                if (!winOrNot.contains(FieldCell.SHIP)) {
                    this.win = 1;
                    throw new NoSuchFieldException("Один из игроков выиграл");
                }
                System.out.print("\n                                                                           << Для продолжения нажмите Enter >>");
                scanner.nextLine();
                scanner.nextLine();
                shot(true, enemy, scanner);

                // если по введенным координатам не оказалось корабля - выводим сообщение МИМО и завершаем метод
            } else {
                enemyField[x][y] = FieldCell.SHIP_HALO;
                System.out.println("                                                                                        МИМО!!!");
                System.out.print("\n\n                                                                           << Для продолжения нажмите Enter >>");
                scanner.nextLine();
                scanner.nextLine();
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("                                                                                    Координаты не верные");
            System.out.print("\n\n                                                                             << Для повторного ввода нажмите Enter >>");
            scanner.nextLine();
            scanner.nextLine();
            shot(true, enemy, scanner);
        } catch (NoSuchFieldException e) {
            System.out.println("                                                                                   !!!ВЫ ПОБЕДИЛИ!!!");
            System.out.print("\n\n                                                                           << Для продолжения нажмите Enter >>");
            scanner.nextLine();
            scanner.nextLine();
        }
        return false;
    }
}