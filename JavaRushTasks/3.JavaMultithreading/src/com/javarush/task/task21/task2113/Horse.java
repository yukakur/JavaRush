package com.javarush.task.task21.task2113;

public class Horse {

    /** 1
     * Для начала нам понадобятся классы "ипподром" и "лошадь".
     * Создай классы Hippodrome (ипподром), Horse (лошадь).
     *
     * Также не забудь, что любая программа начинается с метода main.
     * Добавь его в класс Hippodrome.
     */

    /** 4
     * Теперь вернемся к лошадям. У каждой лошади на скачках должны быть известны имя (name) и скорость (speed).
     * Наши лошади будут бежать просто определенное время (100 секунд/"шагов").
     * Будем определять победителя, как лошадь, пробежавшую наибольшую дистанцию.
     * Поэтому нам понадобится хранить еще и расстояние (distance), которое лошадь уже пробежала.
     * Добавь в класс Horse переменные name (String), speed (double), distance (double).
     */

    private String name;
    private double speed;
    private double distance;

    /** 5
     * Закончим написание класса лошадь (Horse).
     * Добавь конструктор с параметрами (name, speed, distance).
     * Добавь getter'ы и setter'ы для всех полей класса Horse.
     * Делай все методы public, если явно не указано обратное.
     */
    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    //// 9
    //        // Теперь вернемся к методам move и print. Начнем с move.
    //        //В методе move класса Hippodrome в цикле у каждой лошади мы вызываем метод move.
    //        //Да ты прав, его еще нет у класса Horse.
    //        //Поэтому в класс Horse надо добавить свой метод move :)
    //        //И метод print, кстати тоже
    //        //Если я не говорю ничего насчет параметров метода, значит метод без параметров.
    //        //Делай все методы public, если явно не указано обратное.

    public void move() {
        distance += speed * Math.random();
    }
    // 12
    //Осталось совсем немного - дописать класс Horse.
    //Каждый ход у лошади будет вызываться метод move.
    //Когда у лошади вызывают метод move, лошадь должна пробежать некоторую дистанцию.
    //Дистанция зависит от скорости лошади (speed). В самом простом варианте, выглядеть этот метод должен примерно так: distance += speed;
    //Но, чтобы было интереснее, давай сделаем так, чтобы скорость все время немного менялась.
    //Для этого умножь speed на случайное число.
    //Случайное число можно получить с помощью метода Math.random().

    // 13
    //Теперь вернемся к методу print класса Horse.
    //
    //Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
    //........Slevin
    //....Lucky
    //..........Homer
    //
    //Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
    //Количество точек равно distance, округленному (в меньшую сторону) до целого числа.

    public void print() {
        for (int i = 0; i < (int)distance; i++) {
            System.out.print(".");
        }
        System.out.println(this.name);
    }
}
