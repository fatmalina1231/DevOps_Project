package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Supplier;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import tn.esprit.devops_project.repositories.SupplierRepository;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
class SupplierServiceImplTest {

    @InjectMocks
    SupplierServiceImpl supplierService;

    @Mock
    SupplierRepository supplierRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void retrieveAllSuppliers() {
        List<Supplier> supplierList = new ArrayList<>();
        // Créez des fournisseurs simulés
        Supplier supplier1 = new Supplier();
        supplier1.setIdSupplier(1L);
        supplier1.setCode("SUP1");
        supplier1.setLabel("Supplier 1");

        Supplier supplier2 = new Supplier();
        supplier2.setIdSupplier(2L);
        supplier2.setCode("SUP2");
        supplier2.setLabel("Supplier 2");

        supplierList.add(supplier1);
        supplierList.add(supplier2);

        // Configure le mock pour retourner la liste simulée lors de l'appel à findAll
        when(supplierRepository.findAll()).thenReturn(supplierList);

        // Appelez la méthode de la classe testée
        List<Supplier> result = supplierService.retrieveAllSuppliers();

        // Assurez-vous que le résultat est égal à la liste simulée
        assertEquals(supplierList, result);
    }

    @Test
    void addSupplier() {
        Supplier newSupplier = new Supplier();
        newSupplier.setIdSupplier(3L);
        newSupplier.setCode("SUP3");
        newSupplier.setLabel("Supplier 3");

        // Configure le mock pour retourner le nouveau fournisseur simulé lors de l'appel à save
        when(supplierRepository.save(newSupplier)).thenReturn(newSupplier);

        // Appelez la méthode de la classe testée
        Supplier addedSupplier = supplierService.addSupplier(newSupplier);

        // Assurez-vous que le résultat est égal au fournisseur simulé
        assertEquals(newSupplier, addedSupplier);
    }

    @Test
    void updateSupplier() {
        Supplier existingSupplier = new Supplier();
        existingSupplier.setIdSupplier(4L);
        existingSupplier.setCode("SUP4");
        existingSupplier.setLabel("Supplier 4");

        // Configure le mock pour retourner le fournisseur existant simulé lors de l'appel à save
        when(supplierRepository.save(existingSupplier)).thenReturn(existingSupplier);

        // Appelez la méthode de la classe testée
        Supplier updatedSupplier = supplierService.updateSupplier(existingSupplier);

        // Assurez-vous que le résultat est égal au fournisseur simulé
        assertEquals(existingSupplier, updatedSupplier);
    }

    @Test
    void deleteSupplier() {
        Long supplierIdToDelete = 5L;

        // Appelez la méthode de la classe testée
        supplierService.deleteSupplier(supplierIdToDelete);

        // Vérifiez que la méthode deleteById du repository a été appelée avec l'ID du fournisseur à supprimer
        verify(supplierRepository).deleteById(supplierIdToDelete);
    }

    @Test
    void retrieveSupplier() {
        Long supplierId = 6L;
        Supplier supplier = new Supplier();
        supplier.setIdSupplier(supplierId);
        supplier.setCode("SUP6");
        supplier.setLabel("Supplier 6");

        // Configure le mock pour retourner le fournisseur simulé lors de l'appel à findById
        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));

        // Appelez la méthode de la classe testée
        Supplier retrievedSupplier = supplierService.retrieveSupplier(supplierId);

        // Assurez-vous que le résultat est égal au fournisseur simulé
        assertEquals(supplier, retrievedSupplier);
    }
}
