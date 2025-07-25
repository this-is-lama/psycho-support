package my.project.psychosupport.logging;

import my.project.psychosupport.service.HelpService;

public class LoggingHelpService implements HelpService {

	private final HelpService helpService;

	public LoggingHelpService(HelpService helpService) {
		this.helpService = helpService;
	}

	@Override
	public String getRandomHelpMessage() {
		System.out.println("Начало метода");
		String message = helpService.getRandomHelpMessage();
		System.out.println("Конец метода");
		return message;
	}

	@Override
	public void saveHelpMessage(String message) {
		helpService.saveHelpMessage(message);
	}
}
