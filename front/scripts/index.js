let tasks = ["Tarefa 1", "Tarefa 2", "Tarefa 3"];

function updateTaskList() {
    const taskList = document.getElementById("tasklist");

    taskList.innerHTML = "";
    tasks.forEach((task) => {
        let li = document.createElement("li");
        li.className = "task-card"
        li.innerHTML = task;
        taskList.appendChild(li);
    });
}

const addTaskBtn = document.getElementById("addTaskBtn");
const newTaskName = document.getElementById("newTaskName");

addTaskBtn.onclick = () => {
    if (newTaskName.value) {
        tasks.push(newTaskName.value);
        updateTaskList();
        newTaskName.value = "";
    }   
}

updateTaskList();