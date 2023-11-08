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
import tn.esprit.devops_project.entities.SupplierCategory;
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

    // fonctions avec des tests unitaires

    @Test
    void retrieveAllSuppliersTest() {
        List<Supplier> expectedSuppliers = new ArrayList<>();
        expectedSuppliers.add(new Supplier(1L, "SUP1", "Label1", SupplierCategory.ORDINAIRE, null, null));
        expectedSuppliers.add(new Supplier(2L, "SUP2", "Label2", SupplierCategory.CONVENTIONNE, null, null));

        when(supplierRepository.findAll()).thenReturn(expectedSuppliers);

        List<Supplier> retrievedSuppliers = supplierService.retrieveAllSuppliers();

        verify(supplierRepository, times(1)).findAll();
        assertEquals(expectedSuppliers, retrievedSuppliers);
    }

    @Test
    void addSupplierTest() {
        Supplier supplierToAdd = new Supplier(1L, "SUP3", "Label3", SupplierCategory.ORDINAIRE, null, null);

        when(supplierRepository.save(supplierToAdd)).thenReturn(supplierToAdd);

        Supplier addedSupplier = supplierService.addSupplier(supplierToAdd);

        verify(supplierRepository, times(1)).save(supplierToAdd);
        assertEquals(supplierToAdd, addedSupplier);
    }

    @Test
    void updateSupplierTest() {
        Supplier supplierToUpdate = new Supplier(1L, "SUP1", "Label1", SupplierCategory.ORDINAIRE, null, null);

        when(supplierRepository.save(supplierToUpdate)).thenReturn(supplierToUpdate);

        Supplier updatedSupplier = supplierService.updateSupplier(supplierToUpdate);

        verify(supplierRepository, times(1)).save(supplierToUpdate);
        assertEquals(supplierToUpdate, updatedSupplier);
    }

    // fonctions avec Mockito

    @Test
    void deleteSupplierUsingMockitoTest() {
        long supplierId = 1L;
        doNothing().when(supplierRepository).deleteById(supplierId);

        supplierService.deleteSupplier(supplierId);

        verify(supplierRepository, times(1)).deleteById(supplierId);
    }

    @Test
    void retrieveSupplierUsingMockitoTest() {
        long supplierId = 1L;
        Supplier expectedSupplier = new Supplier(1L, "SUP1", "Label1", SupplierCategory.ORDINAIRE, null, null);

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(expectedSupplier));

        Supplier retrievedSupplier = supplierService.retrieveSupplier(supplierId);

        verify(supplierRepository, times(1)).findById(supplierId);
        assertEquals(expectedSupplier, retrievedSupplier);
    }
}
