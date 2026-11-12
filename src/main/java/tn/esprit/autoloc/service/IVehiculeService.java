package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Vehicule vehicule);
    Vehicule retrieveVehicule(Long idVehicule);
    List<Vehicule> retrieveAllVehicules();
    void deleteVehicule(Long idVehicule);
    Vehicule affecterVehicule(Long idVehicule, Long idAgence) ;
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}

