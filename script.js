document.addEventListener("DOMContentLoaded", function () {
  const todoForm = document.getElementById("todo-form");
  const todoInput = document.getElementById("todo-input");
  const todoList = document.getElementById("todo-list");

  // Load existing todos
  fetchTodos();

  // Add new todo
  todoForm.addEventListener("submit", function (e) {
    e.preventDefault();
    const todoText = todoInput.value.trim();
    if (todoText) {
      addTodo(todoText);
      todoInput.value = "";
    }
  });

  // Fetch todos from the backend
  function fetchTodos() {
    fetch("http://localhost:8080/api/todos")
      .then((response) => response.json())
      .then((todos) => {
        todos.forEach((todo) => {
          renderTodoItem(todo);
        });
      })
      .catch((error) => console.error("Error fetching todos:", error));
  }

  // Add new todo to the backend
  function addTodo(text) {
    fetch("http://localhost:8080/api/todos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ text: text }),
    })
      .then((response) => response.json())
      .then((todo) => {
        renderTodoItem(todo);
      })
      .catch((error) => console.error("Error adding todo:", error));
  }

  // Render a todo item in the list
  function renderTodoItem(todo) {
    const li = document.createElement("li");
    li.textContent = todo.text;
    li.dataset.id = todo.id;

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener("click", function () {
      deleteTodo(todo.id, li);
    });

    li.appendChild(deleteButton);
    todoList.appendChild(li);
  }

  // Delete a todo from the backend
  function deleteTodo(id, listItem) {
    fetch(`http://localhost:8080/api/todos/${id}`, {
      method: "DELETE",
    })
      .then(() => {
        listItem.remove();
      })
      .catch((error) => console.error("Error deleting todo:", error));
  }
});
