#ifndef LISTADOBLEMENTEENLAZADA_H
#define LISTADOBLEMENTEENLAZADA_H

#include <iostream>
#include "Nodo.cpp"

using namespace std;

class ListaDoblementeEnlazada
{
    public:
        Nodo* head;
        Nodo* tail;
    
        ListaDoblementeEnlazada();
        ~ListaDoblementeEnlazada();
        void print();
        void insertar(string nombre, int numero);
        void buscarHuesped(int numero);
        bool libre(int numero);
        void buscarHabitacion(string nombre);
        void ordenarAlfa();
        void eliminarPrimero();
        void eliminarUltimo();
        void vecinos(int numero);
};
#endif