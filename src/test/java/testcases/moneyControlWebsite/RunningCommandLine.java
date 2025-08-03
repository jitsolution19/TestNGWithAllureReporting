package testcases.moneyControlWebsite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningCommandLine {

	public static void main(String[] args) throws IOException, InterruptedException {
		deleteExistingChromeDriver();
	}

	public static void deleteExistingChromeDriver() throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "taskkill /f /im chrome.exe");

		// Start the process
		Process process = builder.start();

		// Read the output
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		// Wait for the process to complete
		int exitCode = process.waitFor();
		System.out.println("Exited with code: " + exitCode);	
	}
}
