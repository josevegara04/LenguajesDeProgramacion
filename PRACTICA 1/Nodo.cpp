#include <iostream>
#include "Nodo.h"
using namespace std;

Nodo::Nodo(string nombre, int numero)
{
    huesped = nombre;
    habitacion = numero;
    prev = NULL;
    next = NULL;
}
Nodo::~Nodo()
{
    delete next;
    delete prev;
}