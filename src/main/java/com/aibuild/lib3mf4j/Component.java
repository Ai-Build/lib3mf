/*++

Copyright (C) 2019 3MF Consortium (Original Author)

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

This file has been generated by the Automatic Component Toolkit (ACT) version 1.7.0-develop.

Abstract: This is an autogenerated Java file in order to allow an easy
 use of the 3MF Library

Interface version: 2.0.0

*/

package com.aibuild.lib3mf4j;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import java.lang.ref.Cleaner;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Component extends Base {

	public Component(Lib3MFWrapper wrapper, Pointer handle) {
		super(wrapper, handle);
	}

	/**
	 * Returns the Resource Instance of the component..
	 *
	 * @return filled with the Resource Instance.
	 * @throws Lib3MFException
	 */
	public Object getObjectResource() throws Lib3MFException {
		Pointer bufferObjectResource = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_component_getobjectresource.invokeInt(new java.lang.Object[]{mHandle, bufferObjectResource}));
		Pointer valueObjectResource = bufferObjectResource.getPointer(0);
		Object objectResource = null;
		if (valueObjectResource == Pointer.NULL) {
		  throw new Lib3MFException(Lib3MFException.LIB3MF_ERROR_INVALIDPARAM, "ObjectResource was a null pointer");
		}
		objectResource = new Object(mWrapper, valueObjectResource);
		return objectResource;
	}

	/**
	 * Returns the Resource ID of the component.
	 *
	 * @return returns the Resource ID.
	 * @throws Lib3MFException
	 */
	public int getObjectResourceID() throws Lib3MFException {
		Pointer bufferObjectResourceID = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_component_getobjectresourceid.invokeInt(new java.lang.Object[]{mHandle, bufferObjectResourceID}));
		return bufferObjectResourceID.getInt(0);
	}

	/**
	 * returns, whether a component has a UUID and, if true, the component's UUID
	 *
	 * @return GetUUID Result Tuple
	 * @throws Lib3MFException
	 */
	public GetUUIDResult getUUID() throws Lib3MFException {
		Pointer bufferHasUUID = new Memory(1);
		Pointer bytesNeededUUID = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_component_getuuid.invokeInt(new java.lang.Object[]{mHandle, bufferHasUUID, 0, bytesNeededUUID, null}));
		int sizeUUID = bytesNeededUUID.getInt(0);
		Pointer bufferUUID = new Memory(sizeUUID);
		mWrapper.checkError(this, mWrapper.lib3mf_component_getuuid.invokeInt(new java.lang.Object[]{mHandle, bufferHasUUID, sizeUUID, bytesNeededUUID, bufferUUID}));
		GetUUIDResult returnTuple = new GetUUIDResult();
		returnTuple.HasUUID = bufferHasUUID.getByte(0) != 0;
		returnTuple.UUID = new String(bufferUUID.getByteArray(0, sizeUUID - 1), StandardCharsets.UTF_8);
		return returnTuple;
	}

	public static class GetUUIDResult {
		/**
		 * flag whether the component has a UUID
		 */
		public boolean HasUUID;

		/**
		 * the UUID as string of the form 'xxxxxxxx-xxxx-xxxx-xxxxxxxxxxxxxxxx'
		 */
		public String UUID;

	}
	/**
	 * sets the component's UUID
	 *
	 * @param uUID the UUID as string of the form 'xxxxxxxx-xxxx-xxxx-xxxxxxxxxxxxxxxx'
	 * @throws Lib3MFException
	 */
	public void setUUID(String uUID) throws Lib3MFException {
		byte[] bytesUUID = uUID.getBytes(StandardCharsets.UTF_8);
		Memory bufferUUID = new Memory(bytesUUID.length + 1);
		bufferUUID.write(0, bytesUUID, 0, bytesUUID.length);
		bufferUUID.setByte(bytesUUID.length, (byte)0);
		mWrapper.checkError(this, mWrapper.lib3mf_component_setuuid.invokeInt(new java.lang.Object[]{mHandle, bufferUUID}));
	}

	/**
	 * Returns, if the component has a different transformation than the identity matrix
	 *
	 * @return if true is returned, the transformation is not equal than the identity
	 * @throws Lib3MFException
	 */
	public boolean hasTransform() throws Lib3MFException {
		Pointer bufferHasTransform = new Memory(1);
		mWrapper.checkError(this, mWrapper.lib3mf_component_hastransform.invokeInt(new java.lang.Object[]{mHandle, bufferHasTransform}));
		return bufferHasTransform.getByte(0) != 0;
	}

	/**
	 * Returns the transformation matrix of the component.
	 *
	 * @return filled with the component transformation matrix
	 * @throws Lib3MFException
	 */
	public Transform getTransform() throws Lib3MFException {
		Pointer bufferTransform = new Memory(Transform.SIZE);
		mWrapper.checkError(this, mWrapper.lib3mf_component_gettransform.invokeInt(new java.lang.Object[]{mHandle, bufferTransform}));
		Transform transform = new Transform();
		transform.readFromPointer(bufferTransform, 0);
		return transform;
	}

	/**
	 * Sets the transformation matrix of the component.
	 *
	 * @param transform new transformation matrix
	 * @throws Lib3MFException
	 */
	public void setTransform(Transform transform) throws Lib3MFException {
		Pointer bufferTransform = new Memory(Transform.SIZE);
		transform.writeToPointer(bufferTransform, 0);
		mWrapper.checkError(this, mWrapper.lib3mf_component_settransform.invokeInt(new java.lang.Object[]{mHandle, bufferTransform}));
	}


}

