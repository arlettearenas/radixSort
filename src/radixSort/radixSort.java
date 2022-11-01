/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radixSort;

import java.util.Arrays;
/**
 *
 * @author Noena
 */
public class radixSort {
    // Radix sort Java implementation
 
    // se utiliza Una función de utilidad para obtener el valor máximo en arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // Una función para contar tipo de arr[] según
    // el dígito representado por exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Almacenar el conteo de ocurrencias en conteo[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Cambiar count[i] para que count[i] ahora contenga
        // posición actual de este dígito en salida[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Construir la matriz de salida
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copie la matriz de salida en arr[], de modo que arr[] ahora
        // contiene números ordenados según el actual
        // dígito
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // La función principal que ordena arr[] de
    // tamaño n usando Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Encuentra el número máximo para saber el número de dígitos
        int m = getMax(arr, n);
 
        // Ordena el conteo para cada dígito. Tenga en cuenta que
        // en lugar de pasar un número de dígito, se pasa exp.
        // exp es 10^i donde i es el número de dígito actual
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
 
   // Una función de utilidad para imprimir una matriz
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Mmetodo mein
    public static void main(String[] args)
    {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;
 
        // llamada a la funcion
        radixsort(arr, n);
        print(arr, n);
    }
}

