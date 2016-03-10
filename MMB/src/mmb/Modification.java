/**
 */
package mmb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mmb.Modification#getVarName <em>Var Name</em>}</li>
 *   <li>{@link mmb.Modification#getVarType <em>Var Type</em>}</li>
 * </ul>
 *
 * @see mmb.MmbPackage#getModification()
 * @model
 * @generated
 */
public interface Modification extends EObject {
	/**
	 * Returns the value of the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Name</em>' attribute.
	 * @see #setVarName(String)
	 * @see mmb.MmbPackage#getModification_VarName()
	 * @model
	 * @generated
	 */
	String getVarName();

	/**
	 * Sets the value of the '{@link mmb.Modification#getVarName <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' attribute.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(String value);

	/**
	 * Returns the value of the '<em><b>Var Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Type</em>' attribute.
	 * @see #setVarType(String)
	 * @see mmb.MmbPackage#getModification_VarType()
	 * @model
	 * @generated
	 */
	String getVarType();

	/**
	 * Sets the value of the '{@link mmb.Modification#getVarType <em>Var Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Type</em>' attribute.
	 * @see #getVarType()
	 * @generated
	 */
	void setVarType(String value);

} // Modification
