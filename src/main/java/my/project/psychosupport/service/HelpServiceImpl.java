package my.project.psychosupport.service;

import my.project.psychosupport.logging.Logged;
import my.project.psychosupport.repository.HelpRepository;

import java.util.Random;

/**
 * Сервисный класс для работы с сообщениями поддержки.
 * Обеспечивает бизнес-логику приложения.
 */
@Logged

public class HelpServiceImpl implements HelpService {

	private final HelpRepository helpRepo;

	public HelpServiceImpl(HelpRepository helpRepo) {
		this.helpRepo = helpRepo;
	}

	/**
	 * Возвращает случайное сообщение из хранилища.
	 *
	 * @return Случайное сообщение поддержки или уведомление о пустом хранилище
	 */
	@Override
	public String getRandomHelpMessage() {
		Random rand = new Random();
		int size = helpRepo.getLength();
		if (size == 0) {
			return "Пока нет сообщений поддержки. Пожалуйста, добавьте своё!";
		}
		int index = rand.nextInt(size);
		return helpRepo.getHelpMessageById(index);
	}

	/**
	 * Сохраняет новое сообщение в хранилище.
	 *
	 * @param message Текст сообщения для сохранения
	 * @throws IllegalArgumentException если сообщение null или пустое
	 */
	@Override
	public void saveHelpMessage(String message) {
		helpRepo.saveHelpMessage(message);
	}
}