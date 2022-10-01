import java.util.ArrayList;
import java.util.Scanner;
/*
    Работу выполнил студент ЗКИ-16Б
    Филин Дмитрий Алексеевич

 */

/**
 * Для каждого варианта имеется набор из четырех сущностей. Необходимо выстроить иерархию наследования. В каждом классе (базовом и производных) должно быть  не менее одного числового и одного строкового поля. При вводе числовых параметров обязательна проверка на число и на диапазон (даже если число может быть любое, проверку необходимо реализовать).
 * Для всех классов должны быть реализованы конструкторы (по умолчанию, с параметрами), методы equals(), hashCode(), toString().
 * Реализовать консольное Java-приложение, которое имеет пользовательское меню, содержащее следующие пункты:
 * <p>
 * Добавить новый элемент (Элементы должны добавляться в коллекцию элементов типа базового класса. Необходимо предусмотреть возможность добавления любого объекта производного класса в данную коллекцию).
 * Удалить элемент по индексу.
 * Вывод всех элементов в консоль.
 * Сравнение двух элементов на равенство (по индексам).
 * Завершение работы приложения.
 * <p>
 * Вариант: Двигатель, двигатель внутреннего сгорания, дизельный двигатель, реактивный двигатель.
 */
public class Main {
    /**
     * Выводит на экран данные о двигателях
     * @param arr ArrayList с объектом класса / подкласса Engine
     */
    public static void listEngines(ArrayList<Engine> arr) {
        if(arr.size() == 0) {
            System.out.println("Двигателей нет");
        } else {
            arr.forEach(engine -> System.out.printf("[%d]: %s\n", arr.indexOf(engine), engine.toString()));
        }
    }

    /**
     * Запрашивает от пользователя ввод действительного индекса arr
     * @param arr ArrayList с объектом класса / подкласса Engine
     * @return Индекс выбранного элемента
     */
    public static int requestEngineIndex(ArrayList<Engine> arr) {
        if(arr.size() == 0) return -1;
        while (true) {
            listEngines(arr);
            System.out.println("Введите порядковый номер двигателя:");
            Scanner indexScanner = new Scanner(System.in);
            String indexChoice = indexScanner.nextLine();
            try {
                int indexChoiceInt = Integer.parseInt(indexChoice);
                if(indexChoiceInt < 0 || indexChoiceInt >= arr.size()) continue;
                return indexChoiceInt;
            } catch (Exception e) {
                System.out.println("Неверное значение.");
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Engine> engines = new ArrayList<>();
        System.out.println("Двигатели");
        while(true) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Добавить новый двигатель.");
            System.out.println("2. Удалить двигатель.");
            System.out.println("3. Вывести все двигатели на экран.");
            System.out.println("4. Сравнить два двигателя.");
            System.out.println("0. Выйти");
            String choice = input.nextLine();
            int selectedMenuItem;
            try {
                selectedMenuItem = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректный пункт меню!");
                continue;
            }
            switch (selectedMenuItem) {
                case 0:
                    return;
                case 1:
                    engines.add(new EngineBuilder().build());
                    System.out.println("Двигатель добавлен");
                    break;
                case 2:
                    if(engines.size() != 0) {
                        engines.remove(requestEngineIndex(engines));
                    } else {
                        System.out.println("Удалять нечего.");
                    }
                    break;
                case 3:
                    listEngines(engines);
                    break;
                case 4:
                    if(engines.size() != 0) {
                        if (engines.get(requestEngineIndex(engines)).equals(engines.get(requestEngineIndex(engines)))) {
                            System.out.println("Двигатели одинаковы");
                        } else {
                            System.out.println("Двигатели разные");
                        }
                    } else {
                        System.out.println("Сравнивать нечего.");
                    }
                    break;
                default:
                    System.out.println("Вы ввели некорректный пункт меню!");
                    break;
            }
        }
    }
}