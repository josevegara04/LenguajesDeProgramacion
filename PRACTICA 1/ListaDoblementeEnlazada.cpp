#include <iostream>
#include "ListaDoblementeEnlazada.h"

using namespace std;

ListaDoblementeEnlazada::ListaDoblementeEnlazada()
{
    head = NULL;
    tail = NULL;
}

ListaDoblementeEnlazada::~ListaDoblementeEnlazada()
{
    Nodo* current = head;
    while(current != NULL)
    {
        Nodo* temp = current;
        current = current->next;
        delete temp;
    }
    head = NULL;
    tail = NULL;
}

void ListaDoblementeEnlazada::print()
{
    Nodo* current = head;
    if (current == NULL)
    {
        cout << "Lista vacia." << endl;
    }
    else
    {
        while ( current != NULL)
        {
            cout << "[ | " << current->huesped << " | " << current->habitacion << " | ]" << endl;
            current = current->next;
        }
    }
    
}

void ListaDoblementeEnlazada::insertar( string nombre, int numero)
{
    Nodo* current = head;
    while (current != NULL)
    {
        if(current->habitacion == numero)
        {
            cout << "Ya existe una habitacion con este numero. Por favor, digite otra habiatacion: " << endl;
            cin >> numero;
            current = head;
        }
        else 
        {
            current = current->next;
        }
    }
    Nodo* nuevo = new Nodo(nombre, numero);
    if (head == NULL)
    {
        head = nuevo;
        tail = nuevo;
        cout << "Informacion agregada exitosamente." << endl;
    }
    else
    {
        nuevo->prev = tail;
        tail->next = nuevo;
        tail = tail->next;
        tail->next = NULL;
        cout << "Informacion agregada exitosamente." << endl;
    }
}

void ListaDoblementeEnlazada::buscarHuesped(int numero)
{
    bool encontrado = false;
    Nodo* current = head;
    while(current != NULL)
    {
        if(current->habitacion == numero)
        {
            cout << "Esta habitacion esta a nombre de " << current->huesped << "." << endl;
            encontrado = true;
            break;
        }
        else
        {
            current = current->next;
        }
    }
    if (encontrado == false)
    {
        cout << "No hay habitacion a nombre de este huesped." << endl;
    }
}

bool ListaDoblementeEnlazada::libre(int numero)
{
    bool libre = true;
    Nodo* current = head;
    while (current != NULL)
    {
        if (current->habitacion == numero)
        {
            libre = false;
            break;
        }
        else
        {
            current = current->next;
        }
    }
    return libre;
}

void ListaDoblementeEnlazada::buscarHabitacion(string nombre)
{
    bool encontrado = false;
    Nodo* current = head;
    while(current != NULL)
    {
        if(current->huesped == nombre)
        {
            cout << "La habitacion para este huesped es: " << current->habitacion << "." << endl;
            encontrado = true;
            break;
        }
        else
        {
            current = current->next;
        }
    }
    if (encontrado == false)
    {
        cout << "No hay habitacion a nombre de este huesped." << endl;
    }
}

void ListaDoblementeEnlazada::ordenarAlfa()
{
    bool swapped = true;
    while(swapped) 
    {
        swapped = false;
        Nodo* current = head;
        while(current->next != NULL) 
        {
            if(current->huesped > current->next->huesped) 
            {
                swap(current->huesped, current->next->huesped);
                swap(current->habitacion, current->next->habitacion);
                swapped = true;
            }
            current = current->next;
        }
    }
}


void ListaDoblementeEnlazada::eliminarPrimero()
{
    if(head == NULL)
    {
        cout << "No se puede eliminar ningún elemento. Lista vacia.";
    }
    else if(head->next == NULL)
    {
        delete head;
    }
    else
    {
        Nodo *temp = head;
        head = head->next;
        head->prev = NULL;
        delete temp;
        cout << "Primer elemento eliminado exitosamente." << endl;
    }
}

void ListaDoblementeEnlazada::eliminarUltimo()
{
    if(head == NULL)
    {
        cout << "No se puede eliminar ningún elemento. Lista vacia.";
    }
    else if(head->next == NULL)
    {
        delete head;
    }
    else
    {
        Nodo* current = head;
        while (current->next != NULL)
        {
            current = current->next;
        }
        tail = current->prev;
        tail->next = NULL;
        delete current;
        cout << "Ultimo elemento eliminado exitosamente." << endl;
    }
}

void ListaDoblementeEnlazada::vecinos(int numero)
{
    Nodo* current = head;
    Nodo* prev = NULL;
    if (head == NULL)
    {
        cout << "La lista esta vacia." << endl;
    }
    else
    {
        while (current != NULL)
        {
            if (current->habitacion == numero)
            {
                if (prev == NULL)
                {
                    cout << "El vecino de está habitacion (" << current->habitacion << ") es: "  << current->next->huesped << "." << endl;
                    break;
                }
                else if(current->next == NULL)
                {
                    cout << "El vecino de está habitacion (" << current->habitacion << ") es: "  << prev->huesped << "." << endl;
                    break;
                }
                else
                {
                    cout << "Los vecinos de está habitacion (" << current->habitacion << ") son: "  << prev->huesped << " y " << current->next->huesped << "." << endl;
                    break;
                }
            }
            else 
            {
                prev = current;
                current = current->next;
            }
        }
    }
}