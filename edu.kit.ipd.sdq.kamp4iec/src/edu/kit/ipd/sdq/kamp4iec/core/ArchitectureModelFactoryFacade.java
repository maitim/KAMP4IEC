package edu.kit.ipd.sdq.kamp4iec.core;

import edu.kit.ipd.sdq.kamp4iec.model.Modificationmarks.KAMP4IECModificationRepository;
import edu.kit.ipd.sdq.kamp4iec.model.Modificationmarks.KAMP4IECSeedModifications;
import edu.kit.ipd.sdq.kamp4iec.model.Modificationmarks.ModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4iec.core.ArchitectureVersion.ArchitectureVersionParams;

public class ArchitectureModelFactoryFacade {
	
	private static ArchitectureVersionParams archParams = new ArchitectureVersionParams();
	
	public static ArchitectureVersion createEmptyModel(String name) {
		archParams.name = name;

		archParams.modificationMarkRepository = ArchitectureModelFactoryFacade.createKAMP4IECModificationMarkRepository();

		return new ArchitectureVersion(archParams);
	}
	
	public static KAMP4IECModificationRepository createKAMP4IECModificationMarkRepository() {
		KAMP4IECModificationRepository repository = ModificationmarksFactory.eINSTANCE.createKAMP4IECModificationRepository();

		KAMP4IECSeedModifications seedModifications = ModificationmarksFactory.eINSTANCE.createKAMP4IECSeedModifications();
		repository.setSeedModifications(seedModifications);
		
		return repository;
	}

}
