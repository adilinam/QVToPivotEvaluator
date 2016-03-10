/**
 */
package mma;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rectangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mma.Rectangle#getEdge <em>Edge</em>}</li>
 * </ul>
 *
 * @see mma.MmaPackage#getRectangle()
 * @model
 * @generated
 */
public interface Rectangle extends Location {
	/**
	 * Returns the value of the '<em><b>Edge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' attribute.
	 * @see #setEdge(double)
	 * @see mma.MmaPackage#getRectangle_Edge()
	 * @model
	 * @generated
	 */
	double getEdge();

	/**
	 * Sets the value of the '{@link mma.Rectangle#getEdge <em>Edge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' attribute.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(double value);

} // Rectangle
