package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner; // Import the Scanner class

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class Assistant {

	public static void voice_command() {
		Configuration config = new Configuration();

		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("assistant/src/main/resources/project/5423.dic");

		config.setLanguageModelPath("assistant/src/main/resources/project/5423.lm");

		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);

			SpeechResult speechResult = null;

			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);

				if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome ");
				} else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				} else if (voiceCommand.equalsIgnoreCase("Check email")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome outlook.office.com/mail/");
				} else if (voiceCommand.equalsIgnoreCase("Check weather")) {
					Runtime.getRuntime().exec(
							"cmd.exe /c start chrome https://www.accuweather.com/en/pk/karachi/261158/weather-forecast/261158");
				} else if (voiceCommand.equalsIgnoreCase("whats the weather today?")) {
					Runtime.getRuntime().exec(
							"cmd.exe /c start chrome https://www.accuweather.com/en/pk/karachi/261158/weather-forecast/261158");
				} else if (voiceCommand.equalsIgnoreCase("open calculator")) {
					Runtime.getRuntime().exec("cmd.exe /c start calc");
				} else if (voiceCommand.equalsIgnoreCase("open whatsapp")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome web.whatsapp.com");
				} else if (voiceCommand.equalsIgnoreCase("open canvas")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome lms.habib.edu.pk");
				} else if (voiceCommand.equalsIgnoreCase("open PSCS")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome pscs.habib.edu.pk");
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void type_command() {
		System.out.println("Type your command");
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		// Scanner input = new Scanner(System.in); // Create a Scanner object
		String command = myObj.nextLine(); // Read user input

		if (command.toLowerCase().equals("google")) {
			// do something
		}
		try {
			if (command.toLowerCase().equals("Open Chrome")) {
				Runtime.getRuntime().exec("cmd.exe /c start chrome ");
			} else if (command.toLowerCase().equals("Close Chrome")) {
				Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
			} else if (command.toLowerCase().equals("Check email")) {
				Runtime.getRuntime().exec("cmd.exe /c start chrome outlook.office.com/mail/");
			} else if (command.toLowerCase().equals("Check weather")) {
				Runtime.getRuntime().exec(
						"cmd.exe /c start chrome https://www.accuweather.com/en/pk/karachi/261158/weather-forecast/261158");
			} else if (command.toLowerCase().equals("whats the weather today?")) {
				Runtime.getRuntime().exec(
						"cmd.exe /c start chrome https://www.accuweather.com/en/pk/karachi/261158/weather-forecast/261158");
			} else if (command.toLowerCase().equals("open calculator")) {
				Runtime.getRuntime().exec("cmd.exe /c start calc");
			} else if (command.toLowerCase().equals("open whatsapp")) {
				Runtime.getRuntime().exec("cmd.exe /c start chrome web.whatsapp.com");
			} else if (command.toLowerCase().equals("open canvas")) {
				Runtime.getRuntime().exec("cmd.exe /c start chrome lms.habib.edu.pk");
			} else if (command.toLowerCase().equals("open PSCS")) {
				Runtime.getRuntime().exec("cmd.exe /c start chrome pscs.habib.edu.pk");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] st) {

		// option to type or speak
		System.out.println("Do you want to type or speak?");
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		String mode = myObj.nextLine(); // Read user input

		if (mode.equals("speak")) {
			voice_command();
		} else {
			type_command();
		}
		myObj.close();

	}
}