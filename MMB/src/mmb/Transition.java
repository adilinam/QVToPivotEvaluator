/**
 */
package mmb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mmb.Transition#getEvent <em>Event</em>}</li>
 *   <li>{@link mmb.Transition#getSourceMode <em>Source Mode</em>}</li>
 *   <li>{@link mmb.Transition#getTargetMode <em>Target Mode</em>}</li>
 * </ul>
 *
 * @see mmb.MmbPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' attribute.
	 * @see #setEvent(String)
	 * @see mmb.MmbPackage#getTransition_Event()
	 * @model
	 * @generated
	 */
	String getEvent();

	/**
	 * Sets the value of the '{@link mmb.Transition#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(String value);

	/**
	 * Returns the value of the '<em><b>Source Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Mode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Mode</em>' reference.
	 * @see #setSourceMode(Mode)
	 * @see mmb.MmbPackage#getTransition_SourceMode()
	 * @model required="true"
	 * @generated
	 */
	Mode getSourceMode();

	/**
	 * Sets the value of the '{@link mmb.Transition#getSourceMode <em>Source Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Mode</em>' reference.
	 * @see #getSourceMode()
	 * @generated
	 */
	void setSourceMode(Mode value);

	/**
	 * Returns the value of the '<em><b>Target Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Mode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Mode</em>' reference.
	 * @see #setTargetMode(Mode)
	 * @see mmb.MmbPackage#getTransition_TargetMode()
	 * @model required="true"
	 * @generated
	 */
	Mode getTargetMode();

	/**
	 * Sets the value of the '{@link mmb.Transition#getTargetMode <em>Target Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Mode</em>' reference.
	 * @see #getTargetMode()
	 * @generated
	 */
	void setTargetMode(Mode value);

} // Transition
