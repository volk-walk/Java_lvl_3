import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String [] arr1 = {"111","222", "333", "444"};
        System.out.print("Было:");
        for (int i = 0; i < arr1.length ; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\n");
        swapsTwoElementsOfAnArray(arr1,0,2);
        System.out.print("\n");
        convertingAnArray(arr1);

        Box<Apple> boxForApple1 = new Box<>();//коробка яблок 1
        Box<Apple> boxForApple2 = new Box<>();//коробка яблок 2
        Box<Orange> boxForOrange1 = new Box<>();//коробка апельсинов
        boxForApple1.addFruit(new Apple());//добавить яблоко
        boxForOrange1.addFruit(new Orange());//добавить апельсин

        for (int i = 0; i <5; i++) {
            boxForApple1.addFruit(new Apple());
        }

        for (int i = 0; i <3; i++) {
            boxForOrange1.addFruit(new Orange());
        }
        System.out.println("Вес коробки: "+boxForApple1.getWeightBox());
        System.out.println("Вес коробки: "+boxForOrange1.getWeightBox());
        System.out.println(boxForApple1.compare(boxForOrange1));

        boxForApple1.pourOver(boxForApple2);// пересыпаем
        System.out.println(boxForApple2.compare(boxForOrange1));
        System.out.println(boxForApple1.compare(boxForOrange1));
    }

    // метод меняет два элемента массива местами
    public static void swapsTwoElementsOfAnArray(Object[] array, int firstCellOfArray, int secondCellOfArray){
        Object str = array[firstCellOfArray];
        array[firstCellOfArray] = array[secondCellOfArray];
        array[secondCellOfArray] = str;
        System.out.print("Стало: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    //    преобразования массива в Арай лист
    public static<T> ArrayList convertingAnArray(T[] array){
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(array));
        return arrayList;
    }

}