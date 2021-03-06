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

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

import java.util.Arrays;
import java.util.List;

public class Transform {

	public float[][] Fields = new float[3][4];

	public static final int SIZE = 48;

	public void readFromPointer(Pointer p, long offset) {
		Fields[0][0] = p.getFloat(offset + 0);
		Fields[0][1] = p.getFloat(offset + 4);
		Fields[0][2] = p.getFloat(offset + 8);
		Fields[0][3] = p.getFloat(offset + 12);
		Fields[1][0] = p.getFloat(offset + 16);
		Fields[1][1] = p.getFloat(offset + 20);
		Fields[1][2] = p.getFloat(offset + 24);
		Fields[1][3] = p.getFloat(offset + 28);
		Fields[2][0] = p.getFloat(offset + 32);
		Fields[2][1] = p.getFloat(offset + 36);
		Fields[2][2] = p.getFloat(offset + 40);
		Fields[2][3] = p.getFloat(offset + 44);
	}

	public void writeToPointer(Pointer p, long offset) {
		p.setFloat(offset + 0, Fields[0][0]);
		p.setFloat(offset + 4, Fields[0][1]);
		p.setFloat(offset + 8, Fields[0][2]);
		p.setFloat(offset + 12, Fields[0][3]);
		p.setFloat(offset + 16, Fields[1][0]);
		p.setFloat(offset + 20, Fields[1][1]);
		p.setFloat(offset + 24, Fields[1][2]);
		p.setFloat(offset + 28, Fields[1][3]);
		p.setFloat(offset + 32, Fields[2][0]);
		p.setFloat(offset + 36, Fields[2][1]);
		p.setFloat(offset + 40, Fields[2][2]);
		p.setFloat(offset + 44, Fields[2][3]);
	}

}

