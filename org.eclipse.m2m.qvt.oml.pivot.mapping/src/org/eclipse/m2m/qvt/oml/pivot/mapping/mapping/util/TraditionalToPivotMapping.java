package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;

@SuppressWarnings("restriction")
public class TraditionalToPivotMapping
{
	// The plug-in ID
	public static final @NonNull String PLUGIN_ID = "org.eclipse.m2m.qvt.oml.pivot.mapping";

	public static final @NonNull TracingOption CREATION = new TracingOption(PLUGIN_ID, "creation");

	public static @NonNull String debugId(EObject eObject) {
		if (eObject == null) {
			return "null";
		}
		else {
			return eObject.eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(eObject));
		}
	}

	protected final QVToFacade qvto;
	protected final @NonNull TraditionalQVTo2PivotDeclarationVisitor declarationVisitor;
	protected final @NonNull TraditionalQVTo2PivotReferenceVisitor referenceVisitor;
	
	org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation pivotTransformation;
	private final @NonNull Map<org.eclipse.ocl.utilities.Visitable, org.eclipse.ocl.pivot.Element> traditional2pivot
		= new HashMap<org.eclipse.ocl.utilities.Visitable, org.eclipse.ocl.pivot.Element>();
	
//	private final @NonNull Set<org.eclipse.ocl.utilities.Visitable> references = new HashSet<org.eclipse.ocl.utilities.Visitable>();

	public TraditionalToPivotMapping(QVToFacade qvto) {
		this.qvto = qvto;
		this.declarationVisitor = new TraditionalQVTo2PivotDeclarationVisitor(this);
		this.referenceVisitor = new TraditionalQVTo2PivotReferenceVisitor(this);
	}
	
	/**
	 * adds parameters to traditional2pivot Hashmap,
	 * set ESObject for pivot Element
	 * @param astNode
	 * @param pivotElement
	 * @return
	 */
	public <T extends org.eclipse.ocl.pivot.Element> T addCreated(org.eclipse.ocl.utilities.Visitable astNode, T pivotElement) {
		Element oldPivotElement = traditional2pivot.put(astNode,  pivotElement);
		assert oldPivotElement == null: "reconversion of " + debugId(astNode);
		((PivotObjectImpl) pivotElement).setESObject(astNode);
		String astNodeString;
		try {
			astNodeString = astNode.toString();
		}
		catch (Exception e) {
			astNodeString = e.toString();
		}
		TraditionalToPivotMapping.CREATION.println("Created " + debugId(pivotElement)
				+ " from " + debugId(astNode) + ": " + astNodeString);
		assert oldPivotElement == null;
		return (T)pivotElement;
	}

	public org.eclipse.ocl.pivot.Element basicGetPivot(@NonNull EObject astNode) {
		return traditional2pivot.get(astNode);
	}
	
	public org.eclipse.ocl.pivot.Model convert(org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation operationalTransformation) {
		operationalTransformation.accept(declarationVisitor);	
		for (org.eclipse.ocl.utilities.Visitable astNode : traditional2pivot.keySet()) {
			astNode.accept(referenceVisitor);
		}
		pivotTransformation = (org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation)traditional2pivot.get(operationalTransformation);
		org.eclipse.ocl.pivot.Package pivotPackage = (org.eclipse.ocl.pivot.Package)pivotTransformation.eContainer();
		org.eclipse.ocl.pivot.Model pivotModel = PivotFactory.eINSTANCE.createModel();
		pivotModel.setName("tx");
		pivotModel.getOwnedPackages().add(pivotPackage);
		return pivotModel;
	}

	public @NonNull CompleteModel getCompleteModel() {
		return qvto.getCompleteEnvironment().getOwnedCompleteModel();
	}

	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return qvto.getEnvironmentFactory();
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return qvto.getMetamodelManager();
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return qvto.getStandardLibrary();
	}

	public org.eclipse.ocl.pivot.Element getPivot(@NonNull EObject astNode) {
		Element element = traditional2pivot.get(astNode);
		assert element != null : "No pivot for " + debugId(astNode) + " contained by " + debugId(astNode.eContainer()) + "::" + astNode.eContainingFeature().getName();
		return element;
	}

	public @Nullable <T extends Element> T getPivotOfEcore(@NonNull Class<T> pivotClass, @Nullable EObject eObject) {
		return qvto.getMetamodelManager().getASOfEcore(pivotClass, eObject);
	}

	
	public QVToFacade getQVTo() {
		return qvto;
	}

	public @NonNull OperationalTransformation getTransformation() {
		// TODO Auto-generated method stub
		return pivotTransformation;
	}
	
//	public void queueReference(org.eclipse.ocl.utilities.Visitable astNode) {
//		references.add(astNode);
//	}
}
