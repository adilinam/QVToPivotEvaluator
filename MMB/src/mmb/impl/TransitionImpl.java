/**
 */
package mmb.impl;

import mmb.MmbPackage;
import mmb.Mode;
import mmb.Transition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mmb.impl.TransitionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link mmb.impl.TransitionImpl#getSourceMode <em>Source Mode</em>}</li>
 *   <li>{@link mmb.impl.TransitionImpl#getTargetMode <em>Target Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
	/**
	 * The default value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected String event = EVENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceMode() <em>Source Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMode()
	 * @generated
	 * @ordered
	 */
	protected Mode sourceMode;

	/**
	 * The cached value of the '{@link #getTargetMode() <em>Target Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMode()
	 * @generated
	 * @ordered
	 */
	protected Mode targetMode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MmbPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(String newEvent) {
		String oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmbPackage.TRANSITION__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getSourceMode() {
		if (sourceMode != null && sourceMode.eIsProxy()) {
			InternalEObject oldSourceMode = (InternalEObject)sourceMode;
			sourceMode = (Mode)eResolveProxy(oldSourceMode);
			if (sourceMode != oldSourceMode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MmbPackage.TRANSITION__SOURCE_MODE, oldSourceMode, sourceMode));
			}
		}
		return sourceMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetSourceMode() {
		return sourceMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMode(Mode newSourceMode) {
		Mode oldSourceMode = sourceMode;
		sourceMode = newSourceMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmbPackage.TRANSITION__SOURCE_MODE, oldSourceMode, sourceMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getTargetMode() {
		if (targetMode != null && targetMode.eIsProxy()) {
			InternalEObject oldTargetMode = (InternalEObject)targetMode;
			targetMode = (Mode)eResolveProxy(oldTargetMode);
			if (targetMode != oldTargetMode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MmbPackage.TRANSITION__TARGET_MODE, oldTargetMode, targetMode));
			}
		}
		return targetMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetTargetMode() {
		return targetMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMode(Mode newTargetMode) {
		Mode oldTargetMode = targetMode;
		targetMode = newTargetMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmbPackage.TRANSITION__TARGET_MODE, oldTargetMode, targetMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MmbPackage.TRANSITION__EVENT:
				return getEvent();
			case MmbPackage.TRANSITION__SOURCE_MODE:
				if (resolve) return getSourceMode();
				return basicGetSourceMode();
			case MmbPackage.TRANSITION__TARGET_MODE:
				if (resolve) return getTargetMode();
				return basicGetTargetMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MmbPackage.TRANSITION__EVENT:
				setEvent((String)newValue);
				return;
			case MmbPackage.TRANSITION__SOURCE_MODE:
				setSourceMode((Mode)newValue);
				return;
			case MmbPackage.TRANSITION__TARGET_MODE:
				setTargetMode((Mode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MmbPackage.TRANSITION__EVENT:
				setEvent(EVENT_EDEFAULT);
				return;
			case MmbPackage.TRANSITION__SOURCE_MODE:
				setSourceMode((Mode)null);
				return;
			case MmbPackage.TRANSITION__TARGET_MODE:
				setTargetMode((Mode)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MmbPackage.TRANSITION__EVENT:
				return EVENT_EDEFAULT == null ? event != null : !EVENT_EDEFAULT.equals(event);
			case MmbPackage.TRANSITION__SOURCE_MODE:
				return sourceMode != null;
			case MmbPackage.TRANSITION__TARGET_MODE:
				return targetMode != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Event: ");
		result.append(event);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
