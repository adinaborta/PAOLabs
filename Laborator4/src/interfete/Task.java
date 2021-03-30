package interfete;

import java.util.Random;

public interface Task {
    void execute();
}


class RandomTask implements Task{

    int numar;

    public RandomTask(int numar) {
        Random rand = new Random();
        this.numar = rand.nextInt();
    }

    public void execute(){
        System.out.println("Numarul generat a fost: " + this.numar);
    }

}

class OutTask implements Task{

    String mesaj;

    public OutTask(String mesaj) {
        this.mesaj = mesaj;
    }

    public void execute(){
        System.out.println(this.mesaj);
    }

}

class CounterOutTask implements Task{
    static int cont;

    public void execute(){
        cont += 1;
        System.out.println("Contor la momentul actual: " + cont);
    }

}

class Main{
    public static void main(String[] args) {
        RandomTask randomTask = new RandomTask(27);
        CounterOutTask counterOutTask = new CounterOutTask();
        OutTask outTask = new OutTask("Latte cu caramel");
        CounterOutTask counterOutTask1 = new CounterOutTask();

        randomTask.execute();
        counterOutTask.execute();
        counterOutTask1.execute();
        outTask.execute();

    }
}











