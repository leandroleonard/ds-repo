# Mini Data Structures Project with Spring Boot

This repository contains a mini Java project that explores several fundamental data structures such as Stack, Queue, Binary Trees and Graphs, along with a visual presentation using Spring Boot. In addition, I tried to demonstrate some REST API concepts that I have learned over these days.

## Implemented Data Structures
### Stack
A data structure that follows the Last-In-First-Out (LIFO) approach, where the last element inserted is the first to be removed.

### Queue
A data structure that follows the First-In-First-Out (FIFO) approach, where the first element inserted is the first to be removed.

### Binary Trees
A hierarchical data structure with nodes, where each node has at most two children: the left child and the right child.

### Graph
A data structure that represents a set of vertices and edges, where the edges connect the vertices.

## How to Run the Project
 - Make sure you have the Java Development Kit (JDK) installed on your system.
 - Clone this repository to your local machine.
 - Open the project in your favorite Java IDE.
 - Run the application using the main class or through Maven with the following command:




<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">



| mvn spring-boot:run          |                   | <span class="copy-icon" onclick="copyToClipboard('mvn spring-boot:run')"><i class="far fa-copy"></i></span> &nbsp;<span id="msg"></span> |
| --------------- | ------------------------- | ------ |


<script>
function copyToClipboard(text) {
  const el = document.createElement('textarea');
  el.value = text;
  document.body.appendChild(el);
  el.select();
  document.execCommand('copy');
  document.body.removeChild(el);
  document.getElementById('msg').textContext = "Copied"

}
</script>

 - Access the application at http://localhost:8080.

I hope this project will be a useful source of learning about data structures and their application in Java.

