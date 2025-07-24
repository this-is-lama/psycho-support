package my.project.psychosupport;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет для обработки HTTP-запросов к сервису поддержки.
 * Поддерживает операции GET (получение сообщения) и POST (добавление сообщения).
 */
public class HelpServlet extends HttpServlet {

	private final HelpService helpService = new HelpService();

	/**
	 * Обрабатывает GET-запросы, возвращая случайное сообщение поддержки.
	 *
	 * @param req HTTP-запрос
	 * @param resp HTTP-ответ
	 * @throws IOException при ошибках ввода-вывода
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String message = helpService.getRandomHelpMessage();
		out.println(message);
	}

	/**
	 * Обрабатывает POST-запросы для добавления новых сообщений.
	 *
	 * @param req HTTP-запрос (должен содержать параметр "message")
	 * @param resp HTTP-ответ
	 * @throws IOException при ошибках ввода-вывода
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String message = req.getParameter("message");
		helpService.saveHelpMessage(message);
		out.println("Сообщение сохранено!");
	}
}