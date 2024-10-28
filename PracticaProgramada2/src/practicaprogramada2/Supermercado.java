/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaprogramada2;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author mariano
 */
public class Supermercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeroClientes = 100;
        Cliente[] clientes = new Cliente[numeroClientes];
        
        System.out.println("Inicia la simulación");
        
        for (int i = 0; i < numeroClientes; i++) {
            clientes[i] = new Cliente(i+1);
            clientes[i].start();
        }
        
        
        for(Cliente cliente : clientes){
            try{
                cliente.join();
            }
            catch(InterruptedException e){
                System.out.println("Interrupcion en el hilo principal");
            }
        }
        
        // ordenar a los clientes
        List<Cliente> listaClientes = new ArrayList<>();
        for(Cliente cliente : clientes){
            listaClientes.add(cliente);
        }
        
        listaClientes.sort(Comparator.comparingInt(Cliente::getTiempoEspera));
        
        System.out.println("Orden de clientes por tiempo de espera: ");
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            System.out.println("Cliente" + cliente.id + " tiempo de espera: " + cliente.getTiempoEspera() + "ms, Productso comprados: " + cliente.getProductosComprados());
        }
        
        // mostrar resultados
        
        Cliente.mostrarResultados();
    }
    
}
