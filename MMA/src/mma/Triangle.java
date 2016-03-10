/**
 */
package mma;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mma.Triangle#getSide <em>Side</em>}</li>
 * </ul>
 *
 * @see mma.MmaPackage#getTriangle()
 * @model
 * @generated
 */
public interface Triangle extends Location {
	/**
	 * Returns the value of the '<em><b>Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Side</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Side</em>' attribute.
	 * @see #setSide(double)
	 * @see mma.MmaPackage#getTriangle_Side()
	 * @model
	 * @generated
	 */
	double getSide();

	/**
	 * Sets the value of the '{@link mma.Triangle#getSide <em>Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Side</em>' attribute.
	 * @see #getSide()
	 * @generated
	 */
	void setSide(double value);

} // Triangle
