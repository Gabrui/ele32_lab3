/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   vetorBits.cpp
 * Author: gabriel
 * 
 * Created on 5 de Novembro de 2017, 16:13
 */

#include <cstdio>
#include <cstdlib>

#include "VetorBits.h"

VetorBits::VetorBits(int tamanho) {
    VetorBits(tamanho, 0);
}

VetorBits::VetorBits(int tamanho, unsigned long data) {
    this->tamanho = tamanho;
    this->data = data;
}



VetorBits* VetorBits::clonar() {
    VetorBits* clone = new VetorBits(this->tamanho);
    clone->data = this->data;
    return clone;
}

void VetorBits::decrementar() {
    this->data--;
}

unsigned int VetorBits::distanciaHamming(VetorBits* outro) {
    return this->pesoHamming(this->data^outro->data);
}

bool VetorBits::ehIgual(VetorBits* outro) {
    return this->data == outro->data;
}

unsigned char VetorBits::getBit(int posicao) {
    return (1<<posicao) & this->data;
}

char* VetorBits::imprimir() {
    char* impressao = malloc(tamanho+1);
    impressao[tamanho] = 0;
    for (int i=tamanho-1; i>=0; i--)
        impressao[0] = this->getBit(i)? '1' : '0';
    return impressao;
}

void VetorBits::incrementar() {
    this->data++;
}

bool VetorBits::isZero() {
    return this->data == 0;
}

unsigned int VetorBits::pesoHamming() {
    //int __builtin_popcountll (unsigned long long x);
    return __builtin_popcount(this->data);
}

void VetorBits::setBit(int posicao) {
    this->data |= 1 << posicao;
}

VetorBits* VetorBits::xorBits(VetorBits* outro) {
    return new VetorBits(this->tamanho, this->data^outro->data);
}
