/**
 * 
 * @author QuestLab
 * @author AbdulAli
 * @author FitashHaq
 * @author RazaAshfaq
 * @author AdilInam
 * @since 10 October 2015
 */
package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;

public class QVToFacade extends OCLInternal {
	public static @NonNull QVToFacade newInstance() {
		return newInstance(BasicProjectManager.createDefaultProjectManager(), null);
	}

	public static @NonNull QVToFacade newInstance(@NonNull ProjectManager projectManager,
			@Nullable ResourceSet externalResourceSet) {
		EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE
				.createEnvironmentFactory(projectManager, externalResourceSet);
		QVToFacade qvto = newInstance(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}

		return qvto;
	}

	public static @NonNull QVToFacade newInstance(@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new QVToFacade(environmentFactory);
	}

	//private OCL ocl;
	private final @NonNull MetamodelManagerInternal metamodelManager;

	public QVToFacade(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
		metamodelManager = getMetamodelManager();
		//EPackage.Registry registry = new EPackageRegistryImpl();
		//registry.put(EXTLibraryPackage.eNS_URI, EXTLibraryPackage.eINSTANCE);
		//ocl = OCL.newInstance(registry);
		//ResourceSet resourceSet = ocl.getResourceSet();
		//org.eclipse.ocl.xtext.essentialocl.EssentialOCLStandaloneSetup.doSetup();
	}
}
