package edu.kit.ipd.sdq.kamp4iec.core;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.system.SystemPackage;

//import de.uka.ipd.sdq.componentInternalDependencies.ComponentInternalDependenciesPackage;
import edu.kit.ipd.sdq.kamp.architecture.AbstractArchitectureVersionPersistency;
import edu.kit.ipd.sdq.kamp4iec.model.Modificationmarks.ModificationmarksPackage;

public abstract class AbstractKAMP4IECArchitectureVersionPersistency<T extends ArchitectureVersion> 
		extends AbstractArchitectureVersionPersistency<T> {

	public static final String FILEEXTENSION_REPOSITORY = "repository";
	public static final String FILEEXTENSION_SYSTEM = "system";
	
	@Override
	public void save(String targetDirectoryPath, String filename, T version) {
		savePCMAndKAPSModels(targetDirectoryPath, filename, version);
	}
	
	public static void savePCMAndKAPSModels(String targetDirectoryPath, String filename, ArchitectureVersion version) {
		ResourceSet resourceSet = new ResourceSetImpl();
		String internalModFilePath = filename + "." + FILEEXTENSION_MODIFICATIONMARK;
		
		if (version.getModificationMarkRepository()!=null)
			saveEmfModelToResource(version.getModificationMarkRepository(), targetDirectoryPath, internalModFilePath, resourceSet);
	}
	
	@Override
	protected void registerEPackages(ResourceSet resourceSet) {
    	registerKAPSPackages(resourceSet);
    }
	
	public static void registerKAPSPackages(ResourceSet resourceSet) {
    	resourceSet.getPackageRegistry().put(RepositoryPackage.eNS_URI, RepositoryPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(SystemPackage.eNS_URI, SystemPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(ModificationmarksPackage.eNS_URI, ModificationmarksPackage.eINSTANCE);
    }

}
