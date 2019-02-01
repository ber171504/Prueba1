import java.io.File;
import java.util.Scanner;
//AndresQuinto- 18288
//Andres Berthet-171504
public class Main {


    public static void main(String[] args) {

/////Inicializamos el main pidiendole los datos al usuario
        Scanner input = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Inicializando Calculadora\n\nPor favor ingrese la direccion del archivo a trabajar siguiendo el formato -----> : C:\\Users\\(Su usuario)\\Desktop\\test.txt\nSi desea cerrar el programa escriba pepito:\n");
        String texto = "";
        String Dicarchivo = input.nextLine();
        Boolean luzverde = false;
////Si la direccion del archivo existe se evalua

        if (!Dicarchivo.equals("Pepito")) {
            try {


                File archivito = new File(Dicarchivo);
                Scanner scan = new Scanner(archivito);

                while (scan.hasNextLine()) {
                    texto = texto + scan.next();
                }
                System.out.println("¡Texto hallado!:\n" + texto);
                System.out.println("Leyendo el archivo jefe... un momento");
                luzverde = true;

            } catch (Exception e) {
                System.out.println("No se encontro ningun archivo .txt en esa direccion proporcionada.");
            }
        }
        if(luzverde) {
            try {

                String num1;
                String num2;
                double l1;
                double l2;

                for (int i = 0, n = texto.length(); i < n; i++) {
                    if(texto.charAt(i)=='+'){
                        num1 = calculator.pop();
                        l1 = Double.parseDouble(num1);
                        num2 = calculator.pop();
                        l2 = Double.parseDouble(num2);
                        calculator.push(String.valueOf(calculator.sumar(l1,l2)));
                    }else if(texto.charAt(i)=='-'){
                        num1 = calculator.pop();
                        l1 = Double.parseDouble(num1);
                        num2 = calculator.pop();
                        l2 = Double.parseDouble(num2);
                        calculator.push(String.valueOf(calculator.sumar(l2,l1)));
                    }else if(texto.charAt(i)=='*'){
                        num1 = calculator.pop();
                        l1 = Double.parseDouble(num1);
                        num2 = calculator.pop();
                        l2 = Double.parseDouble(num2);
                        calculator.push(String.valueOf(calculator.multiplicacion(l2,l1)));
                    }else if(texto.charAt(i)=='/'){
                        num1 = calculator.pop();
                        l1 = Double.parseDouble(num1);
                        num2 = calculator.pop();
                        l2 = Double.parseDouble(num2);
                        calculator.push(String.valueOf(calculator.division(l2,l1)));
                    }else{
                        calculator.push(Character.toString(texto.charAt(i)));
                    }
                }
                System.out.println("Ahuevo compa su resultado: "+ calculator.peek());
            } catch (Exception e) {
                System.out.println("Un error ocurrio al procesar el texto. Revise si esta en formato (POSTFIX) porfavor");
            }
        }
    }
}