package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {
    /** 1
     * Для начала нам понадобятся классы "ипподром" и "лошадь".
     * Создай классы Hippodrome (ипподром), Horse (лошадь).
     *
     * Также не забудь, что любая программа начинается с метода main.
     * Добавь его в класс Hippodrome.
     */

    /** 2
     * Раз это ипподром, то на нем должны быть лошади.
     * Значит наш ипподром должен хранить список всех его лошадей.
     * Добавь поле horses типа List<Horse> в класс Hippodrome.
     * А чтобы лошадей не украли - сделай это поле приватным.
     * Добавь getter для этого поля.
     * @param args
     */
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    /** 3
     * Несмотря на то что мы объявили переменную horses, сам список еще не создан (если ты конечно не успел опередить нас).
     * Создай конструктор класса Hippodrome с одним параметром типа List.
     * Сохрани в поле horses полученный в качестве параметра список (инициализируй поле horses).
     */
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    /** 7
     * Но и это еще не все - надо чтобы лошади бежали.
     * Добавь в класс Hippodrome void методы run, move и print. Без параметров.
     * Метод move будет управлять движением всех лошадей.
     * Метод print отрисовывать их на экран.
     * А метод run - управлять всем этим.
     * @param
     */
    public void run() {
        // 8
        // В методе run сделай цикл от 1 до 100. Это и будет наш забег.
        //В теле цикла вызываем сначала move, затем print.
        //Чтобы весь цикл не отработал за долю секунды - добавь в него еще Thread.sleep(200);
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        // 9
        // Теперь вернемся к методам move и print. Начнем с move.
        //В методе move класса Hippodrome в цикле у каждой лошади мы вызываем метод move.
        //Да ты прав, его еще нет у класса Horse.
        //Поэтому в класс Horse надо добавить свой метод move :)
        //И метод print, кстати тоже
        //Если я не говорю ничего насчет параметров метода, значит метод без параметров.
        //Делай все методы public, если явно не указано обратное.

        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        // 10
        // Еще нужно написать метод print класса Hippodrome.
        //В нем тоже все просто: в цикле для каждой лошади вызываем ее метод print.
        //Ну, и еще выведи после цикла 10 пустых строк: System.out.println() - чтобы было красивее.
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    // 15
    //Добавим определение победителя.
    //В классе Hippodrome сделаем два метода:
    //public Horse getWinner() и public void printWinner()
    //
    //Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
    //Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!

    public Horse getWinner() {
        double longestDistance = 0;
        for (Horse h : horses) {
            if (h.getDistance() > longestDistance) longestDistance = h.getDistance();
        }
        for (Horse h : horses) {
            if (h.getDistance() == longestDistance) return h;
        }
        return null;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {

        /** 6
         * Теперь перейдем к классу Hippodrome и методу main.
         * Нам нужно создать объект типа Hippodrome и добавить ему несколько лошадей.
         *
         * Для начала, в классе Hippodrome создай статическое поле game типа Hippodrome.
         *
         * В методе main требуется:
         * a) Создать список лошадей (horses).
         * б) Создать три объекта "лошадь". Имена придумай сам. Начальная скорость у всех лошадей - 3, дистанция - 0.
         * в) Добавить созданных лошадей в список horses.
         * г) Создать объект типа Hippodrome, используя созданный ранее список лошадей, и сохранить этот объект в поле game.
         */
        List<Horse> hors = new ArrayList<>();
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Slevin", 3, 0));
        game.getHorses().add(new Horse("Lucky", 3, 0));
        game.getHorses().add(new Horse("Homer", 3, 0));

        // 11
        //С классом Hippodrome почти закончили.
        //Добавь в конец метода main вызов run().

        game.run();
        game.printWinner();


    }
}
