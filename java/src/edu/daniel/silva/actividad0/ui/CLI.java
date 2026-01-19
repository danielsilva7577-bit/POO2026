package edu.daniel.silva.actividad0.ui;
import edu.daniel.silva.actividad0.process.Switch;
public class CLI {
    public static void start(){
        Switch switch_wifi= new Switch();
        System.out.println("Bienvenido al programa");
        System.out.println("El estado del Switch es = " + switch_wifi.isOn());
        if(switch_wifi.isOn()){
            System.out.println("Desea apagar el switch?");
        }else{
            System.out.println("Desea prender el switch?");
        }
        System.out.println("El estado del switch es = "+switch_wifi.isOn());
    }
}