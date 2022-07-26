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


    // ����� ��������
    protected boolean shot(boolean hit, Player enemy, Scanner scanner) {
        if (!hit) {
            return false;
        }
        GameLogic.playerNewTurnImitation(this);
        System.out.print("\n\n                                                                          ������� ���������� �������� x,y: ");
        scanner.useDelimiter("[.,:;()?!\"\\s�]+");
        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // �������� ���������
            if (x < 0 || x > 9 || y < 0 || y > 9) {
                throw new IllegalArgumentException("���������� ������� �������");
            }

            // ���� � ���� ����������� �������, ������ �� �������� ������� � ���� �����
            if (enemy.myField[x][y].equals(FieldCell.SHIP)) {
                enemy.myField[x][y] = FieldCell.SUNKEN_SHIP;
                this.enemyField[x][y] = FieldCell.SUNKEN_SHIP;

                // �������� ����� ��� ����. ArrayIndexOutOfBoundsException ignored - � ������ ������ ��������� ��� ���������� ������
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

                // ���� ����� - ������ �����
                if (popal) {
                    System.out.println("                                                                                        �����!!!");
                } else {
                    System.out.println("                                                                                       ���������!!!");
                    List<Integer> coordinatesSunkenShip = new ArrayList<>();

                    // ���� ���� - ������ ��������� � �������� ������ ��������� (��� ��� �����) ��������� �������, ���������� �����
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

                // �������� ������� ���������� ����� ��� ���
                List<FieldCell> winOrNot = new ArrayList<>();
                for (FieldCell[] line : enemy.myField) {
                    winOrNot.addAll(Arrays.asList(line));
                }

                // ���� ������� - �������, ���� ��� - ����� �������� shot()
                if (!winOrNot.contains(FieldCell.SHIP)) {
                    this.win = 1;
                    throw new NoSuchFieldException("���� �� ������� �������");
                }
                System.out.print("\n                                                                           << ��� ����������� ������� Enter >>");
                scanner.nextLine();
                scanner.nextLine();
                shot(true, enemy, scanner);

                // ���� �� ��������� ����������� �� ��������� ������� - ������� ��������� ���� � ��������� �����
            } else {
                enemyField[x][y] = FieldCell.SHIP_HALO;
                System.out.println("                                                                                        ����!!!");
                System.out.print("\n\n                                                                           << ��� ����������� ������� Enter >>");
                scanner.nextLine();
                scanner.nextLine();
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("                                                                                    ���������� �� ������");
            System.out.print("\n\n                                                                             << ��� ���������� ����� ������� Enter >>");
            scanner.nextLine();
            scanner.nextLine();
            shot(true, enemy, scanner);
        } catch (NoSuchFieldException e) {
            System.out.println("                                                                                   !!!�� ��������!!!");
            System.out.print("\n\n                                                                           << ��� ����������� ������� Enter >>");
            scanner.nextLine();
            scanner.nextLine();
        }
        return false;
    }
}