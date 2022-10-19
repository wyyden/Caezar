import java.util.Scanner;
import java.lang.Character;

public class Cezar {
    static char[] russianUpper = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    static char space = 32;
    static int indexDefine(char currentChar) {
        currentChar = Character.toUpperCase(currentChar);
        Character currentCharCharacter = currentChar;
        for (int i = 0; i < russianUpper.length; i++) {
            if (currentCharCharacter.equals(russianUpper[i])) {
                return i;
            }
        }
        return -1;
    }

    static char shiftRegister(char currentChar,  int shiftValue){
        int posAndShift = 0;
        posAndShift += indexDefine(currentChar);
        if (posAndShift == -1)
            return space;
        posAndShift += shiftValue;
        posAndShift = (Math.abs(posAndShift) % 33);
        if(Character.isUpperCase(currentChar)){
            return russianUpper[posAndShift];
        }
        else{
            return Character.toLowerCase(russianUpper[posAndShift]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер сдвига: ");
        int shiftValue = sc.nextInt();
        System.out.println("Введите строку для шифрования: ");
        sc.nextLine();
        char[] currentStr = sc.nextLine().toCharArray();
        int changeNum = 0;

        for(int i = 0; i < currentStr.length; i++){

            if ((currentStr[i] >= 64) && (currentStr[i] <= 90)){
                changeNum = (currentStr[i] - 64 + shiftValue) % 26;
                System.out.print((char) (64 + changeNum));
            }
            else if ((currentStr[i] >= 97) && (currentStr[i] <= 122)){
                changeNum = (currentStr[i] - 97 + shiftValue) % 26;
                System.out.print((char) (97 + changeNum));
            }
            else {

                System.out.print(shiftRegister(currentStr[i], shiftValue));

            }
        }
    }
}
