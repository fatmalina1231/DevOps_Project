package tn.esprit.devops_project.services;

import org.hibernate.annotations.common.util.impl.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.devops_project.entities.*;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;
import tn.esprit.devops_project.services.Iservices.IActivitySector;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ActivitySectorImplTest {
@Autowired
    IActivitySector iActivitySector;
    @Mock
    ActivitySectorRepository activitySectorRepository;
    //ActivitySector activity;
    @InjectMocks
    ActivitySectorImpl activitySector;

    //Supplier supplier=new Supplier(1,"aqw","wqa", SupplierCategory.ORDINAIRE,1,1);
    //Invoice invoice=new Invoice(1,10,10,new Date(),new Date(),Boolean.TRUE,1,1);
    //InvoiceDetail invoiceDetail=new InvoiceDetail(1,15,15,1,1);
    //Product product=new Product(1,"azerty",16,3,ProductCategory.ELECTRONICS,1);
    //Stock stock=new Stock(1,"ps",1);
    /*ActivitySector activity=new ActivitySector(1L,"azerty","bbb");
    List<ActivitySector> listActivity = new ArrayList<ActivitySector>() {{
        add(new ActivitySector(2L, "azerty1", "bbb1"));
        add(new ActivitySector(3L, "azerty2", "bbb2"));
    }};*/
    @Test
    void retrieveAllActivitySectors() {
        /*List<ActivitySector> activitySectors=iActivitySector.retrieveAllActivitySectors();
        Assertions.assertEquals(0,activitySectors.size());*/
    }

    @Test
    void addActivitySector() {
        //activity=activitySectorRepository.save(activity);
        //Assertions.assertNotNull(activity.getIdSecteurActivite());
        
        ActivitySector activity=new ActivitySector(1L,"azerty","bbb");
        Mockito.when(activitySectorRepository.save(activity)).thenReturn(activity);
        ActivitySector activitySectorr = activitySector.addActivitySector(activity);
        Assertions.assertNotNull(activitySectorr);
    }

    @Test
    void deleteActivitySector() {
        //activitySector.deleteActivitySector(1L);

        /*Long activitySectorIdToDelete = 1L;
        Mockito.when(activitySectorRepository.existsById(activitySectorIdToDelete)).thenReturn(true);
        Mockito.doNothing().when(activitySectorRepository).deleteById(activitySectorIdToDelete);
        iActivitySector.deleteActivitySector(activitySectorIdToDelete);*/
    }

    @Test
    void updateActivitySector() {
        //activity.setLibelleSecteurActivite("aaa");
        //activity=activitySectorRepository.save(activity);
        //Assertions.assertNotEquals(activity.getLibelleSecteurActivite(),"bbb");

        /*ActivitySector activity = activitySectorRepository.findById(1L).orElse(null);
        activity.setLibelleSecteurActivite("nbv");
        activity = activitySectorRepository.save(activity);
        Assertions.assertNotEquals(activity.getLibelleSecteurActivite(),"bbb");*/
    }

    @Test
    void retrieveActivitySector() {
        /*ActivitySector activity = new ActivitySector(1L,"azerty","bbb");
        Mockito.when(activitySectorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(activity));
        ActivitySector act=activitySector.retrieveActivitySector(1L);
        Assertions.assertNotNull(act);*/

    }
}
