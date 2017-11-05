/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   vetorBits.h
 * Author: gabriel
 *
 * Created on 5 de Novembro de 2017, 16:13
 */

#ifndef VETORBITS_H
#define VETORBITS_H

#define bit unsigned char

class VetorBits {
public:
    VetorBits(int tamanho);
    bit getBit(int posicao);
    void setBit(int posicao);
    VetorBits* xorBits(VetorBits* outro);
    unsigned int pesoHamming();
    unsigned int distanciaHamming(VetorBits* outro);
    void decrementar();
    void incrementar();
    bool isZero();
    bool ehIgual(VetorBits* outro);
    char* imprimir();
    VetorBits* clonar();
private:

};

#endif /* VETORBITS_H */

