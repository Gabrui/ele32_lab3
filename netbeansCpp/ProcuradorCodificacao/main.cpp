/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: gabriel
 *
 * Created on 5 de Novembro de 2017, 15:57
 */

#include <cstdlib>
#include <list>

#include "VetorBits.h"

#define b64 unsigned long long;

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int tam = 8;
    int distMin;
    list<VetorBits> meusVetores;
    VetorBits* atual = new VetorBits(tam);
    char* bufferImpressao;
    
    atual->setBit(tam);
    atual->decrementar();
    bufferImpressao = atual->imprimir();
    puts(bufferImpressao);
    free(bufferImpressao);
    meusVetores.push_back(atual->clonar());
    
    while(!atual->isZero()) {
        bool distante = true;
        list<VetorBits>::iterator listado;
        if (atual->pesoHamming() < distMin) {
            atual->decrementar();
            continue;
        }
        for( listado = meusVetores.begin(); listado != meusVetores.end(); ++listado) {
            if (atual->distanciaHamming(listado) < distMin) {
                distante = false;
                break;
            }
        }
        if (distante)
            meusVetores.push_back(atual->clonar());
        atual->decrementar();
    }
    
    for(VetorBits* i : meusVetores) {
        bufferImpressao = i->imprimir();
        puts(bufferImpressao);
        free(bufferImpressao);
    }
    
    return 0;
}

