package my.project.psychosupport;

import java.util.ArrayList;
import java.util.List;

public class HelpRepository {

	private final List<String> helpMessages =  new ArrayList<>();

	public void saveHelpMessage(String message) {
		helpMessages.add(message);
	}

	public String getHelpMessageById(int index) {
		return helpMessages.get(index);
	}

	public int getLength() {
		return helpMessages.size();
	}
}
