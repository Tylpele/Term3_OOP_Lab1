import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/sort"})
public class SortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputArray = request.getParameter("arrayInput");

        try {
            // Разбираем строку с массивом
            String[] stringArray = inputArray.split(",");
            int[] array = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                array[i] = Integer.parseInt(stringArray[i].trim());
            }

            // Сортируем массив
            Arrays.sort(array);

            // Устанавливаем отсортированный массив в атрибут запроса
            request.setAttribute("sortedArray", array);

            // Перенаправляем на страницу с отсортированным массивом
            RequestDispatcher view = request.getRequestDispatcher("/sorted.jsp");
            view.forward(request, response);
        } catch (NumberFormatException e) {
            // Если возникла ошибка при преобразовании строки в число,
            // устанавливаем сообщение об ошибке в атрибут запроса и
            // перенаправляем обратно на index.html
            request.setAttribute("errorMessage", "An error occurred while processing your request. Please make sure you entered a valid comma-separated list of integers.");
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        }

    }
}
