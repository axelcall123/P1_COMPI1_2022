package P1_COMPI1_2022;

import analizadores.Analizador_Lexico;
import analizadores.Analizador_sintactico;
import analizadores.TError;
import java.io.BufferedReader;
import java.io.FileReader;



public class P1_COMPI1_2022 {
    public static void main(String[] args) {
        new Main().setVisible(true);
        /*try {
            Analizador_Lexico lexico = new Analizador_Lexico(
                    new BufferedReader(new FileReader("D:\\AXEL\\DOCUMENTOS\\U--OTROS\\GITHUB\\COMPI1-2022\\P1_COMPI1_2022\\P1_COMPI1_2022\\src\\P1_COMPI1_2022\\entrada.txt")));
            Analizador_sintactico sintactico = new Analizador_sintactico(lexico);
            sintactico.parse();
            System.out.println("\n\n***Reporte de errores encontrados ");
            for (TError errore : Analizador_Lexico.errores) {
                System.out.println(errore.show());
            }
            for (TError errore : sintactico.errores) {
                System.out.println(errore.show());
            }
        
        } catch (Exception e) {
        } */
    }
}
