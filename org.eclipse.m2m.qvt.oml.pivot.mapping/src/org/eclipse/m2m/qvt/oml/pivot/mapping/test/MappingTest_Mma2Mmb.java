
package org.eclipse.m2m.qvt.oml.pivot.mapping.test;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.mapping.pivot.test.QvtOperationalMappingArgumentsContainer;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.FileOperationsUtil;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.QVToFacade;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.TraditionalToPivotMapping;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.qvto.examples.pivot.qvtoperational.utilities.QVTOperationalASResourceFactory;
import org.junit.Test;

import junit.framework.TestCase;
import mma.MmaPackage;
import mmb.MmbPackage;
import rdb.RdbPackage;
import simpleuml.SimpleumlPackage;


@SuppressWarnings("restriction")
public class MappingTest_Mma2Mmb extends TestCase {

	private static final String qvtoFileUri = System.getProperty("user.dir") + "/Example/MMATransformation.qvto";
	private static final String inUri = System.getProperty("user.dir") + "/Example/Instance.mma";
	@Test
	public void testMapping() throws IOException {
		TraditionalToPivotMapping.CREATION.setState(true);
		collectMappingArguments();
	//	try {
			QVToFacade qvto = QVToFacade.newInstance();
			// create Visitor for traditional object mapping
			TraditionalToPivotMapping converter = new TraditionalToPivotMapping(qvto);

			org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation operationalTransformation = QvtOperationalMappingArgumentsContainer
					.getInstance().getOperationalTransformation();
			org.eclipse.ocl.pivot.Model pivotOperationalTransformation = converter.convert(operationalTransformation);

			
			// Convert Ecore based Transformation to XML
			FileOperationsUtil.writeTraditionalQVTOperationToXML(qvto, operationalTransformation, "traditionalAS_MMA2MMB");
			// Convert Pivot based Transformation to XML
			FileOperationsUtil.writePivotQVTOperationToXML(qvto, pivotOperationalTransformation, "pivotAS_MMA2MMB");
			
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("qvtoas", QVTOperationalASResourceFactory.getInstance());
			Resource asResource = resourceSet.getResource(URI.createURI("pivotAS_SimpleUml2Rdb.qvtoas"), true);
			assert asResource instanceof ASResource;
			for (Resource resource : resourceSet.getResources()) {
				for (EObject eObject : resource.getContents()) {
					assertNoValidationErrors(eObject);
				}
			}

			//		} catch (Exception e) {
				//			e.printStackTrace();
			//		}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 
	 * programmatic execution for collecting arguments
	 */
	public static void assertNoValidationErrors(EObject eObject) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
			s.append(child.getMessage());
		}
		fail(s.toString());
	}

	protected void collectMappingArguments() {
		EPackage.Registry.INSTANCE.put(MmaPackage.eNS_URI, MmaPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(MmbPackage.eNS_URI, MmbPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		// Refer to an existing transformation via URI
		URI transformationURI = URI.createFileURI(qvtoFileUri);
		// create executor for the given transformation
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		// define the transformation input
		// Remark: we take the objects from a resource, however
		// a list of arbitrary in-memory EObjects may be passed
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
				new EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());

		Resource inResource = resourceSet.getResource(URI.createFileURI(inUri), true);
		// Resource inResource = getResourceFromUri(inUri);
		EList<EObject> inObjects = inResource.getContents();

		// create the input extent with its initial contents
		ModelExtent input = new BasicModelExtent(inObjects);
		// create an empty extent to catch the output
		ModelExtent output = new BasicModelExtent();

		// setup the execution environment details ->
		// configuration properties, logger, monitor object etc.
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true);

		// run the transformation assigned to the executor with the given
		// input and output and execution context -> ChangeTheWorld(in, out)
		// Remark: variable arguments count is supported
		ExecutionDiagnostic result = executor.execute(context, input, output);
		if(result.getSeverity() == Diagnostic.OK){			
			System.out.println("Transformation executed.");
		}else{
			System.out.println("Error in execution");
		}
	}

}
