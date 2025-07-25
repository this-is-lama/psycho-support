package my.project.psychosupport.repository;

public interface HelpRepository {
	void saveHelpMessage(String message);

	String getHelpMessageById(int index);

	int getLength();
}
