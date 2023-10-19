package com.apps.petcare.function;

import com.apps.petcare.model.Pet;
import com.apps.petcare.model.PetCareCenter;
import com.apps.petcare.model.PetOwner;
import com.apps.petcare.model.Document;
import com.apps.petcare.model.PetService;
import com.apps.petcare.enums.PetServiceType;
import com.apps.petcare.converter.PetServiceTypeConverter;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;
import com.apps.petcare.repository.PetServiceRepository;
import com.apps.petcare.repository.PetOwnerRepository;
import com.apps.petcare.repository.PetCareCenterRepository;
import com.apps.petcare.repository.DocumentRepository;
import com.apps.petcare.repository.PetRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class JavaFunctions implements ODataFunction {


    
    
}
   
