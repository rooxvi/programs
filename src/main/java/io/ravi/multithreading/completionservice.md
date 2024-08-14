## CompletionService
Suppose you want to optimize the work done by your code, to do that you will explore multiple options like parallel processing, caching, adding more memory to your servers etc. If it's possible to break down the work into smaller chunks, parallel processing (multithreading) is the first thing to try.\
Java, out of the box provides a lot of help about that like: multiple types of thread pools, a number of types of services to handle tasks. One of those services is Completion Service. let's talk about it in detail here.\
Java docs provide the best definition for it: A service that decouples the production of new asynchronous tasks from the consumption of the results of completed tasks.\
How this is done? Think of it as two separate queues, One for submitting tasks to your thread pool and another for returning the completed futures.\
We can create multiple instances of Completion Service (using the ExecutorCompletionService provided in the concurrent package) and use the same Thread Pool (Executor instance). This way, multiple producers will be submitting tasks to same Thread Pool, these tasks will be executed by worker threads as and when they become available, and the result will be returned to same completion-service instance which submitted the task, in the form of a Future.\
### Benefit of CompletionService Over ExecutorService
CompletionService puts the completed tasks (as Future) in separate queue as and when a task completes. calling take() method will return the first completed task. we can start processing these futures and don’t have to wait for all of the submitted tasks to complete.\
ExecutorService on the other hand has only an input queue, we need to keep all of it’s futures in a List/Collection and call get() on them one by one, not knowing which task completed first.\
**CompletionService** = Input Queue > Thread Pool > Output Queue\
**ExecutorService** = Input Queue > Thread Pool

Article
- [Link](https://www.linkedin.com/pulse/completion-service-java-harshul-varshney/)
- [rdafbn.blogspot](https://rdafbn.blogspot.com/2013/01/executorservice-vs-completionservice-vs.html)
