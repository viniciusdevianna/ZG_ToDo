const query = new URLSearchParams(window.location.search);
const taskJson = query.get("tarefa");
const task = JSON.parse(taskJson);

const form = document.getElementById("editTaskForm");

form["task_name"].value = task.name;
form["task_description"].value = task.description;
form["task_category"].value = task.category;
form["priority_selector"].value = task.priority;
form["task_status"].value = task.status;
form["task_limit_date"].value = task.limitDate;

// TODO: validar dados antes de enviar no formulário

