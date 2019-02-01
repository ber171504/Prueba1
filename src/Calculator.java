import java.util.ArrayList;
import java.util.Vector;
//Andres Quinto-18288
//Andres Berthet-171504

public class Calculator  implements iCalculadora, iPila<String> {


    ArrayList<String> array = new ArrayList<>();
    Boolean isEmpty = true;

    //Hacemos todos los overrides necesarios que utilizaremos de iCalculadora
    @Override
    public double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double sumar(double num1, double num2) {
        return num1+num2;
    }

    @Override
    public double division(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public double restar(double num1, double num2) {
        return num1-num2;
    }


    //Llamamos todos los overrides igual que con iCalculadora solo que ahora los de iPila

    @Override
    public String peek() {
        return array.get(array.size()-1);
    }

    @Override
    public void push(String item) {
        array.add(item);
        isEmpty = false;
    }
    @Override
    public String pop() {
        return array.remove(this.size()-1);
    }

    @Override
    public int size() {
        return array.size();
    }
    @Override
    public boolean empty() {
        return array.isEmpty();
    }

}