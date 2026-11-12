package tn.esprit.autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Agence;
import tn.esprit.autoloc.entity.Equipement;
import tn.esprit.autoloc.entity.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Service

public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;
    private final EquipementRepository equipementRepository ;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, AgenceRepository agenceRepository, EquipementRepository equipementRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.agenceRepository = agenceRepository;
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public void deleteVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }


    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() ->
                        new RuntimeException("Agence introuvable"));

        vehicule.setAgence(agence);

        return vehiculeRepository.save(vehicule);
    }
    public Vehicule affecterEquipement(
            Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() ->
                        new RuntimeException("Equipement introuvable"));

        vehicule.getEquipements().add(equipement);

        return vehiculeRepository.save(vehicule);
    }

    // Désaffecter un équipement d'un véhicule
    public Vehicule desaffecterEquipement(
            Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() ->
                        new RuntimeException("Equipement introuvable"));

        vehicule.getEquipements().remove(equipement);

        return vehiculeRepository.save(vehicule);
    }
}



