package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.utilities.QVTOperationalASResourceFactory;

@SuppressWarnings("restriction")
public class FileOperationsUtil {

	/**
	 * 
	 * @return
	 * @throws IOException
	 * used to parse XMI meta-model instance
	 */
	public static XMIResource loadXMLResources(String fileName) throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(ExpressionsPackage.eNS_URI, ExpressionsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(QVTOperationalPackage.eNS_URI, QVTOperationalPackage.eINSTANCE);
		XMIResource resource = new XMIResourceImpl(URI.createURI(fileName));
		resource.load(null);
		System.out.print("");
		return resource;
	}
	
	public static void writeTraditionalQVTOperationToXML(QVToFacade qvto, OperationalTransformation transformation, String filename) throws IOException{
		ResourceSet resourceSet = qvto.getResourceSet();
		Resource resource = resourceSet.createResource(URI.createFileURI(filename+".qvtoas"));
		// add the root object to the resource 
		resource.getContents().add(transformation); 
		// serialize resource you can specify also serialization 
		resource.save(createSaveOptions());
	}
	
	public static void writePivotQVTOperationToXML(QVToFacade qvto, org.eclipse.ocl.pivot.Model model, String filename) throws IOException{
		ResourceSet resourceSet = qvto.getMetamodelManager().getASResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("qvtoas", QVTOperationalASResourceFactory.getInstance());
		String pathName = filename+".qvtoas";
		model.setExternalURI(pathName);
		Resource resource = resourceSet.createResource(URI.createFileURI(pathName));
		// add the root object to the resource 
		resource.getContents().add(model); 
		// serialize resource you can specify also serialization 
		resource.save(createSaveOptions());
	}

	private static Map<Object, Object> createSaveOptions() {
		Map<Object, Object> saveOptions = XMIUtil.createSaveOptions();
		saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		return saveOptions;
	}

}
