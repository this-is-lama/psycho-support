package my.project.psychosupport;

import java.util.Random;

public class HelpService {

	private final HelpRepository helpRepo = new HelpRepository();

	public String getRandomHelpMessage() {
		Random rand = new Random();
		int size = helpRepo.getLength();
		if (size == 0) {
			return "Хранилище пусто!";
		}
		int index = rand.nextInt(size);
		return helpRepo.getHelpMessageById(index);
	}


	public void saveHelpMessage(String message) {
		helpRepo.saveHelpMessage(message);
	}

}
