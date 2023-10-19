package com.apps.petcare.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.apps.petcare.model.Pet;
import com.apps.petcare.model.PetCareCenter;
import com.apps.petcare.model.PetOwner;
import com.apps.petcare.model.Document;
import com.apps.petcare.model.PetService;
import com.apps.petcare.enums.PetServiceType;
import com.apps.petcare.converter.PetServiceTypeConverter;

@Entity(name = "PetOwnerPets")
@Table(schema = "\"petcare\"", name = "\"PetOwnerPets\"")
@Data
public class PetOwnerPets{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"OwnerId\"")
	private Integer ownerId;

    
    @Column(name = "\"PetId\"")
    private Integer petId;
 
}