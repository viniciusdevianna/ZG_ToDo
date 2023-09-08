let tasks = [];

function updateTaskList() {
    const taskList = document.getElementById("tasklist");

    taskList.innerHTML = "";
    tasks.forEach((task) => {
        let li = document.createElement("li");
        li.className = "task-card"
        li.id = "taskcard"
        li.innerHTML = `<p>${task.name}</p><p>${task.priority}</p>`
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