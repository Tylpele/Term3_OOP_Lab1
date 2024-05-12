import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/sort"})
public class SortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputArray = request.getParameter("arrayInput");

        // Разбираем строку с массивом
        String[] stringArray = inputArray.split(",");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.parseInt(stringArray[i].trim());
        }

        // Сортируем массив
        Arrays.sort(array);

        // Сохраняем отсортированный массив как атрибут запроса
        request.setAttribute("sortedArray", array);

        // Перенаправляем запрос на JSP
        RequestDispatcher view = request.getRequestDispatcher("/sorted.jsp");
        view.forward(request, response);
    }
}

