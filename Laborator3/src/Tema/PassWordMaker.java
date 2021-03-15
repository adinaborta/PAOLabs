package Tema;
import java.util.Random;
public class PassWordMaker {
    final static int MagicNumber = 27;
    final String MagicString;
    String name;

    public PassWordMaker(String name) {
        this.name = name;
        MagicString = genMagicString();
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
        for (int i = 0; i < this.MagicNumber; i++){
            strRand.append(genChar());
        }
        StringBuilder passWord = new StringBuilder();

        passWord.append(strRand + " ");
        passWord.append(MagicString, 0, 10);
        passWord.append(" " + this.name.length() + " ");
        passWord.append(new Random().nextInt(100));
        return passWord.toString();
    }

    public static void main(String[] args) {
        PassWordMaker password = new PassWordMaker("Mihai");
        System.out.println(password.getPassword());
    }
}

