package by.it.luksha.jd01_06;

public class Runner {
    public static void main(String[] args) {

        TaskA.task1();
        TaskA.task2();
        TaskA.task3();

        TaskB.task1();
        TaskB.task2();
        TaskB.task3("о");

        TaskC.formatEdgewise();
        System.out.println("Выигрыш в пользу StringBuilder " + ((TaskC.createPoemByConcat() - TaskC.createPoemByAppend())*1000) + " микросекунд");

    }
}
