package fr.inria.diverse.dmgen.launcher

import fr.inria.diverse.dmgen.launcher.ExecutionEnvImpl
import org.eclipse.core.runtime.CoreException
import java.io.IOException
import java.io.File
import java.io.FileNotFoundException
import java.util.List
import java.util.ArrayList

class LocalExecutionEnvImpl extends ExecutionEnvImpl {
	
//	def boolean isWindows() {
//        var os = System.getProperty("os.name")
//        if (os == null) {
//            throw new IllegalStateException("os.name")
//        }
//        os = os.toLowerCase()
//        os.startsWith("windows")
//    }
//
//    def File getJreExecutable() throws FileNotFoundException {
//        val jreDirectory = System.getProperty("java.home")
//        if (jreDirectory == null) {
//            throw new IllegalStateException("java.home")
//        }
//        var File exe
//        if (isWindows()) {
//            exe = new File(jreDirectory, "bin/java.exe")
//        } else {
//            exe = new File(jreDirectory, "bin/java")
//        }
//        if (!exe.isFile()) {
//            throw new FileNotFoundException(exe.toString())
//        }
//        return exe
//    }
//
//    def  int launch(List<String> cmdarray) throws IOException,
//            InterruptedException {
//        val byte[] buffer = newByteArrayOfSize(1024)
//
//        val processBuilder = new ProcessBuilder(cmdarray)
//        processBuilder.redirectErrorStream(true)
//        val process = processBuilder.start
//        val in = process.inputStream
//        var boolean stop = false
//        while (!stop) {
//            val r = in.read(buffer)
//            if (r <= 0) {
//                stop = true
//            }
//            System.out.write(buffer, 0, r)
//        }
//        return process.waitFor()
//    }

	override launch() throws CoreException {
		
	}
	
	override setupEnv() throws IOException, CoreException {
		//Nothing to do 
	}
	
}