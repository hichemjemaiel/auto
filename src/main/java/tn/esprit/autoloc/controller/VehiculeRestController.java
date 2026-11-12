package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Tag(name = "Vehicule Management", description = "Endpoints pour la gestion des véhicules")
@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Ajouter un nouveau véhicule")
    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @Operation(summary = "Mettre à jour un véhicule existant")
    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    @Operation(summary = "Récupérer un véhicule par son ID")
    @GetMapping("/{id}")
    public Vehicule retrieveVehicule(@PathVariable("id") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @Operation(summary = "Récupérer la liste de tous les véhicules")
    @GetMapping
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Supprimer un véhicule par son ID")
    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable("id") Long idVehicule) {
        vehiculeService.deleteVehicule(idVehicule);
    }

    @Operation(summary = "Affecter un véhicule à une agence")
    @PutMapping("/{idVehicule}/affecter-agence/{idAgence}")
    public Vehicule affecterVehicule(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idAgence") Long idAgence) {
        return vehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    @Operation(summary = "Affecter un équipement à un véhicule")
    @PutMapping("/{idVehicule}/affecter-equipement/{idEquipement}")
    public Vehicule affecterEquipement(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idEquipement") Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @Operation(summary = "Désaffecter un équipement d'un véhicule")
    @PutMapping("/{idVehicule}/desaffecter-equipement/{idEquipement}")
    public Vehicule desaffecterEquipement(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idEquipement") Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}
