package finalProject.gameResources;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.ArrayList;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    public static void playSeaBattle() {
        // Имитация начального экрана с запросом имен игроков,инициализация игроков
        System.out.println("\n                                                                                 SEA BATTLE v.0.1\n");
        System.out.println("                                                                                                                                                      Разработан MaxonZubr\n\n\n\n");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("                                                                            Введите имя игрока 1: ");
            Player player1 = new Player(scanner.nextLine());
            System.out.println("\n\n\n");
            System.out.print("                                                                            Введите имя игрока 2: ");
            Player player2 = new Player(scanner.nextLine());
            System.out.println("\n\n\n\n\n\n\n");
            System.out.println("                                                               Перед началом игры SEA BATTLE ознакомьтесь с правилами\n\n\n\n\n\n\n\n\n");
            System.out.print("                                                                        << Для старта игры нажмите Enter >>");
            scanner.nextLine();

            // Имитация экрана с правилами игры, случайное определение первого игрока
            System.out.println("\n\n\n\n");
            System.out.println("                                                                                 ПРАВИЛА ИГРЫ\n\n");
            System.out.println("                В начале игры игроки по очереди расставляют свои корабли на квадратном поле 10х10 клеток. Состав флота каждого игрока:\n");
            System.out.println("                                  1 четырехпалубный  " + FieldCell.SHIP + FieldCell.SHIP + FieldCell.SHIP + FieldCell.SHIP);
            System.out.println("                                  2 трехпалубных  " + FieldCell.SHIP + FieldCell.SHIP + FieldCell.SHIP);
            System.out.println("                                  3 двухпалубных  " + FieldCell.SHIP + FieldCell.SHIP);
            System.out.println("                                  4 однопалубных  " + FieldCell.SHIP + "\n");
            System.out.println("                Корабли могут располагаться по горизонтали и вертикали. Вокруг каждого корабля появляется зона " + FieldCell.SHIP_HALO + " шириной в 1 клетку, в этой зоне корабли размещать нельзя.\n");
            System.out.println("                Во время своего хода вы видите 2 поля размерами 10х10 клеток:");
            System.out.println("                   Мое поле:  на этом поле размещены ваши корабли. Подбитые корабли отмечены " + FieldCell.SUNKEN_SHIP);
            System.out.println("                   Вражеское поле: на этом поле отмечаются подбитые вражеские корабли, а также удаляются обозначения пустых ячеек " + FieldCell.EMPTY + " по координатам которых вы стреляли, но выстрел не достиг цели.\n");
            System.out.println("                Вы вводите координаты выстрела х y, и, если попадание есть, выводится сообщение ПОПАЛ!!! и можно стрелять снова.");
            System.out.println("                Если выстрел не достиг цели выводится сообщение МИМО!!! и ходит следующий игрок.");
            System.out.println("                Игра заканчивается когда один из игроков потопил весь вражеский флот.\n\n");
            System.out.println("                                                                     Первым будет ходить случайно выбранный игрок:\n\n\n");
            Player playerSwitch;    // Случайный выбор 1 игрока
            if (Math.round(Math.random()) == 1) {
                playerSwitch = player2;
                player2 = player1;
                player1 = playerSwitch;
            }
            System.out.println("                                                                              !!!  Первым ходит " + player1.getName() + "  !!!\n\n\n\n\n\n");
            System.out.print("                                                                        << Для расстановки кораблей нажмите Enter >>");
            scanner.nextLine();
            doNotLookTurnImitation(player1, player2, scanner);

            // Смена экранов при расстановке кораблей Игрока 1
            int shipCount = 10;
            int[] fleet = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
            for (int ship : fleet) {
                setShip(player1, scanner, ship, shipCount);
                shipCount--;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                                                            Расстановка флота игрока " + player1.getName() + "\n\n\n\n");
            printMyField(player1);
            System.out.println("\n\n\n\n                                                                            Флот игрока " + player1.getName() + " готов к бою!");
            System.out.print("\n\n\n\n\n\n\n\n                                                                           << Для продолжения нажмите Enter >>");
            scanner.nextLine();
            doNotLookTurnImitation(player2, player1, scanner);

            // Смена экранов при расстановке кораблей Игрока 2
            shipCount = 10;
            for (int ship : fleet) {
                setShip(player2, scanner, ship, shipCount);
                shipCount--;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                                                            Расстановка флота игрока " + player2.getName() + "\n\n\n\n");
            printMyField(player2);
            System.out.println("\n\n\n\n                                                                            Флот игрока " + player2.getName() + " готов к бою!");
            System.out.print("\n\n\n\n\n\n\n\n                                                                           << Для продолжения нажмите Enter >>");
            scanner.nextLine();


            // Происходит игра
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


    // Метод расстановки кораблей с имитацией экранов (вывод полей + запрос координат)
    protected static void setShip(Player player, Scanner scanner, Integer ship, Integer shipCount) {
        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                                                            Расстановка флота игрока " + player.getName() + "\n\n\n\n");
            printMyField(player);
            if (ship == 4) {
                System.out.println("\n\n\n\n\n\n\n                                                                       Осталось ввести координаты " + shipCount + " кораблей");
                System.out.println("\n                                                        Введите координаты для ЧЕТЫРЕХПАЛУБНОГО корабля (формат x,y;x,y;x,y;x,y): \n\n");
            }
            if (ship == 3) {
                System.out.println("\n\n\n\n\n\n\n                                                                       Осталось ввести координаты " + shipCount + " кораблей");
                System.out.print("\n                                                          Введите координаты для ТРЕХПАЛУБНОГО корабля (формат x,y;x,y;x,y): \n\n");
            }
            if (ship == 2) {
                System.out.println("\n\n\n\n\n\n\n                                                                       Осталось ввести координаты " + shipCount + " кораблей");
                System.out.print("\n                                                          Введите координаты для ДВУХПАЛУБНОГО корабля (формат x,y;x,y): \n\n");
            }
            if (ship == 1) {
                System.out.println("\n\n\n\n\n\n\n                                                                       Осталось ввести координаты " + shipCount + " кораблей");
                System.out.print("\n                                                          Введите координаты для ОДНОПАЛУБНОГО корабля (формат x,y): \n\n");
            }
            System.out.print("                                                                                     ");

            // получили координаты, положили в String массив
            String line = scanner.nextLine();
            line = line.replaceAll(",", ";");
            String[] coordinates = line.split(";");

            // декларация int массива для х и y координат
            int[] coordinatesInt = new int[ship * 2];
            int count = 0;

            // заполняем массив, считаем количество цифр. Если было введено не int - NumberFormatException, обработка как не верный ввод
            try {
                for (int i = 0; i < coordinates.length; i++) {
                    coordinatesInt[i] = Integer.parseInt(coordinates[i]);
                    count++;
                }

                // если количество цифр не соответствует количеству цифр всех координат вводимого корбля - IllegalFormatFlagsException, обработка как неверное количество координат
                if (count != ship * 2) {
                    throw new IllegalFormatFlagsException("Данный корабль должен иметь " + ship + " координат");
                }

                // если корабль однопалубный и ячейка пустая, принимаем корабль и завершаем метод
                if (count == 2 && player.getMyField()[coordinatesInt[0]][coordinatesInt[1]] != FieldCell.SHIP && player.getMyField()[coordinatesInt[0]][coordinatesInt[1]] != FieldCell.SHIP_HALO) {
                    player.getMyField()[coordinatesInt[0]][coordinatesInt[1]] = FieldCell.SHIP;
                    shipHalo(coordinatesInt, player.getMyField());
                    break;
                    // если корабль однопалубный и ячейка не пустая - IllegalReceiveException, обработка как не подходящая ячейка
                } else if (count == 2) {
                    throw new IllegalReceiveException("Данный корабль должен быть размещен в подходящей ячейке");
                }

                // если корабль расположен горизонтально, проверяем, что координаты идут по порядку
                if (coordinatesInt[0] == coordinatesInt[2]) {
                    count = 0;
                    for (int i = 1; i < coordinatesInt.length; i += 2) {
                        if (coordinatesInt[1] != coordinatesInt[i] - count) {
                            throw new NumberFormatException("Координаты корабля надо вводить подряд слева-направо или сверху-вниз");
                        }
                        count++;
                    }

                    // если корабль расположен вертикально, проверяем, что координаты идут по порядку
                } else if (coordinatesInt[1] == coordinatesInt[3]) {
                    count = 0;
                    for (int i = 0; i < coordinatesInt.length; i += 2) {
                        if (coordinatesInt[0] != coordinatesInt[i] - count) {
                            throw new NumberFormatException("Координаты корабля надо вводить подряд слева-направо или сверху-вниз");
                        }
                        count++;
                    }
                } else {
                    throw new NumberFormatException("Координаты корабля надо вводить подряд слева-направо или сверху-вниз");
                }

                // если введенные координаты валидны, проверяем пустые ли ячейки по этим координатам
                for (int i = 1; i < coordinatesInt.length; i += 2) {
                    if (player.getMyField()[coordinatesInt[i - 1]][coordinatesInt[i]] != FieldCell.EMPTY) {
                        throw new IllegalReceiveException("Данный корабль должен быть размещен в подходящей ячейке");
                    }
                }

                // если ячейки оказались пусты, заполняем поле кораблем, создаем вокруг корабля ореол, завершаем метод
                for (int i = 1; i < coordinatesInt.length; i += 2) {
                    player.getMyField()[coordinatesInt[i - 1]][coordinatesInt[i]] = FieldCell.SHIP;
                }
                shipHalo(coordinatesInt, player.getMyField());
                break;
            } catch (IllegalFormatFlagsException e) {
                System.out.println("\n                                                                       Данный корабль должен иметь " + ship + " координат\n");
                System.out.print("                                                                          << Для продолжения нажмите Enter >>");
                scanner.nextLine();
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("\n                                                                               Координаты введены неверно\n");
                System.out.print("                                                                          << Для продолжения нажмите Enter >>");
                scanner.nextLine();
            } catch (IllegalReceiveException e) {
                System.out.println("\n                                                                 Данный корабль должен быть размещен в подходящей ячейке\n");
                System.out.print("                                                                          << Для продолжения нажмите Enter >>");
                scanner.nextLine();
            }
        }
    }

    // Метод имитации экрана нового хода
    protected static void playerNewTurnImitation(Player player) {
        System.out.println("\n\n\n\n\n\n\n\n\n                                                                                    Ход игрока " + player.getName() + "\n");
        printMyField(player);
        System.out.println();
        printEnemyField(player);
        System.out.println("\n");
    }

    // Метод имитации экрана при переходе хода другому игроку
    protected static void doNotLookTurnImitation(Player player1, Player player2, Scanner scanner) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                     << Ходит игрок " + player1.getName() + " >>\n");
        System.out.println("                                                                                      " + player2.getName() + " не подглядывай!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("                                                                              << Для продолжения нажмите Enter >>");
        scanner.nextLine();
    }


    // Метод вывода моего поля на экран
    protected static void printMyField(Player player) {
        System.out.println("                                                                                     Мое поле");
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

    // Метод вывода предполагаемого вражеского поля на экран
    protected static void printEnemyField(Player player) {
        System.out.println("                                                                                     Вражеское поле");
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

    // Метод вывода экрана победа
    protected static void printWinner(Player player) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                     << ПОБЕДА игрока " + player.getName() + " >>\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    // Метод поиска части корабля
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

    // Метод установки ореола корабля
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
