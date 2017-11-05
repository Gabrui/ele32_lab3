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

#include <cstdio>
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
    int distMin = 3;
    int quant = 1;
    list<VetorBits*> meusVetores;
    VetorBits* atual = new VetorBits(tam);
    char* bufferImpressao;
    
    printf("Inicio\n");
    atual->setBit(tam);
    atual->decrementar();
    meusVetores.push_back(atual->clonar());
    
    while(!atual->isZero()) {
        bool distante = true;
        list<VetorBits*>::iterator listado;
        bufferImpressao = atual->imprimir();
        puts(bufferImpressao);
        free(bufferImpressao);
        if (atual->pesoHamming() < distMin) {
            atual->decrementar();
            continue;
        }
        for(listado = meusVetores.begin(); listado != meusVetores.end(); ++listado) {
            if (((VetorBits*)(*listado))->distanciaHamming(atual) < distMin) {
                distante = false;
                break;
            }
        }
        if (distante) {
            meusVetores.push_back(atual->clonar());
            quant++;
        }
        atual->decrementar();
    }
    
    printf("ELEMENTOS ENCONTRADOS:");
    for(auto const &i : meusVetores) {
        bufferImpressao = ((VetorBits*)i)->imprimir();
        puts(bufferImpressao);
        free(bufferImpressao);
    }
    printf("Final! Total de %d elementos, tamanho %d", quant, atual->getTamanho());
    getchar();
    return 0;
}

