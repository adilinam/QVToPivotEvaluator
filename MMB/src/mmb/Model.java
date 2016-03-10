/**
 */
package mmb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mmb.Model#getName <em>Name</em>}</li>
 *   <li>{@link mmb.Model#getAutomata <em>Automata</em>}</li>
 * </ul>
 *
 * @see mmb.MmbPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mmb.MmbPackage#getModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mmb.Model#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Automata</b></em>' containment reference list.
	 * The list contents are of type {@link mmb.Automaton}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automata</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automata</em>' containment reference list.
	 * @see mmb.MmbPackage#getModel_Automata()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Automaton> getAutomata();

} // Model
