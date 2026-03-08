# Tony User Guide

Tony is a command-line task manager that helps users manage todos, deadlines, and events efficiently.

---

## Adding a Todo

Adds a todo task.

Format:
todo DESCRIPTION

Example:
todo read book

---

## Adding a Deadline

Adds a task with a deadline.

Format:
deadline DESCRIPTION /by dd-MM-yyyy HHmm

Example:
deadline return book /by 17-10-2025 1800

Note: Dates must follow the format dd-MM-yyyy HHmm using 24-hour time.

---

## Adding an Event

Adds an event with a start and end time.

Format:
event DESCRIPTION /from TIME /to TIME

Example:
event meeting /from 1400 /to 1600

---

## Listing Tasks

Shows all tasks.

Format:
list

---

## Marking Tasks

Marks a task as done.

Format:
mark TASK_NUMBER

Example:
mark 2

---

## Unmarking Tasks

Marks a task as not done.

Format:
unmark TASK_NUMBER

---

## Deleting Tasks

Deletes a task.

Format:
delete TASK_NUMBER

---

## Finding Tasks

Searches for tasks containing a keyword.

Format:
find KEYWORD

Example:
find book

---

## Exiting Tony

Closes the application.

Format:
bye

---
## Example

Below is an example interaction with Tony.

Hello! I'm Tony
What can I do for you?

**Input**: todo read book 

**Output**:

Got it. I've added this task:
   
 [T][ ] read book

Now you have 1 tasks in the list

**Input:** deadline CS2113 Assignment /by 17-10-2025 1800

**Output:** 

Got it. I've added this task:

[D][ ] CS2113 assignment (by: Oct-17-2025 1800)

**Input:** list

**Output:**

Here are the tasks in your list:
1. [T][ ] read book
2. [D][ ] CS2113 Assignment (by: Oct-17-2025 1800)

**Input:** mark 1

**Output:**

Nice! I've marked this task as done:

[T][X] read book

**Input:** find book

**Output:**

Here are the matching tasks in your list:

1. [T][X] read book

**Input:** bye

**Output:** 

Bye. Hope to see you again soon!

