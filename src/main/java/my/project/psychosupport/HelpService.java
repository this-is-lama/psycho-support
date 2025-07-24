package my.project.psychosupport;

import java.util.Random;

/**
 * Сервисный класс для работы с сообщениями поддержки.
 * Обеспечивает бизнес-логику приложения.
 */
public class HelpService {

	private final HelpRepository helpRepo = new HelpRepository();

	/**
	 * Возвращает случайное сообщение из хранилища.
	 *
	 * @return Случайное сообщение поддержки или уведомление о пустом хранилище
	 */
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
	public void saveHelpMessage(String message) {
		helpRepo.saveHelpMessage(message);
	}
}