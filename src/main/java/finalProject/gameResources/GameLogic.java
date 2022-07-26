package finalProject.gameResources;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.ArrayList;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    public static void playSeaBattle() {
        // �������� ���������� ������ � �������� ���� �������,������������� �������
        System.out.println("\n                                                                                 SEA BATTLE v.0.1\n");
        System.out.println("                                                                                                                                                      ���������� MaxonZubr\n\n\n\n");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("                                                                            ������� ��� ������ 1: ");
            Player player1 = new Player(scanner.nextLine());
            System.out.println("\n\n\n");
            System.out.print("                                                                            ������� ��� ������ 2: ");
            Player player2 = new Player(scanner.nextLine());
            System.out.println("\n\n\n\n\n\n\n");
            System.out.println("                                                               ����� ������� ���� SEA BATTLE ������������ � ���������\n\n\n\n\n\n\n\n\n");
            System.out.print("                                                                        << ��� ������ ���� ������� Enter >>");
            scanner.nextLine();

            // �������� ������ � ��������� ����, ��������� ����������� ������� ������
            System.out.println("\n\n\n\n");
            System.out.println("                                                                                 ������� ����\n\n");
            System.out.println("                � ������ ���� ������ �� ������� ����������� ���� ������� �� ���������� ���� 10�10 ������. ������ ����� ������� ������:\n");
            System.out.println("                                  1 ���������������  " + FieldCell.SHIP + FieldCell.SHIP + FieldCell.SHIP + FieldCell.SHIP);
            System.out.println("                                  2 ������������  " + FieldCell.SHIP + FieldCell.SHIP + FieldCell.SHIP);
            System.out.println("                                  3 ������������  " + FieldCell.SHIP + FieldCell.SHIP);
            System.out.println("                                  4 ������������  " + FieldCell.SHIP + "\n");
            System.out.println("                ������� ����� ������������� �� ����������� � ���������. ������ ������� ������� ���������� ���� " + FieldCell.SHIP_HALO + " ������� � 1 ������, � ���� ���� ������� ��������� ������.\n");
            System.out.println("                �� ����� ������ ���� �� ������ 2 ���� ��������� 10�10 ������:");
            System.out.println("                   ��� ����:  �� ���� ���� ��������� ���� �������. �������� ������� �������� " + FieldCell.SUNKEN_SHIP);
            System.out.println("                   ��������� ����: �� ���� ���� ���������� �������� ��������� �������, � ����� ��������� ����������� ������ ����� " + FieldCell.EMPTY + " �� ����������� ������� �� ��������, �� ������� �� ������ ����.\n");
            System.out.println("                �� ������� ���������� �������� � y, �, ���� ��������� ����, ��������� ��������� �����!!! � ����� �������� �����.");
            System.out.println("                ���� ������� �� ������ ���� ��������� ��������� ����!!! � ����� ��������� �����.");
            System.out.println("                ���� ������������� ����� ���� �� ������� ������� ���� ��������� ����.\n\n");
            System.out.println("                                                                     ������ ����� ������ �������� ��������� �����:\n\n\n");
            Player playerSwitch;    // ��������� ����� 1 ������
            if (Math.round(Math.random()) == 1) {
                playerSwitch = player2;
                player2 = player1;
                player1 = playerSwitch;
            }
            System.out.println("                                                                              !!!  ������ ����� " + player1.getName() + "  !!!\n\n\n\n\n\n");
            System.out.print("                                                                        << ��� ����������� �������� ������� Enter >>");
            scanner.nextLine();
            doNotLookTurnImitation(player1, player2, scanner);

            // ����� ������� ��� ����������� �������� ������ 1
            int shipCount = 10;
            int[] fleet = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
            for (int ship : fleet) {
                setShip(player1, scanner, ship, shipCount);
                shipCount--;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                                                            ����������� ����� ������ " + player1.getName() + "\n\n\n\n");
            printMyField(player1);
            System.out.println("\n\n\n\n                                                                            ���� ������ " + player1.getName() + " ����� � ���!");
            System.out.print("\n\n\n\n\n\n\n\n                                                                           << ��� ����������� ������� Enter >>");
            scanner.nextLine();
            doNotLookTurnImitation(player2, player1, scanner);

            // ����� ������� ��� ����������� �������� ������ 2
            shipCount = 10;
            for (int ship : fleet) {
                setShip(player2, scanner, ship, shipCount);
                shipCount--;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                                                            ����������� ����� ������ " + player2.getName() + "\n\n\n\n");
            printMyField(player2);
            System.out.println("\n\n\n\n                                                                            ���� ������ " + player2.getName() + " ����� � ���!");
            System.out.print("\n\n\n\n\n\n\n\n                                                                           << ��� ����������� ������� Enter >>");
            scanner.nextLine();


            // ���������� ����
            while (true) {
                doNotLookTurnImitation(player1, player2, scanner);
                player1.shot(true, player2, scanner);
                if (player1.getWin() == 1) {
                    printWinner(player1);
                    break;
                }
                doNotLookTurnImitation(player2, player1, scanner);
                player2.shot(true, player1, scanner);
                if (player2.getWin() == 1) {
                    printWinner(player2);
                    break;
                }
            }
        }
    }


    // ����� ����������� �������� � ��������� ������� (����� ����� + ������ ���������)
    protected static void setShip(Player player, Scanner scanner, Integer ship, Integer shipCount) {
        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                                                            ����������� ����� ������ " + player.getName() + "\n\n\n\n");
            printMyField(player);
            if (ship == 4) {
                System.out.println("\n\n\n\n\n\n\n                                                                       �������� ������ ���������� " + shipCount + " ��������");
                System.out.println("\n                                                        ������� ���������� ��� ���������������� ������� (������ x,y;x,y;x,y;x,y): \n\n");
            }
            if (ship == 3) {
                System.out.println("\n\n\n\n\n\n\n                                                                       �������� ������ ���������� " + shipCount + " ��������");
                System.out.print("\n                                                          ������� ���������� ��� ������������� ������� (������ x,y;x,y;x,y): \n\n");
            }
            if (ship == 2) {
                System.out.println("\n\n\n\n\n\n\n                                                                       �������� ������ ���������� " + shipCount + " ��������");
                System.out.print("\n                                                          ������� ���������� ��� ������������� ������� (������ x,y;x,y): \n\n");
            }
            if (ship == 1) {
                System.out.println("\n\n\n\n\n\n\n                                                                       �������� ������ ���������� " + shipCount + " ��������");
                System.out.print("\n                                                          ������� ���������� ��� ������������� ������� (������ x,y): \n\n");
            }
            System.out.print("                                                                                     ");

            // �������� ����������, �������� � String ������
            String line = scanner.nextLine();
            line = line.replaceAll(",", ";");
            String[] coordinates = line.split(";");

            // ���������� int ������� ��� � � y ���������
            int[] coordinatesInt = new int[ship * 2];
            int count = 0;

            // ��������� ������, ������� ���������� ����. ���� ���� ������� �� int - NumberFormatException, ��������� ��� �� ������ ����
            try {
                for (int i = 0; i < coordinates.length; i++) {
                    coordinatesInt[i] = Integer.parseInt(coordinates[i]);
                    count++;
                }

                // ���� ���������� ���� �� ������������� ���������� ���� ���� ��������� ��������� ������ - IllegalFormatFlagsException, ��������� ��� �������� ���������� ���������
                if (count != ship * 2) {
                    throw new IllegalFormatFlagsException("������ ������� ������ ����� " + ship + " ���������");
                }

                // ���� ������� ������������ � ������ ������, ��������� ������� � ��������� �����
                if (count == 2 && player.getMyField()[coordinatesInt[0]][coordinatesInt[1]] != FieldCell.SHIP && player.getMyField()[coordinatesInt[0]][coordinatesInt[1]] != FieldCell.SHIP_HALO) {
                    player.getMyField()[coordinatesInt[0]][coordinatesInt[1]] = FieldCell.SHIP;
                    shipHalo(coordinatesInt, player.getMyField());
                    break;
                    // ���� ������� ������������ � ������ �� ������ - IllegalReceiveException, ��������� ��� �� ���������� ������
                } else if (count == 2) {
                    throw new IllegalReceiveException("������ ������� ������ ���� �������� � ���������� ������");
                }

                // ���� ������� ���������� �������������, ���������, ��� ���������� ���� �� �������
                if (coordinatesInt[0] == coordinatesInt[2]) {
                    count = 0;
                    for (int i = 1; i < coordinatesInt.length; i += 2) {
                        if (coordinatesInt[1] != coordinatesInt[i] - count) {
                            throw new NumberFormatException("���������� ������� ���� ������� ������ �����-������� ��� ������-����");
                        }
                        count++;
                    }

                    // ���� ������� ���������� �����������, ���������, ��� ���������� ���� �� �������
                } else if (coordinatesInt[1] == coordinatesInt[3]) {
                    count = 0;
                    for (int i = 0; i < coordinatesInt.length; i += 2) {
                        if (coordinatesInt[0] != coordinatesInt[i] - count) {
                            throw new NumberFormatException("���������� ������� ���� ������� ������ �����-������� ��� ������-����");
                        }
                        count++;
                    }
                } else {
                    throw new NumberFormatException("���������� ������� ���� ������� ������ �����-������� ��� ������-����");
                }

                // ���� ��������� ���������� �������, ��������� ������ �� ������ �� ���� �����������
                for (int i = 1; i < coordinatesInt.length; i += 2) {
                    if (player.getMyField()[coordinatesInt[i - 1]][coordinatesInt[i]] != FieldCell.EMPTY) {
                        throw new IllegalReceiveException("������ ������� ������ ���� �������� � ���������� ������");
                    }
                }

                // ���� ������ ��������� �����, ��������� ���� ��������, ������� ������ ������� �����, ��������� �����
                for (int i = 1; i < coordinatesInt.length; i += 2) {
                    player.getMyField()[coordinatesInt[i - 1]][coordinatesInt[i]] = FieldCell.SHIP;
                }
                shipHalo(coordinatesInt, player.getMyField());
                break;
            } catch (IllegalFormatFlagsException e) {
                System.out.println("\n                                                                       ������ ������� ������ ����� " + ship + " ���������\n");
                System.out.print("                                                                          << ��� ����������� ������� Enter >>");
                scanner.nextLine();
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("\n                                                                               ���������� ������� �������\n");
                System.out.print("                                                                          << ��� ����������� ������� Enter >>");
                scanner.nextLine();
            } catch (IllegalReceiveException e) {
                System.out.println("\n                                                                 ������ ������� ������ ���� �������� � ���������� ������\n");
                System.out.print("                                                                          << ��� ����������� ������� Enter >>");
                scanner.nextLine();
            }
        }
    }

    // ����� �������� ������ ������ ����
    protected static void playerNewTurnImitation(Player player) {
        System.out.println("\n\n\n\n\n\n\n\n\n                                                                                    ��� ������ " + player.getName() + "\n");
        printMyField(player);
        System.out.println();
        printEnemyField(player);
        System.out.println("\n");
    }

    // ����� �������� ������ ��� �������� ���� ������� ������
    protected static void doNotLookTurnImitation(Player player1, Player player2, Scanner scanner) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                     << ����� ����� " + player1.getName() + " >>\n");
        System.out.println("                                                                                      " + player2.getName() + " �� �����������!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("                                                                              << ��� ����������� ������� Enter >>");
        scanner.nextLine();
    }


    // ����� ������ ����� ���� �� �����
    protected static void printMyField(Player player) {
        System.out.println("                                                                                     ��� ����");
        System.out.println("                                                                            y0 y1 y2 y3 y4 y5 y6 y7 y8 y9");
        int xCount = 0;
        for (FieldCell[] line : player.getMyField()) {
            System.out.print("                                                                          x" + xCount + " ");
            for (FieldCell cell : line) {
                System.out.print(cell + "  ");
            }
            xCount++;
            System.out.println();
        }
    }

    // ����� ������ ��������������� ���������� ���� �� �����
    protected static void printEnemyField(Player player) {
        System.out.println("                                                                                     ��������� ����");
        System.out.println("                                                                            y0 y1 y2 y3 y4 y5 y6 y7 y8 y9");
        int xCount = 0;
        for (FieldCell[] line : player.getEnemyField()) {
            System.out.print("                                                                          x" + xCount + " ");
            for (FieldCell cell : line) {
                System.out.print(cell + "  ");
            }
            xCount++;
            System.out.println();
        }
    }

    // ����� ������ ������ ������
    protected static void printWinner(Player player) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                     << ������ ������ " + player.getName() + " >>\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    // ����� ������ ����� �������
    protected static boolean lookForSmthAround(FieldCell[][] field, int x, int y, FieldCell fieldCell) {
        List<FieldCell> lookForShip = new ArrayList<>();
        try {
            if (x == 0 && y != 0 && y != 9) {
                lookForShip.add(field[x][y - 1]);
                lookForShip.add(field[x][y + 1]);
                lookForShip.add(field[x + 1][y]);
                return lookForShip.contains(fieldCell);
            } else if (x == 9 && y != 0 && y != 9) {
                lookForShip.add(field[x][y - 1]);
                lookForShip.add(field[x][y + 1]);
                lookForShip.add(field[x - 1][y]);
                return lookForShip.contains(fieldCell);
            } else if (y == 0 && x != 0 && x != 9) {
                lookForShip.add(field[x - 1][y]);
                lookForShip.add(field[x + 1][y]);
                lookForShip.add(field[x][y + 1]);
                return lookForShip.contains(fieldCell);
            } else if (y == 9 && x != 0 && x != 9) {
                lookForShip.add(field[x - 1][y]);
                lookForShip.add(field[x + 1][y]);
                lookForShip.add(field[x][y - 1]);
                return lookForShip.contains(fieldCell);
            } else if (x == 0 && y == 0) {
                lookForShip.add(field[x + 1][y]);
                lookForShip.add(field[x][y + 1]);
                return lookForShip.contains(fieldCell);
            } else if (x == 0 && y == 9) {
                lookForShip.add(field[x][y - 1]);
                lookForShip.add(field[x + 1][y]);
                return lookForShip.contains(fieldCell);
            } else if (x == 9 && y == 9) {
                lookForShip.add(field[x][y - 1]);
                lookForShip.add(field[x - 1][y]);
                return lookForShip.contains(fieldCell);
            } else if (x == 9 && y == 0) {
                lookForShip.add(field[x - 1][y]);
                lookForShip.add(field[x][y + 1]);
                return lookForShip.contains(fieldCell);
            } else {
                lookForShip.add(field[x][y + 1]);
                lookForShip.add(field[x][y - 1]);
                lookForShip.add(field[x + 1][y]);
                lookForShip.add(field[x - 1][y]);
                return lookForShip.contains(fieldCell);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    // ����� ��������� ������ �������
    protected static void shipHalo(int[] coordinatesInt, FieldCell[][] field) {
        int x;
        int y;
        for (int i = 1; i < coordinatesInt.length; i += 2) {
            x = coordinatesInt[i - 1];
            y = coordinatesInt[i];
            if (x == 0 && y != 0 && y != 9) {
                if (field[x][y - 1] == FieldCell.EMPTY) {
                    field[x][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y - 1] == FieldCell.EMPTY) {
                    field[x + 1][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y] == FieldCell.EMPTY) {
                    field[x + 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y + 1] == FieldCell.EMPTY) {
                    field[x + 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y + 1] == FieldCell.EMPTY) {
                    field[x][y + 1] = FieldCell.SHIP_HALO;
                }
            } else if (x == 9 && y != 0 && y != 9) {
                if (field[x][y + 1] == FieldCell.EMPTY) {
                    field[x][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y - 1] == FieldCell.EMPTY) {
                    field[x][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y + 1] == FieldCell.EMPTY) {
                    field[x - 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y] == FieldCell.EMPTY) {
                    field[x - 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y - 1] == FieldCell.EMPTY) {
                    field[x - 1][y - 1] = FieldCell.SHIP_HALO;
                }
            } else if (y == 0 && x != 0 && x != 9) {
                if (field[x - 1][y] == FieldCell.EMPTY) {
                    field[x - 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y + 1] == FieldCell.EMPTY) {
                    field[x - 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y + 1] == FieldCell.EMPTY) {
                    field[x][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y + 1] == FieldCell.EMPTY) {
                    field[x + 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y] == FieldCell.EMPTY) {
                    field[x + 1][y] = FieldCell.SHIP_HALO;
                }
            } else if (y == 9 && x != 0 && x != 9) {
                if (field[x - 1][y] == FieldCell.EMPTY) {
                    field[x - 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y - 1] == FieldCell.EMPTY) {
                    field[x - 1][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y - 1] == FieldCell.EMPTY) {
                    field[x][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y - 1] == FieldCell.EMPTY) {
                    field[x + 1][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y] == FieldCell.EMPTY) {
                    field[x + 1][y] = FieldCell.SHIP_HALO;
                }
            } else if (x == 0 && y == 0) {
                if (field[x + 1][y] == FieldCell.EMPTY) {
                    field[x + 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y + 1] == FieldCell.EMPTY) {
                    field[x + 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y + 1] == FieldCell.EMPTY) {
                    field[x][y + 1] = FieldCell.SHIP_HALO;
                }
            } else if (x == 0 && y == 9) {
                if (field[x][y - 1] == FieldCell.EMPTY) {
                    field[x][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y - 1] == FieldCell.EMPTY) {
                    field[x + 1][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y] == FieldCell.EMPTY) {
                    field[x + 1][y] = FieldCell.SHIP_HALO;
                }
            } else if (x == 9 && y == 9) {
                if (field[x - 1][y] == FieldCell.EMPTY) {
                    field[x - 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y - 1] == FieldCell.EMPTY) {
                    field[x - 1][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y - 1] == FieldCell.EMPTY) {
                    field[x][y - 1] = FieldCell.SHIP_HALO;
                }
            } else if (x == 9 && y == 0) {
                if (field[x - 1][y] == FieldCell.EMPTY) {
                    field[x - 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y + 1] == FieldCell.EMPTY) {
                    field[x - 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y + 1] == FieldCell.EMPTY) {
                    field[x][y + 1] = FieldCell.SHIP_HALO;
                }
            } else {
                if (field[x - 1][y - 1] == FieldCell.EMPTY) {
                    field[x - 1][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y] == FieldCell.EMPTY) {
                    field[x - 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x - 1][y + 1] == FieldCell.EMPTY) {
                    field[x - 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y + 1] == FieldCell.EMPTY) {
                    field[x][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y + 1] == FieldCell.EMPTY) {
                    field[x + 1][y + 1] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y] == FieldCell.EMPTY) {
                    field[x + 1][y] = FieldCell.SHIP_HALO;
                }
                if (field[x + 1][y - 1] == FieldCell.EMPTY) {
                    field[x + 1][y - 1] = FieldCell.SHIP_HALO;
                }
                if (field[x][y - 1] == FieldCell.EMPTY) {
                    field[x][y - 1] = FieldCell.SHIP_HALO;
                }
            }
        }
    }
}
