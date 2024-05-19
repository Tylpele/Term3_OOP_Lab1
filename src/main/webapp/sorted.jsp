<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sorted Array</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title">Sorted Array</h5>
                </div>
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted">Here is your sorted array:</h6>
                    <ul class="list-group" id="sortedArray">
                        <!-- Место для отображения отсортированного массива -->
                            <%
                        int[] sortedArray = (int[])request.getAttribute("sortedArray");
                        if (sortedArray != null) {
                            for (int i = 0; i < sortedArray.length; i++) {
                    %>
                            <%= sortedArray[i] %>
                            <% if (i != sortedArray.length - 1) { %>
                        ,
                            <% } %>
                            <%
                            }
                        }
                    %>
                </div>
                <div class="card-footer">
                    <!-- Форма с кнопкой для перенаправления на index.jsp через сервлет -->
                    <form action="indexRedirect" method="get">
                        <button type="submit" class="btn btn-primary">Back to Index</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
