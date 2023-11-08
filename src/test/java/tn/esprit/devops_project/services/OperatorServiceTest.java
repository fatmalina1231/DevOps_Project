package tn.esprit.devops_project.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
 class OperatorServiceTest {
    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testFindAllOperator() {
        List<Operator> sampleOperators = new ArrayList<>();
        sampleOperators.add(new Operator(1L, "John", "Doe", "password",null));
        sampleOperators.add(new Operator(2L, "Jane", "Smith", "pass123",null));

        when(operatorRepository.findAll()).thenReturn(sampleOperators);

        List<Operator> retrievedOperators = operatorService.retrieveAllOperators();

        assertNotNull(retrievedOperators);
        assertEquals(2, retrievedOperators.size());

        verify(operatorRepository, times(1)).findAll();
    }
    @Test
     void testAddOperator() {
        Operator newOperator = new Operator(3L, "Alice", "Johnson", "newPassword",null);

        when(operatorRepository.save(newOperator)).thenReturn(newOperator);

        Operator addedOperator = operatorService.addOperator(newOperator);

        assertNotNull(addedOperator);
        assertEquals("Alice", addedOperator.getFname());
        assertEquals("Johnson", addedOperator.getLname());
        assertEquals("newPassword", addedOperator.getPassword());

        verify(operatorRepository, times(1)).save(newOperator);
    }
    @Test
     void testDeleteOperator() {

        operatorService.deleteOperator(3L);

        Optional<Operator> deletedOperator = operatorRepository.findById(3L);
        assertTrue(deletedOperator.isEmpty(), "Operator should have been deleted");
    }

}
