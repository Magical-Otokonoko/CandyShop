package com.trakknamur.springRecap.models.enums;
@Deprecated
public enum TypeParcours {
    TROU_18(18),
    TROU_9(9);

    int nbHoles;

    TypeParcours(int nbHoles) {
        this.nbHoles = nbHoles;
    }

    public int getNbHoles() {
        return nbHoles;
    }
}
