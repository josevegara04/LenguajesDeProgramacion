#ifndef NODO_H
#define NODO_H

#include <iostream>

using namespace std;

class Nodo
{
    public:
        string huesped;
        int habitacion;
        Nodo* next;
        Nodo* prev;

    Nodo(string nombre, int numero);
    ~Nodo();
};

#endif