package org.eclipse.m2m.atl.adt.launching;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;

/**
 * Contains all data necessary to launch the ATL VM. 
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
//TODO use this class to improve AtlVM/AtlLauncher interface
public class AtlLaunchConfiguration {
	
	public class ASMEntry {
		private ASM asm = null;

		public ASM getASM() {
			return asm;
		}

		public void setASM(ASM asm) {
			this.asm = asm;
		}

		public void setASMFromURL(URL asmurl) throws IOException {
			this.asm = new ASMXMLReader().read(new BufferedInputStream(asmurl.openStream()));
		}
	}
	
	private ASMEntry main = null;
	private HashMap libs = new HashMap();

	public ASMEntry getMain() {
		return main;
	}

	public void setMain(ASMEntry main) {
		this.main = main;
	}

	
}
