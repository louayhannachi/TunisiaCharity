package edu.esprit.iservices;

import edu.esprit.entities.Reclamation;
import edu.esprit.entities.TypeReclamation;

import java.util.ArrayList;
import java.util.List;

public interface ITypeReclamation {
    ArrayList<TypeReclamation> getTypeReclmationList();
    TypeReclamation getTypeReclmation(int id);
    void addType(TypeReclamation tr);
    void updateType(TypeReclamation tr);
    void deleteType(TypeReclamation tr);

}
