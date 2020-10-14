/**
 * 
 */
package Presentacion.Controlador;

import Presentacion.Comando.Comando.IDEvento;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author marti
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class RespuestaComando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IDEvento evento;

	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object datos;


	/** 
	 * @return el evento
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IDEvento getEvento() {
		return evento;
	}

	/** 
	 * @param evento el ID_Evento a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEvento(IDEvento evento) {
		this.evento = evento;
	}

	/** 
	 * @return el datos
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object getDatos() {
		return datos;
	}

	/** 
	 * @param datos el Datos a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDatos(Object datos) {
		this.datos = datos;
	}

}