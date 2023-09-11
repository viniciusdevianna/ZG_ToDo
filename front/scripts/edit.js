const query = new URLSearchParams(window.location.search);
const id = query.get("id");

const form = document.getElementById("editTaskForm");
const idField = document.getElementById("taskId");
idField.value = id;

// TODO: validar dados antes de enviar no formulário

