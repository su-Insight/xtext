/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescriptionProvider;
import org.eclipse.xtext.resource.persistence.SerializationExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.8
 */
@Accessors
@SuppressWarnings("all")
public class SerializableEObjectDescription implements IEObjectDescription, Externalizable, SerializableEObjectDescriptionProvider {
  protected URI eObjectURI;
  
  protected EClass eClass;
  
  protected QualifiedName qualifiedName;
  
  protected HashMap<String, String> userData;
  
  @Accessors(AccessorType.NONE)
  protected transient EObject eObjectOrProxy;
  
  public void updateResourceURI(final URI uri) {
    String _fragment = this.eObjectURI.fragment();
    URI _appendFragment = uri.appendFragment(_fragment);
    this.eObjectURI = _appendFragment;
  }
  
  @Override
  public EObject getEObjectOrProxy() {
    if ((this.eObjectOrProxy == null)) {
      final EObject proxy = EcoreUtil.create(this.eClass);
      ((InternalEObject) proxy).eSetProxyURI(this.eObjectURI);
      this.eObjectOrProxy = proxy;
    }
    return this.eObjectOrProxy;
  }
  
  @Override
  public QualifiedName getName() {
    return this.qualifiedName;
  }
  
  @Override
  public String getUserData(final String key) {
    return this.userData.get(key);
  }
  
  @Override
  public String[] getUserDataKeys() {
    return ((String[])Conversions.unwrapArray(this.userData.keySet(), String.class));
  }
  
  @Override
  public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    URI _readURI = SerializationExtensions.readURI(in);
    this.eObjectURI = _readURI;
    EClass _readEcoreElement = SerializationExtensions.<EClass>readEcoreElement(in);
    this.eClass = _readEcoreElement;
    QualifiedName _readQualifiedName = SerializationExtensions.readQualifiedName(in);
    this.qualifiedName = _readQualifiedName;
    HashMap<String, String> _readCastedObject = SerializationExtensions.<HashMap<String, String>>readCastedObject(in);
    this.userData = _readCastedObject;
  }
  
  @Override
  public void writeExternal(final ObjectOutput out) throws IOException {
    SerializationExtensions.writeURI(out, this.eObjectURI);
    URI _uRI = EcoreUtil.getURI(this.eClass);
    SerializationExtensions.writeURI(out, _uRI);
    SerializationExtensions.writeQualifiedName(out, this.qualifiedName);
    out.writeObject(this.userData);
  }
  
  @Override
  public SerializableEObjectDescription toSerializableEObjectDescription() {
    return this;
  }
  
  @Pure
  public URI getEObjectURI() {
    return this.eObjectURI;
  }
  
  public void setEObjectURI(final URI eObjectURI) {
    this.eObjectURI = eObjectURI;
  }
  
  @Pure
  public EClass getEClass() {
    return this.eClass;
  }
  
  public void setEClass(final EClass eClass) {
    this.eClass = eClass;
  }
  
  @Pure
  public QualifiedName getQualifiedName() {
    return this.qualifiedName;
  }
  
  public void setQualifiedName(final QualifiedName qualifiedName) {
    this.qualifiedName = qualifiedName;
  }
  
  @Pure
  public HashMap<String, String> getUserData() {
    return this.userData;
  }
  
  public void setUserData(final HashMap<String, String> userData) {
    this.userData = userData;
  }
}
