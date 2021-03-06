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

public class SliceStack extends Resource {

	public SliceStack(Lib3MFWrapper wrapper, Pointer handle) {
		super(wrapper, handle);
	}

	/**
	 * Get the lower Z-Coordinate of the slice stack.
	 *
	 * @return the lower Z-Coordinate the slice stack
	 * @throws Lib3MFException
	 */
	public double getBottomZ() throws Lib3MFException {
		Pointer bufferZBottom = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_getbottomz.invokeInt(new java.lang.Object[]{mHandle, bufferZBottom}));
		return bufferZBottom.getDouble(0);
	}

	/**
	 * Returns the number of slices
	 *
	 * @return the number of slices
	 * @throws Lib3MFException
	 */
	public long getSliceCount() throws Lib3MFException {
		Pointer bufferCount = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_getslicecount.invokeInt(new java.lang.Object[]{mHandle, bufferCount}));
		return bufferCount.getLong(0);
	}

	/**
	 * Query a slice from the slice stack
	 *
	 * @param sliceIndex the index of the slice
	 * @return the Slice instance
	 * @throws Lib3MFException
	 */
	public Slice getSlice(long sliceIndex) throws Lib3MFException {
		Pointer bufferTheSlice = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_getslice.invokeInt(new java.lang.Object[]{mHandle, sliceIndex, bufferTheSlice}));
		Pointer valueTheSlice = bufferTheSlice.getPointer(0);
		Slice theSlice = null;
		if (valueTheSlice == Pointer.NULL) {
		  throw new Lib3MFException(Lib3MFException.LIB3MF_ERROR_INVALIDPARAM, "TheSlice was a null pointer");
		}
		theSlice = new Slice(mWrapper, valueTheSlice);
		return theSlice;
	}

	/**
	 * Returns the number of slices
	 *
	 * @param zTop upper Z coordinate of the slice
	 * @return a new Slice instance
	 * @throws Lib3MFException
	 */
	public Slice addSlice(double zTop) throws Lib3MFException {
		Pointer bufferTheSlice = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_addslice.invokeInt(new java.lang.Object[]{mHandle, zTop, bufferTheSlice}));
		Pointer valueTheSlice = bufferTheSlice.getPointer(0);
		Slice theSlice = null;
		if (valueTheSlice == Pointer.NULL) {
		  throw new Lib3MFException(Lib3MFException.LIB3MF_ERROR_INVALIDPARAM, "TheSlice was a null pointer");
		}
		theSlice = new Slice(mWrapper, valueTheSlice);
		return theSlice;
	}

	/**
	 * Returns the number of slice refs
	 *
	 * @return the number of slicereferences
	 * @throws Lib3MFException
	 */
	public long getSliceRefCount() throws Lib3MFException {
		Pointer bufferCount = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_getslicerefcount.invokeInt(new java.lang.Object[]{mHandle, bufferCount}));
		return bufferCount.getLong(0);
	}

	/**
	 * Adds another existing slicestack as sliceref in this slicestack
	 *
	 * @param theSliceStack the slicestack to use as sliceref
	 * @throws Lib3MFException
	 */
	public void addSliceStackReference(SliceStack theSliceStack) throws Lib3MFException {
		Pointer theSliceStackHandle = null;
		if (theSliceStack != null) {
			theSliceStackHandle = theSliceStack.getHandle();
		} else {
			throw new Lib3MFException(Lib3MFException.LIB3MF_ERROR_INVALIDPARAM, "TheSliceStack is a null value.");
		}
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_addslicestackreference.invokeInt(new java.lang.Object[]{mHandle, theSliceStackHandle}));
	}

	/**
	 * Adds another existing slicestack as sliceref in this slicestack
	 *
	 * @param sliceRefIndex the index of the slice ref
	 * @return the slicestack that is used as sliceref
	 * @throws Lib3MFException
	 */
	public SliceStack getSliceStackReference(long sliceRefIndex) throws Lib3MFException {
		Pointer bufferTheSliceStack = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_getslicestackreference.invokeInt(new java.lang.Object[]{mHandle, sliceRefIndex, bufferTheSliceStack}));
		Pointer valueTheSliceStack = bufferTheSliceStack.getPointer(0);
		SliceStack theSliceStack = null;
		if (valueTheSliceStack == Pointer.NULL) {
		  throw new Lib3MFException(Lib3MFException.LIB3MF_ERROR_INVALIDPARAM, "TheSliceStack was a null pointer");
		}
		theSliceStack = new SliceStack(mWrapper, valueTheSliceStack);
		return theSliceStack;
	}

	/**
	 * Removes the indirection of slices via slice-refs, i.e. creates the slices of all slice refs of this SliceStack as actual slices of this SliceStack. All previously existing slices or slicerefs will be removed.
	 *
	 * @throws Lib3MFException
	 */
	public void collapseSliceReferences() throws Lib3MFException {
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_collapseslicereferences.invokeInt(new java.lang.Object[]{mHandle}));
	}

	/**
	 * Sets the package path where this Slice should be stored. Input an empty string to reset the path
	 *
	 * @param path the package path where this Slice should be stored
	 * @throws Lib3MFException
	 */
	public void setOwnPath(String path) throws Lib3MFException {
		byte[] bytesPath = path.getBytes(StandardCharsets.UTF_8);
		Memory bufferPath = new Memory(bytesPath.length + 1);
		bufferPath.write(0, bytesPath, 0, bytesPath.length);
		bufferPath.setByte(bytesPath.length, (byte)0);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_setownpath.invokeInt(new java.lang.Object[]{mHandle, bufferPath}));
	}

	/**
	 * Obtains the package path where this Slice should be stored. Returns an empty string if the slicestack is stored within the root model.
	 *
	 * @return the package path where this Slice will be stored
	 * @throws Lib3MFException
	 */
	public String getOwnPath() throws Lib3MFException {
		Pointer bytesNeededPath = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_getownpath.invokeInt(new java.lang.Object[]{mHandle, 0, bytesNeededPath, null}));
		int sizePath = bytesNeededPath.getInt(0);
		Pointer bufferPath = new Memory(sizePath);
		mWrapper.checkError(this, mWrapper.lib3mf_slicestack_getownpath.invokeInt(new java.lang.Object[]{mHandle, sizePath, bytesNeededPath, bufferPath}));
		return new String(bufferPath.getByteArray(0, sizePath - 1), StandardCharsets.UTF_8);
	}


}

