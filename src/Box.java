import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit>{
    ArrayList<T> fruitBox = new ArrayList<>();

    public Box() {

    }

    //добавление фрукта
    public void addFruit(T fruit){
        fruitBox.add(fruit);
    }


    public float getWeightBox(){
        float weight = 0.0f;
        for (T o:fruitBox) {
            weight += o.getWeight();
        }
        return weight;
    }


    public boolean compare(Box<?> box){
        return Math.abs(getWeightBox()-box.getWeightBox()) < 0.0001;
    }


    //пересыпание фруктов
    public void pourOver(Box<T> box){
        box.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
    }
}
