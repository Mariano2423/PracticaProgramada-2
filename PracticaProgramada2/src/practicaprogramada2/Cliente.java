/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author mariano
 */
public class Cliente extends Thread{
    private static int totalProductos = 0;
    private static int totalTiempoEspera = 0;
    private static int totalClientes = 0;
    
    int id;
    private int productosComprados = 0;
    private int tiempoEspera = 0;

    public Cliente(int id) {
        this.id = id;
    }

    public int getProductosComprados() {
        return productosComprados;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }
    
    @Override
    public void run(){
        Random random = new Random();
        
        
        try{
            // Calcula el tiempo de llegada
            int tiempoLlegada = 300 + random.nextInt(301);
            TimeUnit.MILLISECONDS.sleep(tiempoLlegada);
            tiempoEspera += tiempoLlegada;
            System.out.println("Cliente " + id + " ha llegado");
            
            // Recorre los pasillos y selecciona objetos
            int pasillos = 8 + random.nextInt(6);
            for (int i = 0; i < pasillos; i++) {
                int productos = random.nextInt(7);
               int seleccion = 200 + random.nextInt(601);
                TimeUnit.MILLISECONDS.sleep(seleccion);
                productosComprados += productos;
                tiempoEspera += seleccion; 
            }
            
            // Tiempo en caja
            int tiempoCaja = productosComprados * (20 + random.nextInt(61));
            TimeUnit.MILLISECONDS.sleep(tiempoCaja);
            tiempoEspera += tiempoCaja;
            
            // Sumatoria
            totalProductos += productosComprados;
            totalTiempoEspera += tiempoEspera;
            totalClientes ++;
            
            System.out.println("Clienten " + id + " ha terminado de hacer las compras");
        }
        
        catch (InterruptedException e){
            System.out.println("Cliente " + id + " ha sido interrumpido");
        }
    }
        public static void mostrarResultados() {
            int clientes = totalClientes;
            System.out.println("Total de productos comprados: " + totalProductos);
            System.out.println("Promedio de tiempo de espera: " + (clientes > 0 ? totalTiempoEspera / clientes : 0) + "ms");
        }
    }  
