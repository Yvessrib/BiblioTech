package org.example.Classes;

//Importanto funções de data
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Data {

    //Método que armazena e trata a data da máquina
    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
