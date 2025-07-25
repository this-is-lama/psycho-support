package my.project.psychosupport.config;

import my.project.psychosupport.service.HelpService;
import my.project.psychosupport.service.HelpServiceImpl;
import my.project.psychosupport.repository.HelpRepository;
import my.project.psychosupport.repository.HelpRepositoryImpl;

@Config
public class HelpConfig {

	@Instance
	public HelpService helpService() {
		return new HelpServiceImpl(helpRepository());
	}

	@Instance
	public HelpRepository helpRepository() {
		return new HelpRepositoryImpl();
	}
}
