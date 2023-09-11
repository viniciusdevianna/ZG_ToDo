let tasks = [];
const priorities = {
    1: "&#9675;",
    2: "&#128994;",
    3: "&#128993;",
    4: "&#128308;",
    5: "&#10071;&#10071;"
};

function updateTaskList() {
    const taskList = document.getElementById("tasklist");

    taskList.innerHTML = "";
    tasks.forEach((task) => {
        let li = document.createElement("li");
        li.className = "task-card";
        li.id = "taskcard";
        li.innerHTML =
            `<div class="card-title">
                <div class="card-name">
                <p>${task.name}</p>
                <p>${priorities[task.priority]}</p>
                </div>
                <p>${task.status}</p>
            </div>
            <div class="card-description">
                <p>${task.description}</p>
                <p>${task.limitDate || ""}</p>
            </div>`;
        li.onclick = () => location.href = "./edit.html";
        taskList.appendChild(li);
    });
}

const addTaskBtn = document.getElementById("addTaskBtn");
const newTaskName = document.getElementById("newTaskName");
const prioritySelector = document.getElementById("prioritySelector");

addTaskBtn.onclick = () => {
    if (newTaskName.value) {
        let newTask = {
            id: tasks.length,
            name: newTaskName.value,
            priority: prioritySelector.value,
            description: "",
            category: "",
            status: "ToDo",
            limitDate: null
        }
        tasks.push(newTask);
        updateTaskList();
        newTaskName.value = "";
    }
}

updateTaskList();