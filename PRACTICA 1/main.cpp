#include <iostream>
#include "ListaDoblementeEnlazada.cpp"
#include <fstream>
#include <string>
#include <typeinfo>
using namespace std;

void menu()
{
    cout << "Seleccione la accion que desea realizar: " << endl;
    cout << "1. Agregar huesped a habitacion." << endl;
    cout << "2. Buscar huesped o habitacion." << endl;
    cout << "3. Ordenar alfabeticamente los huespedes." << endl;
    cout << "4. Consular los vecinos de una habitacion." << endl;
}


int main()
{
    /*Variables*/
    string huesped, linea;
    int habitacion;
    ListaDoblementeEnlazada lista;
    int opcion;
    fstream archivo;
    bool cen2 = true;
    bool cen = true;

    cout << "¡Bienvenido al Hotel!" << endl;
    archivo.open("hotel.txt", ios::in);
    while (getline(archivo, linea))
    {
        huesped = linea;
        getline(archivo, linea);
        habitacion = stoi(linea);
        lista.insertar(huesped, habitacion);
    }
    archivo.close();
    

    menu();
    cin >> opcion;
    while(opcion != 0)        
    {
        switch(opcion)
        {
            case 1:
                archivo.open("hotel.txt", ios::app);
                if (archivo.tellp() != 0)
                {
                    archivo << endl;
                }
                cout << "Ingrese su nombre por favor: " << endl;
                cin >> huesped;
                cout << "Ingrese el numero de habitacion del 1 al 100: " << endl;
                cin >> habitacion;
                while (habitacion < 1 || habitacion > 100)
                {
                    cout << "Numero de habitacion invalido. Ingrese un numero de habitacion del 1 al 100: " << endl;
                    cin >> habitacion;
                }
                while (!lista.libre(habitacion))
                {
                    cout << "La habitacion esta ocupada. Por favor ingrese otra habitacion del 1 al 100: " << endl;
                    cin >> habitacion;
                }
                lista.insertar(huesped, habitacion);
                archivo << huesped << endl;
                archivo << habitacion << endl;
                archivo.flush();
                archivo.close();
                break;
            case 2:
                cout << "Desea buscar huesped o habitacion: " << endl;
                cout << "1. Huesped" << endl;
                cout << "2. Habitacion" << endl;
                int orden;
                cin >> orden;
                while(cen)
                {
                    if(orden == 1)
                    {
                        cout << "Ingrese el numero de habitacion" << endl;
                        cin >> habitacion;
                        lista.buscarHuesped(habitacion);
                        cen = false;
                    }
                    else if(orden == 2)
                    {
                        cout << "Ingrese el nombre del huesped: " << endl;
                        cin >> huesped;
                        lista.buscarHabitacion(huesped);
                        cen = false;
                    }
                    else
                    {
                        cout << "Opcion incorrecta. Ingrese de nuevo: ";
                        cin >> orden;
                    }
                }
                cen = true;
                break;
            case 3:
                cout <<"Como la desea ordenar: " << endl;
                cout << "1. Los huespedes por orden alfabetico." << endl;
                cout << "2. Los huespedes por orden de llegada." << endl;
                int orden2;
                cin >> orden2;
                while(cen2)
                {
                    if(orden2 == 1)
                    {
                        lista.ordenarAlfa();
                        lista.print();
                        cen2 = false;
                    }
                    else if(orden2 == 2)
                    {
                        lista.print();
                        cen2 = false;
                    }
                    else
                    {
                        cout << "Opcion incorrecta. Ingrese de nuevo: ";
                        cin >> orden2;
                    }
                }
                cen2 = true;
                break;
            case 4:
                cout << "Ingrese la habitacion a la cual desea conocer sus vecinos: " << endl;
                cin >> habitacion;
                lista.vecinos(habitacion);
        }
        menu();
        cin >> opcion;
    }
    cout << "Muchas gracias. Cerrando." << endl;
    exit(0);
    return 0;
}