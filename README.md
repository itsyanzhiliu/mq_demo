# RabbitMQ Demo

- A producer is a user application that sends messages.
- A queue is a buffer that stores messages.
- A consumer is a user application that receives messages.

## "Hello World"
- A producer that sends a single message, and a consumer that receives messages and prints them out. It's a "Hello World" of messaging.



## Work Queue
- The main idea behind Work Queues (aka: Task Queues) is to avoid doing a resource-intensive task immediately and having to wait for it to complete. Instead we schedule the task to be done later. We encapsulate a task as a message and send it to a queue. A worker process running in the background will pop the tasks and eventually execute the job. When you run many workers the tasks will be shared between them.

## Publish & Subscribe

- The core idea in the messaging model in RabbitMQ is that the producer never sends any messages directly to a queue. Actually, quite often the producer doesn't even know if a message will be delivered to any queue at all.

- Instead, the producer can only send messages to an exchange. On one side it receives messages from producers and the other side it pushes them to queues. The exchange must know exactly what to do with a message it receives.
- There are a few exchange types available: `direct`, `topic`, `headers` and `fanout`.

