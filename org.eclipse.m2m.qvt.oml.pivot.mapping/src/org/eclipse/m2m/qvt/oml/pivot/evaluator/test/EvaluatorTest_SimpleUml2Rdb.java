package org.eclipse.m2m.qvt.oml.pivot.evaluator.test;

import java.io.File;
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
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.mapping.pivot.test.QvtOperationalMappingArgumentsContainer;
import org.eclipse.m2m.qvt.oml.pivot.evaluator.QVToPivotEvaluationVisitor;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.FileOperationsUtil;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.QVToFacade;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.TraditionalToPivotMapping;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvto.examples.pivot.qvtoperational.utilities.QVTOperationalASResourceFactory;
import org.junit.Test;

import junit.framework.TestCase;
import rdb.RdbPackage;
import simpleuml.SimpleumlPackage;


@SuppressWarnings("restriction")
public class EvaluatorTest_SimpleUml2Rdb extends TestCase {

	private static final String qvtoFileUri = System.getProperty("user.dir")+"/Example/Simpleuml_To_Rdb_Evaluation.qvto";
	private static final String inUri = System.getProperty("user.dir")+"/Example/pim.simpleuml";
	
	@Test
	public void testMapping() throws IOException {
	
		
		TraditionalToPivotMapping.CREATION.setState(true);
		collectMappingArguments();

		//		try {
		QVToFacade qvto = QVToFacade.newInstance();
		// create Visitor for traditional object mapping
		TraditionalToPivotMapping converter = new TraditionalToPivotMapping(qvto);

		org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation operationalTransformation = QvtOperationalMappingArgumentsContainer
				.getInstance().getOperationalTransformation();
		org.eclipse.ocl.pivot.Model pivotOperationalTransformation = converter.convert(operationalTransformation);
		
		
		//TODO need evaluationEnvironment for this to pass it to the base class OclEvaluationVisitor 
		
		EvaluationEnvironment environment=null; 
		QVToPivotEvaluationVisitor qvtoPivotEvaluationVisitor= new QVToPivotEvaluationVisitor(environment);
		
		
	//	operationalTransformation.accept(evaluationVisitor);
		// Convert Ecore based Transformation to XML
		FileOperationsUtil.writeTraditionalQVTOperationToXML(qvto, operationalTransformation, "traditionalAS_SimpleUml2Rdb");
		// Convert Pivot based Transformation to XML
		FileOperationsUtil.writePivotQVTOperationToXML(qvto, pivotOperationalTransformation, "pivotAS_SimpleUml2Rdb");


		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("qvtoas", QVTOperationalASResourceFactory.getInstance());
		Resource asResource = resourceSet.getResource(URI.createURI("pivotAS_SimpleUml2Rdb.qvtoas"), true);
		assert asResource instanceof ASResource;
		for (Resource resource : resourceSet.getResources()) {
			for (EObject eObject : resource.getContents()) {
				assertNoValidationErrors(eObject);
			}
		}

	}
	
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


	/**
	 * 
	 * programmatic execution for collecting arguments
	 */
	protected void collectMappingArguments() {
		EPackage.Registry.INSTANCE.put(SimpleumlPackage.eNS_URI, SimpleumlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(RdbPackage.eNS_URI, RdbPackage.eINSTANCE);
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
		executor.execute(context, input, output);
		System.out.println("Transformation executed.");
	}

}
