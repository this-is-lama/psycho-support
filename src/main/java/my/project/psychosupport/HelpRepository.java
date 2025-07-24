package my.project.psychosupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-репозиторий для хранения и управления сообщениями психологической поддержки.
 * Обеспечивает базовые CRUD-операции для работы с сообщениями.
 */
public class HelpRepository {

	private final List<String> helpMessages = new ArrayList<>();

	/**
	 * Сохраняет новое сообщение поддержки в хранилище.
	 *
	 * @param message Текст сообщения для сохранения
	 * @throws IllegalArgumentException если сообщение null или пустое
	 */
	public void saveHelpMessage(String message) {
		helpMessages.add(message);
	}

	/**
	 * Получает сообщение по его индексу в хранилище.
	 *
	 * @param index Индекс сообщения (начиная с 0)
	 * @return Текст сообщения
	 * @throws IndexOutOfBoundsException если индекс выходит за границы списка
	 */
	public String getHelpMessageById(int index) {
		return helpMessages.get(index);
	}

	/**
	 * Возвращает текущее количество сообщений в хранилище.
	 *
	 * @return Количество сохраненных сообщений
	 */
	public int getLength() {
		return helpMessages.size();
	}
}