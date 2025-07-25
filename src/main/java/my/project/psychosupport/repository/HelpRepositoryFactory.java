package my.project.psychosupport.repository;

public class HelpRepositoryFactory {

	private static final HelpRepository INSTANCE;

	static {
		INSTANCE = new HelpRepositoryImpl();
	}

	public static HelpRepository getInstance() {
		return INSTANCE;
	}
}
