package Tema;
import java.util.Random;
public class PassWordMaker {
    final static int MAGIC_NUMBER = 27;
    final String MAGIC_STRING;
    String name;

    public PassWordMaker(String name) {
        this.name = name;
        MAGIC_STRING = genMagicString();
    }

    public String genMagicString(){
        Random rand = new Random();
        StringBuilder str = new StringBuilder();
        int n = rand.nextInt(10) + 10;
        for(int i = 0; i < n; i++){
            str.append(genChar());
        }
        return str.toString();
    }

    public char genChar(){
        Random rand = new Random();
        int ascii = rand.nextInt(32);
        return (char)(ascii + 'a');
    }

    public String getPassword(){
        StringBuilder strRand = new StringBuilder();
        for (int i = 0; i < MAGIC_NUMBER; i++){
            strRand.append(genChar());
        }
        StringBuilder password = new StringBuilder();

        password.append(strRand + " ");
        password.append(MAGIC_STRING, 0, 10);
        password.append(" " + this.name.length() + " ");
        password.append(new Random().nextInt(100));
        return password.toString();
    }

    public static void main(String[] args) {
        PassWordMaker password = new PassWordMaker("Mihai");
        System.out.println(password.getPassword());
    }
}

