// TODO: refatorar este código para separar as funções

let tasks = [];
if (localStorage.getItem("tasks")) {
    tasks = JSON.parse(localStorage.getItem("tasks"));
}
const priorities = {
    1: "&#9675;",
    2: "&#128994;",
    3: "&#128993;",
    4: "&#128308;",
    5: "&#10071;&#10071;"
};

function createTask(name, priority, description, category, status, limitdate, id = -1) {
    let newTask = {
        id: id === -1 ? tasks.length : id,
        name: name,
        priority: priority,
        description: description,
        category: category,
        status: status,
        limitDate: limitdate
    };
    tasks.push(newTask);
}

const query = new URLSearchParams(window.location.search);
if (query.has("id")) {
    for (let task of tasks) {
        console.log(task.id);
        console.log(query.get("id"))
        if (task.id == query.get("id")) {
            task.name = query.get("task_name");
            task.priority = query.get("priority_selector");
            task.description = query.get("task_description");
            task.category = query.get("task_category");
            task.status = query.get("task_status");
            task.limitDate = query.get("task_limit_date");
        }
    }
}

function updateTaskList() {
    const taskList = document.getElementById("tasklist");

    taskList.innerHTML = "";
    tasks.forEach((task) => {
        let li = document.createElement("li");
        li.className = "task-card";
        li.id = "taskcard";
        li.innerHTML =
            `<div class="card-title" id=taskCard${task.id}>
                <div class="card-name">
                <p>${task.name}</p>
                <p>${priorities[task.priority]}</p>
                </div>
                <p>${task.status}</p>
                <a id="deleteIcon${task.id}">
                    <span class="material-icons">delete</span>
                </a>
            </div>
            <div class="card-description">
                <p>${task.description}</p>
                <p>${task.limitDate || ""}</p>
            </div>`;
        li.onclick = () => location.href = `./edit.html?tarefa=${JSON.stringify(task)}`;
        taskList.appendChild(li);
        document.getElementById(`deleteIcon${task.id}`).onclick = (event) => {
            event.stopPropagation();
            if (confirm("Tem certeza que deseja deletar a tarefa?")) {
                tasks = tasks.filter((t) => t !== task);
                updateTaskList();
            }
        }
    });
    localStorage.setItem("tasks", JSON.stringify(tasks));
}

const addTaskBtn = document.getElementById("addTaskBtn");
const newTaskName = document.getElementById("newTaskName");
const prioritySelector = document.getElementById("prioritySelector");

addTaskBtn.onclick = () => {
    if (newTaskName.value) {
        createTask(
            name = newTaskName.value,
            priority = prioritySelector.value,
            description = "",
            category = "",
            status = "ToDo",
            limitDate = null);
        updateTaskList();
        newTaskName.value = "";
    }
}

updateTaskList();