package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        help();
        char[][][][] mapStore = new char[7][9][2][10000];
        String[][] mapShow = new String[7][9];
        boolean startGame = true;
        Scanner in = new Scanner(System.in);
        while (startGame) {
            read(mapStore);
            print(mapStore, mapShow, 0);
            gameStart:
            {
                int undoNumber = 0;
                for (int k = 1; k >= 0; k++) {
                    if (k % 2 != 0) {
                        System.out.println("左方玩家操作");
                    } else {
                        System.out.println("右方玩家操作");
                    }
                    String order = in.nextLine();
                    int orderLength = order.length();
                    //judge whether the order is function order
                    if (Objects.equals(order, "help")) {
                        help();
                        k = k - 1;
                    } else if (Objects.equals(order, "restart")) {
                        break gameStart;
                    }
                    //undo
                    else if (Objects.equals(order, "undo")) {
                        if (k == 1) {
                            System.out.println("初始状态，无法悔棋，请重新输入。");
                            k = k - 1;
                        } else {
                            undoNumber = undoNumber + 1;
                            k = k - 2;
                            print(mapStore, mapShow, k);
                        }
                    }
                    //redo
                    else if (Objects.equals(order, "redo")) {
                        if (undoNumber == 0) {
                            System.out.println("最后状态，无法取消悔棋，请重新输入。");
                            k = k - 1;
                        } else {
                            undoNumber = undoNumber - 1;
                            print(mapStore, mapShow, k);
                        }
                    } else if (Objects.equals(order, "exit")) {
                        startGame = false;
                        System.out.println("退出游戏，游戏结束。");
                        break;
                    } else if (orderLength != 2) {
                        System.out.println("非法指令，请重新输入。输入help查看指令帮助。");
                        k = k - 1;
                    } else {
                        char animal = order.charAt(0);
                        char direction = order.charAt(1);
                        if ((animal != '1' & animal != '2' & animal != '3' & animal != '4' & animal != '5' & animal != '6' & animal != '7' & animal != '8')|(direction != 'a' & direction != 'd' & direction != 's' & direction != 'w')) {
                            System.out.println("非法指令，请重新输入。输入help查看指令帮助。");
                            k = k - 1;
                        } else {
                            //read the last map
                            record(mapStore, k);

                            char mouseMe, mouseEn, catMe, catEn, wolfMe, wolfEn, dogMe, dogEn, leopardMe, leopardEn, tigerMe, tigerEn, lionMe, lionEn, elephantMe, elephantEn, homeMe, homeEn, trapMe, trapEn;
                            if (k % 2 != 0) {
                                mouseMe = 'a';
                                mouseEn = '1';
                                catMe = 'b';
                                catEn = '2';
                                wolfMe = 'c';
                                wolfEn = '3';
                                dogMe = 'd';
                                dogEn = '4';
                                leopardMe = 'e';
                                leopardEn = '5';
                                tigerMe = 'f';
                                tigerEn = '6';
                                lionMe = 'g';
                                lionEn = '7';
                                elephantMe = 'h';
                                elephantEn = '8';
                                homeMe = '3';
                                homeEn = '5';
                                trapMe = '2';
                                trapEn = '4';
                            } else {
                                mouseEn = 'a';
                                mouseMe = '1';
                                catEn = 'b';
                                catMe = '2';
                                wolfEn = 'c';
                                wolfMe = '3';
                                dogEn = 'd';
                                dogMe = '4';
                                leopardEn = 'e';
                                leopardMe = '5';
                                tigerEn = 'f';
                                tigerMe = '6';
                                lionEn = 'g';
                                lionMe = '7';
                                elephantEn = 'h';
                                elephantMe = '8';
                                homeMe = '5';
                                homeEn = '3';
                                trapMe = '4';
                                trapEn = '2';
                            }
                            move:
                            {
                                judge:
                                {
                                    char animalFound;
                                    int[] nextLocation = new int[2];
                                    switch (animal) {
                                        case '1':
                                            animalFound = mouseMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        case '2':
                                            animalFound = catMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        case '3':
                                            animalFound = wolfMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        case '4':
                                            animalFound = dogMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        case '5':
                                            animalFound = leopardMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        case '6':
                                            animalFound = tigerMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        case '7':
                                            animalFound = lionMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        case '8':
                                            animalFound = elephantMe;
                                            if (!move(nextLocation, mapStore, k, direction, animalFound, homeMe, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe, trapMe, elephantEn, mouseEn)) {
                                                k = k - 1;
                                                break move;
                                            } else {
                                                break judge;
                                            }
                                        default:
                                    }
                                }
                                //print the current map
                                print(mapStore, mapShow, k);
                                //clear the undoNumber
                                undoNumber = 0;
                                //end judge
                                if (endJudgeIfHomeOccupied(mapStore, k)) {
                                    startGame = false;
                                    break gameStart;
                                }
                                if (!endJudgeIfAlive(mapStore, k)) {
                                    startGame = false;
                                    break gameStart;
                                }
                                if (!endJudgeIfCanMove(mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn, mouseMe, homeEn, trapEn)) {
                                    startGame = false;
                                    break gameStart;
                                }

                            }//label:move
                        }
                    }
                }
            }
        }

    }

    //help
    private static void help() {
        System.out.println("斗兽棋指令介绍：\n1、移动指令：\n数字1-8来表示动物，wsad代表上下左右。\n鼠(1)猫(2)狼(3)狗(4)豹(5)虎(6)狮(7)象(8)");
        System.out.println("例：输入1d表示老鼠向右移动一格。\n2、功能指令：\n(1)restart重新开始\n(2)help查看帮助\n(3)undo悔棋\n(4)redo取消悔棋\n(5)exit退出游戏\n");
    }

    //read the map
    private static void read(char[][][][] mapStore) {
        Scanner scannerMap = null;
        try {
            scannerMap = new Scanner(new File("map.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 7; i++) {
            if (scannerMap == null) throw new AssertionError();
            String map = scannerMap.nextLine();
            for (int j = 0; j < 9; j++) {
                mapStore[i][j][0][0] = map.charAt(j);
            }
        }
        //读取动物地图
        Scanner scannerAnimal = null;
        try {
            scannerAnimal = new Scanner(new File("animal.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 7; i++) {
            if (scannerAnimal == null) throw new AssertionError();
            String animal = scannerAnimal.nextLine();
            for (int j = 0; j < 9; j++) {
                mapStore[i][j][1][0] = animal.charAt(j);
            }
        }
    }

    //read the last map
    private static void record(char[][][][] mapStore, int k) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                mapStore[i][j][0][k] = mapStore[i][j][0][k - 1];
                mapStore[i][j][1][k] = mapStore[i][j][1][k - 1];
            }
        }
    }

    //get the next location according to the order
    private static void direction(int[] nextLocation, char direction, int i, int j) {
        switch (direction) {
            case 'a':
                nextLocation[0] = i;
                nextLocation[1] = j - 1;
                break;
            case 'd':
                nextLocation[0] = i;
                nextLocation[1] = j + 1;
                break;
            case 'w':
                nextLocation[0] = i - 1;
                nextLocation[1] = j;
                break;
            case 's':
                nextLocation[0] = i + 1;
                nextLocation[1] = j;
                break;
            default:
        }
    }

    //get the next location according to the order(when water)
    private static void directionWater(int[] nextLocation1, int[] nextLocation2, int[] nextLocationWater, char direction, int i, int j) {
        switch (direction) {
            case 'a':
                nextLocationWater[0] = i;
                nextLocationWater[1] = j - 4;
                nextLocation1[0] = i;
                nextLocation1[1] = j - 2;
                nextLocation2[0] = i;
                nextLocation2[1] = j - 3;
                break;
            case 'd':
                nextLocationWater[0] = i;
                nextLocationWater[1] = j + 4;
                nextLocation1[0] = i;
                nextLocation1[1] = j + 2;
                nextLocation2[0] = i;
                nextLocation2[1] = j + 3;
                break;
            case 'w':
                nextLocationWater[0] = i - 3;
                nextLocationWater[1] = j;
                nextLocation1[0] = i - 2;
                nextLocation1[1] = j;
                nextLocation2[0] = i - 2;
                nextLocation2[1] = j;
                break;
            case 's':
                nextLocationWater[0] = i + 3;
                nextLocationWater[1] = j;
                nextLocation1[0] = i + 2;
                nextLocation1[1] = j;
                nextLocation2[0] = i + 2;
                nextLocation2[1] = j;
                break;
            default:
        }
    }

    //move
    private static boolean move(int[] nextLocation, char[][][][] mapStore, int k, char direction, char animalFound, char homeMe, char mouseMe, char catMe, char wolfMe, char dogMe, char leopardMe, char tigerMe, char lionMe, char elephantMe, char trapMe, char elephantEn, char mouseEn) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                direction(nextLocation, direction, i, j);
                if (mapStore[i][j][1][k] == animalFound) {
                    if (nextLocation[0] < 0 | nextLocation[0] > 6 | nextLocation[1] < 0 | nextLocation[1] > 8) {
                        System.out.println("动物不可移动出边界，请重新输入。");
                        return false;
                    } else if (judgeIfHome(nextLocation, mapStore, k, homeMe)) {
                        System.out.println("动物不可移动至自己家，请重新输入。");
                        return false;
                    } else if (mapStore[nextLocation[0]][nextLocation[1]][0][k] == '1') {
                        if (animalFound != mouseMe & animalFound != tigerMe & animalFound != lionMe) {
                            System.out.println("该动物不可下水，请重新输入。");
                            return false;
                        }
                        if (animalFound == mouseMe) {
                            go(nextLocation, mapStore, i, j, k);
                            return true;
                        }
                        if (animalFound == tigerMe | animalFound == lionMe) {
                            int[] nextLocation1 = new int[2];
                            int[] nextLocation2 = new int[2];
                            int[] nextLocationWater = new int[2];
                            directionWater(nextLocation1, nextLocation2, nextLocationWater, direction, i, j);
                            direction(nextLocation, direction, i, j);
                            if (!judgeIfCanJump(direction, nextLocation, mapStore, k, mouseEn)) {
                                System.out.println("路线河中有敌方老鼠，不可跳河，请重新输入。");
                                return false;
                            } else if (mapStore[nextLocation[0]][nextLocation[1]][1][k] != '0') {
                                if (!judgeIfAnimalEn(nextLocationWater, mapStore, k, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe)) {
                                    System.out.println("动物不可移动至己方动物位置上，请重新输入。");
                                    return false;
                                } else if (!judgeIfAnimalCanEat(nextLocationWater, mapStore, i, j, k, animalFound, trapMe)) {
                                    System.out.println("动物不可自杀，请重新输入。");
                                    return false;
                                } else {
                                    go(nextLocationWater, mapStore, i, j, k);
                                    return true;
                                }
                            } else {
                                go(nextLocationWater, mapStore, i, j, k);
                                return true;
                            }
                        }
                    } else if (mapStore[nextLocation[0]][nextLocation[1]][1][k] != '0') {
                        if (!judgeIfAnimalEn(nextLocation, mapStore, k, mouseMe, catMe, wolfMe, dogMe, leopardMe, tigerMe, lionMe, elephantMe)) {
                            System.out.println("动物不可移动至己方动物位置上，请重新输入。");
                            return false;
                        } else {
                            if (mapStore[i][j][0][k] == '1' & mapStore[nextLocation[0]][nextLocation[1]][1][k] == elephantEn) {
                                System.out.println("老鼠在水里不能攻击岸上的象，请重新输入。");
                                return false;
                            } else if (!judgeIfAnimalCanEat(nextLocation, mapStore, i, j, k, animalFound, trapMe)) {
                                System.out.println("动物不可自杀，请重新输入。");
                                return false;
                            } else {
                                go(nextLocation, mapStore, i, j, k);
                                return true;
                            }
                        }
                    } else {
                        go(nextLocation, mapStore, i, j, k);
                        return true;
                    }
                }
            }
        }
        System.out.println("动物已死，请重新输入。");
        return false;
    }

    //go
    private static void go(int[] nextLocation, char[][][][] mapStore, int i, int j, int k) {
        mapStore[nextLocation[0]][nextLocation[1]][1][k] = mapStore[i][j][1][k];
        mapStore[i][j][1][k] = '0';
    }

    //print
    private static void print(char[][][][] mapStore, String[][] mapShow, int k) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (mapStore[i][j][1][k] != '0') {
                    switch (mapStore[i][j][1][k]) {
                        case '0':
                            mapShow[i][j] = (" 　 ");
                            break;
                        case 'a':
                            mapShow[i][j] = ("1鼠 ");
                            break;
                        case 'b':
                            mapShow[i][j] = ("2猫 ");
                            break;
                        case 'c':
                            mapShow[i][j] = ("3狼 ");
                            break;
                        case 'd':
                            mapShow[i][j] = ("4狗 ");
                            break;
                        case 'e':
                            mapShow[i][j] = ("5豹 ");
                            break;
                        case 'f':
                            mapShow[i][j] = ("6虎 ");
                            break;
                        case 'g':
                            mapShow[i][j] = ("7狮 ");
                            break;
                        case 'h':
                            mapShow[i][j] = ("8象 ");
                            break;
                        case '1':
                            mapShow[i][j] = (" 鼠1");
                            break;
                        case '2':
                            mapShow[i][j] = (" 猫2");
                            break;
                        case '3':
                            mapShow[i][j] = (" 狼3");
                            break;
                        case '4':
                            mapShow[i][j] = (" 狗4");
                            break;
                        case '5':
                            mapShow[i][j] = (" 豹5");
                            break;
                        case '6':
                            mapShow[i][j] = (" 虎6");
                            break;
                        case '7':
                            mapShow[i][j] = (" 狮7");
                            break;
                        case '8':
                            mapShow[i][j] = (" 象8");
                            break;
                    }
                } else {
                    switch (mapStore[i][j][0][k]) {
                        case '0':
                            mapShow[i][j] = (" 　 ");
                            break;
                        case '1':
                            mapShow[i][j] = (" 水 ");
                            break;
                        case '2':
                            mapShow[i][j] = (" 陷 ");
                            break;
                        case '3':
                            mapShow[i][j] = (" 家 ");
                            break;
                        case '4':
                            mapShow[i][j] = (" 陷 ");
                            break;
                        case '5':
                            mapShow[i][j] = (" 家 ");
                            break;
                        default:
                    }
                }
                System.out.print(mapShow[i][j]);
                if (j == 8) System.out.println();
            }
        }
    }

    //judge whether the next location is water
    private static boolean judgeIfRiver(int[] direction, char[][][][] mapStore, int k) {
        return mapStore[direction[0]][direction[1]][0][k] == '1';
    }

    //judge whether the next location is home
    private static boolean judgeIfHome(int[] direction, char[][][][] mapStore, int k, char homeMe) {
        return mapStore[direction[0]][direction[1]][0][k] == homeMe;
    }

    //judge whether the next location is vacant(no animal on it)
    private static boolean judgeIfVacant(int[] direction, char[][][][] mapStore, int k) {
        return mapStore[direction[0]][direction[1]][1][k] == '0';
    }

    //judge whether the aniaml on next location is enemy
    private static boolean judgeIfAnimalEn(int[] direction, char[][][][] mapStore, int k, char mouseMe, char catMe, char wolfMe, char dogMe, char leopardMe, char tigerMe, char lionMe, char elephantMe) {
        return !(mapStore[direction[0]][direction[1]][1][k] == mouseMe | mapStore[direction[0]][direction[1]][1][k] == catMe | mapStore[direction[0]][direction[1]][1][k] == wolfMe | mapStore[direction[0]][direction[1]][1][k] == dogMe | mapStore[direction[0]][direction[1]][1][k] == leopardMe | mapStore[direction[0]][direction[1]][1][k] == tigerMe | mapStore[direction[0]][direction[1]][1][k] == lionMe | mapStore[direction[0]][direction[1]][1][k] == elephantMe);
    }

    //judge whether the aniaml on next location can be eaten
    private static boolean judgeIfAnimalCanEat(int[] direction, char[][][][] mapStore, int i, int j, int k, char animal, char trapMe) {
        if (mapStore[direction[0]][direction[1]][0][k] == trapMe) {
            return true;
        }
        int animalTran;
        int nextTran;
        if (animal == 'a' | animal == 'b' | animal == 'c' | animal == 'd' | animal == 'e' | animal == 'f' | animal == 'g' | animal == 'h') {
            animalTran = animal - '0' - 48;
            nextTran = mapStore[direction[0]][direction[1]][1][k] - '0';
        } else {
            animalTran = animal - '0';
            nextTran = mapStore[direction[0]][direction[1]][1][k] - '0' - 48;
        }
        if (animalTran == 1) {
            return nextTran == 1 | (mapStore[i][j][0][k] != '1' & nextTran == 8);
        } else if (animalTran == 8) {
            return nextTran != 1;
        } else {
            return animalTran >= nextTran;
        }
    }

    //judge whether the tiger or lion can jump over the river(only judge if there is a mouse)
    private static boolean judgeIfCanJump(char way, int[] direction, char[][][][] mapStore, int k, char mouseEn) {
        if (way == 'w') {
            if (mapStore[direction[0]][direction[1]][0][k] == '1') {
                if (mapStore[direction[0]][direction[1]][1][k] != mouseEn & mapStore[direction[0] - 1][direction[1]][1][k] != mouseEn) {
                    direction[0] = direction[0] - 2;
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        if (way == 's') {
            if (mapStore[direction[0]][direction[1]][0][k] == '1') {
                if (mapStore[direction[0]][direction[1]][1][k] != mouseEn & mapStore[direction[0] + 1][direction[1]][1][k] != mouseEn) {
                    direction[0] = direction[0] + 2;
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        if (way == 'a') {
            if (mapStore[direction[0]][direction[1]][0][k] == '1') {
                if (mapStore[direction[0]][direction[1]][1][k] != mouseEn & mapStore[direction[0]][direction[1] - 1][1][k] != mouseEn & mapStore[direction[0]][direction[1] - 2][1][k] != mouseEn) {
                    direction[1] = direction[1] - 3;
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        if (way == 'd') {
            if (mapStore[direction[0]][direction[1]][0][k] == '1') {
                if (mapStore[direction[0]][direction[1]][1][k] != mouseEn & mapStore[direction[0]][direction[1] + 1][1][k] != mouseEn & mapStore[direction[0]][direction[1] + 2][1][k] != mouseEn) {
                    direction[1] = direction[1] + 3;
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }

    //end judge:if home is occupied
    private static boolean endJudgeIfHomeOccupied(char[][][][] mapStore, int k) {
        if (mapStore[3][0][1][k] == '1' | mapStore[3][0][1][k] == '2' | mapStore[3][0][1][k] == '3' | mapStore[3][0][1][k] == '4'
                | mapStore[3][0][1][k] == '5' | mapStore[3][0][1][k] == '6' | mapStore[3][0][1][k] == '7' | mapStore[3][0][1][k] == '8') {
            System.out.println("左方家被占领，右方玩家胜利，游戏结束。");
            return true;
        }
        if (mapStore[3][8][1][k] == 'a' | mapStore[3][8][1][k] == 'b' | mapStore[3][8][1][k] == 'c' | mapStore[3][8][1][k] == 'd'
                | mapStore[3][8][1][k] == 'e' | mapStore[4][1][1][k] == 'f' | mapStore[3][8][1][k] == 'g' | mapStore[3][8][1][k] == 'h') {
            System.out.println("右方家被占领，左方玩家胜利，游戏结束。");
            return true;
        }
        return false;
    }

    //end judge:if there is animal alive
    private static boolean endJudgeIfAlive(char[][][][] mapStore, int k) {
        if (k % 2 == 0) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 9; j++) {
                    if (mapStore[i][j][1][k] == 'a' | mapStore[i][j][1][k] == 'b' | mapStore[i][j][1][k] == 'c' | mapStore[i][j][1][k] == 'd'
                            | mapStore[i][j][1][k] == 'e' | mapStore[i][j][1][k] == 'f' | mapStore[i][j][1][k] == 'g' | mapStore[i][j][1][k] == 'h') {
                        return true;
                    }
                }
            }
            System.out.println("左方死光，右方玩家胜利，游戏结束。");
            return false;
        } else {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 9; j++) {
                    if (mapStore[i][j][1][k] == '1' | mapStore[i][j][1][k] == '2' | mapStore[i][j][1][k] == '3' | mapStore[i][j][1][k] == '4'
                            | mapStore[i][j][1][k] == '5' | mapStore[i][j][1][k] == '6' | mapStore[i][j][1][k] == '7' | mapStore[i][j][1][k] == '8') {
                        return true;
                    }
                }
            }
            System.out.println("右方死光，左方玩家胜利，游戏结束。");
            return false;
        }
    }

    //end judge:if there is animal that can move
    private static boolean endJudgeIfCanMove(char[][][][] mapStore, int k, char mouseEn, char catEn, char wolfEn, char dogEn, char leopardEn, char tigerEn, char lionEn, char elephantEn, char mouseMe, char homeEn, char trapEn) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                boolean moveUp = true, moveDown = true, moveLeft = true, moveRight = true;
                int[] directionUp = {i - 1, j};
                int[] directionDown = {i + 1, j};
                int[] directionLeft = {i, j - 1};
                int[] directionRight = {i, j + 1};
                if (i == 0) moveUp = false;
                if (j == 0) moveLeft = false;
                if (i == 6) moveDown = false;
                if (j == 8) moveRight = false;
                if (mapStore[i][j][1][k] == mouseEn) {
                    if (moveUp) {
                        if (!judgeIfVacant(directionUp, mapStore, k)) {
                            moveUp = judgeIfAnimalEn(directionUp, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionUp, mapStore, i, j, k, mouseEn, trapEn);
                        } else {
                            moveUp = judgeIfRiver(directionUp, mapStore, k) || !judgeIfHome(directionUp, mapStore, k, homeEn);
                        }
                    }
                    if (moveDown) {
                        if (!judgeIfVacant(directionDown, mapStore, k)) {
                            moveDown = judgeIfAnimalEn(directionDown, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionDown, mapStore, i, j, k, mouseEn, trapEn);
                        } else {
                            moveDown = judgeIfRiver(directionDown, mapStore, k) || !judgeIfHome(directionDown, mapStore, k, homeEn);
                        }
                    }
                    if (moveLeft) {
                        if (!judgeIfVacant(directionLeft, mapStore, k)) {
                            moveLeft = judgeIfAnimalEn(directionLeft, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionLeft, mapStore, i, j, k, mouseEn, trapEn);
                        } else {
                            moveLeft = judgeIfRiver(directionLeft, mapStore, k) || !judgeIfHome(directionLeft, mapStore, k, homeEn);
                        }
                    }
                    if (moveRight) {
                        if (!judgeIfVacant(directionRight, mapStore, k)) {
                            moveRight = judgeIfAnimalEn(directionRight, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionRight, mapStore, i, j, k, mouseEn, trapEn);
                        } else {
                            moveRight = judgeIfRiver(directionRight, mapStore, k) || !judgeIfHome(directionRight, mapStore, k, homeEn);
                        }
                    }
                    if (moveUp | moveDown | moveLeft | moveRight) {
                        return true;
                    }
                }
                if (mapStore[i][j][1][k] == catEn) {
                    if (judgeIfCanMove(mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn, mouseMe, homeEn, trapEn, i, j)) {
                        return true;
                    }
                }
                if (mapStore[i][j][1][k] == wolfEn) {
                    if (judgeIfCanMove(mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn, mouseMe, homeEn, trapEn, i, j)) {
                        return true;
                    }
                }
                if (mapStore[i][j][1][k] == dogEn) {
                    if (judgeIfCanMove(mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn, mouseMe, homeEn, trapEn, i, j)) {
                        return true;
                    }
                }
                if (mapStore[i][j][1][k] == leopardEn) {
                    if (judgeIfCanMove(mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn, mouseMe, homeEn, trapEn, i, j)) {
                        return true;
                    }
                }
                if (mapStore[i][j][1][k] == tigerEn) {
                    if (moveUp) {
                        judgeIfCanJump('w', directionUp, mapStore, k, mouseMe);
                        if (judgeIfCanJump('w', directionUp, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionUp, mapStore, k)) {
                                moveUp = judgeIfAnimalEn(directionUp, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionUp, mapStore, i, j, k, tigerEn, trapEn);
                            } else {
                                moveUp = !judgeIfHome(directionUp, mapStore, k, homeEn);
                            }
                        } else {
                            moveUp = false;
                        }
                    }
                    if (moveDown) {
                        judgeIfCanJump('s', directionDown, mapStore, k, mouseMe);
                        if (judgeIfCanJump('s', directionDown, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionDown, mapStore, k)) {
                                moveDown = judgeIfAnimalEn(directionDown, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionDown, mapStore, i, j, k, tigerEn, trapEn);
                            } else {
                                moveDown = !judgeIfHome(directionDown, mapStore, k, homeEn);
                            }
                        }
                    }
                    if (moveLeft) {
                        judgeIfCanJump('a', directionLeft, mapStore, k, mouseMe);
                        if (judgeIfCanJump('a', directionLeft, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionLeft, mapStore, k)) {
                                moveLeft = judgeIfAnimalEn(directionLeft, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionLeft, mapStore, i, j, k, tigerEn, trapEn);
                            } else {
                                moveLeft = !judgeIfHome(directionLeft, mapStore, k, homeEn);
                            }
                        }
                    }
                    if (moveRight) {
                        judgeIfCanJump('d', directionRight, mapStore, k, mouseMe);
                        if (judgeIfCanJump('d', directionRight, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionRight, mapStore, k)) {
                                moveRight = judgeIfAnimalEn(directionRight, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionRight, mapStore, i, j, k, tigerEn, trapEn);
                            } else {
                                moveRight = !judgeIfHome(directionRight, mapStore, k, homeEn);
                            }
                        }
                    }
                    if (moveUp | moveDown | moveLeft | moveRight) {
                        return true;
                    }
                }
                if (mapStore[i][j][1][k] == lionEn) {
                    if (moveUp) {
                        judgeIfCanJump('w', directionUp, mapStore, k, mouseMe);
                        if (judgeIfCanJump('w', directionUp, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionUp, mapStore, k)) {
                                moveUp = judgeIfAnimalEn(directionUp, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionUp, mapStore, i, j, k, lionEn, trapEn);
                            } else {
                                moveUp = !judgeIfHome(directionUp, mapStore, k, homeEn);
                            }
                        } else {
                            moveUp = false;
                        }
                    }
                    if (moveDown) {
                        judgeIfCanJump('s', directionDown, mapStore, k, mouseMe);
                        if (judgeIfCanJump('s', directionDown, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionDown, mapStore, k)) {
                                moveDown = judgeIfAnimalEn(directionDown, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionDown, mapStore, i, j, k, lionEn, trapEn);
                            } else {
                                moveDown = !judgeIfHome(directionDown, mapStore, k, homeEn);
                            }
                        }
                    }
                    if (moveLeft) {
                        judgeIfCanJump('a', directionLeft, mapStore, k, mouseMe);
                        if (judgeIfCanJump('a', directionLeft, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionLeft, mapStore, k)) {
                                moveLeft = judgeIfAnimalEn(directionLeft, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionLeft, mapStore, i, j, k, lionEn, trapEn);
                            } else {
                                moveLeft = !judgeIfHome(directionLeft, mapStore, k, homeEn);
                            }
                        }
                    }
                    if (moveRight) {
                        judgeIfCanJump('d', directionRight, mapStore, k, mouseMe);
                        if (judgeIfCanJump('d', directionRight, mapStore, k, mouseMe)) {
                            if (!judgeIfVacant(directionRight, mapStore, k)) {
                                moveRight = judgeIfAnimalEn(directionRight, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionRight, mapStore, i, j, k, lionEn, trapEn);
                            } else {
                                moveRight = !judgeIfHome(directionRight, mapStore, k, homeEn);
                            }
                        }
                    }
                    if (moveUp | moveDown | moveLeft | moveRight) {
                        return true;
                    }
                }
                if (mapStore[i][j][1][k] == elephantEn) {
                    if (judgeIfCanMove(mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn, mouseMe, homeEn, trapEn, i, j)) {
                        return true;
                    }
                }
            }
        }
        if (k % 2 == 0) {
            System.out.println("左方无子可动，右方玩家胜利，游戏结束。");
            return false;
        } else {
            System.out.println("右方无子可动，左方玩家胜利，游戏结束。");
            return false;
        }
    }

    //judge if one animal can move
    private static boolean judgeIfCanMove(char[][][][] mapStore, int k, char mouseEn, char catEn, char wolfEn, char dogEn, char leopardEn, char tigerEn, char lionEn, char elephantEn, char mouseMe, char homeEn, char trapEn, int i, int j) {
        boolean moveUp = true, moveDown = true, moveLeft = true, moveRight = true;
        int[] directionUp = {i - 1, j};
        int[] directionDown = {i + 1, j};
        int[] directionLeft = {i, j - 1};
        int[] directionRight = {i, j + 1};

        if (i == 0) moveUp = false;
        if (j == 0) moveLeft = false;
        if (i == 6) moveDown = false;
        if (j == 8) moveRight = false;
        if (moveUp) {
            if (!judgeIfVacant(directionUp, mapStore, k)) {
                moveUp = judgeIfAnimalEn(directionUp, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionUp, mapStore, i, j, k, catEn, trapEn);
            } else {
                moveUp = !judgeIfRiver(directionUp, mapStore, k) & !judgeIfHome(directionUp, mapStore, k, homeEn);
            }
        }
        if (moveDown) {
            if (!judgeIfVacant(directionDown, mapStore, k)) {
                moveDown = judgeIfAnimalEn(directionDown, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionDown, mapStore, i, j, k, catEn, trapEn);
            } else {
                moveDown = !judgeIfRiver(directionDown, mapStore, k) & !judgeIfHome(directionDown, mapStore, k, homeEn);
            }
        }
        if (moveLeft) {
            if (!judgeIfVacant(directionLeft, mapStore, k)) {
                moveLeft = judgeIfAnimalEn(directionLeft, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionLeft, mapStore, i, j, k, catEn, trapEn);
            } else {
                moveLeft = !judgeIfRiver(directionLeft, mapStore, k) & !judgeIfHome(directionLeft, mapStore, k, homeEn);
            }
        }
        if (moveRight) {
            if (!judgeIfVacant(directionRight, mapStore, k)) {
                moveRight = judgeIfAnimalEn(directionRight, mapStore, k, mouseEn, catEn, wolfEn, dogEn, leopardEn, tigerEn, lionEn, elephantEn) && judgeIfAnimalCanEat(directionRight, mapStore, i, j, k, catEn, trapEn);
            } else {
                moveRight = !judgeIfRiver(directionRight, mapStore, k) & !judgeIfHome(directionRight, mapStore, k, homeEn);
            }
        }
        return moveUp | moveDown | moveLeft | moveRight;
    }

}


